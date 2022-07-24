package com.banistmo.certificacion.interactions;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import io.appium.java_client.AppiumDriver;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;

public class Ocultar implements Interaction {

  public static Ocultar teclado() {
    return instrumented(Ocultar.class);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    WebDriver facade = BrowseTheWeb.as(actor).getDriver();
    ((AppiumDriver) facade).hideKeyboard();
  }
}
