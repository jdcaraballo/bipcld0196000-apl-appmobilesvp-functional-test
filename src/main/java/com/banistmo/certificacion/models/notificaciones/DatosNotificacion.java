package com.banistmo.certificacion.models.notificaciones;

public class DatosNotificacion {

  private String menu;
  private String opcion;
  private String activa;
  private String medioNotificacion;
  private String monto;

  public String getMenu() {
    return menu;
  }

  public void setMenu(String menu) {
    this.menu = menu;
  }

  public String getOpcion() {
    return opcion;
  }

  public void setOpcion(String opcion) {
    this.opcion = opcion;
  }

  public String getActiva() {
    return activa;
  }

  public void setActiva(String activa) {
    this.activa = activa;
  }

  public String getMedioNotificacion() {
    return medioNotificacion;
  }

  public void setMedioNotificacion(String medioNotificacion) {
    this.medioNotificacion = medioNotificacion;
  }

  public String getMonto() {
    return monto;
  }

  public void setMonto(String monto) {
    this.monto = monto;
  }
}
