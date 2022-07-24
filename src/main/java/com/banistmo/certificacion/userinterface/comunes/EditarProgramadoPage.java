package com.banistmo.certificacion.userinterface.comunes;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class EditarProgramadoPage {

  public static final Target BTN_CALENDARIO_EDITAR_FECHA_FUTURA =
      Target.the("Boton calendario de editar fecha futura")
          .located(
              By.xpath(
                  "//*[@id='fatherContainer-dateTransfer' or @ng-reflect-id='calendarField']//div"));
  public static final Target TXT_CALENDARIO_EDITAR_FECHA_FUTURA =
      Target.the("Input calendario fecha futura editar")
          .located(
              By.xpath(
                  "(//*[@id='fatherContainer-dateTransfer' or @ng-reflect-id='calendarField']//ion-input/input)[1]"));
  public static final Target TXT_DESCRIPCION_EDITAR =
      Target.the("Input campo descripción editar fecha futura")
          .located(By.xpath("(//*[@ng-reflect-name='details' or @id='detailsField'])[1]/input"));
  public static final Target BTN_FRECUENCIA_EDITAR =
      Target.the("Boton frecuencia editar pagos")
          .located(By.xpath("//*[@ng-reflect-name='frecuency' or @id='frequencyField']//button"));
  public static final Target TXT_FRECUENCIA_EDITAR =
      Target.the("input de frecuencia en editar")
          .located(
              By.xpath(
                  "//*[@ng-reflect-name='frecuency' or @id='frequencyField']/div[@class='select-text']"));
  public static final Target BTN_DIA_FRECUENCIA_SEMANAL_EDITAR =
      Target.the("Boton Dia de frecuencia semanal editar")
          .located(By.xpath("//*[@ng-reflect-name='dayOfWeek' or @id='dayField']//button"));
  public static final Target BTN_DIA_FRECUENCIA_QUINCENAL_EDITAR =
      Target.the("Boton de frecuencia quincenal editar")
          .located(By.xpath("//*[@ng-reflect-name='dayOfBiweekly' or @id='dayField']//button"));
  public static final Target BTN_DIA_FRECUENCIA_MENSUAL_EDITAR =
      Target.the("Boton Dia de frecuencia mensual editar")
          .located(By.xpath("//*[@ng-reflect-name='dayOfMonth' or @id='dayField']//button"));
  public static final Target BTN_CALENDARIO_FECHA_FINAL_EDITAR =
      Target.the("Boton de calendario fecha final editar")
          .located(
              By.xpath("//*[@id='fatherContainer-dayEnd' or @ng-reflect-id='calendarField']//div"));
  public static final Target TXT_CALENDARIO_FECHA_FINAL_EDITAR =
      Target.the("Input calendario fecha final editar")
          .located(
              By.xpath(
                  "(//*[@id='fatherContainer-dayEnd' or @ng-reflect-id='calendarField']//ion-item//input)[1]"));
  public static final Target TXT_DIA_SEMANAL_EDITAR =
      Target.the("input dia frecuencia mensual")
          .located(
              By.xpath(
                  "(//*[@ng-reflect-name='dayOfWeek' or @ng-reflect-name='dayOfBiweekly' or @ng-reflect-name='dayOfMonth' or @id='dayField']//div[@class='select-text'])[1]"));

  private EditarProgramadoPage() {}
}
