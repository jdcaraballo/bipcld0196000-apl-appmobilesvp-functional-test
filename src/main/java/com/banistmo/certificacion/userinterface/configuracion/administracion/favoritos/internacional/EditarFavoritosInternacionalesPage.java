package com.banistmo.certificacion.userinterface.configuracion.administracion.favoritos.internacional;

import net.serenitybdd.screenplay.targets.Target;

public class EditarFavoritosInternacionalesPage {
  public static final Target TXT_NOMBRE_BENEFICIARIO =
      Target.the("Nombre del beneficiario").locatedBy("#nameBeneficiary>input");
  public static final Target TXT_CIUDAD =
      Target.the("Ciudad de residencia del beneficiario").locatedBy("#cityResidence>input");

  private EditarFavoritosInternacionalesPage() {}
}
