package com.banistmo.certificacion.exceptions.pagos;

public class PagoImpuestoException extends AssertionError {

  public static final String PAGO_IMPUESTO_FALLIDO = "No se pudo completar la validación del pago";

  public PagoImpuestoException(String message, Throwable cause) {
    super(message, cause);
  }
}
