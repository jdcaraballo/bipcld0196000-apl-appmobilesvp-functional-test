package com.banistmo.certificacion.task.configuracion.seguridad;

import static com.banistmo.certificacion.utils.enums.EnumVariablesSesion.DESCRIPCION_TOKEN;

import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import com.banistmo.certificacion.questions.configuracion.seguridad.ObtenerCodigoDeActivacion;
import com.banistmo.certificacion.userinterface.configuracion.seguridad.DatosTokenPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class ConCodigoDetectID implements Task {

  private String descripcionToken;

  public ConCodigoDetectID(String descripcionToken) {
    this.descripcionToken = descripcionToken;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.remember(DESCRIPCION_TOKEN.getVariableSesion(), descripcionToken);
    actor.attemptsTo(
        EsperarElemento.esVisible(DatosTokenPage.TXT_CODIGO_VERIFICACION),
        Enter.theValue(ObtenerCodigoDeActivacion.porServicio().answeredBy(actor))
            .into(DatosTokenPage.TXT_CODIGO_VERIFICACION),
        Click.on(DatosTokenPage.BTN_CONTINUAR),
        EsperarCarga.desaparezca(),
        EsperarElemento.esVisible(DatosTokenPage.LBL_ALIAS_TOKEN),
        Enter.theValue(descripcionToken).into(DatosTokenPage.TXT_ALIAS_TOKEN),
        EsperarElemento.esClickable(DatosTokenPage.BTN_GUARDAR),
        Click.on(DatosTokenPage.BTN_GUARDAR));
  }
}
