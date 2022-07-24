package com.banistmo.certificacion.utils.enums;

public enum EnumProductos {
  TARJETAS_CREDITO("Tarjetas de crédito"),
  TARJETA_CREDITO("Tarjeta de crédito"),
  PROPIO("propio");

  private String producto;

  EnumProductos(String producto) {
    this.producto = producto;
  }

  public String getProducto() {
    return producto;
  }
}
