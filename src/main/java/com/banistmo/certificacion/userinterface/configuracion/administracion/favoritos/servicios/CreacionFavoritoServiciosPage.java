package com.banistmo.certificacion.userinterface.configuracion.administracion.favoritos.servicios;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CreacionFavoritoServiciosPage {
  public static final Target BTN_TIPO_PRODUCTO =
      Target.the("Campo tipo de producto").locatedBy("#select_serviceType>button");
  public static final Target BTN_PAGO_SERVICIOS =
      Target.the("Seleccionar tipo de producto").locatedBy("//button[@role='radio']");
  public static final Target TXT_NOMBRE_SERVICIO =
      Target.the("Campo para ir a servicios")
          .located(By.cssSelector("[id='search_serviceName_input']"));
  public static final Target TXT_NOMBRE_SERVICIO_NATIVO_IOS =
      Target.the("Campo para ir a servicios nativo iOS")
          .located(By.xpath("//XCUIElementTypeTextField[@name='Nombre de servicio']"));
  public static final Target TXT_BUSCAR_SERVICIO =
      Target.the("Campo para buscar servicios")
          .locatedBy("(//*[@id='Input_search']/input)[last()-0]");
  public static final Target BTN_SELECCIONAR_SERVICIO =
      Target.the("Selecciona servicio de la lista").locatedBy("[id^='card_ServicesSERVICE_']");
  public static final Target TXT_NOMBRE_CLIENTE =
      Target.the("Campo para ingresar nombre del cliente").locatedBy("#input_refence1>input");
  public static final Target TXT_NUMERO_CLIENTE =
      Target.the("Campo para ingresar numero del cliente").locatedBy("#input_refence2>input");

  private CreacionFavoritoServiciosPage() {}
}
