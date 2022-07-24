package com.banistmo.certificacion.task;

import static com.banistmo.certificacion.userinterface.comunes.ProgramadasPage.BTN_IR_A_CONSOLIDADOS;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class IrAlMenu implements Task {
  public static IrAlMenu deSaldosConsolidados() {
    return instrumented(IrAlMenu.class);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        EsperarElemento.esClickable(BTN_IR_A_CONSOLIDADOS), Click.on(BTN_IR_A_CONSOLIDADOS));
  }
}
