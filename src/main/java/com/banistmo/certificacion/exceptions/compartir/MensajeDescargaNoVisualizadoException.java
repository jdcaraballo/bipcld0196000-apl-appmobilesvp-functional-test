package com.banistmo.certificacion.exceptions.compartir;

public class MensajeDescargaNoVisualizadoException extends AssertionError {
  public static final String MENSAJE_COMPARTIR_NO_ENCONTRADO =
      "Mensaje de descarga completada no se ha encontrado";

  public MensajeDescargaNoVisualizadoException(String mensaje, Throwable causa) {
    super(mensaje, causa);
  }
}
