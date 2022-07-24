package com.banistmo.certificacion.interactions;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.Keys;

public class LimpiarCampo implements Interaction {
  private final Target elemento;

  public LimpiarCampo(Target input) {
    this.elemento = input;
  }

  public static Performable deEntradaDeTexto(Target input) {
    return instrumented(LimpiarCampo.class, input);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    int longitud = elemento.resolveFor(actor).getValue().length();
    for (int i = 0; i < longitud; i++) {
      elemento.resolveFor(actor).sendKeys(Keys.BACK_SPACE);
    }
  }
}
