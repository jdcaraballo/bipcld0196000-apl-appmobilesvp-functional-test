package com.banistmo.certificacion.task.compartir;

import static com.banistmo.certificacion.userinterface.comunes.ConfirmacionTransaccionGeneralPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class CompartirQR implements Task {

  public static CompartirQR transaccionRealizada(String archivoGnerar) {
    return instrumented(CompartirQR.class, archivoGnerar);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        EsperarElemento.esClickable(BTN_COMPARTIR),
        Click.on(BTN_COMPARTIR),
        EsperarCarga.desaparezca(),
        EsperarElemento.esClickable(BTN_GENERAR_PDF),
        Click.on(BTN_GENERAR_PDF),
        EsperarCarga.desaparezca(),
        EsperarElemento.esClickable(MSG_DESCARGA_COMPLETA));
  }
}
