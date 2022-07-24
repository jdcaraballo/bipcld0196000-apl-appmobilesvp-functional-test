package com.banistmo.certificacion.questions.token;

import static com.banistmo.certificacion.userinterface.comunes.TransaccionesGeneralPage.LBL_ALERTA_TOKEN;

import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import java.time.Duration;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;

public class ValidacionDeTokenActualizarDatos implements Question<Boolean> {
  public static ValidacionDeTokenActualizarDatos enPantalla() {
    return new ValidacionDeTokenActualizarDatos();
  }

  @Override
  public Boolean answeredBy(Actor actor) {
    actor.attemptsTo(EsperarElemento.esVisible(LBL_ALERTA_TOKEN));
    return !Visibility.of(LBL_ALERTA_TOKEN.waitingForNoMoreThan(Duration.ofSeconds(10)))
        .viewedBy(actor)
        .resolveAll()
        .isEmpty();
  }
}
