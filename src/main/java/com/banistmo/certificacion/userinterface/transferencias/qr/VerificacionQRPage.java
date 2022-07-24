package com.banistmo.certificacion.userinterface.transferencias.qr;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class VerificacionQRPage {

  public static final Target BTN_MODIFICAR_QR =
      Target.the("Boton modificar QR").located(By.xpath("//*[(contains(text(),'MODIFICAR'))]"));
  public static final Target BTN_CANCELAR_QR =
      Target.the("Boton cancelar QR").located(By.cssSelector("button#cancelVBtn"));
  public static final Target LBL_CANCELAR_TRANSACCION =
      Target.the("Mensaje cancelar transaccion")
          .located(By.xpath("//h2[text()='Cancelar transacción']"));
  public static final Target BTN_CONFIRMAR_CANCELAR_QR =
      Target.the("Boton cancelar QR").located(By.cssSelector("button#btn_confirm"));

  private VerificacionQRPage() {}
}
