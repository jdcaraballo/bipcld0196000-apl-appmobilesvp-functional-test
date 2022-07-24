package com.banistmo.certificacion.task.configuracion.favoritos;

import static com.banistmo.certificacion.userinterface.configuracion.FavoritosGeneralPage.BTN_FAVORITO_ACTIVA;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.banistmo.certificacion.interactions.esperas.Esperar;
import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import com.banistmo.certificacion.task.pagos.programados.SeleccionarOpcionEditarProgramados;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class SeleccionarOpcion implements Task {
  private String descripcion;

  public SeleccionarOpcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public static Performable conDescripcion(String descripcion) {
    return instrumented(SeleccionarOpcionEditarProgramados.class, descripcion);
  }

  public static Performable favoritos(String descripcion) {
    return instrumented(SeleccionarOpcion.class, descripcion);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        Esperar.unTiempo(3000),
        EsperarElemento.esClickable(BTN_FAVORITO_ACTIVA.of(descripcion)),
        Click.on(BTN_FAVORITO_ACTIVA.of(descripcion)),
        EsperarCarga.desaparezca());
  }
}
