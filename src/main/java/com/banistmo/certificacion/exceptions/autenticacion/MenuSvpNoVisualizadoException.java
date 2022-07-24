package com.banistmo.certificacion.exceptions.autenticacion;

public class MenuSvpNoVisualizadoException extends AssertionError {
  public static final String MENU_VALIDACION_NO_ENCONTRADO = "Menu de SVP no visualizado";

  public MenuSvpNoVisualizadoException(String mensaje, Throwable causa) {
    super(mensaje, causa);
  }
}
