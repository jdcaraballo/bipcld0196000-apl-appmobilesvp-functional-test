package com.banistmo.certificacion.userinterface.servicios;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DatosServiciosPage {

  public static final Target TXT_BUSCAR_SERVICIOS =
      Target.the("Input buscar servicios")
          .located(By.xpath("(//*[@id='list_SearchLupa']/..//input)[last()]"));
  public static final Target BTN_SERVICIO =
      Target.the("Boton de servicio filtrado")
          .located(By.xpath("(//*[@id='listAccItem ']/div)[last()]"));

  private DatosServiciosPage() {}
}
