package com.banistmo.certificacion.task.transferencias.cuentaspropias;

import static com.banistmo.certificacion.userinterface.PrincipalPage.*;
import static com.banistmo.certificacion.userinterface.detalles.TransaccionesDetallesPage.*;
import static com.banistmo.certificacion.userinterface.menu.MenuPage.BTN_TRANSACCIONES;
import static com.banistmo.certificacion.userinterface.menu.MenuPage.BTN_TRANSFERENCIAS;
import static com.banistmo.certificacion.userinterface.menu.MenuPage.LBL_DEPOSITOS;
import static com.banistmo.certificacion.userinterface.menu.MenuTransferenciasPage.BTN_ENTRE_CUENTAS_PROPIAS;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import com.banistmo.certificacion.interactions.ClickAleatorio;
import com.banistmo.certificacion.interactions.esperas.Esperar;
import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import com.banistmo.certificacion.task.comunes.SeleccionarVista;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class TransferenciasPropias implements Task {

  private final String ruta;

  public TransferenciasPropias(String ruta) {
    this.ruta = ruta;
  }

  public static Performable desde(String ruta) {
    return instrumented(TransferenciasPropias.class, ruta);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    switch (ruta) {
      case "vista card":
        ingresarVistaCard(actor);
        break;
      case "vista lista":
        ingresarVistaLista(actor);
        break;
      case "menu":
      default:
        ingresarMenu(actor);
        break;
    }
  }

  private void ingresarVistaCard(Actor actor) {
    actor.attemptsTo(
        EsperarElemento.esVisible(LST_BTN_CUENTA_DEPOSITO_VISTA_LISTA),
        EsperarCarga.desaparezca(),
            SeleccionarVista.tipoCard(),
        EsperarCarga.desaparezca(),
        EsperarElemento.esClickable(BTN_CUENTAS_DEPOSITOS_CARD),
        Click.on(BTN_CUENTAS_DEPOSITOS_CARD),
        EsperarCarga.desaparezca(),
        EsperarElemento.esClickable(LST_BTN_TRANSFERIR_PAGAR_CARD),
        ClickAleatorio.enElemento(LST_BTN_TRANSFERIR_PAGAR_CARD));
  }

  private void ingresarVistaLista(Actor actor) {
    actor.attemptsTo(
        Esperar.unTiempo(4000),
        EsperarCarga.desaparezca(),
            SeleccionarVista.tipoLista(),
//        EsperarElemento.esClickable(BTN_VISTA_LISTA),
//        Click.on(BTN_VISTA_LISTA),
        EsperarCarga.desaparezca(),
        EsperarElemento.esClickable(LST_BTN_CUENTA_DEPOSITO_VISTA_LISTA),
        Click.on(LST_BTN_CUENTA_DEPOSITO_VISTA_LISTA),
        EsperarCarga.desaparezca(),
        EsperarCarga.desaparezca(),
        Click.on(BTN_DETALLES),
        EsperarCarga.desaparezca(),
        EsperarElemento.esClickable(BTN_TRANSFERIR),
        Click.on(BTN_TRANSFERIR),
//        Check.whether("iOS".equalsIgnoreCase(getPlataformaEjecucion()))
//            .andIfSo(ClickCambiando.elContexto(BTN_TRANSFERIR_NATIVO_IOS))
//            .otherwise(Click.on(BTN_TRANSFERIR)),
        Esperar.unTiempo(3000));
  }

  private void ingresarMenu(Actor actor) {
    actor.attemptsTo(
        WaitUntil.the(LBL_DEPOSITOS, isVisible()).forNoMoreThan(50).seconds(),
        EsperarElemento.esClickable(BTN_TRANSACCIONES),
        Click.on(BTN_TRANSACCIONES),
        Esperar.unTiempo(3000),
        EsperarElemento.esClickable(BTN_TRANSFERENCIAS),
        Click.on(BTN_TRANSFERENCIAS),
        EsperarCarga.desaparezca(),
        EsperarElemento.esClickable(BTN_ENTRE_CUENTAS_PROPIAS),
        Click.on(BTN_ENTRE_CUENTAS_PROPIAS),
        EsperarCarga.desaparezca());
  }
}
