package com.banistmo.certificacion.interactions.esperas;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import net.serenitybdd.core.time.InternalSystemClock;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

public class Esperar implements Interaction {

  private final int var;

  protected Esperar(int var) {
    this.var = var;
  }

  public static Esperar unTiempo(int var) {
    return instrumented(Esperar.class, var);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    new InternalSystemClock().pauseFor(var);
  }
}
