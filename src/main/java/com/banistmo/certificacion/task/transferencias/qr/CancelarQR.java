package com.banistmo.certificacion.task.transferencias.qr;

import static com.banistmo.certificacion.userinterface.transferencias.qr.VerificacionQRPage.LBL_CANCELAR_TRANSACCION;

import com.banistmo.certificacion.userinterface.transferencias.qr.VerificacionQRPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;

public class CancelarQR implements Task {

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        Click.on(VerificacionQRPage.BTN_CANCELAR_QR),
        Ensure.that(LBL_CANCELAR_TRANSACCION).isDisplayed(),
        Click.on(VerificacionQRPage.BTN_CONFIRMAR_CANCELAR_QR));
  }
}
