package com.banistmo.certificacion.userinterface.configuracion.seguridad;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CambioContrasenaPage {
  public static final Target TXT_CONTRASENA_ACTUAL =
      Target.the("Input contraseña actual").located(By.cssSelector("#inpPassword > input"));
  public static final Target TXT_CONTRASENA_NUEVA =
      Target.the("Input contraseña nueva").located(By.cssSelector("#input_NewPassword > input"));
  public static final Target TXT_CONFIRMAR_CONTRASENA =
      Target.the("Input confirmar contraseña")
          .located(By.cssSelector("#input_NewPasswordConfirm > input"));
  public static final Target BTN_CAMBIAR_CONTRASENA =
      Target.the("Boton cambiar contraseña")
          .located(By.xpath("(//*[@id='btnisValidConfirmPass'])[last()]"));
  public static final Target LBL_BARRA_SEGURIDAD =
      Target.the("Barra seguridad").located(By.id("brogressBarOut"));

  private CambioContrasenaPage() {}
}
