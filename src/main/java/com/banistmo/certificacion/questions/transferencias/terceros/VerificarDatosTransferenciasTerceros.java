package com.banistmo.certificacion.questions.transferencias.terceros;

import static com.banistmo.certificacion.userinterface.transferencias.terceros.TercerosPage.TXT_DESCRIPCION;
import static com.banistmo.certificacion.userinterface.transferencias.terceros.TercerosPage.TXT_MONTO;
import static com.banistmo.certificacion.utils.UtileriaString.eliminarPalabra;

import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import com.banistmo.certificacion.models.comun.Validacion;
import com.banistmo.certificacion.questions.ObtenerValor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class VerificarDatosTransferenciasTerceros implements Question<Boolean> {

  private Validacion validacion;

  public VerificarDatosTransferenciasTerceros(Validacion validacion) {
    this.validacion = validacion;
  }

  public static VerificarDatosTransferenciasTerceros exitosa(Validacion validacion) {
    return new VerificarDatosTransferenciasTerceros(validacion);
  }

  @Override
  public Boolean answeredBy(Actor actor) {
    actor.attemptsTo(EsperarCarga.desaparezca());
    return eliminarPalabra(ObtenerValor.elemento(TXT_MONTO).answeredBy(actor), "$")
            .equals(validacion.getProducto().getMonto())
        && ObtenerValor.elemento(TXT_DESCRIPCION)
            .answeredBy(actor)
            .equals(validacion.getProducto().getDescripcion());
  }
}
