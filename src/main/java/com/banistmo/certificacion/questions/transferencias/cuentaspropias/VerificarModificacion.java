package com.banistmo.certificacion.questions.transferencias.cuentaspropias;

import static com.banistmo.certificacion.userinterface.comunes.ConfirmacionTransaccionGeneralPage.LBL_DETALLES;
import static com.banistmo.certificacion.userinterface.comunes.ConfirmacionTransaccionGeneralPage.LBL_MONTO;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class VerificarModificacion implements Question<Boolean> {

  public static VerificarModificacion transaccion() {
    return new VerificarModificacion();
  }

  @Override
  public Boolean answeredBy(Actor actor) {
    String montoModificado = actor.recall("MontoModificado");
    String detallesModificado = actor.recall("DetallesModificado");
    return Text.of(LBL_MONTO).viewedBy(actor).asString().replace("$", "").equals(montoModificado)
        && Text.of(LBL_DETALLES).viewedBy(actor).asString().equals(detallesModificado);
  }
}
