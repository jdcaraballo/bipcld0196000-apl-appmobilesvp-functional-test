package com.banistmo.certificacion.userinterface.configuracion.administracion.favoritos.internacional;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CreacionFavoritosInternacionalPage {
  public static final Target BTN_PAIS =
      Target.the("Pais del Banco receptor").locatedBy("#selectCountry>button");
  public static final Target LST_BTN_PAIS_RECEPTOR =
      Target.the("Pais del Banco receptor")
          .locatedBy("//ion-item[@class='item item-block item-md item-radio']");
  public static final Target LST_BTN_PAIS_RECEPTOR_IOS =
      Target.the("Pais del Banco receptor iOS")
          .located(By.xpath("//XCUIElementTypeTextField[@name='Nombre del banco de destino']"));
  public static final Target TXT_BANCO_DESTINO =
      Target.the("Nombre del banco de destino")
          .locatedBy("(//*[@id='destinationBank_input'])[last()]");
  public static final Target TXT_BUSCAR_BANCO_DESTINO =
      Target.the("Buscar el nombre del banco receptor").locatedBy("#Input_cuent>input");
  public static final Target BTN_BANCO_DESTINO =
      Target.the("Seleccionar banco recptor").located(By.id("card-bank-0"));
  public static final Target TXT_NOMBRE_BENEFICIARIO =
      Target.the("Nombre del beneficiario").locatedBy("#nameBeneficiary>input");
  public static final Target TXT_PAIS_RESIDENCIA =
      Target.the("Pais de residencia del beneficiario").locatedBy("#countryResidence>input");
  public static final Target TXT_CIUDAD =
      Target.the("Ciudad de residencia del beneficiario").locatedBy("#cityResidence>input");
  public static final Target TXT_DIRECCION_BENEFICIARIO =
      Target.the("Direccion de residencia del " + "beneficiario")
          .locatedBy("#addressBeneficiary>input");
  public static final Target TXT_CORREO_ELECTRONICO =
      Target.the("Correo del beneficiario").locatedBy("#email>input");
  public static final Target TXT_NUMERO_CUENTA =
      Target.the("Numero de cuenta del beneficiario").locatedBy("#accountNumber>input");
  public static final Target TXT_NOMBRE_FAVORITO_INTERNACIONAL =
      Target.the("Nombre personalizado del favorito").locatedBy("#aliasFavoriteName>input");

  private CreacionFavoritosInternacionalPage() {}
}
