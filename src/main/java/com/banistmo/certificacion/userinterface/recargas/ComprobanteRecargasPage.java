package com.banistmo.certificacion.userinterface.recargas;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ComprobanteRecargasPage {
  public static final Target LBL_VALOR_RECARGA =
      Target.the("Label valor de la recarga")
          .located(By.xpath("(//*[@id='amountInfo' or @id='recharge_value'])[last()]"));
  public static final Target LBL_VALOR_RECARGA_TIEMPO_AIRE =
      Target.the("Label valor de la recarga")
          .located(By.xpath("(//*[@id='recharge_value'])[last()]"));
  public static final Target LBL_NUMERO_RECARGA =
      Target.the("Label numero recarga")
          .located(By.xpath("(//*[@id='destinationAccInfoNumber'])[last()]"));

  private ComprobanteRecargasPage() {}
}
