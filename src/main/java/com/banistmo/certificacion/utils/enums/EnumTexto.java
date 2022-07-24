package com.banistmo.certificacion.utils.enums;

public enum EnumTexto {
  TEXTO_CONFIGURACION("Configuración"),
  TEXTO_ADMINISTRACION("Administracion"),
  TEXTO_SEGURIDAD("Seguridad");

  private String texto;

  EnumTexto(String texto) {
    this.texto = texto;
  }

  public String getTexto() {
    return texto;
  }
}
