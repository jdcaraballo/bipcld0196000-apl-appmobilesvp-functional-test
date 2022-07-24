package com.banistmo.certificacion.task.pagos.impuestos;

import com.banistmo.certificacion.interactions.ClickAleatorio;
import com.banistmo.certificacion.interactions.esperas.Esperar;
import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static com.banistmo.certificacion.userinterface.pagos.impuestos.PagoImpuestosPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ConsultarPagoDGI implements Task {

  private String nroBoleta;

  public ConsultarPagoDGI(String nroBoleta) {
    this.nroBoleta = nroBoleta;
  }

  public static ConsultarPagoDGI conBoleta(String nroBoleta) {
    return instrumented(ConsultarPagoDGI.class, nroBoleta);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {

    actor.attemptsTo(
        EsperarCarga.desaparezca(),
        EsperarElemento.esClickable(LBL_CUENTA_RETIRO_IMPUESTOS),
        Click.on(LBL_CUENTA_RETIRO_IMPUESTOS),
            Esperar.unTiempo(5000),
        ClickAleatorio.enElemento(LISTA_CUENTAS_RETIRO_IMPUESTOS),
            EsperarElemento.esClickable(LBL_NRO_BOLETA),
        Click.on(LBL_NRO_BOLETA),
            Enter.theValue(nroBoleta).into(TXT_NRO_BOLETA),
        EsperarElemento.esClickable(BTN_CONSULTAR_IMPUESTOS),
        Click.on(BTN_CONSULTAR_IMPUESTOS),
        EsperarCarga.desaparezca());
  }
}
