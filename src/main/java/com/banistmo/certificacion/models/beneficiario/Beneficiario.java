package com.banistmo.certificacion.models.beneficiario;

public class Beneficiario {
  private String nombre = "Beneficiario";
  private String pais = "Angola";
  private String direccion = "Calle 30 40";
  private String ciudad = "Luanda";
  private String correo = "testqabanistmo@gmail.com";
  private String numero = "46789030";

  public String getNombre() {
    return nombre;
  }

  public String getPais() {
    return pais;
  }

  public void setPais(String pais) {
    this.pais = pais;
  }

  public String getDireccion() {
    return direccion;
  }

  public String getCiudad() {
    return ciudad;
  }

  public String getCorreo() {
    return correo;
  }

  public void setCorreo(String correo) {
    this.correo = correo;
  }

  public String getNumero() {
    return numero;
  }

  public void setNumero(String numero) {
    this.numero = numero;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }

  public void setCiudad(String ciudad) {
    this.ciudad = ciudad;
  }
}
