package com.banistmo.certificacion.task.transferencias.qr;

import static com.banistmo.certificacion.userinterface.transferencias.qr.PreparacionQRPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.banistmo.certificacion.interactions.ClickAleatorio;
import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class PrepararQRCon implements Task {

  private String monto;
  private String descripcion;

  public PrepararQRCon(String monto, String descripcion) {
    this.descripcion = descripcion;
    this.monto = monto;
  }

  public static PrepararQRCon conMonto(String monto, String descripcion) {
    return instrumented(PrepararQRCon.class, monto, descripcion);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        EsperarElemento.esClickable(BTN_CUENTA_DESTINO_QR),
        Click.on(BTN_CUENTA_DESTINO_QR),
        ClickAleatorio.enElemento(LST_CUENTAS_DESTINO_QR),
        EsperarElemento.esClickable(TXT_DESCRIPCION_QR),
        Click.on(RDB_CON_MONTO),
        Enter.theValue(monto).into(TXT_MONTO_QR),
        Enter.theValue(descripcion).into(TXT_DESCRIPCION_QR));
    actor.attemptsTo(Click.on(BTN_CONTINUAR_GENERAR_QR));
  }
}
