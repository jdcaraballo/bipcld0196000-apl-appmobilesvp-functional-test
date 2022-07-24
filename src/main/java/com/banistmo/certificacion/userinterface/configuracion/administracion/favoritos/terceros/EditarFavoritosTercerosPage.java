package com.banistmo.certificacion.userinterface.configuracion.administracion.favoritos.terceros;

import net.serenitybdd.screenplay.targets.Target;

public class EditarFavoritosTercerosPage {
  public static final Target TXT_NOMBRE =
      Target.the("Campo para escribir nombre de favorito").locatedBy("#input_completeName>input");
  public static final Target TXT_CORREO_ELECTRONICO =
      Target.the("campo para correo electronico de favorito").locatedBy("#input_email>input");

  private EditarFavoritosTercerosPage() {}
}
