package com.banistmo.certificacion.exceptions.autenticacion;

public class MensajeCredencialesInvalidasNoVisualizadoException extends AssertionError {
  public static final String MENSAJE_CREDIALES_INCORRECTAS_NO_ENCONTRADO =
      "Mensaje de credenciales incorrectas no visualizado";

  public MensajeCredencialesInvalidasNoVisualizadoException(String mensaje, Throwable causa) {
    super(mensaje, causa);
  }
}
