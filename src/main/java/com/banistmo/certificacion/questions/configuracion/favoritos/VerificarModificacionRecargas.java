package com.banistmo.certificacion.questions.configuracion.favoritos;

import static com.banistmo.certificacion.userinterface.comunes.TransaccionesGeneralPage.BTN_CANCELAR;
import static com.banistmo.certificacion.userinterface.configuracion.administracion.favoritos.recargas.CreacionFavoritoRecargasPage.TXT_NUMERO_PRODUCTO;

import com.banistmo.certificacion.models.comun.Validacion;
import com.banistmo.certificacion.questions.ObtenerValor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;

public class VerificarModificacionRecargas implements Question<Boolean> {

  private Validacion validacion;

  public VerificarModificacionRecargas(Validacion validacion) {
    this.validacion = validacion;
  }

  public static VerificarModificacionRecargas favoritos(Validacion validacion) {
    return new VerificarModificacionRecargas(validacion);
  }

  @Override
  public Boolean answeredBy(Actor actor) {
    boolean resultado =
        ObtenerValor.elemento(TXT_NUMERO_PRODUCTO)
            .answeredBy(actor)
            .equals(validacion.getRecargas().getBeneficiario().getNumero());
    actor.attemptsTo(Click.on(BTN_CANCELAR));
    return resultado;
  }
}
