package com.banistmo.certificacion.questions.extrafinanciamiento;

import net.serenitybdd.screenplay.Question;

public class VerificarSaldo {

  private VerificarSaldo() {}

  public static Question<Boolean> nuevo() {
    return new SaldoNuevo();
  }

  public static Question<Boolean> inicial() {
    return new SaldoInicial();
  }
}
