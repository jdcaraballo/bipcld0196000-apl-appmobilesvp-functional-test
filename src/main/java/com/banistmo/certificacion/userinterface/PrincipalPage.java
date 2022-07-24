package com.banistmo.certificacion.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PrincipalPage {
  public static final Target BTN_CERRAR_SESION =
      Target.the("Boton de salida").located(By.cssSelector("#pcBtnLogout"));
  public static final Target BTN_ACEPTAR_CIERRE_SESION =
      Target.the("Aceptar cierre de sesión").located(By.xpath("//*[text()='ACEPTAR']"));
  public static final Target BTN_VISTA_CARD =
      Target.the("Boton de vista card estando en card").located(By.xpath("//*[@id='idCardsview1']"));
  public static final Target BTN_VISTA_CARD_2 =
          Target.the("Boton de vista card estando en vista lista").located(By.xpath("//*[@id='idCardsview2']"));
  public static final Target BTN_CUENTAS_DEPOSITOS_CARD =
      Target.the("Cuentas de deposito mostradas como card en pantalla principal")
          .located(By.cssSelector("#pcCardProducts"));
  public static final Target BTN_CUENTAS_VISTA_CARD_FILTRO =
      Target.the("Boton productos vista card")
          .locatedBy(("//*[@id='pcCardProducts']//h4[contains(.,'{0}')]"));
  public static final Target LST_BTN_TRANSFERIR_PAGAR_CARD =
      Target.the("Boton para transferir desde el card de los productos")
          .located(By.xpath("//*[contains(@id,'pcCardButtonSegundary')][not(@disabled)]"));
  public static final Target BTN_VISTA_LISTA =
      Target.the("Boton de vista lista desde lista").located(By.xpath("//*[@id='idListView1']"));
  public static final Target BTN_VISTA_LISTA_2 =
      Target.the("Boton de vista lista desde Card").located(By.xpath("//*[@id='idListView2']"));
  public static final Target LST_BTN_CUENTA_DEPOSITO_VISTA_LISTA =
      Target.the("saldo de la cuenta a seleccionar ")
          .located(By.xpath("//*[@class='title-account'][contains(.,'Cuenta')]"));
  public static final Target LST_CARD_PRODUCTOS =
      Target.the("Lista de productos").located(By.xpath("//*[@id='pcContainerCardsV2']"));
  public static final Target ICONO_ESTRELLA =
      Target.the("Icono de cuenta preferida (La estrellita)")
          .locatedBy("//ion-icon[@name='banistmo-premium' or @name='marca-favorita']");
  public static final Target LST_BNT_PRODUCTO_VISTA_CARD =
      Target.the("Boton en cuenta deposito vista card")
          .located(
              By.xpath(
                  "//*[contains(@id,'pcCardButtonSegundary')][not(@disabled)]/../../../../div[contains(@id,'pcCard_')]/div/div[@class='text-header']"));
  public static final Target BNT_CUENTA_DEPOSITO_VISTA_CARD_SECUNDA =
      Target.the("Boton en cuenta deposito vista card")
          .located(
              By.xpath(
                  "(//*[contains(@id,'pcCardButtonSegundary')][not(@disabled)]/../../../../div[contains(@id,'pcCard_')])[2]"));
  public static final Target LBL_MENSAJE_EXTRAFINANCIAMIENTO =
      Target.the("Alerta de extrafinanciamiento aprobado").located(By.id("mess_extraf"));
  public static final Target BTN_VER_DESPUES_EXTRAFINANCIAMIENTO =
      Target.the("Boton ver despues extrafinanciamiento")
          .located(By.cssSelector("#btn_watch>button"));
  public static final Target BTN_MAS_INFO_EXTRAFINANCIAMIENTO =
      Target.the("Boton mas informacion de extrafinanciamiento")
          .located(By.cssSelector("#btn_moreinf>button"));
  public static final Target LBL_SALDO_ACTUAL =
      Target.the("Saldo de la cuenta")
          .locatedBy("//*[@class='id-account'  and contains(text(), '{0}')]/following-sibling::h6");
  public static final Target LBL_SALDO_DISPONIBLE =
      Target.the("Valor disponible en cuenta")
          .locatedBy(
              "(//*[@id='lb_accountNumber' and contains(text(), '{0}')])[last()]/ancestor::ion-card[@class='card-account card card-md']//ion-label[@id='availableAmountDet']");

  private PrincipalPage() {}
}
