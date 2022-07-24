package com.banistmo.certificacion.interactions.esperas;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class Presente implements Task {
  Target elemento;

  public Presente(Target elemento) {
    this.elemento = elemento;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(WaitUntil.the(elemento, isPresent()).forNoMoreThan(20).seconds());
  }
}
