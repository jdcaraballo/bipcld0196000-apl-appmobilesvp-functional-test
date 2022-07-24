package com.banistmo.certificacion.models.productos;

import com.banistmo.certificacion.models.beneficiario.Beneficiario;
import com.banistmo.certificacion.models.builders.RecargasBuilder;

public class Recargas {
  private Producto producto;
  private Beneficiario beneficiario;
  private String nombreOperador;

  public Recargas(RecargasBuilder builder) {
    this.nombreOperador = builder.getNombreOperador();
    this.producto = builder.getProducto();
    this.beneficiario = builder.getBeneficiario();
  }

  public Recargas() {}

  public Beneficiario getBeneficiario() {
    return beneficiario;
  }

  public String getNombreOperador() {
    return nombreOperador;
  }

  public void setNombreOperador(String nombreOperador) {
    this.nombreOperador = nombreOperador;
  }

  public Producto getProducto() {
    return producto;
  }
}
