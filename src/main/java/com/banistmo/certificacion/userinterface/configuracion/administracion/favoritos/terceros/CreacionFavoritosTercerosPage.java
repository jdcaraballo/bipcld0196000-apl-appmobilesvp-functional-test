package com.banistmo.certificacion.userinterface.configuracion.administracion.favoritos.terceros;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CreacionFavoritosTercerosPage {
  public static final Target TXT_NOMBRE =
      Target.the("Campo para escribir nombre de favorito").locatedBy("#input_completeName>input");
  public static final Target TXT_CORREO_ELECTRONICO =
      Target.the("campo para correo electronico de favorito").locatedBy("#input_email>input");
  public static final Target BTN_BANCO_DESTINO =
      Target.the("Banco de destino favorito").locatedBy("#select_destinationBank");
  public static final Target LST_BTN_BANCOS_PRODUCTOS =
      Target.the("Lista de bancos y productos")
          .locatedBy("[class^='item item-block item-md item-radio']");
  public static final Target BTN_TIPO_PRODUCTO =
      Target.the("Tipo de producto favorito").located(By.cssSelector("#select_productType"));
  public static final Target TXT_NUMERO_PRODUCTO =
      Target.the("campo de producto de cuenta tercero")
          .located(By.xpath("//*[@id='input_productNumber']/input"));
  public static final Target TXT_NOMBRE_FAVORITO_TERCEROS =
      Target.the("Campo nombre personalizado del favorito cuentas de terceros")
          .locatedBy(" #input_customName>input");

  private CreacionFavoritosTercerosPage() {}
}
