package com.banistmo.certificacion.task.configuracion.seguridad;

import static com.banistmo.certificacion.userinterface.configuracion.seguridad.CambioContrasenaPage.*;
import static com.banistmo.certificacion.utils.enums.EnumVariablesSesion.CONTRASENA_NUEVA;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.banistmo.certificacion.interactions.Regresar;
import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class CambiarContrasena implements Task {

  private String contrasenaNueva;
  private String contrasenaActual;

  public CambiarContrasena(String contrasenaActual, String contrasenaNueva) {
    this.contrasenaNueva = contrasenaNueva;
    this.contrasenaActual = contrasenaActual;
  }

  public static CambiarContrasena porUnaNueva(String contrasenaActual, String contrasenaNueva) {
    return instrumented(CambiarContrasena.class, contrasenaActual, contrasenaNueva);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        Enter.theValue(contrasenaActual).into(TXT_CONTRASENA_ACTUAL),
        Enter.theValue(contrasenaNueva).into(TXT_CONTRASENA_NUEVA),
        Enter.theValue(contrasenaNueva).into(TXT_CONFIRMAR_CONTRASENA),
        Click.on(LBL_BARRA_SEGURIDAD),
        Click.on(BTN_CAMBIAR_CONTRASENA),
        EsperarCarga.desaparezca(),
        Regresar.pantallaAnterior());
    actor.remember(CONTRASENA_NUEVA.getVariableSesion(), contrasenaNueva);
  }
}
