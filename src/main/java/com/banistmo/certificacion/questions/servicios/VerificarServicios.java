package com.banistmo.certificacion.questions.servicios;

import static com.banistmo.certificacion.userinterface.comunes.ConfirmacionTransaccionGeneralPage.*;
import static com.banistmo.certificacion.userinterface.servicios.ComprobanteServiciosPage.*;
import static com.banistmo.certificacion.userinterface.servicios.ComprobanteServiciosPage.LBL_MONTO;

import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import com.banistmo.certificacion.models.comun.Validacion;
import com.banistmo.certificacion.questions.VerificarMensaje;
import com.banistmo.certificacion.utils.UtileriaString;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class VerificarServicios implements Question<Boolean> {

  private Validacion validacion;
  private String mensajeExitoso;

  public VerificarServicios(Validacion validacion, String mensajeExitoso) {
    this.validacion = validacion;
    this.mensajeExitoso = mensajeExitoso;
  }

  public static VerificarServicios exitosa(Validacion validacion, String mensajeExitoso) {
    return new VerificarServicios(validacion, mensajeExitoso);
  }

  @Override
  public Boolean answeredBy(Actor actor) {
    actor.attemptsTo(EsperarCarga.desaparezca());
    return verificarDatosServicio(actor)
        && Text.of(LBL_NUMERO_COMPROBANTE).viewedBy(actor).asString() != null
        && verificarDatosComprobante(actor);
  }

  private boolean verificarDatosServicio(Actor actor) {
    return Text.of(LBL_DESTINO_COMPROBANTE)
            .viewedBy(actor)
            .asString()
            .equals(validacion.getServicio().getNombreServicio())
        && Text.of(LBL_CODIGO_SERVICIO)
            .viewedBy(actor)
            .asString()
            .equals(validacion.getServicio().getCodigoServicio())
        && Text.of(LBL_NUMERO_SERVICIO)
            .viewedBy(actor)
            .asString()
            .equals(validacion.getServicio().getBeneficiario().getNumero());
  }

  public boolean verificarDatosComprobante(Actor actor) {
    return Text.of(LBL_NUMERO_CUENTA_RETIRO)
            .viewedBy(actor)
            .asString()
            .equals(validacion.getProducto().getNumeroCuentaRetiro())
        && UtileriaString.eliminarPalabra(Text.of(LBL_MONTO).viewedBy(actor).asString(), "$")
            .equals(validacion.getServicio().getProducto().getMonto())
        && VerificarMensaje.esVisible(mensajeExitoso).answeredBy(actor);
  }
}
