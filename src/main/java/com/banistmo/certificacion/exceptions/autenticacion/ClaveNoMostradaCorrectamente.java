package com.banistmo.certificacion.exceptions.autenticacion;

public class ClaveNoMostradaCorrectamente extends AssertionError {
  public static final String CLAVE_NO_MOSTRADA_CORRECTAMENTE =
      "La clave mostrada no es la correcta";

  public ClaveNoMostradaCorrectamente(String mensaje, Throwable causa) {
    super(mensaje, causa);
  }
}
