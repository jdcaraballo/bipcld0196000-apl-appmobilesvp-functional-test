package com.banistmo.certificacion.task.configuracion.favoritos.eliminar;

import static com.banistmo.certificacion.userinterface.configuracion.FavoritosGeneralPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class Eliminar implements Task {

  private final String nombre;

  public Eliminar(String nombre) {
    this.nombre = nombre;
  }

  public static Eliminar favorito(String nombre) {
    return instrumented(Eliminar.class, nombre);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        EsperarElemento.esClickable(BTN_FAVORITO.of(nombre)),
        Click.on(BTN_FAVORITO.of(nombre)),
        EsperarCarga.desaparezca(),
        EsperarElemento.esClickable(BTN_ELIMINAR_FAVORITO),
        Click.on(BTN_ELIMINAR_FAVORITO),
        EsperarElemento.esClickable(BTN_CONFIRMAR_ELIMINAR_FAVORITO),
        Click.on(BTN_CONFIRMAR_ELIMINAR_FAVORITO),
        EsperarCarga.desaparezca(),
        EsperarElemento.esClickable(BTN_PRODUCTOS_ACTIVOS),
        Click.on(BTN_PRODUCTOS_ACTIVOS),
        EsperarCarga.desaparezca());
  }
}
