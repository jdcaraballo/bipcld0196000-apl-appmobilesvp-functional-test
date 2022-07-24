package com.banistmo.certificacion.userinterface.configuracion;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class FavoritosGeneralPage {
  public static final Target TXT_BUSCAR_FAVORITO_ACTIVO =
      Target.the("campo buscar una cuenta").locatedBy("(//*[@id='Input_search']/input)[last()-1]");
  public static final Target TXT_BUSCAR_FAVORITO_INACTIVO =
      Target.the("campo buscar una cuenta").locatedBy("(//*[@id='Input_search']/input)[last()-0]");
  public static final Target BTN_FAVORITO_ACTIVA =
      Target.the("lista de cuentas")
          .locatedBy("//card-favorites[@status='Active']//ion-row//h3[contains(.,'{0}')]");
  public static final Target BTN_FAVORITO_INACTIVA =
      Target.the("lista de cuentas")
          .locatedBy("//card-favorites[@status='Inactive']//ion-row//h3[contains(.,'{0}')]");
  public static final Target BTN_FAVORITO =
      Target.the("lista de cuentas").locatedBy("//card-favorites//ion-row//h3[contains(.,'{0}')]");
  public static final Target BTN_PRODUCTOS_ACTIVOS =
      Target.the("Pestana para ver los productos activos").located(By.id("tab1"));
  public static final Target BTN_PRODUCTOS_INACTIVOS =
      Target.the("Pestana para ver los productos inactivos").located(By.id("tab2"));
  public static final Target BTN_ELIMINAR_FAVORITO =
      Target.the("Boton en editar para eliminar favorito").located(By.id("btn_delete"));
  public static final Target BTN_CONFIRMAR_ELIMINAR_FAVORITO =
      Target.the("Popup de eliminar favorito").located(By.id("btn_modalRemoveButton"));
  public static final Target BTN_NUEVO_FAVORITO =
      Target.the(
              "Nuevo favorito para cuentas de"
                  + " terceros, servicios favoritos, recargas favoritos, internacionales favoritos")
          .located(By.id("card_newFavorite"));
  public static final Target MSG_FAVORITO_CREADO_CORRECTAMENTE =
      Target.the("Mensaje que se muestra al guardar un favorito exitosamente")
          .locatedBy(
              "//*[(@id='success_Msg')and(contains(text(),'Tu producto favorito se ha guardado correctamente.'))]");
  public static final Target BTN_ACTIVAR_INACTIVAR_FAVORITO =
      Target.the("Switch para activar o inactivar favorito")
          .located(By.id("chk_checkButtonDisable-label"));
  public static final Target BTN_GUARDAR_EDITAR_FAVORITO =
      Target.the("Guardar favoritos").located(By.xpath("//button[contains(.,'Guardar')]"));
  public static final Target TXT_NOMBRE_FAVORITO_RECARGAS_SERVICIOS =
      Target.the("nombre personalizado").locatedBy("#input_favoriteName>input");

  private FavoritosGeneralPage() {}
}
