package com.banistmo.certificacion.questions.configuracion.productos;

import static com.banistmo.certificacion.userinterface.comunes.TransaccionesGeneralPage.*;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class VerificarProducto implements Question<Boolean> {

  public static VerificarProducto preferido() {
    return new VerificarProducto();
  }

  @Override
  public Boolean answeredBy(Actor actor) {
    String cuentaPreferidaText = actor.recall("NumeroCuentaPreferida");
    return Text.of(LBL_NUMERO_CUENTA_RETIRO)
        .viewedBy(actor)
        .asString()
        .trim()
        .equals(cuentaPreferidaText);
  }
}
