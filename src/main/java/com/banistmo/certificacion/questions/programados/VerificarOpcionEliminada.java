package com.banistmo.certificacion.questions.programados;

import static com.banistmo.certificacion.userinterface.comunes.ProgramadasPage.BTN_ELIMINAR;
import static com.banistmo.certificacion.userinterface.comunes.ProgramadasPage.BTN_PROGRAMADAS;
import static com.banistmo.certificacion.userinterface.menu.MenuPage.BTN_TRANSFERENCIAS;

import com.banistmo.certificacion.interactions.Regresar;
import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import com.banistmo.certificacion.models.comun.Validacion;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Presence;

public class VerificarOpcionEliminada implements Question<Boolean> {
  private Validacion validacion;

  public VerificarOpcionEliminada(Validacion validacion) {
    this.validacion = validacion;
  }

  public static VerificarOpcionEliminada exitosa(Validacion validacion) {
    return new VerificarOpcionEliminada(validacion);
  }

  @Override
  public Boolean answeredBy(Actor actor) {

    if (Presence.of(BTN_ELIMINAR.of(validacion.getProducto().getDescripcion()))
        .viewedBy(actor)
        .resolveAll()
        .isEmpty()) {
      return true;
    } else {
      actor.attemptsTo(
          Regresar.pantallaAnterior(),
          EsperarElemento.esClickable(BTN_TRANSFERENCIAS),
          Click.on(BTN_TRANSFERENCIAS),
          EsperarElemento.esClickable(BTN_PROGRAMADAS),
          Click.on(BTN_PROGRAMADAS),
          EsperarCarga.desaparezca());
      return Presence.of(BTN_ELIMINAR.of(validacion.getProducto().getDescripcion()))
          .viewedBy(actor)
          .resolveAll()
          .isEmpty();
    }
  }
}
