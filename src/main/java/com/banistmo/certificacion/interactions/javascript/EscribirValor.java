package com.banistmo.certificacion.interactions.javascript;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.JavascriptExecutor;

public class EscribirValor implements Interaction {

  private String valor;
  private Target elemento;

  public EscribirValor(String valor, Target elemento) {
    this.valor = valor;
    this.elemento = elemento;
  }

  public static EscribirValor conJavaScript(String valor, Target elemento) {
    return instrumented(EscribirValor.class, valor, elemento);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    WebElementFacade elementoWebElement = elemento.resolveFor(actor);
    JavascriptExecutor js = (JavascriptExecutor) getDriver();
    js.executeScript("arguments[0].value = '" + valor + "';", elementoWebElement);
    js.executeScript(
        "arguments[0].dispatchEvent(new Event('input', { bubbles: true }));", elementoWebElement);
    js.executeScript(
        "arguments[0].dispatchEvent(new Event('change', { bubbles: true }));", elementoWebElement);
    js.executeScript("arguments[0].blur();", elementoWebElement);
  }
}
