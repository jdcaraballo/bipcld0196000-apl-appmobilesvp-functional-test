package com.banistmo.certificacion.task.configuracion.seguridad;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class InscribirToken {

  private InscribirToken() {}

  public static ConCodigoDetectID exitoso(String descripcionToken) {
    return instrumented(ConCodigoDetectID.class, descripcionToken);
  }

  public static ConOtroDetectID exitosa(
      String otroUsuario, String claveOtroUsuario, String descripcionToken) {
    return instrumented(ConOtroDetectID.class, otroUsuario, claveOtroUsuario, descripcionToken);
  }

  public static ConTarjetaDebitoYPin exitoso(
      String tarjetaDebito, String claveCajeroAutomatico, String descripcionToken) {
    return instrumented(
        ConTarjetaDebitoYPin.class, tarjetaDebito, claveCajeroAutomatico, descripcionToken);
  }

  public static ConTarjetaDebitoYPinFallido fallido(
      String tarjetaDebito, String claveCajeroAutomatico) {
    return instrumented(ConTarjetaDebitoYPinFallido.class, tarjetaDebito, claveCajeroAutomatico);
  }

  public static ConCodigoDetectIDFallido fallido(String codigo) {
    return instrumented(ConCodigoDetectIDFallido.class, codigo);
  }
}
