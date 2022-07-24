package com.banistmo.certificacion.task.autenticacion.recuperarusuario;

import com.banistmo.certificacion.interactions.esperas.Esperar;
import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static com.banistmo.certificacion.userinterface.autenticacion.RecuperarUsuarioPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class IngresarCorreo implements Task {

  private String correo;

  public IngresarCorreo(String correo) {
    this.correo = correo;
  }

  public static IngresarCorreo deUsuario(String correo) {
    return instrumented(IngresarCorreo.class, correo);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {

    actor.attemptsTo(
            EsperarElemento.esClickable(LBL_TXT_CORREO),
        Click.on(LBL_TXT_CORREO),
        Enter.theValue(correo).into(TXT_CORREO),
            EsperarElemento.esClickable(BTN_CONTINUAR),
        Click.on(BTN_CONTINUAR),
        EsperarCarga.desaparezca());
  }
}
