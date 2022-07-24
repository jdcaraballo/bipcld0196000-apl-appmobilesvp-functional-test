package com.banistmo.certificacion.task.menu;

import static com.banistmo.certificacion.userinterface.menu.MenuPage.BTN_CONFIGURACION;
import static com.banistmo.certificacion.userinterface.menu.MenuPage.BTN_QR;
import static com.banistmo.certificacion.userinterface.menu.MenuPage.BTN_TRANSACCIONES;
import static com.banistmo.certificacion.userinterface.menu.MenuPage.LBL_DEPOSITOS;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import com.banistmo.certificacion.interactions.esperas.Esperar;
import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class IngresarOpcion implements Task {

  private final Target opcionPrincipalMenu;
  private final Target subOpcionMenu;

  public IngresarOpcion(Target opcionPrincipalMenu, Target subOpcionMenu) {
    this.opcionPrincipalMenu = opcionPrincipalMenu;
    this.subOpcionMenu = subOpcionMenu;
  }

  public static IngresarOpcion delMenu(Target opcionPrincipalMenu, Target subOpcionMenu) {
    return instrumented(IngresarOpcion.class, opcionPrincipalMenu, subOpcionMenu);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(WaitUntil.the(LBL_DEPOSITOS, isVisible()).forNoMoreThan(50).seconds());

    if (opcionPrincipalMenu.equals(BTN_CONFIGURACION)) {
      actor.attemptsTo(EsperarElemento.esClickable(BTN_TRANSACCIONES), Click.on(BTN_CONFIGURACION));
    } else if (!opcionPrincipalMenu.equals(BTN_QR)) {
      actor.attemptsTo(EsperarElemento.esClickable(BTN_TRANSACCIONES), Click.on(BTN_TRANSACCIONES));
    }

    actor.attemptsTo(
        EsperarCarga.desaparezca(),
        Esperar.unTiempo(10000),
        EsperarElemento.esClickable(opcionPrincipalMenu),
        Click.on(opcionPrincipalMenu),
        Esperar.unTiempo(5000),
        EsperarElemento.esClickable(subOpcionMenu),
        Click.on(subOpcionMenu),
        EsperarCarga.desaparezca());
  }
}
