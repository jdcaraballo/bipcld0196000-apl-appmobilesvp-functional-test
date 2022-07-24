package com.banistmo.certificacion.questions.configuracion.favoritos;

import static com.banistmo.certificacion.userinterface.comunes.TransaccionesGeneralPage.BTN_CANCELAR;
import static com.banistmo.certificacion.userinterface.configuracion.administracion.favoritos.terceros.EditarFavoritosTercerosPage.TXT_CORREO_ELECTRONICO;
import static com.banistmo.certificacion.userinterface.configuracion.administracion.favoritos.terceros.EditarFavoritosTercerosPage.TXT_NOMBRE;

import com.banistmo.certificacion.models.comun.Validacion;
import com.banistmo.certificacion.questions.ObtenerValor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;

public class VerificarModificacionTerceros implements Question<Boolean> {

  private Validacion validacion;

  public VerificarModificacionTerceros(Validacion validacion) {
    this.validacion = validacion;
  }

  public static VerificarModificacionTerceros favoritos(Validacion validacion) {
    return new VerificarModificacionTerceros(validacion);
  }

  @Override
  public Boolean answeredBy(Actor actor) {
    boolean resultado =
        ObtenerValor.elemento(TXT_NOMBRE)
                .answeredBy(actor)
                .equals(validacion.getBeneficiario().getNombre())
            && ObtenerValor.elemento(TXT_CORREO_ELECTRONICO)
                .answeredBy(actor)
                .equals(validacion.getBeneficiario().getCorreo());
    actor.attemptsTo(Click.on(BTN_CANCELAR));
    return resultado;
  }
}
