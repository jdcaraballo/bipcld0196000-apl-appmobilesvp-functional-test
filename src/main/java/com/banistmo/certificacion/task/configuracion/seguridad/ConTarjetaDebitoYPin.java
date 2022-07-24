package com.banistmo.certificacion.task.configuracion.seguridad;

import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import com.banistmo.certificacion.userinterface.configuracion.seguridad.DatosTokenPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class ConTarjetaDebitoYPin implements Task {

  private final String tarjetaDebito;
  private final String claveCajeroAutomatico;
  private final String descripcionToken;

  public ConTarjetaDebitoYPin(
      String tarjetaDebito, String claveCajeroAutomatico, String descripcionToken) {
    this.tarjetaDebito = tarjetaDebito;
    this.claveCajeroAutomatico = claveCajeroAutomatico;
    this.descripcionToken = descripcionToken;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.remember("descripcion token", descripcionToken);
    actor.attemptsTo(
        EsperarElemento.esVisible(DatosTokenPage.TXT_TARJETA_DEBITO),
        Enter.theValue(tarjetaDebito).into(DatosTokenPage.TXT_TARJETA_DEBITO),
        Enter.keyValues(claveCajeroAutomatico).into(DatosTokenPage.TXT_CLAVE_CAJERO_AUTOMATICO),
        EsperarElemento.esClickable(DatosTokenPage.BTN_CONTINUAR),
        Click.on(DatosTokenPage.BTN_CONTINUAR),
        EsperarCarga.desaparezca(),
        EsperarElemento.esVisible(DatosTokenPage.LBL_ALIAS_TOKEN),
        Enter.theValue(descripcionToken).into(DatosTokenPage.TXT_ALIAS_TOKEN),
        EsperarElemento.esClickable(DatosTokenPage.BTN_GUARDAR),
        Click.on(DatosTokenPage.BTN_GUARDAR));
  }
}
