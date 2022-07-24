package com.banistmo.certificacion.task.configuracion.seguridad;

import static com.banistmo.certificacion.userinterface.autenticacion.LoginPage.BTN_CONTINUAR;
import static com.banistmo.certificacion.userinterface.autenticacion.LoginPage.TXT_USUARIO;
import static com.banistmo.certificacion.utils.enums.EnumVariablesSesion.USUARIO_LOGIN;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class IngresarUsuario implements Task {
  public static IngresarUsuario hastaClave() {
    return instrumented(IngresarUsuario.class);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    String usuarioLogin = actor.recall(USUARIO_LOGIN.getVariableSesion());
    actor.attemptsTo(
        EsperarElemento.esClickable(TXT_USUARIO),
        Enter.theValue(usuarioLogin).into(TXT_USUARIO),
        Click.on(BTN_CONTINUAR),
        EsperarCarga.desaparezca());
  }
}
