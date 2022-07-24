package com.banistmo.certificacion.questions.extrafinanciamiento;

import static com.banistmo.certificacion.userinterface.comunes.ProgramadasPage.BTN_IR_A_CONSOLIDADOS;
import static com.banistmo.certificacion.utils.enums.EnumVariablesSesion.SALDO_INICIAL_CUENTA;
import static com.banistmo.certificacion.utils.enums.EnumVariablesSesion.VERIFICAR_TRANSACCION;

import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import com.banistmo.certificacion.models.comun.Validacion;
import com.banistmo.certificacion.task.extrafinanciamiento.MensajeDeExtrafinanciamiento;
import com.banistmo.certificacion.userinterface.PrincipalPage;
import com.banistmo.certificacion.utils.UtileriaString;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Text;

public class SaldoNuevo implements Question<Boolean> {
  @Override
  public Boolean answeredBy(Actor actor) {

    Validacion validacion = actor.recall(VERIFICAR_TRANSACCION.getVariableSesion());
    String cuenta = validacion.getProducto().getNumeroCuentaDestino();
    double montoAprobado = Double.parseDouble(validacion.getProducto().getMonto());
    actor.attemptsTo(Click.on(BTN_IR_A_CONSOLIDADOS), MensajeDeExtrafinanciamiento.verDespues());

    double saldoInicial =
        Double.parseDouble(actor.recall(SALDO_INICIAL_CUENTA.getVariableSesion()).toString()) / 100;
    actor.attemptsTo(
        Click.on(PrincipalPage.LBL_SALDO_ACTUAL.of(cuenta)),
        EsperarElemento.esVisible(PrincipalPage.LBL_SALDO_DISPONIBLE.of(cuenta)));
    double saldoActual =
        (Double.parseDouble(
                UtileriaString.formatearNumeros(
                    Text.of(PrincipalPage.LBL_SALDO_DISPONIBLE.of(cuenta))
                        .viewedBy(actor)
                        .asString()))
            / 100);
    double saldoEsperado = saldoInicial + montoAprobado;
    actor.attemptsTo(Ensure.that(saldoActual).isEqualTo(saldoEsperado));

    return saldoEsperado == saldoActual;
  }
}
