package com.banistmo.certificacion.task.configuracion.productos.preferida;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CuentaPreferida {

  private CuentaPreferida() {}

  public static CuentaPreferidaConfiguracion desdeConfiguracion(String accion) {
    return instrumented(CuentaPreferidaConfiguracion.class, accion);
  }

  public static CuentaPreferidaDetalles desdeDetalles(String accion) {
    return instrumented(CuentaPreferidaDetalles.class, accion);
  }
}
