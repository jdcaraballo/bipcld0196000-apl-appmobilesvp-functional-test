package com.banistmo.certificacion.interactions.esperas;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import net.serenitybdd.screenplay.targets.Target;

public class EsperarElemento {

  private EsperarElemento() {}

  public static Clickable esClickable(Target elemento) {
    return instrumented(Clickable.class, elemento);
  }

  public static Visible esVisible(Target elemento) {
    return instrumented(Visible.class, elemento);
  }

  public static Presente esPresente(Target elemento) {
    return instrumented(Presente.class, elemento);
  }
}
