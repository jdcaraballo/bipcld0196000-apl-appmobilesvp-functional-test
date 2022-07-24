package com.banistmo.certificacion.task.transferencias.qr;

import static com.banistmo.certificacion.userinterface.transferencias.qr.PreparacionQRPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

import com.banistmo.certificacion.interactions.ClickAleatorio;
import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.Wait;

public class PrepararQRSin implements Task {

  private String descripcion;

  public PrepararQRSin(String descripcion) {
    this.descripcion = descripcion;
  }

  public static PrepararQRSin sinMonto(String descripcion) {
    return instrumented(PrepararQRSin.class, descripcion);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        EsperarElemento.esClickable(BTN_CUENTA_DESTINO_QR),
        Click.on(BTN_CUENTA_DESTINO_QR),
        ClickAleatorio.enElemento(LST_CUENTAS_DESTINO_QR),
        EsperarElemento.esClickable(TXT_DESCRIPCION_QR),
        Enter.theValue(descripcion).into(TXT_DESCRIPCION_QR),
        Click.on(BTN_CONTINUAR_GENERAR_QR),
        EsperarElemento.esVisible(BTN_CONFIRMAR_GENERAR_QR),
        Wait.until(the(LBL_CUENTA_DESTINO_QR), isCurrentlyVisible()).forNoLongerThan(30).seconds());
  }
}
