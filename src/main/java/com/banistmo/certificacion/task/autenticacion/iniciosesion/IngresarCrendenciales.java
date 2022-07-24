package com.banistmo.certificacion.task.autenticacion.iniciosesion;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.banistmo.certificacion.task.configuracion.seguridad.CredencialesToken;
import net.serenitybdd.screenplay.Performable;

public class IngresarCrendenciales {

  private IngresarCrendenciales() {}

  public static HastaClave hastaClave(String usuario, String clave) {
    return instrumented(HastaClave.class, usuario, clave);
  }

  public static CalcelarInicioSesion cancelandoInicioSesion(String usuario, String clave) {
    return instrumented(CalcelarInicioSesion.class, usuario, clave);
  }

  public static Performable paraToken(String usuario, String clave) {
    return instrumented(CredencialesToken.class, usuario, clave);
  }
}
