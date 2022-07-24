package com.banistmo.certificacion.task.configuracion.seguridad;

import static com.banistmo.certificacion.userinterface.menu.MenuPage.BTN_CONFIGURACION;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.banistmo.certificacion.interactions.esperas.Esperar;
import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import com.banistmo.certificacion.userinterface.menu.MenuConfiguracionPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class ActualizarDatos implements Task {
  public static ActualizarDatos desdeConfiguracion() {
    return instrumented(ActualizarDatos.class);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        EsperarCarga.desaparezca(),
        EsperarElemento.esClickable(BTN_CONFIGURACION),
        Click.on(BTN_CONFIGURACION),
        EsperarCarga.desaparezca(),
        EsperarElemento.esClickable(MenuConfiguracionPage.BTN_ACTUALIZAR_DATOS),
        Click.on(MenuConfiguracionPage.BTN_ACTUALIZAR_DATOS),
        Esperar.unTiempo(2000));
  }
}
