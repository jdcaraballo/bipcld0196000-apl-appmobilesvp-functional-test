package com.banistmo.certificacion.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UtileriaString {

  private UtileriaString() {}

  public static String formatearNumeros(String cadena) {
    return cadena.replaceAll("[^\\\\0-9]", "");
  }

  public static String formatearCuentasRetiro(String myString) {
    if (myString.length() > 4) {
      return "******" + myString.substring(myString.length() - 4);
    } else {
      return myString;
    }
  }

  public static String formatearTarjeta(String myString) {
    if (myString.length() > 4) {
      return "*" + myString.substring(myString.length() - 4);
    } else {
      return myString;
    }
  }

  public static String eliminarPalabra(String palabra, String caracterEliminar) {
    if (palabra.contains(caracterEliminar)) {
      return palabra.replace(caracterEliminar, "");
    } else {
      return palabra;
    }
  }

  public static String obtenerNumeroProducto(String numeroProducto) {
    if (numeroProducto.contains("Cuenta ahorro ")) {
      return numeroProducto.replace("Cuenta ahorro ", "");
    } else {
      return numeroProducto.replace("Cuenta corriente ", "");
    }
  }

  public static String formatearFechaComprante(String fechaComprobante) {
    String resultadoMesCompleto = null;
    Pattern patternMes = Pattern.compile("[a-zA-Z]+");
    Matcher matcherMes = patternMes.matcher(fechaComprobante);
    while (matcherMes.find()) {
      resultadoMesCompleto = matcherMes.group(0);
    }
    if (fechaComprobante.contains(".")) {
      return fechaComprobante;
    } else {
      return matcherMes.replaceAll(resultadoMesCompleto.substring(0, 3) + ".");
    }
  }

  public static String formatearFechaEliminadoCero(String fechaComprobante) {
    String resultadoFecha = null;
    Pattern patternFecha = Pattern.compile("^.{0,2}");
    Matcher matcherFecha = patternFecha.matcher(fechaComprobante);
    while (matcherFecha.find()) {
      resultadoFecha = matcherFecha.group(0);
    }
    if (resultadoFecha.charAt(0) == '0') {
      return matcherFecha.replaceAll(resultadoFecha.substring(1, 2));
    } else {
      return fechaComprobante;
    }
  }
}
