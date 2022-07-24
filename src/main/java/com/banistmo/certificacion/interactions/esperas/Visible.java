package com.banistmo.certificacion.interactions.esperas;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class Visible implements Interaction {

  Target elemento;

  public Visible(Target elemento) {
    this.elemento = elemento;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(WaitUntil.the(elemento, isVisible()).forNoMoreThan(30).seconds());
  }
}
