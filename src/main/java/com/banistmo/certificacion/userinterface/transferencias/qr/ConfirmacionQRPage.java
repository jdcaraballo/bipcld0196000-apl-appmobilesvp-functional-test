package com.banistmo.certificacion.userinterface.transferencias.qr;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ConfirmacionQRPage {

  public static final Target LBL_MENSAJE_EXITOSO =
      Target.the("Mensaje de QR generado").locatedBy("[class='m-0 message']");
  public static final Target LBL_NOMBRE_COMPLETO =
      Target.the("Nombre completo")
          .located(By.xpath("(//*[contains(@class,'text-transaction')])[1]"));
  public static final Target LBL_TIPO_PRODUCTO =
      Target.the("Tipo de producto")
          .located(By.xpath("(//*[contains(@class,'text-transaction')])[3]"));
  public static final Target LBL_BANCO =
      Target.the("Banco destino")
          .located(By.xpath("(//*[contains(@class,'text-transaction')])[2]"));
  public static final Target LBL_NUMERO_CUENTA =
      Target.the("Número de cuenta")
          .located(By.xpath("(//*[contains(@class,'text-transaction')])[4]"));
  public static final Target IMG_QR = Target.the("Imagen QR").located(By.className("qr-image"));
  public static final Target BTN_DESCARGAR_QR =
      Target.the("Boton descarga QR").located(By.className("banistmo-download"));
  public static final Target LBL_MONTO = Target.the("Monto").located(By.id("amountField"));
  public static final Target LBL_DESCRIPCION =
      Target.the("Descripción de la transferencia").located(By.id("detailsField"));

  private ConfirmacionQRPage() {}
}
