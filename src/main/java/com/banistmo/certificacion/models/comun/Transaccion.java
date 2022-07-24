package com.banistmo.certificacion.models.comun;

import com.banistmo.certificacion.models.beneficiario.Beneficiario;
import com.banistmo.certificacion.models.builders.TransaccionBuilder;
import com.banistmo.certificacion.models.productos.Producto;

public class Transaccion {
  private Producto producto;
  private Beneficiario beneficiario;

  public Transaccion(TransaccionBuilder builder) {
    this.producto = builder.getProducto();
    this.beneficiario = builder.getBeneficiario();
  }

  public Transaccion() {
    this.producto = new Producto();
    this.beneficiario = new Beneficiario();
  }

  public Producto getProducto() {
    return producto;
  }

  public Beneficiario getBeneficiario() {
    return beneficiario;
  }
}
