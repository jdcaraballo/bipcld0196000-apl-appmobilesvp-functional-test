package com.banistmo.certificacion.task.comunes;

import static com.banistmo.certificacion.userinterface.configuracion.seguridad.CambiarImagenFrasePage.BTN_REGRESAR;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import com.banistmo.certificacion.userinterface.configuracion.seguridad.TokenPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class Volver implements Task {
  public static Volver alLogin() {
    return instrumented(Volver.class);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        Click.on(TokenPage.BTN_IR_A_INICIO), EsperarCarga.desaparezca(), Click.on(BTN_REGRESAR));
  }
}
