package com.banistmo.certificacion.task.configuracion.seguridad;

import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import com.banistmo.certificacion.userinterface.configuracion.seguridad.DatosTokenPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static com.banistmo.certificacion.userinterface.autenticacion.RecuperarUsuarioPage.*;

public class ConCodigoDetectIDFallido implements Task {

  private String codigoErrado;

  public ConCodigoDetectIDFallido(String codigoErrado) {
    this.codigoErrado = codigoErrado;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
            Click.on(LBL_TXT_CODIGO_VERIFICACION),
        EsperarElemento.esVisible(TXT_CODIGO_VERIFICACION),
        Enter.theValue(codigoErrado).into(TXT_CODIGO_VERIFICACION),
        Click.on(BTN_CONTINUAR_INSCRIPCION_TOKEN),
        EsperarCarga.desaparezca());
  }
}
