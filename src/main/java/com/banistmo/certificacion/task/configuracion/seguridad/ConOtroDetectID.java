package com.banistmo.certificacion.task.configuracion.seguridad;

import static com.banistmo.certificacion.utils.enums.EnumVariablesSesion.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.banistmo.certificacion.interactions.esperas.Esperar;
import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import com.banistmo.certificacion.questions.configuracion.seguridad.CodigoConOtroUsuario;
import com.banistmo.certificacion.userinterface.configuracion.seguridad.DatosTokenPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class ConOtroDetectID implements Task {

  private String otroUsuario;
  private String claveOtroUsuario;
  private String descripcionToken;

  public ConOtroDetectID(String otroUsuario, String claveOtroUsuario, String descripcionToken) {
    this.otroUsuario = otroUsuario;
    this.claveOtroUsuario = claveOtroUsuario;
    this.descripcionToken = descripcionToken;
  }

  public static Performable exitosa(
      String otroUsuario, String claveOtroUsuario, String descripcionToken) {
    return instrumented(ConOtroDetectID.class, otroUsuario, claveOtroUsuario, descripcionToken);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.remember(OTRO_USUARIO_LOGIN.getVariableSesion(), otroUsuario);
    actor.remember(OTRA_CLAVE_LOGIN.getVariableSesion(), claveOtroUsuario);
    actor.remember(DESCRIPCION_TOKEN.getVariableSesion(), descripcionToken);

    actor.attemptsTo(
        EsperarElemento.esVisible(DatosTokenPage.TXT_CODIGO_VERIFICACION),
        Enter.theValue(CodigoConOtroUsuario.porSoftoken().answeredBy(actor))
            .into(DatosTokenPage.TXT_CODIGO_VERIFICACION),
        Click.on(DatosTokenPage.BTN_CONTINUAR),
        EsperarCarga.desaparezca(),
        EsperarElemento.esVisible(DatosTokenPage.LBL_ALIAS_TOKEN),
        Enter.theValue(descripcionToken).into(DatosTokenPage.TXT_ALIAS_TOKEN),
        Esperar.unTiempo(3),
        EsperarElemento.esVisible(DatosTokenPage.BTN_CONTINUAR),
        Click.on(DatosTokenPage.BTN_CONTINUAR));
  }
}
