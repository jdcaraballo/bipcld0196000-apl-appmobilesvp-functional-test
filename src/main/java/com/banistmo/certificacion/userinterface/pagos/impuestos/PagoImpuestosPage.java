package com.banistmo.certificacion.userinterface.pagos.impuestos;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PagoImpuestosPage {

  public static final Target LBL_CUENTA_RETIRO_IMPUESTOS =
      Target.the("Cuenta retiro de impuestos")
          .located(By.xpath("//*[@id='originAccName']"));

  public static final Target LISTA_CUENTAS_RETIRO_IMPUESTOS =
      Target.the(" Lista de Cuentas retiro de impuestos")
          .located(By.xpath("//*[@id='listAccItem ']/div/ion-card/ion-row"));

  public static final Target BTN_CONSULTAR_IMPUESTOS =
      Target.the("Boton consultar impuestos")
          .located(By.xpath("(//*[@id='continueBtn'])[2]"));

  public static final Target LBL_NRO_BOLETA =
      Target.the("Caja de texto impuestos")
          .located(By.id("ticketNumberPayment"));

  public static final Target TXT_NRO_BOLETA =
          Target.the("Caja de texto impuestos")
                  .located(By.xpath("//*[@id='ticketNumberPayment']/input"));
}

