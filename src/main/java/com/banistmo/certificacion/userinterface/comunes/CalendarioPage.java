package com.banistmo.certificacion.userinterface.comunes;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CalendarioPage {

  public static final Target FLECHA_DERECHA_CALENDARIO =
      Target.the("Siguiente mes calendario").located(By.name("arrow-forward"));
  public static final Target FLECHA_DERECHA_CALENDARIO_NATIVA_IOS =
      Target.the("Siguiente mes calendario")
          .located(By.xpath("//XCUIElementTypeButton[@name='arrow forward']"));
  public static final Target MES_CALENDARIO =
      Target.the("Mes calendario").located(By.xpath("//*[@class='col datepicker-month']"));
  public static final Target MES_CALENDARIO_NATIVO_IOS =
      Target.the("Mes calendario").locatedBy("//XCUIElementTypeStaticText[@name='{0}']");

  public static final Target ANIO_CALENDARIO =
      Target.the("Año calendario").located(By.xpath("//*[@class='col datepicker-year ']"));
  public static final Target ANIO_CALENDARIO_NATIVO_IOS =
      Target.the("Año calendario nativa iOS").locatedBy("//XCUIElementTypeStaticText[@name='{0}']");

  private CalendarioPage() {}
}
