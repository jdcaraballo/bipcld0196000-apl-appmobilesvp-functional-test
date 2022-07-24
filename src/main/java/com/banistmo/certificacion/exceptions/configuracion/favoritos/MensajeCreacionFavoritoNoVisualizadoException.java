package com.banistmo.certificacion.exceptions.configuracion.favoritos;

public class MensajeCreacionFavoritoNoVisualizadoException extends AssertionError {
  public static final String MENSAJE_CREACION_FAVORITOS_NO_VISUALIZADO =
      "Mensaje de creacion favoritos no visualizado";

  public MensajeCreacionFavoritoNoVisualizadoException(String mensaje, Throwable causa) {
    super(mensaje, causa);
  }
}
