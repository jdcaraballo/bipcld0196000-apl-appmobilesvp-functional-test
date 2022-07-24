package com.banistmo.certificacion.questions.driver;

import static org.openqa.selenium.remote.CapabilityType.PLATFORM_NAME;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.WebDriver;

public class ObtenerPlataforma implements Question<String> {

  public static ObtenerPlataforma deEjecucion() {
    return new ObtenerPlataforma();
  }

  @Override
  public String answeredBy(Actor actor) {
    WebDriver facade = BrowseTheWeb.as(actor).getDriver();
    return ((WebDriverFacade) facade).getCapabilities().getCapability(PLATFORM_NAME).toString();
  }
}
