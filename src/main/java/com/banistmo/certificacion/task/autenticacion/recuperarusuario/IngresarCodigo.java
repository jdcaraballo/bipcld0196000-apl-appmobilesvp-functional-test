package com.banistmo.certificacion.task.autenticacion.recuperarusuario;

import com.banistmo.certificacion.interactions.correo.ConsultarCorreoToken;
import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import com.banistmo.certificacion.userinterface.autenticacion.RecuperarUsuarioPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static com.banistmo.certificacion.userinterface.autenticacion.RecuperarUsuarioPage.LBL_TXT_CODIGO_VERIFICACION;
import static com.banistmo.certificacion.userinterface.autenticacion.RecuperarUsuarioPage.TXT_CODIGO_VERIFICACION;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class IngresarCodigo implements Task {

  private String informacionCorreo;

  public IngresarCodigo(String informacionCorreo) {
    this.informacionCorreo = informacionCorreo;
  }

  public static IngresarCodigo inscripcionToken(String informacionDelCorreo) {
    return instrumented(IngresarCodigo.class, informacionDelCorreo);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {

    actor.attemptsTo(
            EsperarElemento.esVisible(LBL_TXT_CODIGO_VERIFICACION),
        Click.on(LBL_TXT_CODIGO_VERIFICACION),
        Enter.theValue(ConsultarCorreoToken.conInformacion(informacionCorreo).answeredBy(actor))
            .into(TXT_CODIGO_VERIFICACION),
        Click.on(RecuperarUsuarioPage.VER_CODIGO_VERIFICACION),
            Click.on(RecuperarUsuarioPage.BTN_CONTINUAR_INSCRIPCION_TOKEN),
        EsperarCarga.desaparezca());
  }
}
