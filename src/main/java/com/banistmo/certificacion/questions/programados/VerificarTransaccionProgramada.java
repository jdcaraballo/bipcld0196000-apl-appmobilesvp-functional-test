package com.banistmo.certificacion.questions.programados;

import static com.banistmo.certificacion.task.comunes.programar.FechaFutura.TEXTO_FECHA_FUTURA;
import static com.banistmo.certificacion.userinterface.comunes.ConfirmacionTransaccionGeneralPage.*;
import static com.banistmo.certificacion.utils.UtileriaString.formatearFechaComprante;
import static com.banistmo.certificacion.utils.UtileriaString.formatearFechaEliminadoCero;

import com.banistmo.certificacion.models.comun.Validacion;
import com.banistmo.certificacion.utils.UtileriaString;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class VerificarTransaccionProgramada implements Question<Boolean> {

  private Validacion validacion;

  public VerificarTransaccionProgramada(Validacion validacion) {
    this.validacion = validacion;
  }

  public static VerificarTransaccionProgramada exitosa(Validacion validacion) {
    return new VerificarTransaccionProgramada(validacion);
  }

  @Override
  public Boolean answeredBy(Actor actor) {
    return verificarDatosProgramados(actor);
  }

  public boolean verificarDatosProgramados(Actor actor) {
    if (TEXTO_FECHA_FUTURA.equals(validacion.getProducto().getTipoTransaccion())) {
      return formatearFechaComprante(
              Text.of(LBL_FECHA_FUTURA).viewedBy(actor).asString().replace(" de ", " "))
          .contains(formatearFechaEliminadoCero(validacion.getProducto().getFechaFuturo()));
    } else {
      return UtileriaString.eliminarPalabra(
                  Text.of(LBL_DATO_FECHA_TRANSACCION).viewedBy(actor).asString(), " ")
              .equals(
                  UtileriaString.eliminarPalabra(validacion.getProducto().getDiaRecurrente(), " "))
          && verificarDatosRecurrente(actor);
    }
  }

  public boolean verificarDatosRecurrente(Actor actor) {
    return Text.of(LBL_FRECUENCIA)
            .viewedBy(actor)
            .asString()
            .equals(validacion.getProducto().getFrecuencia())
        && formatearFechaEliminadoCero(
                formatearFechaComprante(
                    Text.of(LBL_FECHA_INICIAL).viewedBy(actor).asString().replace(" de ", " ")))
            .equals(formatearFechaEliminadoCero(validacion.getProducto().getFechaFuturo()))
        && formatearFechaEliminadoCero(
                formatearFechaComprante(
                    Text.of(LBL_FECHA_FINAL).viewedBy(actor).asString().replace(" de ", " ")))
            .contains(formatearFechaEliminadoCero(validacion.getProducto().getFechaFuturoFin()));
  }
}
