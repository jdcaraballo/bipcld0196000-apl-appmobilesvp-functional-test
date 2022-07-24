package com.banistmo.certificacion.exceptions.configuracion.seguridad;

public class InscribirTokenException extends AssertionError {
  public static final String INSCRIPCION_DE_TOKEN_FALLIDA = "Inscripción de token fallida";

  public InscribirTokenException(String message, Throwable cause) {
    super(message, cause);
  }
}
