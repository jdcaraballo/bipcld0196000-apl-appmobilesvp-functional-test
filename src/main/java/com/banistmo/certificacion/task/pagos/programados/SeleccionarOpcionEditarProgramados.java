package com.banistmo.certificacion.task.pagos.programados;

import static com.banistmo.certificacion.userinterface.comunes.ProgramadasPage.BTN_EDITAR;

import com.banistmo.certificacion.interactions.esperas.Esperar;
import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class SeleccionarOpcionEditarProgramados implements Task {
  private String descripcion;

  public SeleccionarOpcionEditarProgramados(String descripcion) {
    this.descripcion = descripcion;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        EsperarElemento.esClickable(BTN_EDITAR.of(descripcion)),
        Click.on(BTN_EDITAR.of(descripcion)),
        Esperar.unTiempo(2000));
  }
}
