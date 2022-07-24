package com.banistmo.certificacion.task.comunes;

import static com.banistmo.certificacion.exceptions.transferencia.TransferenciaExitosaException.MODAL_DE_SOFTTOKEN_NO_ENCONTRADO;
import static com.banistmo.certificacion.userinterface.comunes.TransaccionesGeneralPage.BTN_CONTINUAR;
import static com.banistmo.certificacion.userinterface.comunes.TransaccionesGeneralPage.LBL_INGRESA_SOFTTOKEN;
import static com.banistmo.certificacion.userinterface.comunes.VerificarTransaccionPage.BTN_TERMINAR_TRANSACCION;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.banistmo.certificacion.exceptions.transferencia.TransferenciaExitosaException;
import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import com.banistmo.certificacion.questions.configuracion.seguridad.ValidacionMensajeSoftToken;
import com.banistmo.certificacion.questions.transferencias.MuestraLog;
import java.time.Duration;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Presence;

public class TerminarSin implements Task {

  public static TerminarSin esperar() {
    return instrumented(TerminarSin.class);
  }

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
          Click.on(BTN_TERMINAR_TRANSACCION.waitingForNoMoreThan(Duration.ofSeconds(10))));
    }

    actor.should(
        seeThat(ValidacionMensajeSoftToken.enPantalla())
            .orComplainWith(
                TransferenciaExitosaException.class,
                MODAL_DE_SOFTTOKEN_NO_ENCONTRADO + MuestraLog.browser().answeredBy(actor)));
    actor.attemptsTo(
        EsperarElemento.esVisible(
            LBL_INGRESA_SOFTTOKEN.waitingForNoMoreThan(Duration.ofSeconds(15))));
  }
}
