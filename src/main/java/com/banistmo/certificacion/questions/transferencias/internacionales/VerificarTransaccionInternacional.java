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

public class VerificarTransaccionInternacional implements Question<Boolean> {

  private Validacion validacion;

  public VerificarTransaccionInternacional(Validacion validacion) {
    this.validacion = validacion;
  }

  public static VerificarTransaccionInternacional exitosa(Validacion validacion) {
    return new VerificarTransaccionInternacional(validacion);
  }

  @Override
  public Boolean answeredBy(Actor actor) {
    return verificarComprobante(actor) && verificarDatosTransaccion(actor);
  }

  public boolean verificarComprobante(Actor actor) {
    return verificarDatosComprobante(actor)
        && verificarDatosBancoReceptor(actor)
        && datosBeneficiario(actor);
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

  public boolean datosBeneficiario(Actor actor) {
    return verificarDatosBeneficiario(actor)
        && verificarDatosAdicionalesBeneficiario(actor)
        && Text.of(LBL_NUMERO_CUENTA)
            .viewedBy(actor)
            .asString()
            .equals(validacion.getProducto().getNumeroCuentaDestino());
  }

  public boolean verificarDatosBeneficiario(Actor actor) {
    return Text.of(LBL_NOMBRE_BENEFICIARIO)
            .viewedBy(actor)
            .asString()
            .equals(validacion.getBeneficiario().getNombre())
        && Text.of(LBL_PAIS_BENEFICIARIO)
            .viewedBy(actor)
            .asString()
            .equals(validacion.getBeneficiario().getPais())
        && Text.of(LBL_CIUDAD_BENEFICIARIO)
            .viewedBy(actor)
            .asString()
            .equals(validacion.getBeneficiario().getCiudad());
  }

  public boolean verificarDatosAdicionalesBeneficiario(Actor actor) {
    return Text.of(LBL_DIRECCION_BENEFICIARIO)
            .viewedBy(actor)
            .asString()
            .equals(validacion.getBeneficiario().getDireccion())
        && Text.of(LBL_CORREO_BENEFICIARIO)
            .viewedBy(actor)
            .asString()
            .equals(validacion.getBeneficiario().getCorreo());
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
