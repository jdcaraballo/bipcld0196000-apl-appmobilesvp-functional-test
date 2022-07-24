package com.banistmo.certificacion.userinterface.detalles;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class TransaccionesDetallesPage {
  public static final Target BTN_DETALLES =
      Target.the("Mostrar Detalle de producto ").located(By.xpath("//*[@id='tab2']"));
  public static final Target BTN_TRANSFERIR =
      Target.the("Boton para transferir desde el detalle de un producto")
          .located(By.xpath("(//*[@id='btnDetTransfer'])[2]"));
  public static final Target BTN_TRANSFERIR_NATIVO_IOS =
      Target.the("Boton para transferir desde el detalle de un producto")
          .located(By.xpath("//XCUIElementTypeButton[@name='TRANSFERIR flecha_derecha']"));
  public static final Target BTN_CONFIGURACION =
      Target.the("icono configuraciones primera cuenta")
          .located(By.xpath("(//*[@id='config_own_account'])[2]"));
  public static final Target BTN_CONFIGURACION_SEGUNDA_CUENTA =
      Target.the("icono configuraciones segunda cuenta")
          .located(By.xpath("(//*[@id='config_own_account'])[3]"));
  public static final Target BTN_PAGAR =
      Target.the("Boton para pagar desde el detalle de un producto").located(By.id("btn_pay"));

  private TransaccionesDetallesPage() {}
}
