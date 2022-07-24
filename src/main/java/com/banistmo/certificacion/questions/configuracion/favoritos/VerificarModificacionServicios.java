package com.banistmo.certificacion.questions.configuracion.favoritos;

import static com.banistmo.certificacion.userinterface.comunes.TransaccionesGeneralPage.BTN_CANCELAR;
import static com.banistmo.certificacion.userinterface.configuracion.administracion.favoritos.servicios.CreacionFavoritoServiciosPage.TXT_NOMBRE_CLIENTE;
import static com.banistmo.certificacion.userinterface.configuracion.administracion.favoritos.servicios.CreacionFavoritoServiciosPage.TXT_NUMERO_CLIENTE;

import com.banistmo.certificacion.models.comun.Validacion;
import com.banistmo.certificacion.questions.ObtenerValor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;

public class VerificarModificacionServicios implements Question<Boolean> {

  private Validacion validacion;

  public VerificarModificacionServicios(Validacion validacion) {
    this.validacion = validacion;
  }

  public static VerificarModificacionServicios favoritos(Validacion validacion) {
    return new VerificarModificacionServicios(validacion);
  }

  @Override
  public Boolean answeredBy(Actor actor) {
    boolean resultado =
        ObtenerValor.elemento(TXT_NOMBRE_CLIENTE)
                .answeredBy(actor)
                .equals(validacion.getServicio().getBeneficiario().getNombre())
            && ObtenerValor.elemento(TXT_NUMERO_CLIENTE)
                .answeredBy(actor)
                .equals(validacion.getServicio().getBeneficiario().getNumero());
    actor.attemptsTo(Click.on(BTN_CANCELAR));
    return resultado;
  }
}
