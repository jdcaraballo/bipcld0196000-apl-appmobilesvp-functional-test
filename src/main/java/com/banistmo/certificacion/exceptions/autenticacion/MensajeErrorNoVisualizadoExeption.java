package com.banistmo.certificacion.exceptions.autenticacion;

public class MensajeErrorNoVisualizadoExeption extends AssertionError {
  public static final String MENSAJE_ERROR_NO_ENCONTRADO = "Mensaje de error no visualizado";

  public MensajeErrorNoVisualizadoExeption(String mensaje, Throwable causa) {
    super(mensaje, causa);
  }
}
