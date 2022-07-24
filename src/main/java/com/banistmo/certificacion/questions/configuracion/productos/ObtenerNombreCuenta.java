package com.banistmo.certificacion.questions.configuracion.productos;

import java.util.List;
import java.util.Random;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

public class ObtenerNombreCuenta implements Question<String> {

  private Target elementos;

  public ObtenerNombreCuenta(Target elementos) {
    this.elementos = elementos;
  }

  public static ObtenerNombreCuenta aleatorio(Target elementos) {
    return new ObtenerNombreCuenta(elementos);
  }

  @Override
  public String answeredBy(Actor actor) {
    List<WebElementFacade> lstElementos = elementos.resolveAllFor(actor);
    Random random = new Random();
    int valorRandom = random.nextInt(lstElementos.size());
    return lstElementos.get(valorRandom).getText();
  }
}
