package com.banistmo.certificacion.userinterface.transferencias.terceros;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DatosTercerosPage {
  public static final Target TXT_NOMBRE =
      Target.the("Campo para ingresar " + "nombre")
          .located(By.xpath("//*[@id='txt_PayeeName' or @id='input_completeName']/input"));
  public static final Target TXT_CORREO =
      Target.the("Campo para ingresar " + "nombre")
          .located(By.xpath("//*[@id='txt_PayeeMail' or @id='input_email']/input"));
  public static final Target BTN_BANCO =
      Target.the("Opcion para elegir el banco")
          .located(By.xpath("//*[@id='select_destinationBank' or @id='txt_PayeeBank']"));
  public static final Target LST_BTN_BANCO_PRODUCTOS =
      Target.the("lista de bancos o de " + "cuentas ")
          .located(By.cssSelector("[class^='item item-block item-md item-radio']"));
  public static final Target BTN_CUENTA =
      Target.the("Lista tipos de cuentas ")
          .located(By.cssSelector("#txt_PayeeProductType>[id^='select-']"));
  public static final Target TXT_NUMERO_CUENTA =
      Target.the("Campo para ingresar numero de cuenta ")
          .located(By.xpath("//*[@id='txt_PayeeProductName' or @id='input_productNumber']/input"));
  public static final Target CHK_GUARDAR_FAVORITO =
      Target.the("CheckBox para guardar " + "cuenta como favorita")
          .located(By.id("chk_SaveAssFavorite"));
  public static final Target TXT_NOMBRE_FAVORITO =
      Target.the("CheckBox para guardar " + "cuenta como favorita")
          .located(By.cssSelector("#txt_AliasFavoriteName>input"));
  public static final Target BTN_AGREGAR =
      Target.the("Campo para ingresar numero de " + "cuenta ")
          .located(By.xpath("(//*[@id='continueBtn' or @id='btn_Add'])[last()]"));

  private DatosTercerosPage() {}
}
