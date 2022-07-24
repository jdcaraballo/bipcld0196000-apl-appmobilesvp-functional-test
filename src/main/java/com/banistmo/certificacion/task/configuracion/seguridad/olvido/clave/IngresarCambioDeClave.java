package com.banistmo.certificacion.task.configuracion.seguridad.olvido.clave;

import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static com.banistmo.certificacion.userinterface.autenticacion.LoginPage.*;
import static com.banistmo.certificacion.userinterface.autenticacion.RecuperarUsuarioPage.BTN_CONTINUAR_BACK_LOGIN;
import static com.banistmo.certificacion.userinterface.configuracion.seguridad.CambioContrasenaPage.*;
import static com.banistmo.certificacion.utils.enums.EnumVariablesSesion.CONTRASENA_NUEVA;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class IngresarCambioDeClave implements Task {

  private String contrasenaNueva;

  public IngresarCambioDeClave(String contrasenaNueva) {
    this.contrasenaNueva = contrasenaNueva;
  }

  public static IngresarCambioDeClave nueva(String contrasenaNueva) {
    return instrumented(IngresarCambioDeClave.class,  contrasenaNueva);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        Enter.theValue(contrasenaNueva).into(TXT_CONTRASENA_NUEVA),
        Click.on(BTN_VISUALIZAR_CLAVE_CAMBIO_CLAVE),
        Enter.theValue(contrasenaNueva).into(TXT_CONFIRMAR_CONTRASENA),
        Click.on(BTN_VISUALIZAR_CONFIRMAR_CLAVE_CAMBIO_CLAVE),
        Click.on(BTN_CAMBIAR_CONTRASENA),
        EsperarCarga.desaparezca(),
        EsperarElemento.esClickable(BTN_CONTINUAR_BACK_LOGIN));
    actor.remember(CONTRASENA_NUEVA.getVariableSesion(), contrasenaNueva);
  }
}
