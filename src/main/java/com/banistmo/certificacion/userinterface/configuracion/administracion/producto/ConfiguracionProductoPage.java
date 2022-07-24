package com.banistmo.certificacion.userinterface.configuracion.administracion.producto;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ConfiguracionProductoPage {
  public static final Target BTN_CUENTA_PREFERIDA =
      Target.the("Boton seleccionar como cuenta" + " preferida")
          .located(By.id("chk_checkButtonPA-label"));
  public static final Target LST_BTN_CUENTAS =
      Target.the("Primera Cuenta").locatedBy("//ion-card[@class='card card-md']");
  public static final Target LST_LBL_NOMBRE_CUENTAS =
      Target.the("Label nombre cuentas").locatedBy("//ion-card[@class='card card-md']//div/h2");
  public static final Target BTN_NOMBRE_CUENTAS =
      Target.the("Boton nombre cuentas")
          .locatedBy("//ion-card[@class='card card-md']//div/h2[contains(.,'{0}')]/../..");
  public static final Target BTN_NUMERO_CUENTA =
      Target.the("Boton numero cuentas")
          .locatedBy("//ion-card[@class='card card-md']//div/label[contains(.,'{0}')]/../..");
  public static final Target BTN_CUENTA_SEGUNDA =
      Target.the("Segunda Cuenta").locatedBy("(//ion-card[@class='card card-md'])[2]");
  public static final Target BTN_CONFIRMAR_CAMBIO =
      Target.the("Confirmar cambios").located(By.id("btn_modalSaveButton"));
  public static final Target LBL_NUMERO_CUENTA_PREFERIDA =
      Target.the("Confirmar cambios")
          .located(By.xpath("//*[@name='marca-favorita']/../..//label[@id='typepeAccount']"));
  public static final Target BTN_GUARDAR =
      Target.the("Guardar configuracion de producto")
          .located(By.xpath("(//*[@id='btnContinue'])[last()]"));
  public static final Target LBL_NUMERO_CUENTA =
      Target.the("Número de la cuenta para la validación").located(By.id("accountProductNumber"));
  public static final Target BTN_EDITAR_NOMBRE_CUENTA =
      Target.the("Nombre de la cuenta ").located(By.xpath("//*[@name='banistmo-edit']"));
  public static final Target TXT_NOMBRE_CUENTA =
      Target.the("Editar alias de la cuenta")
          .located(By.cssSelector("#inpEditAccountName > input"));
  public static final Target CHK_DEFINIR_OBJETIVO_ACTIVADA =
      Target.the("Check box objetivo de ahorro activiado")
          .located(By.xpath("//input[@id='objetive_input'][@ng-reflect-model='true']"));
  public static final Target CHK_DEFINIR_OBJETIVO =
      Target.the("Check box definir obketivo de ahorro").located(By.id("objetive_input-label"));
  public static final Target BTN_CANCELAR =
      Target.the("Cancelar configuracion de producto")
          .located(By.xpath("(//*[@id='btnCancel'])[last()]"));
  public static final Target LBL_VALOR_DISPONIBLE_CUENTA =
      Target.the("Label valor Disponible Cuenta").located(By.id("availableBalance"));
  public static final Target TXT_MONTO_AHORRO =
      Target.the("Input monto ahorro").located(By.cssSelector("#Input_NumberID > input"));
  public static final Target LBL_VALOR_OBJETIVO_AHORRO =
      Target.the("Label valor ahorro Cuenta").located(By.id("objetiveAvailable"));
  public static final Target PRG_OBJETIVO_AHORRO =
      Target.the("Barra de progreso objetivo de ahorro").located(By.className("progress-bar"));

  private ConfiguracionProductoPage() {}
}
