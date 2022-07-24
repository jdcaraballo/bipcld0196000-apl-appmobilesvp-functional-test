package com.banistmo.certificacion.task.configuracion.notificaciones;

import static com.banistmo.certificacion.userinterface.configuracion.administracion.AdministrarNotificacionesPage.CHK_MEDIO;
import static com.banistmo.certificacion.userinterface.configuracion.administracion.AdministrarNotificacionesPage.LST_CHK_MEDIOS_ACTIVOS;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.banistmo.certificacion.interactions.ClickInvisible;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class ActivarMedios implements Task {

  private final String medios;
  private final String opcion;

  public ActivarMedios(String medios, String opcion) {
    this.medios = medios;
    this.opcion = opcion;
  }

  public static ActivarMedios notificaciones(String medios, String opcion) {
    return instrumented(ActivarMedios.class, medios, opcion);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    String[] mediosActivar = medios.split(",");
    String[] mediosActivos =
        LST_CHK_MEDIOS_ACTIVOS
            .of(opcion)
            .resolveFor(actor)
            .getAttribute("ng-reflect-value-input")
            .split(",");

    for (String mediosActivo : mediosActivos) {
      actor.attemptsTo(ClickInvisible.enReporte(CHK_MEDIO.of(mediosActivo)));
    }

    for (String medio : mediosActivar) {
      actor.attemptsTo(Click.on(CHK_MEDIO.of(medio)));
    }
  }
}
