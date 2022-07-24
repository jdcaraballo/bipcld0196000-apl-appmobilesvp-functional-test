package com.banistmo.certificacion.userinterface.comunes;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ProgramadasPage {

  public static final Target BTN_ELIMINAR =
      Target.the("Boton para eliminar Programadas")
          .locatedBy(
              "(//h1[contains(text(),'{0}')]/parent::div)[1]/following-sibling::div//i[@class='fal fa-trash-alt']");
  public static final Target BTN_CONFIRMAR_ELIMINAR_PROGRAMADA =
      Target.the("Boton para eliminar Programadas").located(By.id("btn_modalRemoveButton"));
  public static final Target BTN_EDITAR =
      Target.the("Boton para eliminar Programadas")
          .locatedBy(
              "(//h1[contains(text(),'{0}')]/parent::div)[1]/following-sibling::div//i[@class='icon-banistmo icon-edit']");
  public static final Target BTN_DIA_FRECUENCIA_QUINCENAL =
      Target.the("Boton de dia frecuencia Quincenal")
          .located(
              By.xpath(
                  "(//*[contains(@ng-reflect-name,'dayOfBiweekly') or @id='btn_Frecuencia']//button)[last()]"));
  public static final Target BTN_DIA_FRECUENCIA_MENSUAL =
      Target.the("Boton de frecuencia Mensual")
          .located(
              By.xpath(
                  "(//*[contains(@ng-reflect-name,'dayOfMonth') or @id='btn_Frecuencia']//button)[last()]"));
  public static final Target BTN_IR_A_CONSOLIDADOS =
      Target.the("Boton ir a consolidados").located(By.cssSelector("#consolidateBtn>button"));

  public static final Target BTN_DIA_FRECUENCIA_SEMANAL =
      Target.the("Boton dia de frecuencia")
          .located(
              By.xpath(
                  "(//*[contains(@ng-reflect-name,'dayOfWeek') or @id='btn_Frecuencia']//button)[last()]"));

  public static final Target BTN_PROGRAMADAS =
      Target.the("Boton programadas pagos - transferencias")
          .located(By.xpath(".//*[@id='paymentSchedule' or @id='scheduleTx']"));

  private ProgramadasPage() {}
}
