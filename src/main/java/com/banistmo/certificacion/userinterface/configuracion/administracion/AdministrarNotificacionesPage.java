package com.banistmo.certificacion.userinterface.configuracion.administracion;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class AdministrarNotificacionesPage {

  public static final Target OPC_MENU =
      Target.the("Opcion de menu Administrar Notificaciones - {0}")
          .locatedBy("//*[@id='menu_thirdAccounts']//label[text()='{0}']");
  public static final Target CHK_NOTIFICACION =
      Target.the("Check de notificacion {0}")
          .locatedBy(
              "(//*[@class='col-3 col-md-3 text-label-option' "
                  + "and contains(.,'{0}')]/following-sibling::div)[1]");
  public static final Target STS_CHK_NOTIFICACION =
      Target.the("Estado de check de notificaciones {0}")
          .locatedBy(
              "(//*[@class='col-3 col-md-3 text-label-option' "
                  + "and contains(.,'{0}')]/following-sibling::div)[1]/app-toggle");
  public static final Target BTN_MEDIO =
      Target.the("Boton medio de notificacion {0}")
          .locatedBy(
              "(//*[@class='col-3 col-md-3 text-label-option' "
                  + "and contains(.,'{0}')]/following-sibling::div)[2]");
  public static final Target LST_CHK_MEDIOS_ACTIVOS =
      Target.the("Boton medio de notificacion {0}")
          .locatedBy("(//div[contains(.,'{0}')]/following-sibling::div)[2]//app-multiselect");
  public static final Target CHK_MEDIO =
      Target.the("Checks de medios {0}")
          .locatedBy("//app-multiselect//input[@name='options' and @value='{0}']");
  public static final Target TXT_MONTO_MINIMO_NOTIFICAR =
      Target.the("Input monto mínimo de notificación {0}")
          .locatedBy("(//*[contains(.,'{0}')]/following-sibling::div)[3]//input");
  public static final Target BTN_CONTINUAR =
      Target.the("Boton continuar configuración").located(By.cssSelector("#btn_save>button"));

  private AdministrarNotificacionesPage() {}
}
