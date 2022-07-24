package com.banistmo.certificacion.questions;

import static com.banistmo.certificacion.userinterface.autenticacion.LoginPage.MSG_APLICACION;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class VerificarMensaje implements Question<Boolean> {

  private String mensaje;

  public VerificarMensaje(String mensaje) {
    this.mensaje = mensaje;
  }

  public static VerificarMensaje esVisible(String mensaje) {
    return new VerificarMensaje(mensaje);
  }

  @Override
  public Boolean answeredBy(Actor actor) {
    return !MSG_APLICACION.of(mensaje).resolveAllFor(actor).isEmpty();
  }
}
