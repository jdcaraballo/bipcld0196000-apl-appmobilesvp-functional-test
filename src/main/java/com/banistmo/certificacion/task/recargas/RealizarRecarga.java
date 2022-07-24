package com.banistmo.certificacion.task.recargas;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.banistmo.certificacion.models.builders.RecargasBuilder;
import com.banistmo.certificacion.task.recargas.tiempoaire.RecargaGuardada;
import com.banistmo.certificacion.task.recargas.tiempoaire.RecargaNueva;

public class RealizarRecarga {

  private RealizarRecarga() {}

  public static RecargaNueva nueva(RecargasBuilder builder) {
    return instrumented(RecargaNueva.class, builder.build());
  }

  public static RecargaGuardada guardada(RecargasBuilder builder) {
    return instrumented(RecargaGuardada.class, builder.build());
  }
}
