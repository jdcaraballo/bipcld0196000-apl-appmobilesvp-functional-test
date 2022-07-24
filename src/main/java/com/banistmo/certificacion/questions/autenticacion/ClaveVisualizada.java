package com.banistmo.certificacion.questions.autenticacion;

import static com.banistmo.certificacion.userinterface.autenticacion.LoginPage.TXT_CLAVE;

import com.banistmo.certificacion.questions.ObtenerValor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ClaveVisualizada implements Question<Boolean> {

  private final String clave;

  public ClaveVisualizada(String clave) {
    this.clave = clave;
  }

  public static ClaveVisualizada esCorrecta(String clave) {
    return new ClaveVisualizada(clave);
  }

  @Override
  public Boolean answeredBy(Actor actor) {
    return ObtenerValor.elemento(TXT_CLAVE).answeredBy(actor).equals(clave);
  }
}
