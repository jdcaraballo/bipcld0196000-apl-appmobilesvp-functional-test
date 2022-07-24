package com.banistmo.certificacion.questions.programados;

import com.banistmo.certificacion.models.comun.Validacion;
import com.banistmo.certificacion.questions.transferencias.terceros.VerificarTransaccionTerceros;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class VerificarTransaccionTercerosProgramada implements Question<Boolean> {

  private Validacion validacion;
  private String mensajeExitoso;

  public VerificarTransaccionTercerosProgramada(Validacion validacion, String mensajeExitoso) {
    this.validacion = validacion;
    this.mensajeExitoso = mensajeExitoso;
  }

  public static VerificarTransaccionTercerosProgramada exitosa(
      Validacion validacion, String mensajeExitoso) {
    return new VerificarTransaccionTercerosProgramada(validacion, mensajeExitoso);
  }

  @Override
  public Boolean answeredBy(Actor actor) {
    return VerificarTransaccionTerceros.exitosa(validacion, mensajeExitoso).answeredBy(actor)
        && VerificarTransaccionProgramada.exitosa(validacion).answeredBy(actor);
  }
}
