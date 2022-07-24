package com.banistmo.certificacion.task.transferencias.qr;

import static com.banistmo.certificacion.userinterface.comunes.ConfirmacionTransaccionGeneralPage.BTN_COMPARTIR;
import static com.banistmo.certificacion.userinterface.transferencias.qr.PreparacionQRPage.BTN_CONFIRMAR_GENERAR_QR;
import static com.banistmo.certificacion.userinterface.transferencias.qr.PreparacionQRPage.LBL_CUENTA_DESTINO_QR;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import java.time.Duration;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.Wait;

public class TerminarDatosQR implements Question<Boolean> {

  public TerminarDatosQR(Object datosQRClass) {}

  public static TerminarDatosQR enQR() {
    return new TerminarDatosQR(TerminarDatosQR.class);
  }

  @Override
  public Boolean answeredBy(Actor actor) {
    actor.attemptsTo(
        Wait.until(the(LBL_CUENTA_DESTINO_QR), isCurrentlyVisible()).forNoLongerThan(30).seconds());
    return verificarDatosComprobanteQR(actor);
  }

  public boolean verificarDatosComprobanteQR(Actor actor) {
    actor.attemptsTo(
        EsperarElemento.esVisible(BTN_CONFIRMAR_GENERAR_QR),
        EsperarElemento.esVisible(
            LBL_CUENTA_DESTINO_QR.waitingForNoMoreThan(Duration.ofSeconds(20))));
    actor.attemptsTo(
        Ensure.that(LBL_CUENTA_DESTINO_QR).text().isNotBlank(),
        Click.on(BTN_CONFIRMAR_GENERAR_QR),
        EsperarCarga.desaparezca(),
        EsperarElemento.esVisible(BTN_COMPARTIR));
    return true;
  }
}
