package com.banistmo.certificacion.questions;

import static com.banistmo.certificacion.userinterface.autenticacion.LoginPage.MSG_APLICACION;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class VerificarMensajeAlRegresar implements Question<Boolean> {

  private String mensaje;

  public VerificarMensajeAlRegresar(String mensaje) {
    this.mensaje = mensaje;
  }

  public static VerificarMensajeAlRegresar esVisible(String mensaje) {
    return new VerificarMensajeAlRegresar(mensaje);
  }

  @Override
  public Boolean answeredBy(Actor actor) {
    return !MSG_APLICACION.of(mensaje).resolveAllFor(actor).isEmpty();
  }
}
