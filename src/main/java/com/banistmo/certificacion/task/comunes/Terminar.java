package com.banistmo.certificacion.task.comunes;

import static com.banistmo.certificacion.userinterface.comunes.TransaccionesGeneralPage.BTN_CONTINUAR;
import static com.banistmo.certificacion.userinterface.comunes.VerificarTransaccionPage.BTN_TERMINAR_TRANSACCION;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.banistmo.certificacion.interactions.esperas.Esperar;
import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import com.banistmo.certificacion.task.extrafinanciamiento.TerminarExtrafinanciamiento;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Presence;

public class Terminar implements Task {

  public static Terminar transaccion() {
    return instrumented(Terminar.class);
  }

  public static TerminarExtrafinanciamiento extrafinanciamiento() {
    return instrumented(TerminarExtrafinanciamiento.class);
  }

  public static TerminarConToken trasanccionConToken() {
    return instrumented(TerminarConToken.class);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        EsperarCarga.desaparezca(),
        EsperarElemento.esClickable(BTN_CONTINUAR),
        Click.on(BTN_CONTINUAR),
        EsperarCarga.desaparezca(),
        Esperar.unTiempo(6000));
    if (!Presence.of(BTN_TERMINAR_TRANSACCION).viewedBy(actor).resolveAll().isEmpty()) {
      actor.attemptsTo(
          EsperarElemento.esClickable(BTN_TERMINAR_TRANSACCION),
          Click.on(BTN_TERMINAR_TRANSACCION),
          Esperar.unTiempo(5000),
          EsperarCarga.desaparezca());
    }
    actor.attemptsTo(EsperarCarga.desaparezca());
  }
}
