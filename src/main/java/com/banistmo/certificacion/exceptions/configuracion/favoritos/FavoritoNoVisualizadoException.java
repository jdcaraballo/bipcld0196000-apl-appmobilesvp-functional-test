package com.banistmo.certificacion.exceptions.configuracion.favoritos;

public class FavoritoNoVisualizadoException extends AssertionError {
  public static final String FAVORITO_NO_VISUALIZADO = "El favorito recien creado no es visible";

  public FavoritoNoVisualizadoException(String mensaje, Throwable causa) {
    super(mensaje, causa);
  }
}
