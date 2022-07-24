package com.banistmo.certificacion.exceptions.extrafinanciamiento;

public class ExtrafinanciamientoException extends AssertionError {

  public static final String MENSAJE_NO_VISIBLE =
      "Mensaje de extrafinanciamiento aprobado no visible";
  public static final String MENSAJE_EXITOSO_NO_VISIBLE =
      "Mensaje de transaccion exitosa no visible";
  public static final String DATOS_COMPROBANTE_ERRADOS =
      "Los datos del comprobante no son los esperados";
  public static final String NUEVO_SALDO_ERRADO = "El saldo esperado es diferente al nuevo saldo";
  public static final String SALDO_INICIAL_DIFERENTE =
      "El saldo inicial no es igual al saldo actual";

  public ExtrafinanciamientoException(String message, Throwable cause) {
    super(message, cause);
  }
}
