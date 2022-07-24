package com.banistmo.certificacion.task.autenticacion.cerrarsesion;

import static com.banistmo.certificacion.userinterface.PrincipalPage.BTN_ACEPTAR_CIERRE_SESION;
import static com.banistmo.certificacion.userinterface.PrincipalPage.BTN_CERRAR_SESION;
import static com.banistmo.certificacion.userinterface.menu.MenuPage.BTN_CONFIGURACION;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.banistmo.certificacion.interactions.esperas.Esperar;
import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import com.banistmo.certificacion.userinterface.menu.MenuConfiguracionPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;

public class CerrarSesion implements Task {

  private final String formaCerrarSesion;

  public CerrarSesion(String formaCerrarSesion) {
    this.formaCerrarSesion = formaCerrarSesion;
  }

  public static CerrarSesion enSvp(String formaCerrarSesion) {
    return instrumented(CerrarSesion.class, formaCerrarSesion);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        EsperarCarga.desaparezca(),
        Check.whether("pantalla inicio".equals(formaCerrarSesion))
            .andIfSo(EsperarElemento.esClickable(BTN_CERRAR_SESION), Click.on(BTN_CERRAR_SESION))
            .otherwise(
                EsperarElemento.esClickable(BTN_CONFIGURACION),
                Click.on(BTN_CONFIGURACION),
                EsperarCarga.desaparezca(),
                EsperarElemento.esClickable(MenuConfiguracionPage.BTN_SALIR),
                Click.on(MenuConfiguracionPage.BTN_SALIR)),
        Esperar.unTiempo(2000),
        EsperarElemento.esClickable(BTN_ACEPTAR_CIERRE_SESION),
        Click.on(BTN_ACEPTAR_CIERRE_SESION));
  }
}
