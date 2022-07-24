package com.banistmo.certificacion.task.comunes;

import static com.banistmo.certificacion.exceptions.transferencia.TransferenciaExitosaException.TRANSFERENCIA_EXITOSA_NO_ENCONTRADO;
import static com.banistmo.certificacion.userinterface.comunes.ConfirmacionTransaccionGeneralPage.LBL_NUMERO_COMPROBANTE;
import static com.banistmo.certificacion.userinterface.comunes.TransaccionesGeneralPage.BTN_CONTINUAR;
import static com.banistmo.certificacion.userinterface.comunes.VerificarTransaccionPage.BTN_TERMINAR_TRANSACCION;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

import com.banistmo.certificacion.exceptions.transferencia.TransferenciaExitosaException;
import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import com.banistmo.certificacion.questions.configuracion.seguridad.ValidacionDeToken;
import com.banistmo.certificacion.questions.transferencias.MuestraLog;
import java.time.Duration;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Presence;

public class TerminarConToken implements Task {
  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        EsperarCarga.desaparezca(),
        EsperarElemento.esClickable(BTN_CONTINUAR),
        Click.on(BTN_CONTINUAR));
    if (!Presence.of(BTN_TERMINAR_TRANSACCION.waitingForNoMoreThan(Duration.ofSeconds(5)))
        .viewedBy(actor)
        .resolveAll()
        .isEmpty()) {
      actor.attemptsTo(
          EsperarElemento.esClickable(BTN_TERMINAR_TRANSACCION),
          Click.on(BTN_TERMINAR_TRANSACCION.waitingForNoMoreThan(Duration.ofSeconds(5))));
    }

    actor.should(
        seeThat(ValidacionDeToken.enPantalla())
            .orComplainWith(
                TransferenciaExitosaException.class,
                TRANSFERENCIA_EXITOSA_NO_ENCONTRADO + MuestraLog.browser().answeredBy(actor)));
    actor.attemptsTo(
        EsperarElemento.esVisible(
            LBL_NUMERO_COMPROBANTE.waitingForNoMoreThan(Duration.ofSeconds(15))));
  }
}
