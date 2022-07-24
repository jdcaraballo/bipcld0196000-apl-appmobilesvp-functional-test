package com.banistmo.certificacion.task.configuracion.seguridad;

import static com.banistmo.certificacion.userinterface.menu.MenuConfiguracionPage.BTN_ACTUALIZAR_DATOS_HOME;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.banistmo.certificacion.interactions.esperas.Esperar;
import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class ActualizacionDatos implements Task {
  public static ActualizacionDatos desdeHome() {
    return instrumented(ActualizacionDatos.class);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        EsperarCarga.desaparezca(),
        EsperarElemento.esClickable(BTN_ACTUALIZAR_DATOS_HOME),
        Click.on(BTN_ACTUALIZAR_DATOS_HOME),
        Esperar.unTiempo(2000));
  }
}
