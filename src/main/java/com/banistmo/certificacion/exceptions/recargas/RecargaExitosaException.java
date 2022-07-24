package com.banistmo.certificacion.exceptions.recargas;

public class RecargaExitosaException extends AssertionError {
  public static final String RECARGA_NO_EXITOSA = "Recarga al producto fallido";

  public RecargaExitosaException(String mensaje, Throwable causa) {
    super(mensaje, causa);
  }
}
