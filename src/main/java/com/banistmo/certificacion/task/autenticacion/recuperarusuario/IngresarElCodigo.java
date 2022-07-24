package com.banistmo.certificacion.task.autenticacion.recuperarusuario;


import com.banistmo.certificacion.interactions.correo.ConsultaDeCorreo;
import com.banistmo.certificacion.interactions.esperas.Esperar;
import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import com.banistmo.certificacion.userinterface.autenticacion.RecuperarUsuarioPage;
import com.google.api.client.repackaged.org.apache.commons.codec.binary.Base64;
import com.google.api.client.repackaged.org.apache.commons.codec.binary.StringUtils;
import com.google.api.services.gmail.model.Message;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static com.banistmo.certificacion.userinterface.autenticacion.RecuperarUsuarioPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class IngresarElCodigo implements Task {

  private String informacionCorreo;

  public IngresarElCodigo(String informacionCorreo) {
    this.informacionCorreo = informacionCorreo;
  }

  public static IngresarElCodigo correo(String informacionDelCorreo) {
    return instrumented(IngresarElCodigo.class, informacionDelCorreo);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    if ("Olvidó usuario".equalsIgnoreCase(informacionCorreo)) {
      String codigoVerificacion =
              buscarCodigo(ConsultaDeCorreo.conInformacion(informacionCorreo).getMessage());
      actor.attemptsTo(
              EsperarElemento.esVisible(LBL_TXT_CODIGO_VERIFICACION),
              Click.on(LBL_TXT_CODIGO_VERIFICACION),
              Enter.theValue(codigoVerificacion).into(RecuperarUsuarioPage.TXT_CODIGO_VERIFICACION),
              Click.on(VER_CODIGO_VERIFICACION),
              Click.on(BTN_CONTINUAR_INSCRIPCION_TOKEN),
              EsperarCarga.desaparezca());
    }

    if ("Recuperar Contraseña".equalsIgnoreCase(informacionCorreo)) {
      actor.attemptsTo(Esperar.unTiempo(20000));
      String codigoVerificacion =
              buscarCodigoOlvidoContrasena(
                      ConsultaDeCorreo.conInformacion(informacionCorreo).getMessage());
      actor.attemptsTo(
              EsperarElemento.esVisible(LBL_TXT_CODIGO_VERIFICACION),
              Click.on(LBL_TXT_CODIGO_VERIFICACION),
              Enter.theValue(codigoVerificacion).into(RecuperarUsuarioPage.TXT_CODIGO_VERIFICACION),
              Click.on(VER_CODIGO_VERIFICACION),
              Click.on(BTN_CONTINUAR_INSCRIPCION_TOKEN),
              EsperarCarga.desaparezca());
    }

  }

  private String buscarCodigoOlvidoContrasena(Message message) {
    String buscado = "color:#00B0F0";
    String emailBody =
            StringUtils.newStringUtf8(Base64.decodeBase64(message.getPayload().getBody().getData()));
    int index = emailBody.indexOf(buscado);
    return emailBody.substring(index + 17, index + 25);
  }

  private String buscarCodigo(Message message) {
    String buscado = "Código de verificación: ";
    String emailBody = message.getSnippet();
    int index = emailBody.indexOf(buscado);
    return emailBody.substring(index, index + 32).replace(buscado, "");
  }
}