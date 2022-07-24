package com.banistmo.certificacion.userinterface.recargas;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class RecargasPage {
  public static final Target TXT_MONTO =
      Target.the("Monto a pagar recargas").locatedBy("(//*[@id='text-amount']/input)[last()]");
  public static final Target TXT_DESCRIPCION =
      Target.the("Descripcion del pago de servicio")
          .locatedBy("(//*[@id='detailfield']/input)[last()]");
  public static final Target LST_BTN_RECARGAS_GUARDADAS =
      Target.the("Boton recargas guardadas")
          .located(
              By.xpath(
                  "//*[contains(@id,'content-card-listAccItem') or contains(@id,'listAccItem')]/div"));
  public static final Target LBL_NUMERO_GUARDADO =
      Target.the("Label numero guardado")
          .located(By.xpath("//*[@id='dateLimit' or @id='lbl_referenceId']"));

  private RecargasPage() {}
}
