package com.banistmo.certificacion.userinterface.comunes;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class TransaccionesGeneralPage {
  public static final Target BTN_MOSTRAR_CUENTAS_RETIRO =
      Target.the("Boton cuentas retiro").located(By.cssSelector("div#originAccCard"));
  public static final Target BTN_MOSTRAR_CUENTAS_DESTINO =
      Target.the("Boton cuentas destino ").locatedBy("#id_basic_card");
  public static final Target LST_BTN_CUENTA_RETIRO_DESTINO =
      Target.the("Lista de cuentas retiro o destino").located(By.cssSelector("[id^='currency-']"));
  public static final Target LBL_NUMERO_CUENTA_RETIROS =
      Target.the("numero de la cuenta a retirar")
          .locatedBy("(//*[@id='originNumberAccount' or @id='originAccCard'])[2]");
  public static final Target LBL_SALDO_INICIAL_CUENTA_RETIRO =
      Target.the("saldo de la cuenta a retirar")
          .located(
              By.xpath("//*[@id='destinationAmount' and contains(@class, 'amount-available')]"));
  public static final Target LBL_NUMERO_CUENTA_DESTINO =
      Target.the("numero de la cuenta destino")
          .located(By.xpath("//*[@id='destinationNumberAccount' or @id='numerDestination']"));
  public static final Target BTN_CONTINUAR =
      Target.the("Boton para continuar la transaccion")
          .locatedBy(
              "(//*[@id='continueBtn' or @id='id_buttonSubmit' or @id='newTxBtnContinue' or @id='continueBtnRecurrent' or @id='transferBtn'])[last()]");
  public static final Target BTN_AGREGAR_NUEVA_CUENTA =
      Target.the(
              "Nuevo favorito para cuentas de"
                  + " terceros, servicios favoritos, recargas favoritos, internacionales favoritos")
          .located(
              By.xpath(
                  "//*[@id='content_text' or @id='newCreditThird' or @id='newLoanThirdLabel']"));
  public static final Target LBL_NUMERO_CUENTA_RETIRO =
      Target.the(
              "Nuevo favorito para cuentas de"
                  + " terceros, servicios favoritos, recargas favoritos, internacionales favoritos")
          .located(By.id("originNumberAccount"));
  public static final Target BTN_CANCELAR =
      Target.the("Boton cancelar")
          .located(
              By.xpath(
                  "(//button[@id='cancelBtn' or @id='cancel' or @id='id_buttonCancel'])[last()]"));
  public static final Target BTN_CANCELAR_QR =
      Target.the("Boton cancelar").located(By.xpath("//*[(contains(text(),'CANCELAR'))]"));
  public static final Target BTN_CUENTA_TERCERO_ACH =
      Target.the("Boton cuenta guardada ACH")
          .locatedBy(
              "//ion-card//ion-icon[contains(@id,'banistmo-card') or contains(@id,'banistmo-ahorro') or contains(@id,'icon_account') or contains(@id,'banistmo-cash-payment')]/../..//div//label[contains(.,'Banco') or @id='avaible-'][not(contains(.,'Banistmo s.a') or contains(.,'BANISTMO S.A') or contains(.,'Fecha') or contains(.,'Plazo'))]");
  public static final Target BTN_PRODUCTO_PROPIO =
      Target.the("Boton productos propios")
          .located(
              By.xpath(
                  "(//ion-card//ion-row/ion-icon[not(contains(@id,'banistmo-card') or contains(@id,'banistmo-ahorro') or contains(@id,'banistmo-cash-payment') or contains(@id,'mas'))])[last()]"));
  public static final Target BTN_PRODUCTO_PROPIO_2 =
      Target.the("Boton productos propios")
          .located(
              By.xpath("(//*[@id='accName[object Object]'])"));
  public static final Target BTN_CUENTA_TERCERO_BANISTMO =
      Target.the("Boton cuenta guardada ACH")
          .locatedBy(
              "//ion-card//ion-icon[contains(@id,'banistmo-card') or contains(@id,'banistmo-ahorro') or contains(@id,'icon_account') or contains(@id,'banistmo-cash-payment')]/../..//div//label[contains(.,'Banco') or @id='avaible-'][contains(.,'Banistmo s.a') or contains(.,'BANISTMO S.A')]");
  public static final Target LBL_BANCO_DESTINO =
      Target.the("Label banco destino terceros")
          .located(By.xpath("(//*[@class='available label label-md'])[last()]"));
  public static final Target TXT_MONTO =
      Target.the("Input monto")
          .located(
              By.xpath(
                  "(//ion-input[@id='amountField' or @id='text-amount' or @id='Input_NumberID']/input)[last()]"));
  public static final Target TXT_DESCRIPCION =
      Target.the("Input descripcion")
          .located(
              By.xpath(
                  "(//*[contains(@id,'detailsField') or @id='detailField' or @ng-reflect-name='details'])[1]"));
  public static final Target BTN_ACEPTAR_TERMINOS =
      Target.the("Boton Aceptar términos y condiciones")
          .located(By.cssSelector("#btnAgree>button"));
  public static final Target BTN_TIPO_TRANSACCION =
      Target.the("Boton tipo de transaccion")
          .located(
              By.xpath(
                  "(//div[contains(.,'En línea')]/following-sibling::button[not(@ng-reflect-tooltip)])[last()]"));
  public static final Target LST_TIPO =
      Target.the("Lista de tipo de pago, frecuencia o dia")
          .located(By.cssSelector("[class^='item item-block item-md item-radio']"));
  public static final Target BTN_CALENDARIO_NATIVO_IOS =
      Target.the("Boton calendario nativo iOS")
          .located(
              By.xpath(
                  "//XCUIElementTypeTextField[@name='Fecha de pago' or @name='Fecha de la transferencia']"));
  public static final Target BTN_CALENDARIO =
      Target.the("Boton calendario")
          .located(
              By.xpath(
                  "(//*[contains(@id,'fatherContainer-dateTransfer') or contains(@class,'margin-date')]//ion-item)[last()]"));

  public static final Target BTN_CONTINUAR_CALENDARIO =
      Target.the("Boton continuar del calendario")
          .located(By.xpath("//span[@class='button-inner' and text()=' Continuar']"));
  public static final Target BTN_CONTINUAR_CALENDARIO_NATIVA_IOS =
      Target.the("Boton continuar del calendario nativa iOS")
          .located(By.xpath("(//XCUIElementTypeButton[@name='CONTINUAR'])[last()]"));
  public static final Target BTN_CALENDARIO_INICIAL =
      Target.the("Boton calendario fecha inicial")
          .located(
              By.xpath(
                  "(//*[contains(@id,'fatherContainer-dayInitial') or @id='startDateField']//input/../../..)[last()]"));
  public static final Target BTN_CALENDARIO_INICIAL_NATIVO_IOS =
      Target.the("Boton calendario inicial nativo iOS")
          .located(By.xpath("//XCUIElementTypeTextField[@name='Fecha inicial']"));
  public static final Target BTN_CALENDARIO_FINAL =
      Target.the("Boton calendario fecha final")
          .located(
              By.xpath(
                  "(//*[contains(@id,'fatherContainer-dayEnd') or @id='finalDateField']//input/../../..)[last()]"));
  public static final Target BTN_CALENDARIO_FINAL_NATIVO_IOS =
      Target.the("Boton calendario final nativo iOS")
          .located(By.xpath("//XCUIElementTypeTextField[@name='Fecha final']"));
  public static final Target BTN_TIPO_FRECUENCIA =
      Target.the("Boton tipo de frecuencia")
          .located(By.xpath("(//*[contains(text(),'Frecuencia')]/..//ion-select/button)[last()]"));
  public static final Target BTN_FECHA_CALENDARIO =
      Target.the("Boton fecha")
          .locatedBy("//span[text()=' {0} ' and not(contains(@class,'datepicker-selected'))]");
  public static final Target BTN_FECHA_CALENDARIO_NATIVO_IOS =
      Target.the("Boton fecha calendario nativa iOS")
          .locatedBy("//XCUIElementTypeStaticText[@name='{0}']");
  public static final Target LBL_ALERTA_TOKEN =
      Target.the("Alerta de valdiación de token")
          .locatedBy("//*[contains(text(), ' Estamos validando tu número de Token... ')]");
  public static final Target LBL_INGRESA_SOFTTOKEN =
      Target.the("Alerta de ingreso de token").locatedBy("//*[@id='msg_succes_favorite']");
  public static final Target TXT_SOFTTOKEN =
      Target.the("Caja para ingresar softtoken").locatedBy("//*[@id=\"inpPassword\"]/input");
  public static final Target BTN_CONTINUAR_SOFTTOKEN =
      Target.the("Boton continuar Softtoken")
          .locatedBy("//*[@id=\"bottonContinueInputId\"]/div[2]/div");
  public static final Target LBL_SOFTTOKEN_INCORRECTO =
      Target.the("Label Softtoken Incorrecto")
          .locatedBy("//*[contains(text(), ' Token incorrecto. Ingresa el código nuevamente ')]");
  public static final Target LBL_SOFTTOKEN =
      Target.the("Label Ingrese Softtoken")
          .locatedBy("//*[contains(text(), ' Ingresa tu número de Soft Token. ')]");
  public static final Target BTN_VOLVER_SOFTTOKEN =
      Target.the("Boton Volver atras Softtoken")
          .locatedBy("//*[@id=\"bottonCancelInputId\"]/div[2]/div/span");
  public static final Target BTN_VOLVER_ANTERIOR =
      Target.the("Boton Volver Softtoken").locatedBy("//*[contains(text(), 'CANCELAR')]");
  public static final Target BTN_ENTENDIDO_ANTERIOR =
      Target.the("Boton Volver Entendido").locatedBy("//*[contains(text(), 'ENTENDIDO')]");
  public static final Target BTN_ENTENDIDO_ANTERIOR_2 =
          Target.the("Boton Volver Entendido").locatedBy("//*[contains(text(), 'Entendido')]");
  public static final Target BTN_CONFIGURACION =
      Target.the("Boton Configuracion").locatedBy("//*[contains(text(), 'Configuración')]");

  private TransaccionesGeneralPage() {}
}
