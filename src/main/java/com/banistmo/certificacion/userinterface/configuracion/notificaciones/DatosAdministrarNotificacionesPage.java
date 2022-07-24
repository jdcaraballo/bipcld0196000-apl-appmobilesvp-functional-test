package com.banistmo.certificacion.userinterface.configuracion.notificaciones;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DatosAdministrarNotificacionesPage {

  public static final Target LBL_DATOS_CONFIRMACION =
      Target.the("Nuevos datos de configuracion")
          .located(By.xpath("//div[contains(@class,'label-resumen') or @class='currency']"));
  public static final Target LBL_MEDIOS_ACTIVAR =
      Target.the("Medios a activar")
          .located(
              By.xpath("//label[contains(.,'Medio')]/parent::div/following-sibling::div/div/div"));
  public static final Target LBL_MONTO_MINIMO =
      Target.the("Monto minimo de notificacion")
          .located(By.xpath("//label[contains(.,'Valor')]/parent::div/following-sibling::div/div"));
  public static final Target LBL_COMPLETADO =
      Target.the("Mensaje de exito")
          .located(By.xpath("//*[contains(@class,'notification success')]"));

  private DatosAdministrarNotificacionesPage() {}
}
