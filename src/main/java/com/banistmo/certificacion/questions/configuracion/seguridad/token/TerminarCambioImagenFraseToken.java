package com.banistmo.certificacion.questions.configuracion.seguridad.token;

import static com.banistmo.certificacion.exceptions.transferencia.TransferenciaExitosaException.TRANSFERENCIA_EXITOSA_NO_ENCONTRADO;
import static com.banistmo.certificacion.userinterface.configuracion.seguridad.CambiarImagenFrasePage.SUB_OPT_CAMBIO_IMAGEN_FRASE;
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

public class TerminarCambioImagenFraseToken implements Task {
  public static TerminarCambioImagenFraseToken deUsuario() {
    return new TerminarCambioImagenFraseToken();
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        EsperarElemento.esClickable(BTN_CONFIGURACION),
        Click.on(BTN_CONFIGURACION),
        Click.on(BTN_OPT_SEGURIDAD),
        Click.on(BTN_OPT_SEGURIDAD),
        Click.on(BTN_OPT_SEGURIDAD));
    if (!Presence.of(SUB_OPT_CAMBIO_IMAGEN_FRASE).viewedBy(actor).resolveAll().isEmpty()) {
      actor.attemptsTo(
          EsperarElemento.esClickable(SUB_OPT_CAMBIO_IMAGEN_FRASE),
          Click.on(SUB_OPT_CAMBIO_IMAGEN_FRASE));
    }
    actor.should(
        seeThat(ValidacionDeToken.enPantalla())
            .orComplainWith(
                TransferenciaExitosaException.class,
                TRANSFERENCIA_EXITOSA_NO_ENCONTRADO + MuestraLog.browser().answeredBy(actor)));
    actor.attemptsTo(EsperarCarga.desaparezca());
  }
}
