package com.banistmo.certificacion.exceptions.transferencia;

public class TransferenciaNoModificadaException extends AssertionError {
  public static final String TRANSFERENCIA_MODIFICADA_NO_EXITOSA =
      "La modificacion de la transferencia no ha sido exitosa";
  public static final String DATOS_NO_MANTENIDOS_CORRECTAMENTE =
      "La modificacion de la transferencia no ha sido exitosa";

  public TransferenciaNoModificadaException(String mensaje, Throwable causa) {
    super(mensaje, causa);
  }
}
