package com.banistmo.certificacion.exceptions.pagos;

public class PagoEliminadoExitosoException extends AssertionError {

  public static final String PAGO_NO_ELIMINADO = "Pago programado no eliminado";

  public PagoEliminadoExitosoException(String mensaje, Throwable causa) {
    super(mensaje, causa);
  }
}
