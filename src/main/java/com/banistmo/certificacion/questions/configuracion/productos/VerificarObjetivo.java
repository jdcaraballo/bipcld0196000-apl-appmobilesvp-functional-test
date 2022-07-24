package com.banistmo.certificacion.questions.configuracion.productos;

import static com.banistmo.certificacion.userinterface.configuracion.administracion.producto.ConfiguracionProductoPage.*;
import static com.banistmo.certificacion.utils.enums.EnumVariablesSesion.NUMERO_CUENTA;
import static com.banistmo.certificacion.utils.enums.EnumVariablesSesion.VALOR_AHORRO;

import com.banistmo.certificacion.interactions.ClickInvisible;
import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class VerificarObjetivo implements Question<Boolean> {

  public static VerificarObjetivo deAhorro() {
    return new VerificarObjetivo();
  }

  @Override
  public Boolean answeredBy(Actor actor) {
    String numeroCuenta = actor.recall(NUMERO_CUENTA.getVariableSesion());
    actor.attemptsTo(
        ClickInvisible.enReporte(BTN_NUMERO_CUENTA.of(numeroCuenta)),
        EsperarElemento.esVisible(BTN_EDITAR_NOMBRE_CUENTA));
    double objetivoAhorro = actor.recall(VALOR_AHORRO.getVariableSesion());
    double saldoDisponible =Double.parseDouble(Text.of(LBL_VALOR_DISPONIBLE_CUENTA).viewedBy(actor).asString().replace("$", "").replace(",", ""));
    double porcentajeAhorro = (saldoDisponible * 100) / objetivoAhorro;
    return Text.of(LBL_VALOR_OBJETIVO_AHORRO)
            .viewedBy(actor)
            .asString()
            .replace("$", "")
            .replace(",", "")
            .equals(String.valueOf(objetivoAhorro))
        && formatearStringSinDecimales(
                Double.parseDouble(
                    PRG_OBJETIVO_AHORRO.resolveFor(actor).getAttribute("ng-reflect-progress")))
            .equals(formatearStringSinDecimales(porcentajeAhorro));
  }

  private String formatearStringSinDecimales(double numero) {
    return String.format("%.0f", numero);
  }
}
