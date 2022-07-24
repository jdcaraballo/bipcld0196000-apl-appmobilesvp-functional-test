package com.banistmo.certificacion.stepdefinitions;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import com.banistmo.certificacion.questions.configuracion.seguridad.CambioContrasena;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class CommonsStepDefinitions {

  private static Scenario scenario;

  @Before
  public void prepareStage() {
    if (scenario != null) {
      if (scenario.isFailed()) {
        cerrarSesion();
      }
    }
    OnStage.setTheStage(new OnlineCast());
  }

  @After
  public void afterStage(Scenario scenario) {
    CommonsStepDefinitions.scenario = scenario;
    cerrarSesion();
  }

  @After("@CambioContrasena")
  public void resetContrasena(Scenario scenario) {
    if (scenario.getStatus().toString().contains("PASSED")) {
    /*cambioContrasena(
    theActorInTheSpotlight().recall(CONTRASENA_NUEVA.getvariableSesion()).toString(),
    theActorInTheSpotlight().recall(CONTRASENA.getvariableSesion()).toString());*/
      theActorInTheSpotlight().attemptsTo(CambioContrasena.porServicio());
    }
  }

  private void cerrarSesion() {
    theActorInTheSpotlight().attemptsTo(Open.url("http://localhost:8080/"));
  }
}
