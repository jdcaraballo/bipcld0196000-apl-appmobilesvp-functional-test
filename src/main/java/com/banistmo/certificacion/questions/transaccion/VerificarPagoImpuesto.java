package com.banistmo.certificacion.questions.transaccion;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class VerificarPagoImpuesto implements Question<Boolean> {

  public static VerificarPagoImpuesto exitoso() {
    return new VerificarPagoImpuesto();
  }

  @Override
  public Boolean answeredBy(Actor actor) {
    return false;
  }
}
