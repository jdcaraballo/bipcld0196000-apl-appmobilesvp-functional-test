package com.banistmo.certificacion.exceptions.configuracion.favoritos;

public class FavoritoNoInactivadoException extends AssertionError {
  public static final String FAVORITOS_NO_INACTIVADO = "Favorito no inactivado correctamente";

  public FavoritoNoInactivadoException(String mensaje, Throwable causa) {
    super(mensaje, causa);
  }
}
