package com.banistmo.certificacion.userinterface.transferencias.terceros;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class TercerosPage {
  public static final Target MSG_CREACION_EXITOS_FAVORITO =
      Target.the("Pestana para ver los productos inactivos")
          .locatedBy(
              "//*[(@id='msg_succes_favorite')and(contains(text(),'nueva cuenta favorita de manera exitosa'))]");
  public static final Target TXT_MONTO =
      Target.the("Input monto transferencias terceros")
          .located(
              By.xpath("(//ion-input[@id='amountField0' or @id='amountField']/input)[last()]"));
  public static final Target TXT_DESCRIPCION =
      Target.the("Input Descripcion terceros")
          .located(
              By.xpath("(//ion-input[@id='detailfield0' or @id='detailsField']/input)[last()]"));

  private TercerosPage() {}
}
