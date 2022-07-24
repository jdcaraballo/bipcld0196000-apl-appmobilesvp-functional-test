package com.banistmo.certificacion.questions.transferencias.internacionales;

import static com.banistmo.certificacion.userinterface.comunes.ConfirmacionTransaccionGeneralPage.LBL_NUMERO_COMPROBANTE;
import static com.banistmo.certificacion.userinterface.transferencias.internacionales.ComprobanteInternacionalPage.*;
import static com.banistmo.certificacion.utils.enums.EnumMensajes.TRANSACCION_EXITOSA;

import com.banistmo.certificacion.models.comun.Validacion;
import com.banistmo.certificacion.questions.VerificarMensaje;
import com.banistmo.certificacion.utils.UtileriaString;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class VerificarTransaccionGuardadaInternacional implements Question<Boolean> {

  private Validacion validacion;

  public VerificarTransaccionGuardadaInternacional(Validacion validacion) {
    this.validacion = validacion;
  }

  public static VerificarTransaccionGuardadaInternacional exitosa(Validacion validacion) {
    return new VerificarTransaccionGuardadaInternacional(validacion);
  }

  @Override
  public Boolean answeredBy(Actor actor) {
    return verificarComprobante(actor) && verificarDatosTransaccion(actor);
  }

  public boolean verificarComprobante(Actor actor) {
    return verificarDatosComprobante(actor) && verificarDatosBancoReceptor(actor);
  }

  public boolean verificarDatosComprobante(Actor actor) {
    return Text.of(LBL_NUMERO_COMPROBANTE).viewedBy(actor).asString() != null
        && VerificarMensaje.esVisible(TRANSACCION_EXITOSA.getMensaje()).answeredBy(actor);
  }

  public boolean verificarDatosBancoReceptor(Actor actor) {
    return Text.of(LBL_PAIS_DESTINO)
            .viewedBy(actor)
            .asString()
            .equals(validacion.getProducto().getPaisDestino())
        && Text.of(LBL_BANCO_DESTINO)
            .viewedBy(actor)
            .asString()
            .equals(validacion.getProducto().getBanco())
        && Text.of(LBL_CODIGO_RUTA)
            .viewedBy(actor)
            .asString()
            .equals(validacion.getProducto().getCodigoBanco());
  }

  public boolean verificarDatosTransaccion(Actor actor) {
    return Text.of(LBL_DESCRIPCION)
            .viewedBy(actor)
            .asString()
            .equals(validacion.getProducto().getDescripcion())
        && UtileriaString.eliminarPalabra(Text.of(LBL_MONTO).viewedBy(actor).asString(), "$")
            .equals(validacion.getProducto().getMonto())
        && Text.of(LBL_CUENTA_RETIRO)
            .viewedBy(actor)
            .asString()
            .contains(validacion.getProducto().getNumeroCuentaRetiro());
  }
}
