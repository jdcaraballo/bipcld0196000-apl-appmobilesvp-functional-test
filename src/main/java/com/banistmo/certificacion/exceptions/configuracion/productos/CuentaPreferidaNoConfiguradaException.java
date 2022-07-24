package com.banistmo.certificacion.exceptions.configuracion.productos;

public class CuentaPreferidaNoConfiguradaException extends AssertionError {
  public static final String CUENTA_PREFERIDA_NO_CONFIGURADA = "Cuenta preferida no configurada";

  public CuentaPreferidaNoConfiguradaException(String mensaje, Throwable causa) {
    super(mensaje, causa);
  }
}
