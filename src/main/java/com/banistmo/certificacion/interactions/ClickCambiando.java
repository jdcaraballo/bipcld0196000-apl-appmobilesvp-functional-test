package com.banistmo.certificacion.interactions;

import static com.banistmo.certificacion.utils.UtileriaDriver.cambiarContexto;
import static com.banistmo.certificacion.utils.enums.EnumContextosDriver.NATIVA;
import static com.banistmo.certificacion.utils.enums.EnumContextosDriver.WEBVIEW;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

public class ClickCambiando implements Interaction {

  private Target elemento;

  public ClickCambiando(Target elemento) {
    this.elemento = elemento;
  }

  public static ClickCambiando elContexto(Target elemento) {
    return instrumented(ClickCambiando.class, elemento);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    cambiarContexto(NATIVA);
    actor.attemptsTo(Click.on(elemento));
    cambiarContexto(WEBVIEW);
  }
}
