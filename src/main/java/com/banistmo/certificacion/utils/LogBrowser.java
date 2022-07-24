package com.banistmo.certificacion.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.stream.Collectors;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class LogBrowser {

  private LogBrowser() {}

  public static String obtener() {
    String stringSevere = "SEVERE";
    String resultado = "";
    WebDriver driver = getDriver();
    if (!driver.toString().contains("Firefox")) {
      List<LogEntry> listLogs =
          driver
              .manage()
              .logs()
              .get(LogType.BROWSER)
              .getAll()
              .stream()
              .filter(p -> p.getLevel().toString().equals(stringSevere))
              .collect(Collectors.toList());
      for (LogEntry listLog : listLogs) {
        resultado =
            resultado.concat(
                "\n"
                    + listLog.getLevel().toString()
                    + " -> "
                    + getHora(listLog.getTimestamp())
                    + ": \n"
                    + listLog.getMessage());
      }
    }
    return resultado;
  }

  public static String getHora(long timestamp) {
    Date date = new Date(timestamp);
    DateFormat formatter = new SimpleDateFormat("HH:mm:ss.SSS");
    formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
    return formatter.format(date);
  }
}
