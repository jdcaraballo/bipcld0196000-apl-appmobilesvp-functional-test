package com.banistmo.certificacion.models.comun;

import com.banistmo.certificacion.models.beneficiario.Beneficiario;
import com.banistmo.certificacion.models.notificaciones.DatosNotificacion;
import com.banistmo.certificacion.models.productos.Producto;
import com.banistmo.certificacion.models.productos.Recargas;
import com.banistmo.certificacion.models.productos.Servicio;

public class Validacion {
  private Servicio servicio = new Servicio();
  private Beneficiario beneficiario = new Beneficiario();
  private Producto producto = new Producto();
  private Recargas recargas = new Recargas();
  private DatosNotificacion datosNotificacion = new DatosNotificacion();

  public Validacion(Transaccion transaccion) {
    producto = transaccion.getProducto();
    beneficiario = transaccion.getBeneficiario();
  }

  public Validacion(Producto producto) {
    this.producto = producto;
  }

  public Validacion(Recargas recargas) {
    this.recargas = recargas;
  }

  public Validacion() {}

  public Validacion(Servicio servicio) {
    this.servicio = servicio;
  }

  public Validacion(DatosNotificacion datosNotificacion) {
    this.datosNotificacion = datosNotificacion;
  }

  public Servicio getServicio() {
    return servicio;
  }

  public Beneficiario getBeneficiario() {
    return beneficiario;
  }

  public Producto getProducto() {
    return producto;
  }

  public void setProducto(Producto producto) {
    this.producto = producto;
  }

  public Recargas getRecargas() {
    return recargas;
  }

  public DatosNotificacion getDatosNotificacion() {
    return datosNotificacion;
  }
}
