package com.banistmo.certificacion.task.autenticacion.recuperarusuario;

import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import com.banistmo.certificacion.task.autenticacion.iniciosesion.Intro;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.banistmo.certificacion.userinterface.autenticacion.LoginPage.BTN_OLVIDO_USUARIO;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class IniciarOlvidoUsuario implements Task {

  public static IniciarOlvidoUsuario enSvp() {
    return instrumented(IniciarOlvidoUsuario.class);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        Intro.deSvp(),
        EsperarCarga.desaparezca(),
        Click.on(BTN_OLVIDO_USUARIO));
  }
}
