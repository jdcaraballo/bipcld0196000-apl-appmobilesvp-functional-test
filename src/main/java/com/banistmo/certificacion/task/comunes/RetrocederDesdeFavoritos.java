package com.banistmo.certificacion.task.comunes;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.banistmo.certificacion.interactions.Regresar;
import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class RetrocederDesdeFavoritos implements Task {

  public static RetrocederDesdeFavoritos hastaPantallaInicio() {
    return instrumented(RetrocederDesdeFavoritos.class);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        Regresar.pantallaAnterior(),
        Regresar.pantallaAnterior(),
        Regresar.pantallaAnterior(),
        EsperarCarga.desaparezca());
  }
}
