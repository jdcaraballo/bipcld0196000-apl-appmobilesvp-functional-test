package com.banistmo.certificacion.task.configuracion.seguridad;

import static com.banistmo.certificacion.userinterface.PrincipalPage.BTN_ACEPTAR_CIERRE_SESION;
import static com.banistmo.certificacion.userinterface.menu.MenuPage.BTN_CONFIGURACION;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.banistmo.certificacion.interactions.esperas.Esperar;
import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import com.banistmo.certificacion.userinterface.menu.MenuConfiguracionPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class CerrarSesion implements Task {
  public static CerrarSesion desdeConfiguracion() {
    return instrumented(CerrarSesion.class);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
            EsperarCarga.desaparezca(),
            EsperarElemento.esClickable(BTN_CONFIGURACION),
            Click.on(BTN_CONFIGURACION),
            EsperarCarga.desaparezca(),
            EsperarElemento.esClickable(MenuConfiguracionPage.BTN_SALIR),
            Click.on(MenuConfiguracionPage.BTN_SALIR),
            Esperar.unTiempo(10000),
            EsperarElemento.esClickable(BTN_ACEPTAR_CIERRE_SESION),
            Click.on(BTN_ACEPTAR_CIERRE_SESION));
  }
}