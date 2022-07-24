package com.banistmo.certificacion.models.builders;

import com.banistmo.certificacion.models.beneficiario.Beneficiario;
import com.banistmo.certificacion.models.productos.Producto;
import com.banistmo.certificacion.models.productos.Recargas;
import java.util.List;
import java.util.Map;

public class RecargasBuilder {
  private String nombreOperador;
  private Beneficiario beneficiario = new Beneficiario();
  private Producto producto = new Producto();

  public RecargasBuilder() {
    this.beneficiario.setNumero("");
    this.nombreOperador = "";
    this.producto.setMonto("");
  }

  public static RecargasBuilder con() {
    return new RecargasBuilder();
  }

  public RecargasBuilder nombreOperador(List<Map<String, String>> datos) {
    this.nombreOperador = datos.get(0).get("Operador");
    return this;
  }

  public RecargasBuilder tipoProducto(List<Map<String, String>> datos) {
    this.producto.setTipoProducto(datos.get(0).get("Tipo producto"));
    return this;
  }

  public RecargasBuilder nombreFavorito(List<Map<String, String>> datos) {
    this.producto.setDescripcion(datos.get(0).get("Nombre favorito"));
    return this;
  }

  public RecargasBuilder numeroTarjeta(List<Map<String, String>> datos) {
    this.beneficiario.setNumero(datos.get(0).get("Numero de Tarjeta"));
    return this;
  }

  public RecargasBuilder numeroPanapass(List<Map<String, String>> datos) {
    this.beneficiario.setNumero(datos.get(0).get("Numero Panapass"));
    return this;
  }

  public RecargasBuilder numeroCelular(List<Map<String, String>> datos) {
    this.beneficiario.setNumero(datos.get(0).get("Numero de celular"));
    return this;
  }

  public RecargasBuilder nombreOperador(String dato) {
    this.nombreOperador = dato;
    return this;
  }

  public RecargasBuilder numero(List<Map<String, String>> datos) {
    this.beneficiario.setNumero(datos.get(0).get("Numero"));
    return this;
  }

  public RecargasBuilder monto(List<Map<String, String>> datos) {
    this.producto.setMonto(datos.get(0).get("Monto"));
    return this;
  }


  public RecargasBuilder monto(String monto) {
    this.producto.setMonto(monto);
    return this;
  }

  public Beneficiario getBeneficiario() {
    return beneficiario;
  }

  public Producto getProducto() {
    return producto;
  }

  public String getNombreOperador() {
    return nombreOperador;
  }

  public Recargas build() {
    return new Recargas(this);
  }
}
