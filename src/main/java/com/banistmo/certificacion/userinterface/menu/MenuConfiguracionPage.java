package com.banistmo.certificacion.userinterface.menu;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class MenuConfiguracionPage {
  public static final Target BTN_CERRAR_SESION =
      Target.the("Boton cerrar sesion desde configuracion")
          .located(By.cssSelector("[ng-reflect-name='marca-logout']"));
  public static final Target BTN_SALIR =
      Target.the("Boton salir desde configuracion").locatedBy("//*[@id='exit']");
  public static final Target BTN_OPT_CONFIGURACION =
      Target.the("Boton opcion configuracion")
          .locatedBy("//p[text()='{0}']/parent::div[@class='card-demo']");
  public static final Target BTN_OPT_ADMINISTRACION =
          Target.the("Boton opcion administracion").locatedBy("//*[@id='config']");
  public static final Target BTN_OPT_SEGURIDAD =
      Target.the("Boton opcion  Seguridad").located(By.id("security"));
  public static final Target BTN_ACTUALIZAR_DATOS =
      Target.the("Boton Actualizar Datos")
          .locatedBy("//*[(contains(text(),'Actualización de datos'))]");
  public static final Target BTN_ACTUALIZAR_DATOS_HOME =
          Target.the("Boton Actualizar Datos").locatedBy("//*[(contains(text(),'Actualizar datos'))]");

  private MenuConfiguracionPage() {}
}
