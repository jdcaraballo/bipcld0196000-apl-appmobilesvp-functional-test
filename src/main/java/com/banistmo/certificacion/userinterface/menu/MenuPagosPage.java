package com.banistmo.certificacion.userinterface.menu;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class MenuPagosPage {
  public static final Target BTN_TARJETAS_CREDITO =
      Target.the("Boton Pagos Tarjetas de credito")
          .located(By.xpath("//span[text()='Tarjetas de crédito']/parent::button"));
  public static final Target BTN_SERVICIOS =
      Target.the("Boton Pagos Servicios")
          .located(By.xpath("//span[text()='Servicios']/parent::button"));
  public static final Target BTN_PRESTAMOS =
      Target.the("Boton pagos Prestamos")
          .located(By.xpath("//span[text()='Préstamos']/parent::button"));
  public static final Target BTN_PROGRAMADOS =
      Target.the("Opcion de pagos programados")
          .located(By.xpath("//span[text()='Programados']/parent::button"));

  private MenuPagosPage() {}
}
