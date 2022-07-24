package com.banistmo.certificacion.exceptions.configuracion.productos;

public class ObjetivoAhorroNoConfiguradoException extends AssertionError {
  public static final String OBJETIVO_AHORRO_NO_CONFIGURADO =
      "El objetivo de ahorro no fue configurado correctamente";

  public ObjetivoAhorroNoConfiguradoException(String mensaje, Throwable causa) {
    super(mensaje, causa);
  }
}
