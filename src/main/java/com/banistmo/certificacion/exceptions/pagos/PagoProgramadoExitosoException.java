package com.banistmo.certificacion.exceptions.pagos;

public class PagoProgramadoExitosoException extends AssertionError {
  public static final String PAGO_PROGRAMADO_NO_EXITOSO = "Pago programado al producto fallido";

  public PagoProgramadoExitosoException(String mensaje, Throwable causa) {
    super(mensaje, causa);
  }
}
