package com.banistmo.certificacion.task.configuracion.favoritos;

import static com.banistmo.certificacion.userinterface.configuracion.administracion.AdministracionPage.BTN_OPT_FAVORITOS;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class IngresarFavorito implements Task {
  private final String opcion;

  public IngresarFavorito(String opcion) {
    this.opcion = opcion;
  }

  public static IngresarFavorito opcion(String opcion) {
    return instrumented(IngresarFavorito.class, opcion);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        EsperarElemento.esClickable(BTN_OPT_FAVORITOS.of(opcion)),
        Click.on(BTN_OPT_FAVORITOS.of(opcion)),
        EsperarCarga.desaparezca());
  }
}
