package com.banistmo.certificacion.task.configuracion.seguridad.token;

import static com.banistmo.certificacion.exceptions.transferencia.TransferenciaExitosaException.TRANSFERENCIA_EXITOSA_NO_ENCONTRADO;
import static com.banistmo.certificacion.userinterface.configuracion.seguridad.CambiarImagenFrasePage.BTN_GUARDAR;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.banistmo.certificacion.exceptions.transferencia.TransferenciaExitosaException;
import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import com.banistmo.certificacion.questions.token.ValidacionDeToken;
import com.banistmo.certificacion.questions.transferencias.MuestraLog;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class AplicarConToken implements Task {

  private String accion;

  public AplicarConToken(String accion) {
    this.accion = accion;
  }

  public static AplicarConToken elCambioImagenFrase(String accion) {
    return instrumented(AplicarConToken.class, accion);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    if (accion.contains("guarda")) {
      actor.attemptsTo(Click.on(BTN_GUARDAR));
      actor.should(
          seeThat(ValidacionDeToken.enPantalla())
              .orComplainWith(
                  TransferenciaExitosaException.class,
                  TRANSFERENCIA_EXITOSA_NO_ENCONTRADO + MuestraLog.browser().answeredBy(actor)));
      actor.attemptsTo(EsperarCarga.desaparezca());
    }
  }
}
