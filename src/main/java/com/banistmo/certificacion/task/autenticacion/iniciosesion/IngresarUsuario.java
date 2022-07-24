package com.banistmo.certificacion.task.autenticacion.iniciosesion;

import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static com.banistmo.certificacion.userinterface.autenticacion.LoginPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class IngresarUsuario implements Task {

  String usuario;

  public IngresarUsuario(String usuario) {
    this.usuario = usuario;
  }

  public static IngresarUsuario enSvp(String usuario) {
    return instrumented(IngresarUsuario.class, usuario);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        Intro.deSvp(),
        EsperarElemento.esClickable(TXT_USUARIO),
        Enter.theValue(usuario).into(TXT_USUARIO),
        Click.on(BTN_CONTINUAR),
        EsperarCarga.desaparezca(),
        EsperarElemento.esClickable(BTN_OLVIDO_CLAVE),
        Click.on(BTN_OLVIDO_CLAVE));
  }
}
