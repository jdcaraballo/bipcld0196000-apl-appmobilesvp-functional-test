package com.banistmo.certificacion.task.comunes.cancelartransaccion;

import static com.banistmo.certificacion.userinterface.comunes.TransaccionesGeneralPage.*;
import static com.banistmo.certificacion.userinterface.comunes.VerificarTransaccionPage.BTN_CONFIRMAR_CANCELAR_TRANSFERENCIA;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class CancelarQR implements Task {

  public static CancelarQR generarQR() {
    return instrumented(CancelarQR.class);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        EsperarElemento.esClickable(BTN_CANCELAR_QR),
        Click.on(BTN_CANCELAR_QR),
        EsperarElemento.esClickable(BTN_CONFIRMAR_CANCELAR_TRANSFERENCIA),
        Click.on(BTN_CONFIRMAR_CANCELAR_TRANSFERENCIA));
  }
}
