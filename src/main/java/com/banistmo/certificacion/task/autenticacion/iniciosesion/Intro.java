package com.banistmo.certificacion.task.autenticacion.iniciosesion;

import static com.banistmo.certificacion.userinterface.autenticacion.LoginPage.BTN_SKIP_INTRO;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.banistmo.certificacion.interactions.esperas.Esperar;
import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Visibility;

public class Intro implements Task {

  public static Intro deSvp() {
    return instrumented(Intro.class);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        EsperarCarga.desaparezca(), Esperar.unTiempo(6000), EsperarCarga.desaparezca());
    if (!Visibility.of(BTN_SKIP_INTRO).viewedBy(actor).resolveAll().isEmpty()) {
      actor.attemptsTo(
          EsperarElemento.esVisible(BTN_SKIP_INTRO),
          EsperarElemento.esClickable(BTN_SKIP_INTRO),
          Click.on(BTN_SKIP_INTRO));
    }
  }
}
