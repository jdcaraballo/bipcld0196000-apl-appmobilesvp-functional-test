package com.banistmo.certificacion.questions.transferencias.cuentaspropias;

import com.banistmo.certificacion.models.comun.Validacion;
import com.banistmo.certificacion.questions.programados.VerificarTransaccionProgramada;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class VerificarTransferenciaCuentasPropiasProgramadas implements Question<Boolean> {

  private Validacion validacion;
  private String mensajeExitoso;

  public VerificarTransferenciaCuentasPropiasProgramadas(
      Validacion validacion, String mensajeExitoso) {
    this.validacion = validacion;
    this.mensajeExitoso = mensajeExitoso;
  }

  public static VerificarTransferenciaCuentasPropiasProgramadas exitosa(
      Validacion validacion, String mensajeExitoso) {
    return new VerificarTransferenciaCuentasPropiasProgramadas(validacion, mensajeExitoso);
  }

  @Override
  public Boolean answeredBy(Actor actor) {
    return VerificarTransferenciaCuentasPropias.exitosa(validacion, mensajeExitoso)
            .answeredBy(actor)
        && VerificarTransaccionProgramada.exitosa(validacion).answeredBy(actor);
  }
}
