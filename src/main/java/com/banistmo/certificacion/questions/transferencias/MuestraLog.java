package com.banistmo.certificacion.questions.transferencias;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

import java.util.List;
import java.util.stream.Collectors;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.openqa.selenium.logging.LogEntry;

public class MuestraLog implements Question<String> {
  public static MuestraLog browser() {
    return new MuestraLog();
  }

  @Override
  public String answeredBy(Actor actor) {
    String log = "";

    List<LogEntry> consoleLog =
        getDriver()
            .manage()
            .logs()
            .get("browser")
            .getAll()
            .stream()
            .filter(p -> "SEVERE".equals(p.getLevel().toString()))
            .collect(Collectors.toList());

    for (LogEntry logEntry : consoleLog) {
      log = "\n" + log.concat(logEntry.getMessage());
    }
    return log;
  }
}
