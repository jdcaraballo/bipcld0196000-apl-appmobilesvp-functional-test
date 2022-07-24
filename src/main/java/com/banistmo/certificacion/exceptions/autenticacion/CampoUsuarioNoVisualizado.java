package com.banistmo.certificacion.exceptions.autenticacion;

public class CampoUsuarioNoVisualizado extends AssertionError {
  public static final String CAMPO_USUARIO_NO_VISUALIZADO = "El campo usuario no es visible";

  public CampoUsuarioNoVisualizado(String mensaje, Throwable causa) {
    super(mensaje, causa);
  }
}
