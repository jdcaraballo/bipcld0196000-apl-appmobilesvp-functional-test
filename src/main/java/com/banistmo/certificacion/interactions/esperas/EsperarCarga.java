package com.banistmo.certificacion.interactions.esperas;

import static com.banistmo.certificacion.userinterface.autenticacion.LoginPage.SPN_CARGA;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.questions.Presence;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.steps.StepInterceptor;
import org.openqa.selenium.StaleElementReferenceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EsperarCarga implements Interaction {

  private static final Logger LOGGER = LoggerFactory.getLogger(StepInterceptor.class);
  private int intentos = 0;

  public static EsperarCarga desaparezca() {
    return instrumented(EsperarCarga.class);
  }

  private <T extends Actor> void esperando(T actor) {
    while (intentos < 10) {
      if (!Presence.of(SPN_CARGA).viewedBy(actor).resolveAll().isEmpty()) {
        actor.attemptsTo(WaitUntil.the(SPN_CARGA, isNotVisible()).forNoMoreThan(30).seconds());
      }
      actor.attemptsTo(Esperar.unTiempo(1000));
      if (Presence.of(SPN_CARGA).viewedBy(actor).resolveAll().isEmpty()) {
        break;
      }
      intentos++;
    }
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    try {
      esperando(actor);
    } catch (StaleElementReferenceException e) {
      LOGGER.info(String.valueOf(e));
    }
  }
}
