package com.banistmo.certificacion.task.autenticacion.recuperarusuario;

import com.banistmo.certificacion.interactions.correo.ConsultarCorreo;
import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import com.banistmo.certificacion.userinterface.autenticacion.RecuperarUsuarioPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static com.banistmo.certificacion.userinterface.autenticacion.RecuperarUsuarioPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class IngresarCodigoPor implements Task {

  private String informacionCorreo;

  public IngresarCodigoPor(String informacionCorreo) {
    this.informacionCorreo = informacionCorreo;
  }

  public static IngresarCodigoPor olvidoUsuario(String informacionDelCorreo) {
    return instrumented(IngresarCodigoPor.class, informacionDelCorreo);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {

    actor.attemptsTo(
        Enter.keyValues(ConsultarCorreo.conInformacion(informacionCorreo).answeredBy(actor))
            .into(TXT_CODIGO_VERIFICACION),
            Click.on(RecuperarUsuarioPage.VER_CODIGO_VERIFICACION),
            Click.on(RecuperarUsuarioPage.BTN_CONTINUAR_INSCRIPCION_TOKEN),
        EsperarCarga.desaparezca());
  }
}
