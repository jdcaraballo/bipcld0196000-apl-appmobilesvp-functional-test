package com.banistmo.certificacion.exceptions.configuracion.favoritos;

public class MensajeEdicionFavoritoNoVisualizadoException extends AssertionError {
  public static final String MENSAJE_EDICION_FAVORITOS_NO_VISUALIZADO =
      "Mensaje de edicion favoritos no visualizado";

  public MensajeEdicionFavoritoNoVisualizadoException(String mensaje, Throwable causa) {
    super(mensaje, causa);
  }
}
