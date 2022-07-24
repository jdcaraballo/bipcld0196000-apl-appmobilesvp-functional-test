package com.banistmo.certificacion.task.configuracion.seguridad;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import com.banistmo.certificacion.userinterface.configuracion.seguridad.TokenPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;

public class EliminarToken implements Task {
  public static EliminarToken registrado() {
    return instrumented(EliminarToken.class);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    String descripcionToken = actor.recall("descripcion token").toString();
    actor.attemptsTo(
        Click.on(TokenPage.BTN_IR_A_INICIO),
        EsperarCarga.desaparezca(),
        EsperarElemento.esClickable(TokenPage.BTN_GENERAR),
        Click.on(TokenPage.BTN_ELIMINAR),
        EsperarElemento.esVisible(TokenPage.BTN_USUARIO_REGISTRADO.of(descripcionToken)),
        Ensure.that(TokenPage.BTN_USUARIO_REGISTRADO.of(descripcionToken)).isDisplayed(),
        Click.on(TokenPage.BTN_USUARIO_REGISTRADO.of(descripcionToken)),
        EsperarElemento.esVisible(TokenPage.BTN_CONFIRMAR_ELIMINAR),
        Click.on(TokenPage.BTN_CONFIRMAR_ELIMINAR));
  }
}
