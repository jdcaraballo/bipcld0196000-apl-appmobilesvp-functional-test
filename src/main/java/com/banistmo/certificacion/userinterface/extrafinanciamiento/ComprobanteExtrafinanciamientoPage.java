package com.banistmo.certificacion.userinterface.extrafinanciamiento;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ComprobanteExtrafinanciamientoPage {

  public static final Target LBL_CUENTA_DEPOSITO =
      Target.the("Numero de cuenta deposito").located(By.id("destinationAccInfoNumber"));
  public static final Target LBL_MONTO_SOLICITADO =
      Target.the("Monto solicitado").located(By.id("amountInfo"));
  public static final Target LBL_CUOTAS =
      Target.the("Cutotas a pagar").located(By.id("duesNumber"));
  public static final Target LBL_CUOTA_MENSUAL =
      Target.the("Valor cuota mensual")
          .located(
              By.xpath(
                  "//ion-label[contains(.,'Cuota mensual')]/following-sibling::ion-label[@id='extrafinancing.sososo']"));

  private ComprobanteExtrafinanciamientoPage() {}
}
