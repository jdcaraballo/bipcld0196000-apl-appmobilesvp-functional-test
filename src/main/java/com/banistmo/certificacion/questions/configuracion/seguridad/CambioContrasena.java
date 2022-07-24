package com.banistmo.certificacion.questions.configuracion.seguridad;

import static com.banistmo.certificacion.utils.enums.EnumVariablesSesion.CONTRASENA;
import static com.banistmo.certificacion.utils.enums.EnumVariablesSesion.CONTRASENA_NUEVA;
import static com.banistmo.certificacion.utils.enums.EnumVariablesSesion.USUARIO_LOGIN;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CambioContrasena implements Task {
    private static final Logger LOGGER = LoggerFactory.getLogger(CambioContrasena.class);
    private String usuario;
    private String claveActual;
    private String claveNueva;

    public static CambioContrasena porServicio() {
        return instrumented(CambioContrasena.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        usuario = actor.recall(USUARIO_LOGIN.getVariableSesion());
        claveActual = actor.recall(CONTRASENA.getVariableSesion());
        claveNueva = actor.recall(CONTRASENA_NUEVA.getVariableSesion());
        String uri = "https://api.banistmolabs.com";
        String pathCreateToken = "/securityv2/v2/security/token/create";
        String pathPasswChange = "/securityv2/v2/security/users/password";
        String token = postCrearToken(uri, pathCreateToken, obtenerBody(usuario, claveNueva));
        cambioPassw(uri, pathPasswChange, token);
    }
    private String obtenerBody(String usuario, String clave) {
        String body = "";
        try {
            body =
                    new String(
                            Files.readAllBytes(Paths.get("src/test/resources/jsonFiles/token/jsonToken.json")));
        } catch (IOException e) {
            LOGGER.warn(String.valueOf(e));
        }
        return body.replaceAll("@userName", usuario).replaceAll("@password", clave);
    }
    private String cambioPassw(String uri, String basePathChagePassw, String token) {
        String body = "";
        try {
            body =
                    new String(
                            Files.readAllBytes(
                                    Paths.get("src/test/resources/jsonFiles/cambio_passw/cambioPasswBody.json")))
                            .replaceAll("@claveActual", claveNueva)
                            .replaceAll("@claveNueva", "Prueba123##");
        } catch (IOException e) {
            LOGGER.warn(String.valueOf(e));
        }
        SerenityRest.given()
                .baseUri(uri)
                .basePath(basePathChagePassw)
                .body(body)
                .auth()
                .oauth2(token)
                .when()
                .put();
        Assert.assertEquals(200, SerenityRest.lastResponse().statusCode());
        return SerenityRest.lastResponse().jsonPath().getString("body.ADMMessage");
    }
    private String postCrearToken(String uri, String basePathCreateToken, String jsonData) {
        SerenityRest.given().baseUri(uri).basePath(basePathCreateToken).body(jsonData).when().post();
        Assert.assertEquals(200, SerenityRest.lastResponse().statusCode());
        return SerenityRest.lastResponse().jsonPath().getString("access_token");
    }

}