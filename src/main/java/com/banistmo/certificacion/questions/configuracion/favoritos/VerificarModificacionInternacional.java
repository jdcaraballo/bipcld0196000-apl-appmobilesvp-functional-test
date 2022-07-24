package com.banistmo.certificacion.questions.configuracion.favoritos;

import static com.banistmo.certificacion.userinterface.comunes.TransaccionesGeneralPage.BTN_CANCELAR;
import static com.banistmo.certificacion.userinterface.configuracion.administracion.favoritos.internacional.EditarFavoritosInternacionalesPage.TXT_CIUDAD;
import static com.banistmo.certificacion.userinterface.configuracion.administracion.favoritos.internacional.EditarFavoritosInternacionalesPage.TXT_NOMBRE_BENEFICIARIO;

import com.banistmo.certificacion.models.comun.Validacion;
import com.banistmo.certificacion.questions.ObtenerValor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;

public class VerificarModificacionInternacional implements Question<Boolean> {

  private Validacion validacion;

  public VerificarModificacionInternacional(Validacion validacion) {
    this.validacion = validacion;
  }

  public static VerificarModificacionInternacional favoritos(Validacion validacion) {
    return new VerificarModificacionInternacional(validacion);
  }

  @Override
  public Boolean answeredBy(Actor actor) {
    boolean resultado =
        ObtenerValor.elemento(TXT_NOMBRE_BENEFICIARIO)
                .answeredBy(actor)
                .equals(validacion.getBeneficiario().getNombre())
            && ObtenerValor.elemento(TXT_CIUDAD)
                .answeredBy(actor)
                .equals(validacion.getBeneficiario().getCiudad());
    actor.attemptsTo(Click.on(BTN_CANCELAR));
    return resultado;
  }
}
