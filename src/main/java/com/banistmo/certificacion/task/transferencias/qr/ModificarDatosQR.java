package com.banistmo.certificacion.task.transferencias.qr;

import static com.banistmo.certificacion.userinterface.transferencias.qr.PreparacionQRPage.*;
import static com.banistmo.certificacion.userinterface.transferencias.qr.VerificacionQRPage.BTN_MODIFICAR_QR;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.banistmo.certificacion.interactions.Limpiar;
import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class ModificarDatosQR implements Task {

  private String monto;
  private String descripcion;

  public ModificarDatosQR(String monto, String descripcion) {
    this.monto = monto;
    this.descripcion = descripcion;
  }

  public static Performable deQR(String monto, String descripcion) {
    return instrumented(ModificarDatosQR.class, monto, descripcion);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        EsperarElemento.esClickable(BTN_MODIFICAR_QR),
        Click.on(BTN_MODIFICAR_QR),
        EsperarElemento.esClickable(RDB_CON_MONTO),
        Click.on(RDB_CON_MONTO),
        Enter.theValue(monto).into(TXT_MONTO_QR),
        Limpiar.campo(TXT_DESCRIPCION_QR),
        Enter.theValue(descripcion).into(TXT_DESCRIPCION_QR));
    actor.attemptsTo(Click.on(BTN_CONTINUAR_GENERAR_QR));
  }
}
