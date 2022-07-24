package com.banistmo.certificacion.exceptions.configuracion.favoritos;

public class FavoritoNoActivadoException extends AssertionError {
  public static final String FAVORITOS_NO_ACTIVADO = "Favorito no activado correctamente";

  public FavoritoNoActivadoException(String mensaje, Throwable causa) {
    super(mensaje, causa);
  }
}
