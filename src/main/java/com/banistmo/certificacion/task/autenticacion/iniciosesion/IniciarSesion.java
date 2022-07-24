package com.banistmo.certificacion.task.autenticacion.iniciosesion;

import static com.banistmo.certificacion.userinterface.autenticacion.LoginPage.*;
import static com.banistmo.certificacion.utils.enums.EnumVariablesSesion.CONTRASENA;
import static com.banistmo.certificacion.utils.enums.EnumVariablesSesion.USUARIO_LOGIN;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.banistmo.certificacion.interactions.esperas.Esperar;
import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class IniciarSesion implements Task {

  private final String usuario;
  private final String clave;

  public IniciarSesion(String usuario, String clave) {
    this.usuario = usuario;
    this.clave = clave;
  }

  public static IniciarSesion enSvp(String usuario, String clave) {
    return instrumented(IniciarSesion.class, usuario, clave);
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
        Esperar.unTiempo(5),
        Click.on(BTN_INICIAR_SESION),
        EsperarCarga.desaparezca());
    actor.remember(USUARIO_LOGIN.getVariableSesion(), usuario);
    actor.remember(CONTRASENA.getVariableSesion(), clave);
  }
}
