package com.banistmo.certificacion.userinterface.menu;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class MenuPage {

  public static final Target LBL_DEPOSITOS =
      Target.the("Consolidado de depositos")
          .located(By.cssSelector("[class='card-container grid']"));
  public static final Target BTN_TRANSACCIONES =
      Target.the("Menu transacciones").located(By.id("tab-t0-1"));
  public static final Target BTN_TRANSFERENCIAS =
      Target.the("Sub Menu opcion Transferencias")
          .located(By.xpath("//*[(contains(text(),'Transferencias'))]"));
  public static final Target BTN_PAGOS =
      Target.the("Menu inferior opcion Pagos")
          .located(By.xpath("//ion-icon[@ng-reflect-name='marca-pagos']/parent::div"));
  public static final Target BTN_IMPUESTOS =
          Target.the("Boton Impeustos").located(By.xpath("//*[contains(text(),'Impuestos')]"));
  public static final Target BTN_RECARGAS =
      Target.the("Menu inferior opcion Recargas")
          .located(By.xpath("//ion-icon[@ng-reflect-name='marca-recargas']/parent::div"));
  public static final Target BTN_CONFIGURACION =
      Target.the("Menu inferior opcion Configuracion").located(By.xpath("//*[@id='tab-t0-2']"));
  public static final Target BTN_SEGURIDAD =
      Target.the("Menu inferior opcion Mas").located(By.xpath("//*[@id='security']"));
  public static final Target BTN_MIS_PRODUCTOS =
      Target.the("Menu opcion mis productos").located(By.xpath("//*[(contains(text(),'Mis productos'))]"));
  public static final Target BTN_QR =
      Target.the("Boton flotante QR").located(By.xpath("//*[contains(@name,'qr')]"));
  public static final Target BTN_GENERAR_QR =
      Target.the("Boton generar QR").located(By.xpath("//*[(contains(text(),'Generar QR'))]"));

  private MenuPage() {}
}
