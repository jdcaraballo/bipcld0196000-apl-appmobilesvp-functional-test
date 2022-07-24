package com.banistmo.certificacion.userinterface.configuracion.seguridad;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SeguridadPage {
  public static final Target BTN_CAMBIAR_CONTRASENA =
      Target.the("Boton cambiar contrasena")
          .located(By.xpath("//*[text()='Cambiar contraseña']/ancestor::button"));

  private SeguridadPage() {}
}
