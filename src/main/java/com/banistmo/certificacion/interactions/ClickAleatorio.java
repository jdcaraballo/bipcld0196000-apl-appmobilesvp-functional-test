package com.banistmo.certificacion.interactions;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import java.util.List;
import java.util.Random;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;

public class ClickAleatorio implements Interaction {

  private final Target elementos;

  public ClickAleatorio(Target elementos) {
    this.elementos = elementos;
  }

  public static ClickAleatorio enElemento(Target elementos) {
    return instrumented(ClickAleatorio.class, elementos);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    List<WebElementFacade> lstElementos = elementos.resolveAllFor(actor);
    Random random = new Random();
    int valorRandom = random.nextInt(lstElementos.size());
    lstElementos.get(valorRandom).click();
  }
}
