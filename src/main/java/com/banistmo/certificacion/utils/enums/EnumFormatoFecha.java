package com.banistmo.certificacion.utils.enums;

public enum EnumFormatoFecha {
  FORMATO_FECHA_DD("d"),
  FORMATO_FECHA_MMM("MMM"),
  FORMATO_FECHA_MMMM("MMMM"),
  FORMATO_FECHA_YYYY("YYYY");

  private final String formatoFecha;

  EnumFormatoFecha(String formatoFecha) {
    this.formatoFecha = formatoFecha;
  }

  public String getFormatoFecha() {
    return formatoFecha;
  }
}
