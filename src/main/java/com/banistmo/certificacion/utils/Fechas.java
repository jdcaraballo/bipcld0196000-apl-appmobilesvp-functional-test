package com.banistmo.certificacion.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import net.thucydides.core.steps.StepInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Fechas {

  private static final Logger LOGGER = LoggerFactory.getLogger(StepInterceptor.class);

  private Fechas() {}

  public static String obtenerFechaFuturaDias(int dias, String formato) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formato);
    LocalDate manana = LocalDate.now().plusDays(dias);
    return formatter.format(manana);
  }

  public static String formatearFecha(String fecha, String formatoFecha) {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", new Locale("es"));
    Date d = null;
    try {
      d = sdf.parse(fecha);
    } catch (ParseException e) {
      LOGGER.info("Excepción ocurrida al dar formato a la fecha" + e);
    }
    sdf.applyPattern(formatoFecha);
    return sdf.format(d);
  }
}
