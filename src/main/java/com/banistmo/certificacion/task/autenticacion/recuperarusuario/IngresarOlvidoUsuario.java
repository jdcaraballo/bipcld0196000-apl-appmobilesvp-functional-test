package com.banistmo.certificacion.task.autenticacion.recuperarusuario;

import com.banistmo.certificacion.interactions.SelecionarLista;
import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import com.banistmo.certificacion.userinterface.autenticacion.RecuperarUsuarioPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import java.util.List;
import java.util.Map;

import static com.banistmo.certificacion.userinterface.autenticacion.RecuperarUsuarioPage.*;
import static com.banistmo.certificacion.userinterface.comunes.TransaccionesGeneralPage.LST_TIPO;

public class IngresarOlvidoUsuario implements Task {

  private String tipoId;
  private String nroId;
  private String correo;

  public IngresarOlvidoUsuario(List<Map<String, String>> datos) {
    this.tipoId = datos.get(0).get("tipo id");
    this.nroId = datos.get(0).get("nro id");
    this.correo = datos.get(0).get("correo");
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    String[] cedula = nroId.split("-");
    actor.attemptsTo(
            EsperarElemento.esVisible(LST_TIPO_ID),
            Click.on(LST_TIPO_ID),
            SelecionarLista.unaOpcion(tipoId,LST_TIPO));

    if ("Cédula".equals(tipoId)) {
      actor.attemptsTo(
              EsperarCarga.desaparezca(),
              EsperarElemento.esClickable(BTN_PROVINCIA),
              Click.on(BTN_PROVINCIA),

              SelecionarLista.unaOpcion(cedula[0],LST_TIPO_PROVINCIA),
              Click.on(BTN_SELECCIONAR),
              EsperarElemento.esClickable(TXT_2DO_DIGITO),
              Enter.theValue(cedula[1]).into(TXT_2DO_DIGITO),
              Enter.theValue(cedula[2]).into(TXT_3ER_DIGITO));
    } else {
      actor.attemptsTo(
              Click.on(LBL_TXT_PASAPORTE),
              Enter.keyValues(nroId).into(TXT_PASAPORTE));
    }

    actor.attemptsTo(
            Click.on(RecuperarUsuarioPage.BTN_CONTINUAR),
            EsperarElemento.esClickable(LBL_TXT_CORREO),
            Click.on(LBL_TXT_CORREO),
            Enter.theValue(correo).into(TXT_CORREO),
            EsperarElemento.esClickable(BTN_CONTINUAR_CORREO),
            Click.on(BTN_CONTINUAR_CORREO),
            EsperarCarga.desaparezca());
  }
}
