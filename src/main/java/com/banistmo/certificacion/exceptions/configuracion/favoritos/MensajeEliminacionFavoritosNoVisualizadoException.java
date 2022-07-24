package com.banistmo.certificacion.exceptions.configuracion.favoritos;

public class MensajeEliminacionFavoritosNoVisualizadoException extends AssertionError {
  public static final String MENSAJE_ELIMINACION_FAVORITOS_NO_VISUALIZADO =
      "Mensaje exitoso de eliminacion favoritos no visualizado";

  public MensajeEliminacionFavoritosNoVisualizadoException(String mensaje, Throwable causa) {
    super(mensaje, causa);
  }
}
