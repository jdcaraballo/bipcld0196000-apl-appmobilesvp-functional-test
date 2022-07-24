package com.banistmo.certificacion.stepdefinitions.tarjetascredito;

import static com.banistmo.certificacion.exceptions.pagos.PagoProgramadoExitosoException.PAGO_PROGRAMADO_NO_EXITOSO;
import static com.banistmo.certificacion.models.builders.TransaccionBuilder.con;
import static com.banistmo.certificacion.userinterface.menu.MenuPage.BTN_PAGOS;
import static com.banistmo.certificacion.userinterface.menu.MenuPagosPage.BTN_TARJETAS_CREDITO;
import static com.banistmo.certificacion.utils.enums.EnumMensajes.*;
import static com.banistmo.certificacion.utils.enums.EnumVariablesSesion.VERIFICAR_TRANSACCION;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import com.banistmo.certificacion.exceptions.pagos.PagoExitosoException;
import com.banistmo.certificacion.exceptions.pagos.PagoProgramadoExitosoException;
import com.banistmo.certificacion.interactions.esperas.Esperar;
import com.banistmo.certificacion.models.builders.TransaccionBuilder;
import com.banistmo.certificacion.models.comun.Validacion;
import com.banistmo.certificacion.questions.programados.VerificarTransaccionTercerosProgramada;
import com.banistmo.certificacion.questions.transferencias.cuentaspropias.VerificarTransferenciaCuentasPropias;
import com.banistmo.certificacion.questions.transferencias.cuentaspropias.VerificarTransferenciaCuentasPropiasProgramadas;
import com.banistmo.certificacion.questions.transferencias.terceros.VerificarTransaccionTerceros;
import com.banistmo.certificacion.task.comunes.transacciones.Modificar;
import com.banistmo.certificacion.task.menu.IngresarOpcion;
import com.banistmo.certificacion.task.pagos.RealizarPago;
import cucumber.api.java.ast.Cuando;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;
import java.util.List;
import java.util.Map;

public class TarjetaCreditoStepDefinitions {

  @Cuando(
      "^el intenta realizar el pago de Tarjetas de crédito por el consolidados de productos con un valor: (.*)$")
  public void realizarPagoTarjetasCreditoPropiosConsolidadoProductos(String monto) {
    theActorInTheSpotlight()
        .attemptsTo(RealizarPago.tarjetasCreditoPropiasDesdeConsolidado(con().monto(monto)));
  }

  @Cuando(
      "^el intenta realizar el pago de Tarjetas de crédito por detalles del producto con un valor: (.*)$")
  public void realizarPagoTarjetasCreditoPropiosDetalles(String monto) {
    theActorInTheSpotlight()
        .attemptsTo(RealizarPago.tarjetasCreditoPropiasDesdeDetalles(con().monto(monto)));
  }

  @Cuando("^el intenta realizar un pago de una Tarjeta credito (.*) con un monto: (.*)$")
  public void realizarPagoTarjetaCreditoGuardada(String tipoTarjeta, String monto) {
    theActorInTheSpotlight()
        .attemptsTo(
            IngresarOpcion.delMenu(BTN_PAGOS, BTN_TARJETAS_CREDITO),
            RealizarPago.tarjetaCreditoGuardada(con().monto(monto), tipoTarjeta));
  }

  @Cuando("^el intenta realizar el pago (.*) de una Tarjeta credito propia$")
  public void realizarPagoMinimoTarjetaCreditoGuardada(String tipoPago) {
    theActorInTheSpotlight()
        .attemptsTo(
            IngresarOpcion.delMenu(BTN_PAGOS, BTN_TARJETAS_CREDITO),
            RealizarPago.opcionTarjetaCreditoGuardada(tipoPago));
  }

