package com.banistmo.certificacion.models.notificaciones;

import java.util.List;
import java.util.Map;

public class DatosNotificacionBuilder {

  private DatosNotificacion datosNotificacion = new DatosNotificacion();

  public DatosNotificacionBuilder() {
    this.datosNotificacion.setMenu("");
    this.datosNotificacion.setOpcion("");
    this.datosNotificacion.setMedioNotificacion("");
    this.datosNotificacion.setActiva("");
    this.datosNotificacion.setMonto("");
  }

  public static DatosNotificacionBuilder con() {
    return new DatosNotificacionBuilder();
  }

  public DatosNotificacionBuilder menu(List<Map<String, String>> datos) {
    this.datosNotificacion.setMenu(datos.get(0).get("menu"));
    return this;
  }

  public DatosNotificacionBuilder menu(String datos) {
    this.datosNotificacion.setMenu(datos);
    return this;
  }

  public DatosNotificacionBuilder opcion(List<Map<String, String>> datos) {
    this.datosNotificacion.setOpcion(datos.get(0).get("opcion"));
    return this;
  }

  public DatosNotificacionBuilder opcion(String datos) {
    this.datosNotificacion.setOpcion(datos);
    return this;
  }

  public DatosNotificacionBuilder activa(List<Map<String, String>> datos) {
    if (("si").equalsIgnoreCase((datos.get(0).get("notificar")))) {
      this.datosNotificacion.setActiva("true");
    } else {
      this.datosNotificacion.setActiva("false");
    }
    return this;
  }

  public DatosNotificacionBuilder activa(String datos) {
    if (("si").equalsIgnoreCase((datos)) || ("true").equalsIgnoreCase((datos))) {
      this.datosNotificacion.setActiva("true");
    } else {
      this.datosNotificacion.setActiva("false");
    }
    return this;
  }

  public DatosNotificacionBuilder medioNotificacion(List<Map<String, String>> datos) {
    this.datosNotificacion.setMedioNotificacion(datos.get(0).get("medio"));
    return this;
  }

  public DatosNotificacionBuilder medioNotificacion(String datos) {
    this.datosNotificacion.setMedioNotificacion(datos);
    return this;
  }

  public DatosNotificacionBuilder monto(List<Map<String, String>> datos) {
    this.datosNotificacion.setMonto(datos.get(0).get("monto"));
    return this;
  }

  public DatosNotificacionBuilder monto(String datos) {
    this.datosNotificacion.setMonto(datos);
    return this;
  }

  public DatosNotificacion build() {
    return datosNotificacion;
  }
}
