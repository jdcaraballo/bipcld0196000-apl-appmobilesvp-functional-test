package com.banistmo.certificacion.utils;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getProxiedDriver;
import static org.openqa.selenium.remote.CapabilityType.PLATFORM_NAME;

import com.banistmo.certificacion.utils.enums.EnumContextosDriver;
import io.appium.java_client.AppiumDriver;
import java.util.Set;

public class UtileriaDriver {

  private UtileriaDriver() {}

  public static String getPlataformaEjecucion() {
    AppiumDriver driver = getProxiedDriver();
    return driver.getCapabilities().getCapability(PLATFORM_NAME).toString();
  }

  public static void cambiarContexto(EnumContextosDriver enumContextosDriver) {
    AppiumDriver driver = getProxiedDriver();
    Set<String> contexts = driver.getContextHandles();
    for (String context : contexts) {
      if (context.contains(enumContextosDriver.getContexto())) {
        driver.context(context);
        break;
      }
    }
  }
}
