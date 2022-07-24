package com.banistmo.certificacion.questions.configuracion.productos;

import static com.banistmo.certificacion.userinterface.configuracion.administracion.producto.ConfiguracionProductoPage.BTN_NOMBRE_CUENTAS;
import static com.banistmo.certificacion.utils.enums.EnumVariablesSesion.NOMBRE_NUEVO;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;

public class VerificarCambio implements Question<Boolean> {

  public static VerificarCambio aliasProducto() {
    return new VerificarCambio();
  }

  @Override
  public Boolean answeredBy(Actor actor) {
    String nombreProducto = actor.recall(NOMBRE_NUEVO.getVariableSesion());
    return Visibility.of(BTN_NOMBRE_CUENTAS.of(nombreProducto)).viewedBy(actor).asBoolean();
  }
}
