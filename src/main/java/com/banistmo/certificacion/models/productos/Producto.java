package com.banistmo.certificacion.models.productos;

import com.banistmo.certificacion.models.builders.ProductoBuilder;

public class Producto {
  private String numeroCuentaRetiro;
  private String tipoProducto;
  private String numeroCuentaDestino;
  private String banco;
  private String codigoBanco;
  private String monto;
  private String descripcion = "Prueba";
  private String tipoTransaccion;
  private String fechaFuturo;
  private String frecuencia;
  private String diaRecurrente;
  private String fechaFuturoFin;
  private String paisDestino;
  private String diasFinal;
  private String diasInicial;
  private String cuotas;
  private String cuotaMensual;

  public Producto(ProductoBuilder builder) {
    this.numeroCuentaDestino = builder.getNumeroCuentaDestino();
    this.banco = builder.getBanco();
    this.monto = builder.getMonto();
    this.frecuencia = builder.getFrecuencia();
  }

  public Producto() {}

  public String getNumeroCuentaDestino() {
    return numeroCuentaDestino;
  }

  public void setNumeroCuentaDestino(String numeroCuentaDestino) {
    this.numeroCuentaDestino = numeroCuentaDestino;
  }

  public String getBanco() {
    return banco;
  }

  public void setBanco(String banco) {
    this.banco = banco;
  }

  public String getMonto() {
    return monto;
  }

  public void setMonto(String monto) {
    this.monto = monto;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public String getFrecuencia() {
    return frecuencia;
  }

  public void setFrecuencia(String frecuencia) {
    this.frecuencia = frecuencia;
  }

  public String getNumeroCuentaRetiro() {
    return numeroCuentaRetiro;
  }

  public void setNumeroCuentaRetiro(String numeroCuentaRetiro) {
    this.numeroCuentaRetiro = numeroCuentaRetiro;
  }

  public String getTipoTransaccion() {
    return tipoTransaccion;
  }

  public void setTipoTransaccion(String tipoTransaccion) {
    this.tipoTransaccion = tipoTransaccion;
  }

  public String getFechaFuturo() {
    return fechaFuturo;
  }

  public void setFechaFuturo(String fechaFuturo) {
    this.fechaFuturo = fechaFuturo;
  }

  public String getDiaRecurrente() {
    return diaRecurrente;
  }

  public void setDiaRecurrente(String diaRecurrente) {
    this.diaRecurrente = diaRecurrente;
  }

  public String getFechaFuturoFin() {
    return fechaFuturoFin;
  }

  public void setFechaFuturoFin(String fechaFuturoFin) {
    this.fechaFuturoFin = fechaFuturoFin;
  }

  public String getTipoProducto() {
    return tipoProducto;
  }

  public void setTipoProducto(String tipoCuenta) {
    this.tipoProducto = tipoCuenta;
  }

  public String getCodigoBanco() {
    return codigoBanco;
  }

  public void setCodigoBanco(String codigoBanco) {
    this.codigoBanco = codigoBanco;
  }

  public String getPaisDestino() {
    return paisDestino;
  }

  public void setPaisDestino(String paisDestino) {
    this.paisDestino = paisDestino;
  }

  public int getDiasFinal() {
    return Integer.parseInt(diasFinal);
  }

  public void setDiasFinal(String diasFinal) {
    this.diasFinal = diasFinal;
  }

  public int getDiasInicial() {
    return Integer.parseInt(diasInicial);
  }

  public void setDiasInicial(String diasInicial) {
    this.diasInicial = diasInicial;
  }

  public String getCuotas() {
    return cuotas;
  }

  public void setCuotas(String cuotas) {
    this.cuotas = cuotas;
  }

  public String getCuotaMensual() {
    return cuotaMensual;
  }

  public void setCuotaMensual(String cuotaMensual) {
    this.cuotaMensual = cuotaMensual;
  }
}
