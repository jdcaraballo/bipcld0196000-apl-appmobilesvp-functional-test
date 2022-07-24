package com.banistmo.certificacion.task.comunes.seleccionarcuentas;

import static com.banistmo.certificacion.userinterface.comunes.TransaccionesGeneralPage.*;
import static com.banistmo.certificacion.userinterface.comunes.TransaccionesGeneralPage.BTN_MOSTRAR_CUENTAS_DESTINO;

import com.banistmo.certificacion.interactions.ClickAleatorio;
import com.banistmo.certificacion.interactions.ClickCuenta;
import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class TransaccionCuentaGuardada implements Task {

  private String tipoCuentaTerceros;

  public TransaccionCuentaGuardada(String tipoCuentaTerceros) {
    this.tipoCuentaTerceros = tipoCuentaTerceros;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        EsperarElemento.esClickable(BTN_MOSTRAR_CUENTAS_RETIRO),
        Click.on(BTN_MOSTRAR_CUENTAS_RETIRO),
        EsperarCarga.desaparezca(),
        EsperarElemento.esClickable(LST_BTN_CUENTA_RETIRO_DESTINO),
        ClickAleatorio.enElemento(LST_BTN_CUENTA_RETIRO_DESTINO),
        EsperarCarga.desaparezca(),
        EsperarElemento.esClickable(BTN_MOSTRAR_CUENTAS_DESTINO),
        Click.on(BTN_MOSTRAR_CUENTAS_DESTINO),
        EsperarCarga.desaparezca(),
        ClickCuenta.guardada(tipoCuentaTerceros));
  }
}
