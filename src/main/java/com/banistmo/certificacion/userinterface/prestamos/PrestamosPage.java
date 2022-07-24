package com.banistmo.certificacion.userinterface.prestamos;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PrestamosPage {
  public static final Target LBL_TIPO_PRODUCTO =
      Target.the("Opcion lista desplegable seleccionada")
          .locatedBy("//select[@id='list_productType']/option[@value='{0}']");
  public static final Target LST_TIPO_PRODUCTO =
      Target.the("Opcion lista desplegable seleccionada")
          .locatedBy("//*[@id='select_productType']");
  public static final Target LBL_TITULO_PRESTAMO =
      Target.the("Titulo prestamo").located(By.xpath("//h5[.='Pago de préstamos']"));
  public static final Target LBL_CUENTA_RETIRO_PRESTAMOS =
      Target.the("Cuenta de retiro").locatedBy("(//*[@id='originAccCard'])[last()]");
  public static final Target LBL_NUMERO_PRESTAMO_PAGAR =
      Target.the("Prestamo destino").located(By.xpath("//*[@ng-reflect-id='destinationAccCard']"));
  public static final Target TXT_DESCRIPCION_PRESTAMO =
      Target.the("Descripcion del pago de prestamo")
          .located(By.cssSelector("#detailsField > input"));
  public static final Target BTN_ALERTA =
      Target.the("Boton alerta").located(By.xpath("//*[@ion-button='alert-button']"));

  private PrestamosPage() {}
}
