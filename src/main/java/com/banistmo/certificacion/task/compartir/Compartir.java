package com.banistmo.certificacion.task.compartir;

import static com.banistmo.certificacion.userinterface.comunes.ConfirmacionTransaccionGeneralPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.banistmo.certificacion.interactions.ClickCambiando;
import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import com.banistmo.certificacion.questions.driver.ObtenerPlataforma;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;

public class Compartir implements Task {

  private final String archivoGnerar;

  public Compartir(String archivoGnerar) {
    this.archivoGnerar = archivoGnerar;
  }

  public static Compartir transaccionRealizada(String archivoGnerar) {
    return instrumented(Compartir.class, archivoGnerar);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        EsperarElemento.esClickable(BTN_COMPARTIR),
        Click.on(BTN_COMPARTIR),
        EsperarCarga.desaparezca(),
        Check.whether("PDF".equals(archivoGnerar))
            .andIfSo(EsperarElemento.esClickable(BTN_GENERAR_PDF), Click.on(BTN_GENERAR_PDF))
            .otherwise(
                EsperarElemento.esClickable(BTN_GENERAR_IMAGEN), Click.on(BTN_GENERAR_IMAGEN)),
        EsperarCarga.desaparezca(),
        Check.whether("iOS".equalsIgnoreCase(ObtenerPlataforma.deEjecucion().answeredBy(actor)))
            .andIfSo(ClickCambiando.elContexto(BTN_DONE_IOS)));
  }
}
