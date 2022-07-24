package com.banistmo.certificacion.task.configuracion.seguridad.token;

import static com.banistmo.certificacion.exceptions.transferencia.TransferenciaExitosaException.TRANSFERENCIA_EXITOSA_NO_ENCONTRADO;
import static com.banistmo.certificacion.userinterface.menu.MenuPage.BTN_CONFIGURACION;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.banistmo.certificacion.exceptions.transferencia.TransferenciaExitosaException;
import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import com.banistmo.certificacion.questions.token.ValidacionDeTokenActualizarDatos;
import com.banistmo.certificacion.questions.transferencias.MuestraLog;
import com.banistmo.certificacion.userinterface.menu.MenuConfiguracionPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class ActualizarDatosHomeToken implements Task {
  public static ActualizarDatosHomeToken desdeHome() {
    return instrumented(ActualizarDatosHomeToken.class);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        EsperarCarga.desaparezca(),
        EsperarElemento.esClickable(BTN_CONFIGURACION),
        Click.on(BTN_CONFIGURACION),
        EsperarCarga.desaparezca(),
        EsperarElemento.esClickable(MenuConfiguracionPage.BTN_ACTUALIZAR_DATOS),
        Click.on(MenuConfiguracionPage.BTN_ACTUALIZAR_DATOS));
    actor.should(
        seeThat(ValidacionDeTokenActualizarDatos.enPantalla())
            .orComplainWith(
                TransferenciaExitosaException.class,
                TRANSFERENCIA_EXITOSA_NO_ENCONTRADO + MuestraLog.browser().answeredBy(actor)));
    actor.attemptsTo(EsperarCarga.desaparezca());
  }
}
