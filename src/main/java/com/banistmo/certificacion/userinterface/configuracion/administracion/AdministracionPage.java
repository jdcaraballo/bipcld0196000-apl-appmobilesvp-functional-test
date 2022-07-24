package com.banistmo.certificacion.userinterface.configuracion.administracion;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class AdministracionPage {
  public static final Target BTN_MIS_FAVORITOS =
      Target.the("Menu CONFIGURACION opcion Administracion opcion mis favoritos")
          .locatedBy("//*[contains(text(),'Mis favoritos')]");
  public static final Target BTN_OPT_FAVORITOS =
      Target.the("Boton para favoritos").locatedBy("//ion-row//label[contains(.,'{0}')]");
  public static final Target BTN_CONFIGURAR_PRODUCTOS =
      Target.the("Menu MAS " + "opcion Administracion opcion configurar productos")
          .located(By.xpath("//*[contains(text(),'Configurar productos')]"));
  public static final Target BTN_ADMINISTRAR_NOTIFICACIONES =
      Target.the("Opción de administración de notificaciones")
          .located(By.xpath("//*[contains(text(),'Administrar notificaciones')]"));

  private AdministracionPage() {}
}
