package com.banistmo.certificacion.questions.configuracion.seguridad;

import static com.banistmo.certificacion.userinterface.comunes.TransaccionesGeneralPage.LBL_INGRESA_SOFTTOKEN;

import java.time.Duration;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;

public class ValidacionMensajeSoftToken implements Question<Boolean> {
  public static ValidacionMensajeSoftToken enPantalla() {
    return new ValidacionMensajeSoftToken();
  }

  @Override
  public Boolean answeredBy(Actor actor) {

    return !Visibility.of(LBL_INGRESA_SOFTTOKEN.waitingForNoMoreThan(Duration.ofSeconds(30)))
        .viewedBy(actor)
        .resolveAll()
        .isEmpty();
  }
}
