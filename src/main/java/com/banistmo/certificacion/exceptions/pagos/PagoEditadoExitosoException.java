package com.banistmo.certificacion.exceptions.pagos;

public class PagoEditadoExitosoException extends AssertionError {
  public static final String PAGO_NO_EDITADO = "Edición de pago programado fallido";

  public PagoEditadoExitosoException(String mensaje, Throwable causa) {
    super(mensaje, causa);
  }
}
