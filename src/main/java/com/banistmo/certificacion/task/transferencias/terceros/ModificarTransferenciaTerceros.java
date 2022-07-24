package com.banistmo.certificacion.task.transferencias.terceros;

import static com.banistmo.certificacion.userinterface.comunes.TransaccionesGeneralPage.BTN_CONTINUAR;
import static com.banistmo.certificacion.userinterface.comunes.VerificarTransaccionPage.BTN_MODIFICAR_TRANSACCION;

import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class ModificarTransferenciaTerceros implements Task {

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        EsperarElemento.esClickable(BTN_CONTINUAR),
        Click.on(BTN_CONTINUAR),
        EsperarCarga.desaparezca(),
        EsperarElemento.esClickable(BTN_MODIFICAR_TRANSACCION),
        Click.on(BTN_MODIFICAR_TRANSACCION));
  }
}
