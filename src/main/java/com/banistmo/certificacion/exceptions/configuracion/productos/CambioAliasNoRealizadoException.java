package com.banistmo.certificacion.exceptions.configuracion.productos;

public class CambioAliasNoRealizadoException extends AssertionError {
  public static final String CAMBIO_ALIAS_NO_REALIZADO =
      "El cambio de alias no fue realizado correctamente";

  public CambioAliasNoRealizadoException(String mensaje, Throwable causa) {
    super(mensaje, causa);
  }
}
