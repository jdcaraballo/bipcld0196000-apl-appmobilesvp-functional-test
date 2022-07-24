package com.banistmo.certificacion.questions.extrafinanciamiento;

import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import com.banistmo.certificacion.userinterface.PrincipalPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class MensajeDeExtrafinanciamiento implements Question<Boolean> {

  public static MensajeDeExtrafinanciamiento reaparece() {
    return new MensajeDeExtrafinanciamiento();
  }

  @Override
  public Boolean answeredBy(Actor actor) {
    actor.attemptsTo(EsperarElemento.esVisible(PrincipalPage.LBL_MENSAJE_EXTRAFINANCIAMIENTO));
    return PrincipalPage.LBL_MENSAJE_EXTRAFINANCIAMIENTO.resolveFor(actor).isCurrentlyVisible();
  }
}
