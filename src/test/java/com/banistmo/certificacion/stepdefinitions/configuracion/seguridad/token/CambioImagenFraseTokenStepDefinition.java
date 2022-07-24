package com.banistmo.certificacion.stepdefinitions.configuracion.seguridad.token;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import com.banistmo.certificacion.task.configuracion.seguridad.token.AplicarConToken;
import cucumber.api.java.es.Y;

public class CambioImagenFraseTokenStepDefinition {

  @Y("^el (.*) los cambios realizados de imagen y frase con validacion token$")
  public void aplicarCambiosImagenFraseConToken(String accion) {
    theActorInTheSpotlight().attemptsTo(AplicarConToken.elCambioImagenFrase(accion));
  }
}
