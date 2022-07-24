package com.banistmo.certificacion.userinterface.transferencias.internacionales;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DatosInternacionalesPage {

  public static final Target BTN_PAIS_DESTINO =
      Target.the("Boton pais destino").located(By.cssSelector("#id_selectCountry"));
  public static final Target LST_BTN_BANCOS_PAIS =
      Target.the("lista de bancos y paises ").located(By.cssSelector("ion-list > ion-item"));
  public static final Target BTN_NOMBRE_BANCO_DESTINO =
      Target.the("Boton Banco destino").located(By.id("id_destinationBank_input"));
  public static final Target TXT_BUSCAR_BANCO_DESTINO =
      Target.the("Input buscar Banco destino")
          .located(By.xpath("(//*[@id='Input_cuent']/input)[last()]"));
  public static final Target BTN_CARD_BANCO =
      Target.the("Boton card Banco").located(By.xpath("//*[@id='card-bank-0']"));
  public static final Target TXT_NOMBRE =
      Target.the("Input Nombre del beneficiario")
          .located(By.cssSelector("#id_nameBeneficiary > input"));
  public static final Target TXT_DIRECCION =
      Target.the("Input Direccion del beneficiario")
          .located(By.cssSelector("#id_addressBeneficiary > input"));
  public static final Target TXT_CIUDAD =
      Target.the("input Ciudad de residencia del beneficiario")
          .located(By.cssSelector("#id_cityResidence > input"));
  public static final Target TXT_PAIS =
      Target.the("Input Pais de residencia del beneficiario")
          .located(By.cssSelector("#id_countryResidence > input"));
  public static final Target TXT_TELEFONO =
      Target.the("Input Telefono del beneficiario").located(By.cssSelector("#id_phone > input"));
  public static final Target TXT_CORREO =
      Target.the("Input Email del beneficiario").located(By.cssSelector("#id_email > input"));
  public static final Target TXT_CUENTA =
      Target.the("Input Cuenta del beneficiario")
          .located(By.cssSelector("#id_accountNumber > input"));
  public static final Target BTN_CONTINUAR_TRANSFERENCIA =
      Target.the("Boton para continuar con la transferencia internacional")
          .located(By.cssSelector("#id_submitButton"));

  private DatosInternacionalesPage() {}
}
