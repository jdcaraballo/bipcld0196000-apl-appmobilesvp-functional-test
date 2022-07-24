package com.banistmo.certificacion.userinterface.comunes;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class VerificarTransaccionPage {
  public static final Target BTN_TERMINAR_TRANSACCION =
      Target.the("Boton para transferir o pagar").locatedBy("//button[@id='transferBtn']");
  public static final Target BTN_MODIFICAR_TRANSACCION =
      Target.the("Boton modificar datos de la transferencia")
          .located(By.cssSelector("#modifyBtn > button"));
  public static final Target BTN_CONFIRMAR_CANCELAR_TRANSFERENCIA =
      Target.the("Boton confirmar cancelacion transferencia")
          .located(By.xpath("//*[@id='btn_modalContinueButton']"));

  private VerificarTransaccionPage() {}
}
