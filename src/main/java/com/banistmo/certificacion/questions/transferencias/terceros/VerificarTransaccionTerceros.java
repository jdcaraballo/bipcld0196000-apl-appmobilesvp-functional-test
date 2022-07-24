package com.banistmo.certificacion.questions.transferencias.terceros;

import static com.banistmo.certificacion.userinterface.comunes.ConfirmacionTransaccionGeneralPage.*;
import static com.banistmo.certificacion.utils.UtileriaString.eliminarPalabra;
import static com.banistmo.certificacion.utils.UtileriaString.formatearTarjeta;

import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import com.banistmo.certificacion.models.comun.Validacion;
import com.banistmo.certificacion.questions.VerificarMensaje;
import com.banistmo.certificacion.utils.UtileriaString;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class VerificarTransaccionTerceros implements Question<Boolean> {

  private Validacion validacion;
  private String mensajeExitoso;

  public VerificarTransaccionTerceros(Validacion validacion, String mensajeExitoso) {
    this.validacion = validacion;
    this.mensajeExitoso = mensajeExitoso;
  }

  public static VerificarTransaccionTerceros exitosa(Validacion validacion, String mensajeExitoso) {
    return new VerificarTransaccionTerceros(validacion, mensajeExitoso);
  }

  @Override
  public Boolean answeredBy(Actor actor) {
    actor.attemptsTo(EsperarCarga.desaparezca());
    return verificarDatosComprobante(actor)
        && verificarDatosBanco(actor)
        && verificarDatosBeneficiarioCuenta(actor);
  }

  public boolean verificarDatosComprobante(Actor actor) {
    return Text.of(LBL_NUMERO_COMPROBANTE).viewedBy(actor).asString() != null
        && Text.of(LBL_NUMERO_CUENTA_RETIRO)
            .viewedBy(actor)
            .asString()
            .equals(validacion.getProducto().getNumeroCuentaRetiro())
        && VerificarMensaje.esVisible(mensajeExitoso).answeredBy(actor);
  }

  public boolean verificarDatosBanco(Actor actor) {
    return Text.of(LBL_BANCO_COMPROBANTE)
        .viewedBy(actor)
        .asString()
        .equalsIgnoreCase(eliminarPalabra(validacion.getProducto().getBanco(), "Banco destino: "));
  }

  public boolean verificarDatosBeneficiarioCuenta(Actor actor) {
    String cuentaFormateada;
    if (validacion.getProducto().getNumeroCuentaDestino().length() >= 11) {
      cuentaFormateada = formatearTarjeta(validacion.getProducto().getNumeroCuentaDestino());
    } else {
      cuentaFormateada = validacion.getProducto().getNumeroCuentaDestino();
    }
    return Text.of(LBL_DESTINO_COMPROBANTE).viewedBy(actor).asString().equals(cuentaFormateada)
        && UtileriaString.eliminarPalabra(
                Text.of(LBL_MONTO_COMPROBANTE).viewedBy(actor).asString(), "$")
            .equals(validacion.getProducto().getMonto());
  }
}
