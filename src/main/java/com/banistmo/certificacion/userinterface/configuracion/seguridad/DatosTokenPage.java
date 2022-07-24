package com.banistmo.certificacion.userinterface.configuracion.seguridad;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DatosTokenPage {

  public static final Target TXT_CODIGO_VERIFICACION =
      Target.the("Input codigo de verificacion").located(By.cssSelector("#lbl_Codverif>input"));
  public static final Target LBL_ALIAS_TOKEN =
      Target.the("Mensaje de nombre personalizado token").located(By.id("mess_regEmail"));
  public static final Target TXT_ALIAS_TOKEN =
      Target.the("Input alias token").located(By.cssSelector("#lbl_user>input"));
  public static final Target BTN_CONTINUAR =
      Target.the("Boton continuar en codigo de verificacion")
          .located(By.cssSelector("button#btnContinue"));
  public static final Target TXT_TARJETA_DEBITO =
      Target.the("Input tarjeta de debito").located(By.cssSelector("#lbl_associate_digits>input"));
  public static final Target TXT_CLAVE_CAJERO_AUTOMATICO =
      Target.the("Input clave de cajero automatico")
          .located(By.xpath("//*[@ng-reflect-name='pin_debit0']"));
  public static final Target BTN_GUARDAR =
      Target.the("Boton guardar token").located(By.xpath("//*[@ng-reflect-text='Guardar']/button"));
  public static final Target BTN_IR_A_INICIO =
      Target.the("Boton ir al inicio").located(By.xpath("//*[@id='btn-Home']"));

  private DatosTokenPage() {}
}
