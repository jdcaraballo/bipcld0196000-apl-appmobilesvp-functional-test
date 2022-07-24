package com.banistmo.certificacion.task.comunes.programar;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import java.util.List;
import java.util.Map;
import net.serenitybdd.screenplay.Performable;

public class Programar {

  private Programar() {}

  public static Performable conFechaFutura(int dias) {
    return instrumented(FechaFutura.class, dias);
  }

  public static Performable conRecurrente(List<Map<String, String>> datos) {
    return instrumented(Recurrente.class, datos);
  }
}
