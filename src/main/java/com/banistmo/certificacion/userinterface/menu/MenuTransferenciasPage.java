package com.banistmo.certificacion.userinterface.menu;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class MenuTransferenciasPage {
  public static final Target BTN_ENTRE_CUENTAS_PROPIAS =
      Target.the("Menu Transferencias opcion propias")
          .located(By.xpath("//button[.='Entre cuentas propias']"));
  public static final Target BTN_TERCEROS =
      Target.the("Menu Transferencias opcion terceros")
          .located(By.xpath("//button[.='A terceros']"));
  public static final Target BTN_INTERNACIONALES =
      Target.the("Menu Transferencias opcion Internacionales")
          .located(By.xpath("//button[.='Internacionales']"));
  public static final Target BTN_PROGRAMADAS =
      Target.the("Menu Transferencias opcion programadas")
          .located(By.xpath("//button[.='Programadas']"));

  private MenuTransferenciasPage() {}
}
