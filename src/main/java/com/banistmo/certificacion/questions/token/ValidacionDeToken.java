package com.banistmo.certificacion.questions.token;

import static com.banistmo.certificacion.userinterface.comunes.TransaccionesGeneralPage.LBL_ALERTA_TOKEN;

import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import java.time.Duration;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;

public class ValidacionDeToken implements Question<Boolean> {
  public static ValidacionDeToken enPantalla() {
    return new ValidacionDeToken();
  }

  @Override
  public Boolean answeredBy(Actor actor) {
    actor.attemptsTo(EsperarCarga.desaparezca(), EsperarElemento.esVisible(LBL_ALERTA_TOKEN));
    return !Visibility.of(LBL_ALERTA_TOKEN.waitingForNoMoreThan(Duration.ofSeconds(20)))
        .viewedBy(actor)
        .resolveAll()
        .isEmpty();
  }
}
