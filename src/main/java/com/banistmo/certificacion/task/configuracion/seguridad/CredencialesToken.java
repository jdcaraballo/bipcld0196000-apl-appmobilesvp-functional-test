package com.banistmo.certificacion.task.configuracion.seguridad;

import static com.banistmo.certificacion.userinterface.autenticacion.LoginPage.BTN_TOKEN;
import static com.banistmo.certificacion.userinterface.configuracion.seguridad.TokenPage.*;
import static com.banistmo.certificacion.utils.enums.EnumVariablesSesion.CLAVE_LOGIN;
import static com.banistmo.certificacion.utils.enums.EnumVariablesSesion.USUARIO_LOGIN;

import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import com.banistmo.certificacion.task.autenticacion.iniciosesion.Intro;
import com.banistmo.certificacion.userinterface.configuracion.seguridad.TokenPage;
import java.time.Duration;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.questions.Presence;

public class CredencialesToken implements Task {

  private final String usuario;
  private final String clave;

  public CredencialesToken(String usuario, String clave) {
    this.usuario = usuario;
    this.clave = clave;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    guardaCredenciales(usuario, clave, actor);
    actor.attemptsTo(
        Intro.deSvp(),
        EsperarCarga.desaparezca(),
        EsperarElemento.esClickable(BTN_TOKEN),
        Click.on(BTN_TOKEN),
        EsperarElemento.esClickable(BTN_INSCRIBIR),
        Click.on(BTN_INSCRIBIR),
        EsperarElemento.esVisible(TXT_USUARIO),
        Enter.theValue(usuario).into(TXT_USUARIO),
        Enter.theValue(clave).into(TXT_CLAVE),
        Click.on(TokenPage.BTN_VER_CLAVE),
        EsperarElemento.esClickable(BTN_CONTINUAR),
        Click.on(BTN_CONTINUAR),
        EsperarCarga.desaparezca());
    actor.attemptsTo(
        Check.whether(
                !Presence.of(
                        LBL_ALERTA_INSCRITO_EN_OTRO_DISPOSITIVO.waitingForNoMoreThan(
                            Duration.ofSeconds(5)))
                    .viewedBy(actor)
                    .resolveAll()
                    .isEmpty())
            .andIfSo(Click.on(BTN_CONTINUAR_REGISTRO)),
        EsperarCarga.desaparezca());
  }

  private void guardaCredenciales(String usuario, String clave, Actor actor) {
    actor.remember(USUARIO_LOGIN.getVariableSesion(), usuario);
    actor.remember(CLAVE_LOGIN.getVariableSesion(), clave);
  }
}
