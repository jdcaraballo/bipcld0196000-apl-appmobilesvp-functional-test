package com.banistmo.certificacion.models.productos;

import com.banistmo.certificacion.models.beneficiario.Beneficiario;
import com.banistmo.certificacion.models.builders.ServicioBuilder;

public class Servicio {
  private String nombreServicio;
  private String codigoServicio;
  private Beneficiario beneficiario;
  private Producto producto;

  public Servicio(ServicioBuilder builder) {
    this.nombreServicio = builder.getServicio();
    this.beneficiario = builder.getBeneficiario();
    this.producto = builder.getProducto();
  }

  public Servicio() {}

  public String getCodigoServicio() {
    return codigoServicio;
  }

  public void setCodigoServicio(String codigoServicio) {
    this.codigoServicio = codigoServicio;
  }

  public String getNombreServicio() {
    return nombreServicio;
  }

  public Beneficiario getBeneficiario() {
    return beneficiario;
  }

  public Producto getProducto() {
    return producto;
  }
}
