package com.banistmo.certificacion.questions.configuracion.seguridad;

import static com.banistmo.certificacion.userinterface.comunes.TransaccionesGeneralPage.LBL_ALERTA_TOKEN;

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

    return !Visibility.of(LBL_ALERTA_TOKEN.waitingForNoMoreThan(Duration.ofSeconds(15)))
        .viewedBy(actor)
        .resolveAll()
        .isEmpty();
  }
}
