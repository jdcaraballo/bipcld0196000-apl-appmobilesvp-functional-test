package com.banistmo.certificacion.questions.servicios;

import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import com.banistmo.certificacion.models.comun.Validacion;
import com.banistmo.certificacion.questions.programados.VerificarTransaccionProgramada;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class VerificarServiciosProgramados implements Question<Boolean> {

  private Validacion validacion;
  private String mensajeExitoso;

  public VerificarServiciosProgramados(Validacion validacion, String mensajeExitoso) {
    this.validacion = validacion;
    this.mensajeExitoso = mensajeExitoso;
  }

  public static VerificarServiciosProgramados exitosa(
      Validacion validacion, String mensajeExitoso) {
    return new VerificarServiciosProgramados(validacion, mensajeExitoso);
  }

  @Override
  public Boolean answeredBy(Actor actor) {
    actor.attemptsTo(EsperarCarga.desaparezca());
    return VerificarServicios.exitosa(validacion, mensajeExitoso).answeredBy(actor)
        && VerificarTransaccionProgramada.exitosa(validacion).answeredBy(actor);
  }
}
