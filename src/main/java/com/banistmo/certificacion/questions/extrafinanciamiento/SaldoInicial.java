package com.banistmo.certificacion.questions.extrafinanciamiento;

import static com.banistmo.certificacion.utils.enums.EnumVariablesSesion.SALDO_INICIAL_CUENTA;
import static com.banistmo.certificacion.utils.enums.EnumVariablesSesion.VERIFICAR_TRANSACCION;

import com.banistmo.certificacion.models.comun.Validacion;
import com.banistmo.certificacion.task.extrafinanciamiento.MensajeDeExtrafinanciamiento;
import com.banistmo.certificacion.userinterface.PrincipalPage;
import com.banistmo.certificacion.utils.UtileriaString;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Text;

public class SaldoInicial implements Question<Boolean> {
  @Override
  public Boolean answeredBy(Actor actor) {
    Validacion validacion = actor.recall(VERIFICAR_TRANSACCION.getVariableSesion());
    String cuenta = validacion.getProducto().getNumeroCuentaDestino();

    actor.attemptsTo(MensajeDeExtrafinanciamiento.verDespues());

    double saldoInicial =
        Double.parseDouble(actor.recall(SALDO_INICIAL_CUENTA.getVariableSesion()).toString()) / 100;
    double saldoActual =
        Double.parseDouble(
                UtileriaString.formatearNumeros(
                    Text.of(PrincipalPage.LBL_SALDO_ACTUAL.of(cuenta)).viewedBy(actor).asString()))/ 100;

    actor.attemptsTo(
        Scroll.to(PrincipalPage.LBL_SALDO_ACTUAL.of(cuenta)),
        Ensure.that(saldoActual).isEqualTo(saldoInicial));
    return saldoActual == saldoInicial;
  }
}
