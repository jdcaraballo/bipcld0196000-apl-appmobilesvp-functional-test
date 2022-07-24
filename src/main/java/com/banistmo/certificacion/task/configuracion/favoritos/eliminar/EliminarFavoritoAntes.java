package com.banistmo.certificacion.task.configuracion.favoritos.eliminar;

import static com.banistmo.certificacion.userinterface.configuracion.FavoritosGeneralPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.banistmo.certificacion.interactions.esperas.Esperar;
import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import net.serenitybdd.markers.IsHidden;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.questions.Visibility;

public class EliminarFavoritoAntes implements Task, IsHidden {

  private final String nombre;

  public EliminarFavoritoAntes(String nombre) {
    this.nombre = nombre;
  }

  public static EliminarFavoritoAntes deLaPrueba(String nombre) {
    return instrumented(EliminarFavoritoAntes.class, nombre);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        EsperarCarga.desaparezca(),
        EsperarElemento.esClickable(TXT_BUSCAR_FAVORITO_ACTIVO),
        Enter.theValue(nombre).into(TXT_BUSCAR_FAVORITO_ACTIVO));
    if (!Visibility.of(BTN_FAVORITO_ACTIVA.of(nombre)).viewedBy(actor).resolveAll().isEmpty()) {
      actor.attemptsTo(Eliminar.favorito(nombre));
    } else {
      actor.attemptsTo(
          EsperarElemento.esClickable(BTN_PRODUCTOS_INACTIVOS),
          Click.on(BTN_PRODUCTOS_INACTIVOS),
          Enter.theValue(nombre).into(TXT_BUSCAR_FAVORITO_INACTIVO),
          Esperar.unTiempo(1000));
      if (!Visibility.of(BTN_FAVORITO_INACTIVA.of(nombre)).viewedBy(actor).resolveAll().isEmpty()) {
        actor.attemptsTo(Eliminar.favorito(nombre));
      } else {
        actor.attemptsTo(
            EsperarElemento.esClickable(BTN_PRODUCTOS_ACTIVOS),
            Click.on(BTN_PRODUCTOS_ACTIVOS),
            EsperarCarga.desaparezca());
      }
    }
  }
}
