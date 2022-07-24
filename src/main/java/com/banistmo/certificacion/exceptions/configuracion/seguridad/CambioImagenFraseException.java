package com.banistmo.certificacion.exceptions.configuracion.seguridad;

public class CambioImagenFraseException extends AssertionError {
  public static final String ERROR_CAMBIO_IMAGE_FRASE =
      "Error al realizar la modificación de imagen o frase";

  public CambioImagenFraseException(String mensaje, Throwable causa) {
    super(mensaje, causa);
  }
}
