package com.banistmo.certificacion.questions.configuracion.seguridad;

import static com.banistmo.certificacion.utils.enums.EnumVariablesSesion.DESCRIPCION_TOKEN;

import com.banistmo.certificacion.userinterface.configuracion.seguridad.TokenPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Presence;

public class TokenEliminado implements Question<Boolean> {
  public static TokenEliminado exitoso() {
    return new TokenEliminado();
  }

  @Override
  public Boolean answeredBy(Actor actor) {
    String descripcionToken = actor.recall(DESCRIPCION_TOKEN.getVariableSesion()).toString();
    actor.attemptsTo(Click.on(TokenPage.BTN_ENTENDIDO));
    if (!Presence.of(TokenPage.BTN_INSCRIBIR).viewedBy(actor).resolveAll().isEmpty()) {
      actor.attemptsTo(Click.on(TokenPage.BTN_INSCRIBIR));
      return Presence.of(TokenPage.BTN_USUARIO_REGISTRADO.of(descripcionToken))
          .viewedBy(actor)
          .resolveAll()
          .isEmpty();
    }
    return true;
  }
}
