package com.banistmo.certificacion.task.configuracion;

import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import com.banistmo.certificacion.task.comunes.Retroceder;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.banistmo.certificacion.userinterface.menu.MenuConfiguracionPage.BTN_OPT_ADMINISTRACION;
import static com.banistmo.certificacion.userinterface.menu.MenuPage.BTN_CONFIGURACION;
import static com.banistmo.certificacion.userinterface.menu.MenuPage.LBL_DEPOSITOS;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Entrar implements Task {

  private final String opcionMenu;
  private final Target opcionConfiguracion;

  public Entrar(String opcionMenu, Target opcionConfiguracion) {
    this.opcionMenu = opcionMenu;
    this.opcionConfiguracion = opcionConfiguracion;
  }

  public static Entrar aConfiguracion(String submenu, Target opcionSubmenu) {
    return instrumented(Entrar.class, submenu, opcionSubmenu);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
            Retroceder.hastaPantallaInicio(),
            WaitUntil.the(LBL_DEPOSITOS, isVisible()).forNoMoreThan(50).seconds());
    actor.attemptsTo(
        EsperarCarga.desaparezca(),
        EsperarElemento.esClickable(BTN_CONFIGURACION),
        Click.on(BTN_CONFIGURACION),
        EsperarElemento.esClickable(BTN_OPT_ADMINISTRACION.of(opcionMenu)),
        Click.on(BTN_OPT_ADMINISTRACION.of(opcionMenu)),
        EsperarCarga.desaparezca(),
        EsperarElemento.esClickable(opcionConfiguracion),
        Click.on(opcionConfiguracion),
        EsperarCarga.desaparezca());
  }
}
