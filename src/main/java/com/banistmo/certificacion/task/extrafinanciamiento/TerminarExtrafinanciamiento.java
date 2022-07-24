package com.banistmo.certificacion.task.extrafinanciamiento;

import static com.banistmo.certificacion.userinterface.comunes.TransaccionesGeneralPage.BTN_CONTINUAR;

import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class TerminarExtrafinanciamiento implements Task {
  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        EsperarCarga.desaparezca(),
        EsperarElemento.esClickable(BTN_CONTINUAR),
        Click.on(BTN_CONTINUAR),
        EsperarCarga.desaparezca());
  }
}
