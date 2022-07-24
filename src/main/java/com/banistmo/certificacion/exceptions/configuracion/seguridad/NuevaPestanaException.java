package com.banistmo.certificacion.exceptions.configuracion.seguridad;

public class NuevaPestanaException extends AssertionError {
  public static final String NUEVA_PESTANIA_NO_ENCONTRADA =
      "no se encuentra nueva pestaña para continuar el flujo";

  public NuevaPestanaException(String mensaje, Throwable causa) {
    super(mensaje, causa);
  }
}
