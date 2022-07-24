package com.banistmo.certificacion.questions.programados;

import static com.banistmo.certificacion.task.comunes.programar.FechaFutura.TEXTO_FECHA_FUTURA;
import static com.banistmo.certificacion.userinterface.comunes.EditarProgramadoPage.*;
import static com.banistmo.certificacion.utils.UtileriaString.eliminarPalabra;

import com.banistmo.certificacion.models.comun.Validacion;
import com.banistmo.certificacion.questions.ObtenerValor;
import com.banistmo.certificacion.userinterface.comunes.TransaccionesGeneralPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class VerificarPagoEditado implements Question<Boolean> {

  private Validacion validacion;

  public VerificarPagoEditado(Validacion validacion) {
    this.validacion = validacion;
  }

  public static VerificarPagoEditado exitosa(Validacion validacion) {
    return new VerificarPagoEditado(validacion);
  }

  @Override
  public Boolean answeredBy(Actor actor) {
    return verificarDatosEditados(actor) && verificarNuevaFecha(actor);
  }

  private boolean verificarDatosEditados(Actor actor) {
    return eliminarPalabra(TransaccionesGeneralPage.TXT_MONTO.resolveFor(actor).getValue(), "$")
            .equals(eliminarPalabra(validacion.getProducto().getMonto(), "$"))
        && TXT_DESCRIPCION_EDITAR
            .resolveFor(actor)
            .getValue()
            .equals(validacion.getProducto().getDescripcion());
  }

  private boolean verificarNuevaFecha(Actor actor) {
    if (TEXTO_FECHA_FUTURA.equals(validacion.getProducto().getTipoTransaccion())) {
      return ObtenerValor.elemento(TXT_CALENDARIO_EDITAR_FECHA_FUTURA)
          .answeredBy(actor)
          .equals(validacion.getProducto().getFechaFuturo());
    } else {
      return Text.of(TXT_DIA_SEMANAL_EDITAR)
              .viewedBy(actor)
              .asString()
              .equals(validacion.getProducto().getDiaRecurrente())
          && Text.of(TXT_FRECUENCIA_EDITAR)
              .viewedBy(actor)
              .asString()
              .equals(validacion.getProducto().getFrecuencia())
          && ObtenerValor.elemento(TXT_CALENDARIO_FECHA_FINAL_EDITAR)
              .answeredBy(actor)
              .equals(validacion.getProducto().getFechaFuturoFin());
    }
  }
}
