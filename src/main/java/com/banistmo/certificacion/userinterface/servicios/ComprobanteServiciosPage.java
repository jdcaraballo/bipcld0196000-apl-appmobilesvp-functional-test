package com.banistmo.certificacion.userinterface.servicios;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ComprobanteServiciosPage {

  public static final Target LBL_CODIGO_SERVICIO =
      Target.the("Label codigo servicio")
          .located(By.xpath("(//*[@id='lbl_ServiceCategory'])[last()]"));
  public static final Target LBL_NUMERO_SERVICIO =
      Target.the("Label numero servicio").located(By.xpath("(//*[@id='kef0'])[last()]"));
  public static final Target LBL_MONTO =
      Target.the("Label monto").located(By.xpath("(//*[@id='lbl_Amount'])[last()]"));
  public static final Target LBL_NUMERO_CUENTA_RETIROS =
      Target.the("numero de la cuenta a retirar").locatedBy("(//*[@id='originAccCard'])[last()]");

  private ComprobanteServiciosPage() {}
}
