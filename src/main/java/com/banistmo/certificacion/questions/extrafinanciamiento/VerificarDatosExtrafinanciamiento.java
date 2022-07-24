package com.banistmo.certificacion.questions.extrafinanciamiento;

import static com.banistmo.certificacion.userinterface.extrafinanciamiento.ComprobanteExtrafinanciamientoPage.*;
import static com.banistmo.certificacion.userinterface.extrafinanciamiento.ComprobanteExtrafinanciamientoPage.LBL_MONTO_SOLICITADO;
import static com.banistmo.certificacion.utils.enums.EnumVariablesSesion.VERIFICAR_TRANSACCION;

import com.banistmo.certificacion.models.comun.Validacion;
import com.banistmo.certificacion.utils.UtileriaString;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.ensure.Ensure;

public class VerificarDatosExtrafinanciamiento implements Question<Boolean> {

  public static Question<Boolean> solicitado() {
    return new VerificarDatosExtrafinanciamiento();
  }

  @Override
  public Boolean answeredBy(Actor actor) {
    Validacion validacion = actor.recall(VERIFICAR_TRANSACCION.getVariableSesion());
    actor.attemptsTo(
        Scroll.to(LBL_CUENTA_DEPOSITO),
        Ensure.that(validacion.getProducto().getNumeroCuentaDestino())
            .contains(LBL_CUENTA_DEPOSITO.resolveFor(actor).getText()),
        Scroll.to(LBL_CUOTAS),
        Ensure.that(validacion.getProducto().getCuotas())
            .contains(LBL_CUOTAS.resolveFor(actor).getText()),
        Scroll.to(LBL_CUOTA_MENSUAL),
        Ensure.that(validacion.getProducto().getCuotaMensual())
            .contains(LBL_CUOTA_MENSUAL.resolveFor(actor).getText()),
        Scroll.to(LBL_MONTO_SOLICITADO),
        Ensure.that(
                UtileriaString.formatearNumeros(LBL_MONTO_SOLICITADO.resolveFor(actor).getText()))
            .contains(validacion.getProducto().getMonto()));
    return true;
  }
}
