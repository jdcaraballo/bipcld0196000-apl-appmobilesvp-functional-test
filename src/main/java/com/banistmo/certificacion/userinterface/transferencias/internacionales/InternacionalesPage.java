package com.banistmo.certificacion.userinterface.transferencias.internacionales;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class InternacionalesPage {
  public static final Target TXT_MONTO =
      Target.the("Input Monto de transferencia internacional")
          .located(By.cssSelector("#id_amount > input"));
  public static final Target TXT_DESCRIPCION =
      Target.the("Input Descripcion de transferencia " + "internacional")
          .located(By.cssSelector("#id_descriptionTransfer > input"));
  public static final Target RBT_ASUMIR_COSTO =
      Target.the("Radio boton de Asumo el costo de la transferencia OUR")
          .located(By.cssSelector("#id_radio-0our"));
  public static final Target LBL_CODIGO_BANCO =
      Target.the("Label codigo banco")
          .located(By.xpath("(//*[@class='number-code-bank label label-md'])[last()]"));
  public static final Target BTN_CUENTA_INTERNACIONAL_GUARDADA =
      Target.the("Boton cuenta guardada internacional")
          .located(By.cssSelector("[id^='content-card-']"));
  public static final Target LBL_BANCO_DESTINO =
      Target.the("Label banco destino").located(By.xpath("(//*[@id='idBankInf'])[last()]"));
  public static final Target LBL_PAIS_DESTINO =
      Target.the("Label banco destino")
          .located(By.xpath("(//*[@id='originNumberAccount'])[last()]"));

  private InternacionalesPage() {}
}
