package com.banistmo.certificacion.task.comunes;

import static com.banistmo.certificacion.userinterface.PrincipalPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.banistmo.certificacion.interactions.Regresar;
import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.questions.Visibility;

public class Retroceder implements Task {

  public static Retroceder hastaPantallaInicio() {
    return instrumented(Retroceder.class);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    while (Visibility.of(LST_CARD_PRODUCTOS).viewedBy(actor).resolveAll().isEmpty()) {
      actor.attemptsTo(Regresar.pantallaAnterior(), EsperarCarga.desaparezca());
    }
  }
}
