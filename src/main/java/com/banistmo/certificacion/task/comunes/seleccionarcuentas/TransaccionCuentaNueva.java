package com.banistmo.certificacion.task.comunes.seleccionarcuentas;

import static com.banistmo.certificacion.userinterface.comunes.TransaccionesGeneralPage.*;

import com.banistmo.certificacion.interactions.ClickAleatorio;
import com.banistmo.certificacion.interactions.esperas.Esperar;
import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class TransaccionCuentaNueva implements Task {

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        EsperarElemento.esClickable(BTN_MOSTRAR_CUENTAS_RETIRO),
        Click.on(BTN_MOSTRAR_CUENTAS_RETIRO),
        EsperarCarga.desaparezca(),
        EsperarElemento.esClickable(LST_BTN_CUENTA_RETIRO_DESTINO),
        ClickAleatorio.enElemento(LST_BTN_CUENTA_RETIRO_DESTINO),
        EsperarElemento.esClickable(BTN_MOSTRAR_CUENTAS_DESTINO),
        Click.on(BTN_MOSTRAR_CUENTAS_DESTINO),
        EsperarCarga.desaparezca(),
        EsperarElemento.esClickable(BTN_AGREGAR_NUEVA_CUENTA),
        Click.on(BTN_AGREGAR_NUEVA_CUENTA),
        Esperar.unTiempo(2000));
  }
}
