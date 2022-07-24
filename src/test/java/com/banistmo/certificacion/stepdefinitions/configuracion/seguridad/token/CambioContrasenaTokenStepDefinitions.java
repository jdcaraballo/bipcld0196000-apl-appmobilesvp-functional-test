package com.banistmo.certificacion.stepdefinitions.configuracion.seguridad.token;

import static com.banistmo.certificacion.utils.enums.EnumVariablesSesion.CONTRASENA;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import com.banistmo.certificacion.task.configuracion.seguridad.CambiarContrasena;
import com.banistmo.certificacion.task.token.TerminarCambioConToken;
import cucumber.api.java.es.Cuando;

public class CambioContrasenaTokenStepDefinitions {

  @Cuando("el cambie la contraseña por (.*) con validacion token")
  public void elCambieLaContrasenaConValidacionToken(String contrasena) {
    String clave = theActorInTheSpotlight().recall(CONTRASENA.getVariableSesion());
    cambiarLaContrasena(clave, contrasena);
  }

  public static void cambiarLaContrasena(String contrasenaActual, String contrasenaNueva) {
    theActorInTheSpotlight()
        .attemptsTo(
            TerminarCambioConToken.deSeguridad(),
            CambiarContrasena.porUnaNueva(contrasenaActual, contrasenaNueva));
  }
}
