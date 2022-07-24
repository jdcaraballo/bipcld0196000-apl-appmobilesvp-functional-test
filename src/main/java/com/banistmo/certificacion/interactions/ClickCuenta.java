package com.banistmo.certificacion.interactions;

import static com.banistmo.certificacion.userinterface.comunes.TransaccionesGeneralPage.*;
import static com.banistmo.certificacion.userinterface.recargas.RecargasPage.LST_BTN_RECARGAS_GUARDADAS;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;

public class ClickCuenta implements Interaction {

  private String tipoCuenta;

  public ClickCuenta(String tipoCuenta) {
    this.tipoCuenta = tipoCuenta;
  }

  public static ClickCuenta guardada(String tipoCuenta) {
    return instrumented(ClickCuenta.class, tipoCuenta);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    switch (tipoCuenta) {
      case "Banistmo":
        actor.attemptsTo(Click.on(BTN_CUENTA_TERCERO_BANISTMO));
        break;
      case "ACH":
        actor.attemptsTo(
            EsperarElemento.esClickable(BTN_CUENTA_TERCERO_ACH),
            ClickAleatorio.enElemento(BTN_CUENTA_TERCERO_ACH));
        break;
      case "propio":
        actor.attemptsTo(
            EsperarElemento.esClickable(BTN_PRODUCTO_PROPIO_2),
            ClickAleatorio.enElemento(BTN_PRODUCTO_PROPIO_2));
        break;
      case "recargas":
        actor.attemptsTo(
            EsperarElemento.esClickable(LST_BTN_RECARGAS_GUARDADAS),
            ClickAleatorio.enElemento(LST_BTN_RECARGAS_GUARDADAS));
        break;
      default:
    }
  }
}
