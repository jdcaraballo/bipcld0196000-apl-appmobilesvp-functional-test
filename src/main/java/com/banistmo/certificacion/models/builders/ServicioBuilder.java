package com.banistmo.certificacion.models.builders;

import com.banistmo.certificacion.models.beneficiario.Beneficiario;
import com.banistmo.certificacion.models.productos.Producto;
import com.banistmo.certificacion.models.productos.Servicio;
import java.util.List;
import java.util.Map;

public class ServicioBuilder {
  private String servicio;
  private Beneficiario beneficiario = new Beneficiario();
  private Producto producto = new Producto();

  public ServicioBuilder() {
    this.servicio = "";
    this.producto.setMonto("");
  }

  public static ServicioBuilder con() {
    return new ServicioBuilder();
  }

  public ServicioBuilder servicio(List<Map<String, String>> datos) {
    this.servicio = datos.get(0).get("Nombre servicio");
    return this;
  }

  public ServicioBuilder nombreFavorito(List<Map<String, String>> datos) {
    this.producto.setDescripcion(datos.get(0).get("Nombre favorito"));
    return this;
  }

  public ServicioBuilder monto(List<Map<String, String>> datos) {
    this.producto.setMonto(datos.get(0).get("Monto"));
    return this;
  }

  public ServicioBuilder numero(List<Map<String, String>> datos) {
    this.beneficiario.setNumero(datos.get(0).get("Numero pago"));
    return this;
  }

  public ServicioBuilder nombreCliente(List<Map<String, String>> datos) {
    this.beneficiario.setNombre(datos.get(0).get("Nombre beneficiario"));
    return this;
  }

  public ServicioBuilder telefono(List<Map<String, String>> datos) {
    this.beneficiario.setNumero(datos.get(0).get("Numero pago"));
    return this;
  }

  public String getServicio() {
    return servicio;
  }

  public Beneficiario getBeneficiario() {
    return beneficiario;
  }

  public Producto getProducto() {
    return producto;
  }

  public Servicio build() {
    return new Servicio(this);
  }
}
