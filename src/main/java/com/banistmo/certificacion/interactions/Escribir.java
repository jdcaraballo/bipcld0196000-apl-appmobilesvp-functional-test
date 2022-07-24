package com.banistmo.certificacion.interactions;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.banistmo.certificacion.interactions.javascript.EscribirValor;
import com.banistmo.certificacion.questions.driver.ObtenerPlataforma;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.targets.Target;

public class Escribir implements Interaction {

  private String valor;
  private Target elemento;

  public Escribir(String valor, Target elemento) {
    this.valor = valor;
    this.elemento = elemento;
  }

  public static Escribir valorPlataforma(String valor, Target elemento) {
    return instrumented(Escribir.class, valor, elemento);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    String plataforma = ObtenerPlataforma.deEjecucion().answeredBy(actor);
    actor.attemptsTo(
        Check.whether("iOS".equalsIgnoreCase(plataforma))
            .andIfSo(EscribirValor.conJavaScript(valor, elemento), Click.on(elemento))
            .otherwise(Enter.theValue(valor).into(elemento)));
  }
}
