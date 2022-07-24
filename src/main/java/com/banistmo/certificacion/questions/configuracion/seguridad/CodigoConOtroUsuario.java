package com.banistmo.certificacion.questions.configuracion.seguridad;

import static com.banistmo.certificacion.utils.enums.EnumVariablesSesion.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CodigoConOtroUsuario implements Question<String> {
  private static final Logger LOGGER = LoggerFactory.getLogger(CodigoConOtroUsuario.class);

  public static CodigoConOtroUsuario porSoftoken() {
    return new CodigoConOtroUsuario();
  }

  @Override
  public String answeredBy(Actor actor) {
    String otroUsuario = actor.recall(OTRO_USUARIO_LOGIN.getVariableSesion());
    String claveOtroUsuario = actor.recall(OTRA_CLAVE_LOGIN.getVariableSesion());
    String uri = "https://api.banistmolabs.com";
    String pathCreateToken = "/securityv2/v2/security/token/create";
    String pathDetectIdRegister = "/detectIDv2/v2/detectId/provisioning/register";

    String token = postCrearToken(uri, pathCreateToken, obtenerBody(otroUsuario, claveOtroUsuario));

    return obtenerCodigo(uri, pathDetectIdRegister, token);
  }

  private String obtenerBody(String otroUsuario, String claveOtroUsuario) {
    String body = "";
    try {
      body =
          new String(
              Files.readAllBytes(Paths.get("src/test/resources/jsonFiles/token/jsonToken.json")));
    } catch (IOException e) {
      LOGGER.warn(String.valueOf(e));
    }
    return body.replaceAll("@userName", otroUsuario).replaceAll("@password", claveOtroUsuario);
  }

  private String obtenerCodigo(String uri, String basePathDetectIdRegister, String token) {
    SerenityRest.given()
        .baseUri(uri)
        .basePath(basePathDetectIdRegister)
        .auth()
        .oauth2(token)
        .when()
        .post();
    Assert.assertEquals(200, SerenityRest.lastResponse().statusCode());
    return SerenityRest.lastResponse().jsonPath().getString("body.activation_code");
  }

  private String postCrearToken(String uri, String basePathCreateToken, String jsonData) {
    SerenityRest.given().baseUri(uri).basePath(basePathCreateToken).body(jsonData).when().post();
    Assert.assertEquals(200, SerenityRest.lastResponse().statusCode());
    return SerenityRest.lastResponse().jsonPath().getString("access_token");
  }
}
