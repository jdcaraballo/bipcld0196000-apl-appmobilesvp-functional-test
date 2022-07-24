package com.banistmo.certificacion.userinterface.comunes;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ConfirmacionTransaccionGeneralPage {
  public static final Target BTN_COMPARTIR =
      Target.the("Compartir transaccion").located(By.cssSelector("button#shareBtn"));
  public static final Target BTN_GENERAR_PDF =
      Target.the("Generar PDF").locatedBy("//*[contains(text(), 'Generar PDF')]");
  public static final Target BTN_GENERAR_IMAGEN =
      Target.the("Generar Imagen").locatedBy("//*[contains(text(), 'Generar Imagen')]");
  public static final Target MSG_DESCARGA_COMPLETA =
      Target.the("Mensaje de descarga completa")
          .locatedBy("//*[contains(text(), 'Descarga completada')]");
  public static final Target LBL_MONTO =
      Target.the("Monto mostrado en comprobante de la transferencia")
          .located(By.cssSelector("#toPrint #amountInfo"));
  public static final Target LBL_DETALLES =
      Target.the("Detalles en comprobante")
          .located(By.xpath("(//*[@id='detailsInfo' or @id='detailInfo'])[last()]"));
  public static final Target LBL_NUMERO_CUENTA_RETIRO =
      Target.the("Label cuenta retiro comprobante")
          .located(By.xpath("(//*[@id='originAccInfo']//ion-label)[last()]"));
  public static final Target LBL_MONTO_COMPROBANTE =
      Target.the("Label monto comprobante")
          .located(By.xpath("(//*[@id='amountField' or @id='amountInfo'])[last()]"));
  public static final Target LBL_NUMERO_COMPROBANTE =
      Target.the("Label numero comprobante").located(By.xpath("(//*[@id='receiptInfo'])[last()]"));
  public static final Target LBL_BANCO_COMPROBANTE =
      Target.the("Label banco comprobante")
          .located(By.xpath("(//*[@id='bankDetination' or @id='bankNameInfo'])[last()]"));
  public static final Target LBL_DESTINO_COMPROBANTE =
      Target.the("Label destino comprobante")
          .located(By.xpath("(//*[@id='destinationAccInfo']//ion-row)[last()]"));
  public static final Target LBL_COMPROBANTE =
      Target.the("Datos comprobante")
          .locatedBy("(//ion-label[contains(.,'{0}')]/following-sibling::ion-label)[last()]");
  public static final Target LBL_FECHA_FUTURA =
      Target.the("Label fecha a realizar la transaccion programada")
          .located(By.xpath("(//*[@id='InitialDateInfo' or @id='txDate'])[last()]"));
  public static final Target LBL_DATO_FECHA_TRANSACCION =
      Target.the("Lalbel fecha recurrencia").located(By.xpath("(//*[@id='txDay'])[last()]"));
  public static final Target LBL_FRECUENCIA =
      Target.the("Label frecuencia")
          .located(By.xpath("(//*[@id='txTypeFrecuency' or @id='txFrecuency'])[last()]"));
  public static final Target LBL_FECHA_INICIAL =
      Target.the("Label Fecha inicial")
          .located(By.xpath("(//*[@id='txInitDate' or @id='txInitialDate'])[last()]"));
  public static final Target LBL_FECHA_FINAL =
      Target.the("Label Fecha final")
          .located(By.xpath("(//*[@id='txEndDate' or @id='txEndDate'])[last()]"));
  public static final Target BTN_DONE_IOS =
      Target.the("Boton nativo Done iOS")
          .located(By.xpath("//XCUIElementTypeButton[@name='Done']"));

  private ConfirmacionTransaccionGeneralPage() {}
}
