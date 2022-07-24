package com.banistmo.certificacion.task.comunes.seleccionarproducto;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SeleccionarProducto {

  private SeleccionarProducto() {}

  public static ProductoConsolidado propioDesdeConsolidado(String producto) {
    return instrumented(ProductoConsolidado.class, producto);
  }

  public static ProductoDetalles propioDesdeDetalles(String producto) {
    return instrumented(ProductoDetalles.class, producto);
  }
}
