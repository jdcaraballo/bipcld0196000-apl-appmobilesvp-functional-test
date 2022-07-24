package com.banistmo.certificacion.interactions;

import com.banistmo.certificacion.interactions.esperas.Esperar;
import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Presence;

import static com.banistmo.certificacion.userinterface.comunes.TransaccionesGeneralPage.*;
import static com.banistmo.certificacion.userinterface.comunes.VerificarTransaccionPage.BTN_CONFIRMAR_CANCELAR_TRANSFERENCIA;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CancelarSimple implements Task {

  private final String pantalla;

  public CancelarSimple(String pantalla) {
    this.pantalla = pantalla;
  }

  public static CancelarSimple transaccion(String pantalla) {
    return instrumented(CancelarSimple.class, pantalla);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    if ("Preparación".equals(pantalla)) {
      actor.attemptsTo(
              EsperarElemento.esClickable(BTN_CANCELAR),
              Click.on(BTN_CANCELAR));
      if (!Presence.of(BTN_CONFIRMAR_CANCELAR_TRANSFERENCIA)
          .viewedBy(actor)
          .resolveAll()
          .isEmpty()) {
        actor.attemptsTo(
                EsperarElemento.esClickable(BTN_CANCELAR),
                Click.on(BTN_CANCELAR));
      }
    } else {
      actor.attemptsTo(
          Click.on(BTN_CONTINUAR),
          EsperarCarga.desaparezca(),
          EsperarElemento.esClickable(BTN_CANCELAR),
          Click.on(BTN_CANCELAR),
          EsperarCarga.desaparezca());
      if (!Presence.of(BTN_ENTENDIDO_ANTERIOR).viewedBy(actor).resolveAll().isEmpty()) {
        actor.attemptsTo(
            EsperarElemento.esClickable(BTN_ENTENDIDO_ANTERIOR),
                Click.on(BTN_ENTENDIDO_ANTERIOR));
      }
    }
  }
}