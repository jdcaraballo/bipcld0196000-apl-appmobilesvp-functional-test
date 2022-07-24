package com.banistmo.certificacion.questions;

import static com.banistmo.certificacion.userinterface.prestamos.PrestamosPage.BTN_ALERTA;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import com.banistmo.certificacion.interactions.ClickInvisible;
import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;
import net.serenitybdd.screenplay.targets.Target;

public class ElementoEsperado implements Question<Boolean> {

  Target elemento;

  public ElementoEsperado(Target elemento) {
    this.elemento = elemento;
  }

  public static ElementoEsperado esVisible(Target elemento) {
    return new ElementoEsperado(elemento);
  }

  @Override
  public Boolean answeredBy(Actor actor) {
    actor.attemptsTo(EsperarCarga.desaparezca());
    boolean resultado = elemento.resolveFor(actor).isVisible();
    if (!Visibility.of(BTN_ALERTA).viewedBy(actor).resolveAll().isEmpty()) {
      theActorInTheSpotlight().attemptsTo(ClickInvisible.enReporte(BTN_ALERTA));
    }
    return resultado;
  }
}
