package com.banistmo.certificacion.questions.configuracion.seguridad.token;

import static com.banistmo.certificacion.exceptions.transferencia.TransferenciaExitosaException.TRANSFERENCIA_EXITOSA_NO_ENCONTRADO;
import static com.banistmo.certificacion.userinterface.configuracion.seguridad.SeguridadPage.BTN_CAMBIAR_CONTRASENA;
import static com.banistmo.certificacion.userinterface.menu.MenuConfiguracionPage.BTN_OPT_SEGURIDAD;
import static com.banistmo.certificacion.userinterface.menu.MenuPage.BTN_CONFIGURACION;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

import com.banistmo.certificacion.exceptions.transferencia.TransferenciaExitosaException;
import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import com.banistmo.certificacion.questions.configuracion.seguridad.ValidacionDeToken;
import com.banistmo.certificacion.questions.transferencias.MuestraLog;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Presence;

public class TerminarCambioConToken implements Task {
  public static TerminarCambioConToken deSeguridad() {
    return new TerminarCambioConToken();
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        EsperarElemento.esClickable(BTN_CONFIGURACION),
        Click.on(BTN_CONFIGURACION),
        Click.on(BTN_OPT_SEGURIDAD));
    if (!Presence.of(BTN_CAMBIAR_CONTRASENA).viewedBy(actor).resolveAll().isEmpty()) {
      actor.attemptsTo(
          EsperarElemento.esClickable(BTN_CAMBIAR_CONTRASENA), Click.on(BTN_CAMBIAR_CONTRASENA));
    }
    actor.should(
        seeThat(ValidacionDeToken.enPantalla())
            .orComplainWith(
                TransferenciaExitosaException.class,
                TRANSFERENCIA_EXITOSA_NO_ENCONTRADO + MuestraLog.browser().answeredBy(actor)));
    actor.attemptsTo(EsperarCarga.desaparezca());
  }
}
