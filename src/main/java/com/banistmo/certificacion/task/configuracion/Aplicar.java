package com.banistmo.certificacion.task.configuracion;

import static com.banistmo.certificacion.userinterface.configuracion.seguridad.CambiarImagenFrasePage.BTN_GUARDAR;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import com.banistmo.certificacion.userinterface.configuracion.seguridad.CambiarImagenFrasePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class Aplicar implements Task {

  private String accion;

  public Aplicar(String accion) {
    this.accion = accion;
  }

  public static Aplicar cambioImagenFrase(String accion) {
    return instrumented(Aplicar.class, accion);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    if (accion.contains("guarda")) {
      actor.attemptsTo(Click.on(BTN_GUARDAR), EsperarCarga.desaparezca());
    } else {
      actor.attemptsTo(Click.on(CambiarImagenFrasePage.BTN_REGRESAR), EsperarCarga.desaparezca());
    }
  }
}
