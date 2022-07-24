package com.banistmo.certificacion.userinterface.extrafinanciamiento;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ExtrafinanciamientoPage {

  public static final Target TXT_MONTO_A_SOLICITAR =
      Target.the("Input monto a solicitar").located(By.cssSelector("#amount_request>input"));
  public static final Target BTN_LST_CUOTAS =
      Target.the("Boton de cuotas").located(By.cssSelector("#numb_dues>button"));
  public static final Target TXT_DESCRIPCION_EXTRAFINANCIAMIENTO =
      Target.the("Input campo descripcion").located(By.cssSelector("#detailfield>input"));
  public static final Target LBL_COUTA_MENSUAL =
      Target.the("Monto de cuota mensual")
          .located(
              By.xpath(
                  "//*[@id='fatherContainer-cout_mens']//ion-label[contains(@class, 'text-amount')]"));

  private ExtrafinanciamientoPage() {}
}
