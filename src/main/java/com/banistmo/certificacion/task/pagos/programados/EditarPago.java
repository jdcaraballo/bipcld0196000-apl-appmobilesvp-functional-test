package com.banistmo.certificacion.task.pagos.programados;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.banistmo.certificacion.models.builders.TransaccionBuilder;
import net.serenitybdd.screenplay.Performable;

public class EditarPago {

  private EditarPago() {}

  public static Performable fechaFutura(TransaccionBuilder edicion, String dias) {
    return instrumented(EditarPagoFechaFutura.class, edicion.build(), dias);
  }

  public static Performable fechaRecurrente(TransaccionBuilder edicion) {
    return instrumented(EditarPagoFechaRecurrente.class, edicion.build());
  }
}
