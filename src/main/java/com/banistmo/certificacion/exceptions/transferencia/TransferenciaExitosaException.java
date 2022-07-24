package com.banistmo.certificacion.exceptions.transferencia;

public class TransferenciaExitosaException extends AssertionError {
  public static final String TRANSFERENCIA_EXITOSA_NO_ENCONTRADO =
      "La transferencia no ha sido exitosa";
  public static final String MODAL_DE_SOFTTOKEN_NO_ENCONTRADO =
      "El Modal de Softtoken no fue encontrado";

  public TransferenciaExitosaException(String mensaje, Throwable causa) {
    super(mensaje, causa);
  }
}
