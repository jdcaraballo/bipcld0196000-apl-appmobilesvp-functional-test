package com.banistmo.certificacion.interactions;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class Regresar implements Interaction {

  @Override
  public <T extends Actor> void performAs(T actor) {
    BrowseTheWeb.as(actor).getDriver().navigate().back();
  }

  public static Interaction pantallaAnterior() {
    return instrumented(Regresar.class);
  }
}
