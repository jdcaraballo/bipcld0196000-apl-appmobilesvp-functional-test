package com.banistmo.certificacion.userinterface.servicios;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ServiciosPage {

  public static final Target BTN_CONSULTAR =
      Target.the("Boton Consultar").located(By.id("btn_consult_references_telered"));
  public static final Target TXT_NUMERO_CONSULTA =
      Target.the("Input numero consulta").located(By.xpath("//*[@id='1']//input"));
  public static final Target TXT_NUMERO_TELEFONO =
      Target.the("Input numero telefono").located(By.xpath("//*[@id='0']//input"));

  private ServiciosPage() {}
}
