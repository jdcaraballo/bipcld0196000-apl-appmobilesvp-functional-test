package com.banistmo.certificacion.userinterface.tarjetascreditos;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class TarjetasCreditoPage {
  public static final Target RBT_OTRO_VALOR =
      Target.the("Radio boton otro valor").located(By.id("id_radio-2"));
  public static final Target TXT_MONTO =
      Target.the("Input monto transferencias terceros")
          .located(By.xpath("(//*[@id='text-amount']/input)[last()]"));
  public static final Target TXT_DESCRIPCION =
      Target.the("Input Descripcion terceros")
          .located(By.xpath("//ion-label[contains(.,'Descripción del pago')]/../..//input"));
  public static final Target TXT_DESCRIPCION_TERCEROS =
      Target.the("Input Descripcion terceros")
          .located(By.xpath("//*[@id='fatherContainer-']//input"));
  public static final Target RBT_PAGO =
      Target.the("Radio boton pago")
          .locatedBy("//label[contains(@id,'id_radio')][contains(.,'Pago {0}')]");
  public static final Target LBL_MONTO_PAGO =
      Target.the("Label monto pago")
          .locatedBy(
              "//label[contains(@id,'id_radio')][contains(.,'Pago {0}')]/../../..//label[@class='currency-value']");

  private TarjetasCreditoPage() {}
}
