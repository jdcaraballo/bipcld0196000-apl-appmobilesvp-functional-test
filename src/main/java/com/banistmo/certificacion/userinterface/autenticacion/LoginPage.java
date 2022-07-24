package com.banistmo.certificacion.userinterface.autenticacion;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage {
  public static final Target BTN_SKIP_INTRO =
      Target.the("Saltar Intro").located(By.xpath("(//*[@class='skip row']/span)[1]"));
  public static final Target TXT_USUARIO =
      Target.the("Login Input").located(By.id("input_username"));
  public static final Target BTN_CONTINUAR =
      Target.the("Contenedor Button Continue")
          .located(By.xpath("(//*[@id='btnContintoggleStateueUser'])[last()]"));
  public static final Target TXT_CLAVE =
      Target.the("Password Input").located(By.cssSelector("#inpPassword > input"));
  public static final Target BTN_INICIAR_SESION =
      Target.the("Button Login").located(By.cssSelector("button#btnLogin"));
  public static final Target SPN_CARGA =
      Target.the("Loader de carga").located(By.xpath("//*[@class='loading-inner']"));
  public static final Target MSG_APLICACION =
      Target.the("Mensaje de la aplicacion Principal").locatedBy("//*[contains(text(),'{0}')]");
  public static final Target MSG_APLICACION_SIN_PRODUCTOS =
          Target.the("Mensaje de la aplicacion  sin productos").locatedBy("(//*[contains(text(),'{0}')])[4]");
  public static final Target BTN_VISUALIZAR_CLAVE =
      Target.the("Visualizar clave").located(By.id("buttonEffect"));
  public static final Target BTN_VISUALIZAR_CLAVE_CAMBIO_CLAVE =
          Target.the("Visualizar clave").located(By.id("btn_seeNewPassword"));
  public static final Target BTN_VISUALIZAR_CONFIRMAR_CLAVE_CAMBIO_CLAVE =
          Target.the("Visualizar clave").located(By.xpath("//*[@class='icon icon-md ion-md-banistmo-view']"));
  public static final Target BTN_CANCELAR_LOGIN =
      Target.the("Cancelar Login").located(By.id("btnCancelPass"));
  public static final Target BTN_TOKEN =
      Target.the("Boton configuracion de token").located(By.name("acceso"));
  public static final Target MSG_APLICACION_SIN_FONDOS =
      Target.the("Mensaje de la aplicacion").locatedBy("//*[@id=\"alert-msg-0\"]");
    public static final Target BTN_OLVIDO_USUARIO =
      Target.the("Link Olvidaste el Usuario").locatedBy("//*[contains(text(),'¿Olvidaste el usuario?')]");
  public static final Target BTN_OLVIDO_CLAVE =
      Target.the("Link Olvidaste clave").locatedBy("//*[@id='hrfFotgotPass']");

  private LoginPage() {}
}
