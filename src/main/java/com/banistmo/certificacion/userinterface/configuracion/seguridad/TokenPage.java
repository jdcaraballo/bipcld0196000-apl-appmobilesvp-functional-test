package com.banistmo.certificacion.userinterface.configuracion.seguridad;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class TokenPage {

  public static final Target BTN_INSCRIBIR =
      Target.the("Boton inscribir token")
          .located(By.xpath("//p[text()='Inscribir Token']/ancestor::div[@class='card-token']"));
  public static final Target TXT_USUARIO =
      Target.the("Campo de usuario").located(By.xpath("(//*[@id='inpUser']/input)[last()]"));
  public static final Target TXT_CLAVE =
      Target.the("Campo de clave").located(By.cssSelector("#inpPassword>input"));
  public static final Target BTN_CONTINUAR =
      Target.the("Boton continuar registro").located(By.cssSelector("button#btn_continuetoken"));
  public static final Target BTN_IR_A_INICIO =
      Target.the("Boton ir al inicio").located(By.id("btn-Home"));
  public static final Target BTN_GENERAR =
      Target.the("Boton generar token")
          .located(By.xpath("//p[text()='Generar Token']/ancestor::div[@class='card-token']"));
  public static final Target BTN_USUARIO_REGISTRADO =
      Target.the("Boton usuario registrado").locatedBy("//*[@id='item_' and contains(., '{0}')]");
  public static final Target BTN_CONTINUAR_REGISTRO =
      Target.the("Boton continuar registro en alerta")
          .located(By.cssSelector("button#btn_continue"));
  public static final Target BTN_ELIMINAR =
      Target.the("Boton eliminar token")
          .located(By.xpath("//p[text()='Eliminar Token']/ancestor::div[@class='card-token']"));
  public static final Target BTN_CONFIRMAR_ELIMINAR =
      Target.the("Boton confirmar eliminar registro").located(By.xpath("//*[@id='droptoken']"));
  public static final Target BTN_ENTENDIDO =
      Target.the("Boton mensaje 'Entendido' ").located(By.id("Btn_confirm"));
  public static final Target LBL_ALERTA_INSCRITO_EN_OTRO_DISPOSITIVO =
      Target.the("Alerta inscrito en otro dispositivo")
          .located(
              By.xpath(
                  "//*[contains(text(), 'Si su usuario ya se encuentra inscrito para el uso del SoftToken')]"));
  public static final Target BTN_VER_CLAVE =
      Target.the("Boton ver contraseña").located(By.id("btn_confirm"));

  private TokenPage() {}
}
