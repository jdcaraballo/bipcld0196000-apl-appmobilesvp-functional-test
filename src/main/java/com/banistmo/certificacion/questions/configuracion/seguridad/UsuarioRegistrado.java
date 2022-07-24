package com.banistmo.certificacion.questions.configuracion.seguridad;

import static com.banistmo.certificacion.utils.enums.EnumVariablesSesion.DESCRIPCION_TOKEN;

import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import com.banistmo.certificacion.userinterface.configuracion.seguridad.TokenPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;

public class UsuarioRegistrado implements Question<Boolean> {
  public static Question<Boolean> correctamente() {
    return new UsuarioRegistrado();
  }

  @Override
  public Boolean answeredBy(Actor actor) {
    String descripcionToken = actor.recall(DESCRIPCION_TOKEN.getVariableSesion()).toString();
    actor.attemptsTo(
        Click.on(TokenPage.BTN_IR_A_INICIO),
        EsperarCarga.desaparezca(),
        EsperarElemento.esClickable(TokenPage.BTN_GENERAR),
        Click.on(TokenPage.BTN_GENERAR));
    return TokenPage.BTN_USUARIO_REGISTRADO.of(descripcionToken).resolveFor(actor).isVisible();
  }
}
