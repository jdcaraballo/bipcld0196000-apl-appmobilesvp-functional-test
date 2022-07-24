package com.banistmo.certificacion.userinterface.transferencias.qr;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PreparacionQRPage {

  public static final Target BTN_CUENTA_DESTINO_QR =
      Target.the("Boton cuenta destino").located(By.xpath("//*[@id='id_basic_card']/ion-row"));
  public static final Target LST_CUENTAS_DESTINO_QR =
      Target.the("Lista de cuentas destino").located(By.xpath("//*[@id='accName']"));
  public static final Target TXT_DESCRIPCION_QR =
      Target.the("Input descripcion QR").located(By.xpath("//*[@id='descriptionText']/input"));
  public static final Target BTN_CONTINUAR_QR =
      Target.the("Boton continuar preparacion QR")
          .located(By.xpath("//*[(contains(text(),'GENERAR'))]"));
  public static final Target BTN_CONFIRMAR_GENERAR_QR =
      Target.the("Boton continuar preparacion QR")
          .located(By.xpath("//*[(contains(text(),'GENERAR'))]"));
  public static final Target BTN_CONTINUAR_GENERAR_QR =
      Target.the("Boton generar QR").located(By.xpath("//*[@id='continueBtn']"));
  public static final Target BTN_GENERAR =
      Target.the("Boton generar QR").located(By.cssSelector("button#payBtn"));
  public static final Target LBL_CUENTA_DESTINO_QR =
      Target.the("Numero de cuenta destino")
          .located(By.xpath("//*[(contains(text(),'Cuenta destino'))]"));
  public static final Target RDB_CON_MONTO =
      Target.the("Opcion QR con monto")
          .located(By.xpath("//*[(contains(text(),' QR con monto '))]"));
  public static final Target TXT_MONTO_QR =
      Target.the("Input monto").located(By.xpath("//*[@id=\"text-amount\"]/input"));

  private PreparacionQRPage() {}
}
