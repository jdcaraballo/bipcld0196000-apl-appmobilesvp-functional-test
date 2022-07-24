package com.banistmo.certificacion.exceptions.pagos;

public class PagoExitosoException extends AssertionError {
  public static final String PAGO_NO_EXITOSO = "Pago al producto fallido";

  public PagoExitosoException(String mensaje, Throwable causa) {
    super(mensaje, causa);
  }
}
