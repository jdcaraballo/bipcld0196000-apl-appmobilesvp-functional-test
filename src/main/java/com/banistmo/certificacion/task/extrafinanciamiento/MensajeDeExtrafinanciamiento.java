package com.banistmo.certificacion.task.extrafinanciamiento;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.banistmo.certificacion.interactions.esperas.Esperar;
import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import com.banistmo.certificacion.userinterface.PrincipalPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;

public class MensajeDeExtrafinanciamiento implements Task {

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        EsperarElemento.esVisible(PrincipalPage.LBL_MENSAJE_EXTRAFINANCIAMIENTO),
        Ensure.that(PrincipalPage.LBL_MENSAJE_EXTRAFINANCIAMIENTO).isDisplayed(),
        Click.on(PrincipalPage.BTN_VER_DESPUES_EXTRAFINANCIAMIENTO),
        Click.on(PrincipalPage.BTN_VISTA_CARD),
        Click.on(PrincipalPage.BTN_VISTA_LISTA),
        EsperarElemento.esVisible(PrincipalPage.LST_BTN_CUENTA_DEPOSITO_VISTA_LISTA),
        Esperar.unTiempo(3000));
  }

  public static MensajeDeExtrafinanciamiento verDespues() {
    return instrumented(MensajeDeExtrafinanciamiento.class);
  }

}
