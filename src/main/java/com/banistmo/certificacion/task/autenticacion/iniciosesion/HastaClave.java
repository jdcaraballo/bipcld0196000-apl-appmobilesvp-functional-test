package com.banistmo.certificacion.task.autenticacion.iniciosesion;

import static com.banistmo.certificacion.userinterface.autenticacion.LoginPage.*;
import static com.banistmo.certificacion.userinterface.autenticacion.LoginPage.TXT_CLAVE;

import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class HastaClave implements Task {

  String usuario;
  String clave;

  public HastaClave(String usuario, String clave) {
    this.usuario = usuario;
    this.clave = clave;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        Intro.deSvp(),
        EsperarElemento.esClickable(TXT_USUARIO),
        Enter.theValue(usuario).into(TXT_USUARIO),
        Click.on(BTN_CONTINUAR),
        EsperarCarga.desaparezca(),
        EsperarElemento.esClickable(TXT_CLAVE),
        Enter.theValue(clave).into(TXT_CLAVE),
        Click.on(BTN_VISUALIZAR_CLAVE));
  }
}
