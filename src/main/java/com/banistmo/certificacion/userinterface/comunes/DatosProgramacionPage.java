package com.banistmo.certificacion.userinterface.comunes;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DatosProgramacionPage {

  public static final Target LBL_MENSAJE_EXITOSO =
      Target.the("Etiqueta de mensjae exitoso").located(By.id("success_Msg"));
  public static final Target TXT_FECHA_FUTURA_PAGO =
      Target.the("Fecha futura de pago prestamos")
          .located(
              By.xpath(
                  "(//*[contains(@id,'fatherContainer-dateTransfer') or contains(@class,'margin-date')]//ion-input[1]/input)[last()]"));
  public static final Target LBL_FECHA_INICIO_RECURRENTE =
      Target.the("Fecha de inicio recurrente")
          .located(
              By.xpath("((//ion-label[.='Fecha inicial'])[last()]/following::ion-input/input)[1]"));
  public static final Target LBL_FECHA_FIN_RECURRENTE =
      Target.the("Fecha de fin recurrente")
          .located(
              By.xpath("((//ion-label[.='Fecha final'])[last()]/following::ion-input/input)[1]"));

  private DatosProgramacionPage() {}
}
