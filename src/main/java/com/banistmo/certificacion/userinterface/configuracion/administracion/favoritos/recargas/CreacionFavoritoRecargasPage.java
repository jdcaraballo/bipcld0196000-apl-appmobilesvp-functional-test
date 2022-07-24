package com.banistmo.certificacion.userinterface.configuracion.administracion.favoritos.recargas;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CreacionFavoritoRecargasPage {
  public static final Target BTN_TIPO_RECARGA =
      Target.the("Buscar tipo de recarga").located(By.id("select_rechargeType"));
  public static final Target LST_BTN_TIPOS_RECARGAS_PROVEEDOR =
      Target.the("seleccionar de lista")
          .locatedBy("//ion-item[@class='item item-block item-md item-radio']");
  public static final Target TXT_NUMERO_PRODUCTO =
      Target.the("numero de producto").locatedBy("#input_productNumber>input");
  public static final Target BTN_PROVEEDOR =
      Target.the("Buscar proveedor de destino").located(By.id("select_destinationProvider"));

  private CreacionFavoritoRecargasPage() {}
}
