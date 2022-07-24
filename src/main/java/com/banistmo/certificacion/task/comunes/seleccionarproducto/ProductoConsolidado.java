package com.banistmo.certificacion.task.comunes.seleccionarproducto;

import static com.banistmo.certificacion.userinterface.PrincipalPage.*;

import com.banistmo.certificacion.interactions.ClickAleatorio;
import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import com.banistmo.certificacion.task.comunes.SeleccionarVista;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class ProductoConsolidado implements Task {

  private String producto;

  public ProductoConsolidado(String producto) {
    this.producto = producto;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
      actor.attemptsTo(
              SeleccionarVista.tipoCard(),
          EsperarCarga.desaparezca(),
          EsperarElemento.esClickable(BTN_CUENTAS_VISTA_CARD_FILTRO.of(producto)),
          Click.on(BTN_CUENTAS_VISTA_CARD_FILTRO.of(producto)),
          EsperarCarga.desaparezca(),
          ClickAleatorio.enElemento(LST_BTN_TRANSFERIR_PAGAR_CARD),
          EsperarCarga.desaparezca());
    }

}