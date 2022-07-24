package com.banistmo.certificacion.userinterface.transferencias.propias;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CuentasPropiasPage {
  public static final Target TXT_MONTO =
      Target.the("Input Monto a transferir cuentas propias")
          .located(By.cssSelector("#Input_NumberID > input"));
  public static final Target TXT_DETALLES =
      Target.the("Input Detalle transferencia cuentas propias")
          .located(By.cssSelector("#detailsField>input"));

  private CuentasPropiasPage() {}
}
