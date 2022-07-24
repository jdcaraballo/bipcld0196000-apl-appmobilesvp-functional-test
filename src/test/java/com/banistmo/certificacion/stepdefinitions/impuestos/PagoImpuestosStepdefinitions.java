package com.banistmo.certificacion.stepdefinitions.impuestos;

import com.banistmo.certificacion.exceptions.pagos.PagoImpuestoException;
import com.banistmo.certificacion.questions.transaccion.VerificarPagoImpuesto;
import com.banistmo.certificacion.task.menu.IngresarOpcion;
import com.banistmo.certificacion.task.pagos.impuestos.ConsultarPagoDGI;
import cucumber.api.java.ast.Cuando;
import cucumber.api.java.es.Entonces;

import static com.banistmo.certificacion.exceptions.pagos.PagoImpuestoException.PAGO_IMPUESTO_FALLIDO;
import static com.banistmo.certificacion.userinterface.menu.MenuPage.*;

import static com.banistmo.certificacion.utils.enums.EnumVariablesSesion.NRO_BOLETA_DGI;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class PagoImpuestosStepdefinitions {

  @Cuando("^el intenta consultar impuestos DGI con el nro de boleta$")
  public void pagoImpuestosDGI() {
    String nroBoleta = System.getProperty(NRO_BOLETA_DGI.getVariableSesion());
    theActorInTheSpotlight().attemptsTo(
            IngresarOpcion.delMenu(BTN_PAGOS, BTN_IMPUESTOS),
            ConsultarPagoDGI.conBoleta(nroBoleta));
  }

  @Entonces("^el pago a prestamo a terceros debe impuestos debe ser exitoso$")
  public void verificarPagoImpuestoExitoso() {
    theActorInTheSpotlight()
        .should(
            seeThat(VerificarPagoImpuesto.exitoso())
                .orComplainWith(PagoImpuestoException.class, PAGO_IMPUESTO_FALLIDO));
  }

  @Cuando("^el intenta consultar impuestos DGI con el nro de boleta (.*)$")
  public void pagoImpuestosDGIIvalido(String nroBoleta) {
    theActorInTheSpotlight()
        .attemptsTo(
            IngresarOpcion.delMenu(BTN_PAGOS, BTN_IMPUESTOS),
            ConsultarPagoDGI.conBoleta(nroBoleta));
  }
}
