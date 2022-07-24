package com.banistmo.certificacion.models.builders;

import com.banistmo.certificacion.models.beneficiario.Beneficiario;
import com.banistmo.certificacion.models.comun.Transaccion;
import com.banistmo.certificacion.models.productos.Producto;
import java.util.List;
import java.util.Map;

public class TransaccionBuilder {

  private Producto producto = new Producto();
  private Beneficiario beneficiario = new Beneficiario();

  public TransaccionBuilder() {
    this.producto.setBanco("");
    this.producto.setNumeroCuentaDestino("");
    this.producto.setTipoProducto("");
    this.producto.setMonto("");
    this.producto.setFrecuencia("");
  }

  public static TransaccionBuilder con() {
    return new TransaccionBuilder();
  }

  public TransaccionBuilder pais(List<Map<String, String>> datos) {
    this.producto.setPaisDestino(datos.get(0).get("Pais"));
    return this;
  }

  public TransaccionBuilder numeroCuenta(List<Map<String, String>> datos) {
    this.producto.setNumeroCuentaDestino(datos.get(0).get("Cuenta"));
    return this;
  }

  public TransaccionBuilder banco(List<Map<String, String>> datos) {
    this.producto.setBanco(datos.get(0).get("Banco"));
    return this;
  }

  public TransaccionBuilder tipoProducto(List<Map<String, String>> datos) {
    this.producto.setTipoProducto(datos.get(0).get("Tipo producto"));
    return this;
  }

  public TransaccionBuilder cuenta(List<Map<String, String>> datos) {
    this.producto.setNumeroCuentaDestino(datos.get(0).get("Cuenta"));
    return this;
  }

  public TransaccionBuilder monto(List<Map<String, String>> datos) {
    this.producto.setMonto(datos.get(0).get("Monto"));
    return this;
  }

  public TransaccionBuilder descripcion(List<Map<String, String>> datos) {
    this.producto.setDescripcion(datos.get(0).get("Descripcion"));
    return this;
  }

  public TransaccionBuilder nombreFavorito(List<Map<String, String>> datos) {
    this.producto.setDescripcion(datos.get(0).get("Nombre favorito"));
    return this;
  }

  public TransaccionBuilder frecuencia(List<Map<String, String>> datos) {
    this.producto.setFrecuencia(datos.get(0).get("Frecuencia"));
    return this;
  }

  public TransaccionBuilder monto(String monto) {
    this.producto.setMonto(monto);
    return this;
  }

  public TransaccionBuilder descripcion(String descripcion) {
    this.producto.setDescripcion(descripcion);
    return this;
  }

  public TransaccionBuilder frecuencia(String frecuencia) {
    this.producto.setFrecuencia(frecuencia);
    return this;
  }

  public TransaccionBuilder nombreBeneficiario(List<Map<String, String>> datos) {
    this.beneficiario.setNombre(datos.get(0).get("Nombre beneficiario"));
    return this;
  }

  public TransaccionBuilder correo(List<Map<String, String>> datos) {
    this.beneficiario.setCorreo(datos.get(0).get("Correo electronico"));
    return this;
  }

  public TransaccionBuilder paisBeneficiario(List<Map<String, String>> datos) {
    this.beneficiario.setPais(datos.get(0).get("Pais beneficiario"));
    return this;
  }

  public TransaccionBuilder ciudad(List<Map<String, String>> datos) {
    this.beneficiario.setCiudad(datos.get(0).get("Ciudad beneficiario"));
    return this;
  }

  public TransaccionBuilder direccion(List<Map<String, String>> datos) {
    this.beneficiario.setDireccion(datos.get(0).get("Direccion beneficiario"));
    return this;
  }

  public TransaccionBuilder telefono(List<Map<String, String>> datos) {
    this.beneficiario.setDireccion(datos.get(0).get("Telefono beneficiario"));
    return this;
  }

  public TransaccionBuilder diaRecurrente(List<Map<String, String>> datos) {
    this.producto.setDiaRecurrente(datos.get(0).get("Dia"));
    return this;
  }

  public TransaccionBuilder diasFinal(List<Map<String, String>> datos) {
    this.producto.setDiasFinal(datos.get(0).get("Dias final"));
    return this;
  }

  public TransaccionBuilder cuotas(String cuota) {
    this.producto.setCuotas(cuota);
    return this;
  }

  public Producto getProducto() {
    return producto;
  }

  public Beneficiario getBeneficiario() {
    return beneficiario;
  }

  public Transaccion build() {
    return new Transaccion(this);
  }
}
