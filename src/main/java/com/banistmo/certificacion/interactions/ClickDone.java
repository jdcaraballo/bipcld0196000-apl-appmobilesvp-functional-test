package com.banistmo.certificacion.interactions;

import static com.banistmo.certificacion.utils.UtileriaDriver.cambiarContexto;
import static com.banistmo.certificacion.utils.enums.EnumContextosDriver.NATIVA;
import static com.banistmo.certificacion.utils.enums.EnumContextosDriver.WEBVIEW;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getProxiedDriver;

import io.appium.java_client.AppiumDriver;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

public class ClickDone implements Interaction {

  public static ClickDone nativoIOS() {
    return instrumented(ClickDone.class);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    AppiumDriver driver = getProxiedDriver();
    cambiarContexto(NATIVA);
    driver.findElementByAccessibilityId("Done").click();
    cambiarContexto(WEBVIEW);
  }
}
