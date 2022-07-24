package com.banistmo.certificacion.task.configuracion.seguridad;

import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import com.banistmo.certificacion.userinterface.configuracion.seguridad.DatosTokenPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class ConTarjetaDebitoYPinFallido implements Task {

  private String tarjetaDebito;
  private String claveCajeroAutomatico;

  public ConTarjetaDebitoYPinFallido(String tarjetaDebito, String claveCajeroAutomatico) {
    this.tarjetaDebito = tarjetaDebito;
    this.claveCajeroAutomatico = claveCajeroAutomatico;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        EsperarElemento.esVisible(DatosTokenPage.TXT_TARJETA_DEBITO),
        Enter.theValue(tarjetaDebito).into(DatosTokenPage.TXT_TARJETA_DEBITO),
        Enter.keyValues(claveCajeroAutomatico).into(DatosTokenPage.TXT_CLAVE_CAJERO_AUTOMATICO),
        Click.on(DatosTokenPage.BTN_CONTINUAR),
        EsperarCarga.desaparezca());
  }
}
