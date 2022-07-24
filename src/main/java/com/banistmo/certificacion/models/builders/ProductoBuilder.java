package com.banistmo.certificacion.models.builders;

import com.banistmo.certificacion.models.productos.Producto;

public class ProductoBuilder {
  private String numeroCuentaDestino;
  private String banco;
  private String monto;
  private String frecuencia;

  public ProductoBuilder() {
    this.numeroCuentaDestino = "";
    this.banco = "";
    this.monto = "";
    this.frecuencia = "";
  }

  public static ProductoBuilder con() {
    return new ProductoBuilder();
  }

  public ProductoBuilder monto(String monto) {
    this.monto = monto;
    return this;
  }

  public ProductoBuilder frecuencia(String frecuencia) {
    this.frecuencia = frecuencia;
    return this;
  }

  public String getNumeroCuentaDestino() {
    return numeroCuentaDestino;
  }

  public String getBanco() {
    return banco;
  }

  public String getMonto() {
    return monto;
  }

  public String getFrecuencia() {
    return frecuencia;
  }

  public void setFrecuencia(String frecuencia) {
    this.frecuencia = frecuencia;
  }

  public Producto build() {
    return new Producto(this);
  }
}
