package com.banistmo.certificacion.task.comunes.seleccionarcuentas;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import net.serenitybdd.screenplay.Performable;

public class SeleccionarCuenta {

  private SeleccionarCuenta() {}

  public static Performable destinoNueva() {
    return instrumented(TransaccionCuentaNueva.class);
  }

  public static Performable transaccion(String tipoCuenta) {
    return instrumented(TransaccionCuentaGuardada.class, tipoCuenta);
  }
}
