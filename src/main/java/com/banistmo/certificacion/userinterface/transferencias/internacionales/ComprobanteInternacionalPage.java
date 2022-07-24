package com.banistmo.certificacion.userinterface.transferencias.internacionales;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ComprobanteInternacionalPage {
  public static final Target LBL_CUENTA_RETIRO =
      Target.the("Label cuenta retiro").located(By.xpath("(//*[@id='retirementAccount'])[last()]"));
  public static final Target LBL_PAIS_DESTINO =
      Target.the("Label pais destino").located(By.id("destinationAccountCountry"));
  public static final Target LBL_BANCO_DESTINO =
      Target.the("Label banco destino").located(By.id("bankInfoDetail"));
  public static final Target LBL_CODIGO_RUTA =
      Target.the("Label codigo ruta").located(By.id("bankInfoDetailCode"));
  public static final Target LBL_NOMBRE_BENEFICIARIO =
      Target.the("Label nombre beneficiario").located(By.id("beneficiaryInfoNameCustomer"));
  public static final Target LBL_PAIS_BENEFICIARIO =
      Target.the("Label pais beneficiario").located(By.id("beneficiaryInfoCountry"));
  public static final Target LBL_CIUDAD_BENEFICIARIO =
      Target.the("Label ciudad beneficiario").located(By.id("beneficiaryInfoCity"));
  public static final Target LBL_DIRECCION_BENEFICIARIO =
      Target.the("Label direccion beneficiario").located(By.id("beneficiaryInfoAddress"));
  public static final Target LBL_CORREO_BENEFICIARIO =
      Target.the("Label correo beneficiario").located(By.id("beneficiaryInfoEmail"));
  public static final Target LBL_DESCRIPCION = Target.the("Label detail").located(By.id("detail"));
  public static final Target LBL_NUMERO_CUENTA =
      Target.the("Label numero cuenta").located(By.id("destinationAccountProductNumber"));
  public static final Target LBL_MONTO = Target.the("Label monto").located(By.id("amount"));

  private ComprobanteInternacionalPage() {}
}
