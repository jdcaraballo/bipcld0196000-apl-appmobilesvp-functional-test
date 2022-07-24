package com.banistmo.certificacion.exceptions.configuracion.seguridad;

public class EliminarTokenException extends AssertionError {
  public static final String ELIMINAR_TOKEN_FALLIDO = "No se pudo eliminar el token indicado";

  public EliminarTokenException(String message, Throwable cause) {
    super(message, cause);
  }
}
