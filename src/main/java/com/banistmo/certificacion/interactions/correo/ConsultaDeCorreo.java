package com.banistmo.certificacion.interactions.correo;

import com.google.api.services.gmail.model.Message;

import java.io.IOException;
import java.security.GeneralSecurityException;

import static com.banistmo.certificacion.utils.GmailAPI.getGmailService;
import static com.banistmo.certificacion.utils.GmailAPI.getMailByBody;

public class ConsultaDeCorreo {

  private String informacionCorreo;

  public ConsultaDeCorreo(String informacionCorreo) {
    this.informacionCorreo = informacionCorreo;
  }

  public static ConsultaDeCorreo conInformacion(String informacionDelCorreo) {
    return new ConsultaDeCorreo(informacionDelCorreo);
  }

  public Message getMessage() {
    Message message = null;

    System.setProperty(
        "refresh.token",
        "1//05jfntVIsswlLCgYIARAAGAUSNwF-L9Ir-T86uHWdkqqipkcOEFX7_WAvKU6Xt-miwFOVj_TVu5Lawy8ASJ7IJ3DPESCdF8Bxf6g");
    System.setProperty(
        "client.id", "1010124264903-2ak7asm0ca838q9v1eh0t050hf0jgt09.apps.googleusercontent.com");
    System.setProperty("client.secret", "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");

    try {
      getGmailService();
    } catch (IOException | GeneralSecurityException e) {
      e.printStackTrace();
    }

    try {
      message = getMailByBody(informacionCorreo);
    } catch (IOException e) {
      e.printStackTrace();
    }

    return message;
  }
}