  @Entonces("^el pago a (?:TDC|prestamo) propio debe ser exitoso$")
  public void verificarPagoPropios() {
    Validacion validacion =
        theActorInTheSpotlight().recall(VERIFICAR_TRANSACCION.getVariableSesion());
    theActorInTheSpotlight()
        .should(
            seeThat(
                    VerificarTransferenciaCuentasPropias.exitosa(
                        validacion, PAGO_EJECUTADO_EXITOSO.getMensaje()))
                .orComplainWith(PagoExitosoException.class, PagoExitosoException.PAGO_NO_EXITOSO));
  }

  @Entonces("^el pago TDC propio debe ser exitoso$")
  public void verificarPagoPropiosTdc() {
    Validacion validacion =
            theActorInTheSpotlight().recall(VERIFICAR_TRANSACCION.getVariableSesion());
    theActorInTheSpotlight()
            .should(
                    seeThat(
                            VerificarTransferenciaCuentasPropias.exitosa(
                                    validacion, PAGO_EXITOSO_SEGUNDO_MENSAJE.getMensaje()))
                            .orComplainWith(PagoExitosoException.class, PagoExitosoException.PAGO_NO_EXITOSO));
  }

  @Cuando("^el ingresa a pago tarjetas propias$")
  public void ingresarPagosTarjetas() {
    theActorInTheSpotlight().attemptsTo(IngresarOpcion.delMenu(BTN_PAGOS, BTN_TARJETAS_CREDITO));
  }

  @Y("el modifica los datos del pago a tarjetas propias")
  public void modificarTransferenciaCuentasPropias(List<Map<String, String>> datos) {
    theActorInTheSpotlight()
        .attemptsTo(
            Modificar.pagoTarjetasCredito(
                TransaccionBuilder.con().monto(datos).descripcion(datos)));
  }

  @Cuando("^el intenta pagar una tarjeta de credito terceros$")
  public void realizarPagoTarjetaCredito(List<Map<String, String>> datos) {
    theActorInTheSpotlight()
        .attemptsTo(
            IngresarOpcion.delMenu(BTN_PAGOS, BTN_TARJETAS_CREDITO),
            RealizarPago.tarjetasCreditoTerceros(con().banco(datos).cuenta(datos).monto(datos)));
  }

  @Entonces("el pago a TDC a terceros debe ser exitoso")
  public void verificarDatosTarjetaTerceros() {
    Validacion validacion =
        theActorInTheSpotlight().recall(VERIFICAR_TRANSACCION.getVariableSesion());
    theActorInTheSpotlight()
        .should(
            seeThat(
                    VerificarTransaccionTerceros.exitosa(
                        validacion, PAGO_EXITOSO_SEGUNDO_MENSAJE.getMensaje()))
                .orComplainWith(PagoExitosoException.class, PagoExitosoException.PAGO_NO_EXITOSO));
  }

  @Entonces("^el pago propio deberia ser programado exitosamente$")
  public void verificarPagoPrestamoTercerosProgramado() {
    Validacion validacion =
        theActorInTheSpotlight().recall(VERIFICAR_TRANSACCION.getVariableSesion());
    theActorInTheSpotlight()
        .should(
            seeThat(
                    VerificarTransferenciaCuentasPropiasProgramadas.exitosa(
                        validacion, MENSAJE_EXITOSO_PAGO_PROGRAMADA.getMensaje()))
                .orComplainWith(PagoProgramadoExitosoException.class, PAGO_PROGRAMADO_NO_EXITOSO));
  }

  @Entonces("el pago terceros deberia ser programada exitosamente")
  public void verificarDatosTransferenciaTercerosProgramada() {
    Validacion validacion =
        theActorInTheSpotlight().recall(VERIFICAR_TRANSACCION.getVariableSesion());
    theActorInTheSpotlight().attemptsTo(Esperar.unTiempo(10000));
    theActorInTheSpotlight()
        .should(
            seeThat(
                    VerificarTransaccionTercerosProgramada.exitosa(
                        validacion, MENSAJE_EXITOSO_PAGO_PROGRAMADA.getMensaje()))
                .orComplainWith(PagoProgramadoExitosoException.class, PAGO_PROGRAMADO_NO_EXITOSO));
  }
}
