package com.banistmo.certificacion.userinterface.menu;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class MenuRecargasPage {
  public static final Target BTN_TIEMPO_AIRE =
      Target.the("Boton recarga tiempo aire").located(By.id("time_recharges"));
  public static final Target BTN_METROBUS =
      Target.the("Boton recarga metrobus").located(By.id("reloas_metro_bus"));
  public static final Target BTN_OPERADOR =
      Target.the("Boton recarga Operador Mobil").located(By.xpath("//*[contains(text(),'{0}')]"));
  public static final Target BTN_CLARO =
          Target.the("Boton recarga Claro").located(By.xpath("//*[contains(text(),'Claro')]"));
  public static final Target BTN_DIGICEL =
          Target.the("Boton recarga Digicel").located(By.xpath("//*[contains(text(),'Digicel')]"));
  public static final Target BTN_MAS_MOVIL =
          Target.the("Boton recarga Mas Movil").located(By.xpath("//*[contains(text(),'Más Móvil')]"));
  public static final Target BTN_METRO_METROBUS =
          Target.the("Boton recarga MetroBus").located(By.xpath("//*[contains(text(),'Metro y Metrobus')]"));
  public static final Target BTN_NEQUI =
          Target.the("Boton recarga Nequi").located(By.xpath("//*[contains(text(),'Nequi')]"));
  public static final Target BTN_PANAPASS =
          Target.the("Boton recarga panapass").located(By.xpath("//*[contains(text(),'Panapass')]"));
  public static final Target BTN_TIGO =
          Target.the("Boton recarga Tigo").located(By.xpath("//*[contains(text(),'Tigo')]"));

  private MenuRecargasPage() {}
}
