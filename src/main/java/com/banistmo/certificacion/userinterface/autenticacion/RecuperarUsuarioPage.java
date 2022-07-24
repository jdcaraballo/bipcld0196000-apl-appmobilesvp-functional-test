package com.banistmo.certificacion.userinterface.autenticacion;

import net.serenitybdd.screenplay.targets.Target;
import org.apache.tools.ant.taskdefs.Tar;
import org.openqa.selenium.By;

public class RecuperarUsuarioPage {


  public static final Target LST_TIPO_ID =
      Target.the("Lista de tipo de identificacion")
          .located(By.id("btn_ListTypeID"));
  public static final Target TIPO_ID_CEDULA =
          Target.the("tipo de identificacion").located(By.id("rb-2-0"));
  public static final Target TIPO_ID =
      Target.the("tipo de identificacion").located(By.xpath("//*[contains(text(),'{0}')]"));
  public static final Target BTN_PROVINCIA =
      Target.the("Provincia").located(By.xpath("(//*[@id='btn_ListTypeID'])[2]"));

  //
  public static final Target TXT_2DO_DIGITO =
      Target.the("Input 2do Digito").located(By.xpath("(//*[@id='Input_2ndDigit']/input)[1]"));
  public static final Target TXT_3ER_DIGITO =
      Target.the("Input 3er Digito").located(By.xpath("(//*[@id='Input_2ndDigit']/input)[2]"));
  public static final Target LBL_TXT_PASAPORTE =
      Target.the("Input Pasaporte").located(By.xpath("//*[@id='Input_NumberID']/div"));
  public static final Target TXT_PASAPORTE =
      Target.the("Input Pasaporte").located(By.xpath("//*[@id='Input_NumberID']/input"));
  public static final Target BTN_CONTINUAR =
      Target.the("Boton continuar").located(By.xpath("//button[contains(@id, 'Continue')]"));
  public static final Target BTN_CONTINUAR_BACK_LOGIN =
      Target.the("Boton continuar").located(By.xpath("//*[@id='btnContinue']"));
  public static final Target BTN_CONTINUAR_CORREO =
      Target.the("Boton continuar").located(By.xpath("(//*[@id='btnContinue'])[2]"));
  public static final Target BTN_CONTINUAR_INSCRIPCION_TOKEN =
      Target.the("Boton continuar").located(By.xpath("(//*[@id='btnContinue'])[4]"));
  //  public static final Target TXT_CORREO =
  //      Target.the("Input correo recuperacion").located(By.id("input_MailUser"));
  public static final Target LBL_TXT_CORREO =
      Target.the("dar click en el boton correo recuperacion")
          .located(By.xpath("//*[@id='input_MailUser']/div"));
  public static final Target TXT_CORREO =
          Target.the("Input correo recuperacion")
                  .located(By.xpath("//*[@id='input_MailUser']/input"));
  public static final Target LBL_TXT_CODIGO_VERIFICACION =
          Target.the("lbl Input codigo de verificacion")
                  .located(By.id("input_verificationCode"));

  public static final Target TXT_CODIGO_VERIFICACION =
      Target.the("Input codigo de verificacion")
          .located(By.xpath("//*[@id='input_verificationCode']/input"));

  public static final Target VER_CODIGO_VERIFICACION =
      Target.the("Clic Ver codigo de verificacion")
          .located(By.xpath("//*[@id='btn_seePassword']"));

  public static final Target LBL_USUARIO_RECUPERADO =
      Target.the("Usuario recuperado").located(By.xpath("//*[@class='textUsername col']"));
  public static final Target CODIGO_TOKEN_EMAIL =
      Target.the("Codigo Token recuperado del correo")
          .located(
              By.xpath(
                  "//*[@id='m_-5733587933861142237content-body']/td/table/tbody/tr[3]/td/p/strong"));
  public static final Target LST_TIPO_PROVINCIA = Target.the("Tipo de Provincia").located(By.cssSelector("[class^='alert-radio-label']"));
  public static final Target BTN_SELECCIONAR = Target.the("Boton Seleccionar Provincia").located(By.xpath("//*[contains(text(),'Seleccionar')]/.."));


  private RecuperarUsuarioPage() {}
}
