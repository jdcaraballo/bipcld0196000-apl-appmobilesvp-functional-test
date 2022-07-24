package com.banistmo.certificacion.exceptions.autenticacion;

public class MensajeUsuarioBloqueadoNoVisualizadoException extends AssertionError {
  public static final String MENSAJE_USUARIO_BLOQUEADO_NO_ENCONTRADO =
      "Mensaje de usuario bloqueado no visualizado";

  public MensajeUsuarioBloqueadoNoVisualizadoException(String mensaje, Throwable causa) {
    super(mensaje, causa);
  }
}
