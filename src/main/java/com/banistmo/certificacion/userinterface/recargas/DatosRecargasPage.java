package com.banistmo.certificacion.userinterface.recargas;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DatosRecargasPage {
  public static final Target BTN_NOMBRE_OPERADOR =
      Target.the("Ingresar operador de recarga").located(By.cssSelector("#operator_name"));
  public static final Target LST_BTN_OPERADOR =
      Target.the("lista de operadores")
          .located(By.cssSelector("[class^='item item-block item-md item-radio']"));
  public static final Target TXT_NUMERO_CELULAR =
      Target.the("Input numero celular")
          .located(By.xpath("//*[@id='number_product' or @id='Numbers_product']/input"));

  private DatosRecargasPage() {}
}
