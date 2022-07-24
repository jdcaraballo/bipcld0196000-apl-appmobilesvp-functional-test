package com.banistmo.certificacion.questions.configuracion.seguridad;

public class DatosImagenFrase {

  private DatosImagenFrase() {}

  public static CambioImagenFrase nuevos() {
    return new CambioImagenFrase();
  }

  public static SinCambioImagenFrase sinCambio() {
    return new SinCambioImagenFrase();
  }
}
