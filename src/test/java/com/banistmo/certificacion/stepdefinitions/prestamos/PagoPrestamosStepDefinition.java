package com.banistmo.certificacion.stepdefinitions.prestamos;

import static com.banistmo.certificacion.exceptions.pagos.PagoEditadoExitosoException.PAGO_NO_EDITADO;
import static com.banistmo.certificacion.exceptions.pagos.PagoProgramadoExitosoException.PAGO_PROGRAMADO_NO_EXITOSO;
import static com.banistmo.certificacion.userinterface.autenticacion.LoginPage.MSG_APLICACION_SIN_FONDOS;
import static com.banistmo.certificacion.userinterface.menu.MenuPage.BTN_PAGOS;
import static com.banistmo.certificacion.userinterface.menu.MenuPagosPage.BTN_PRESTAMOS;
import static com.banistmo.certificacion.userinterface.menu.MenuPagosPage.BTN_PROGRAMADOS;
import static com.banistmo.certificacion.utils.enums.EnumMensajes.*;
import static com.banistmo.certificacion.utils.enums.EnumVariablesSesion.DESCRIPCION_PAGO_FECHA_FUTURA;
import static com.banistmo.certificacion.utils.enums.EnumVariablesSesion.VERIFICAR_TRANSACCION;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import com.banistmo.certificacion.exceptions.pagos.PagoEliminadoExitosoException;
import com.banistmo.certificacion.exceptions.pagos.PagoExitosoException;
import com.banistmo.certificacion.exceptions.pagos.PagoProgramadoExitosoException;
import com.banistmo.certificacion.exceptions.transferencia.TransferenciaExitosaException;
import com.banistmo.certificacion.interactions.esperas.Esperar;
import com.banistmo.certificacion.models.builders.TransaccionBuilder;
import com.banistmo.certificacion.models.comun.Validacion;
import com.banistmo.certificacion.questions.ElementoEsperado;
import com.banistmo.certificacion.questions.VerificarMensaje;
import com.banistmo.certificacion.questions.prestamos.VerificarTransaccionPrestamosTerceros;
import com.banistmo.certificacion.questions.prestamos.programados.VerificarPagoDePrestamoProgramado;
import com.banistmo.certificacion.questions.programados.VerificarOpcionEliminada;
import com.banistmo.certificacion.questions.programados.VerificarPagoEditado;
import com.banistmo.certificacion.task.IrAlMenu;
import com.banistmo.certificacion.task.comunes.programar.EliminarTransaccion;
import com.banistmo.certificacion.task.comunes.programar.Programar;
import com.banistmo.certificacion.task.configuracion.favoritos.SeleccionarOpcion;
import com.banistmo.certificacion.task.menu.IngresarOpcion;
import com.banistmo.certificacion.task.pagos.RealizarPago;
import com.banistmo.certificacion.task.pagos.programados.EditarPago;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;
import java.util.List;
import java.util.Map;

public class PagoPrestamosStepDefinition {

  @Cuando("el intenta realizar el pago de un Préstamo por el consolidados de productos")
  public void pagoPrestamoPropioConsolidadoProductos() {
    theActorInTheSpotlight().attemptsTo(RealizarPago.prestamosPropiosDesdeConsolidado());
  }

  @Cuando("el intenta realizar el pago de un Préstamo por detalles")
  public void pagoPrestamoPropioDetalles() {
    theActorInTheSpotlight().attemptsTo(RealizarPago.prestamosPropiosDesdeDetalles());
  }

  @Cuando("^el intenta pagar un prestamo a terceros (?:ACH|Banistmo)$")
  public void pagoPrestamoTerceros(List<Map<String, String>> datos) {
    theActorInTheSpotlight()
        .attemptsTo(
            IngresarOpcion.delMenu(BTN_PAGOS, BTN_PRESTAMOS),
            RealizarPago.prestamoNuevoTerceros(
                TransaccionBuilder.con()
                    .banco(datos)
                    .cuenta(datos)
                    .monto(datos)
                    .descripcion(datos)));
  }

  @Cuando("el intenta realizar un pago de un prestamo (.*) con un monto: (.*)")
  public void pagoPrestamoGuardado(String tipoCuentaTerceros, String monto) {
    theActorInTheSpotlight()
        .attemptsTo(
            IngresarOpcion.delMenu(BTN_PAGOS, BTN_PRESTAMOS),
            RealizarPago.prestamosGuardados(
                TransaccionBuilder.con()
                    .monto(monto)
                    .descripcion(DESCRIPCION_PAGO_FECHA_FUTURA.getVariableSesion()),
                tipoCuentaTerceros));
  }

  @Cuando("el edita el pago programado con fecha futura (.*) dias")
  public void elEditaElPagoProgramado(String dias, List<Map<String, String>> datos) {
    theActorInTheSpotlight()
        .attemptsTo(
            IrAlMenu.deSaldosConsolidados(),
            IngresarOpcion.delMenu(BTN_PAGOS, BTN_PROGRAMADOS),
            EditarPago.fechaFutura(TransaccionBuilder.con().monto(datos).descripcion(datos), dias));
  }

  @Cuando("el edita el pago programado con fecha recurrente")
  public void elEditaElPagoProgramadoConFechaRecurrente(List<Map<String, String>> datos) {
    theActorInTheSpotlight()
        .attemptsTo(
            IrAlMenu.deSaldosConsolidados(),
            IngresarOpcion.delMenu(BTN_PAGOS, BTN_PROGRAMADOS),
            EditarPago.fechaRecurrente(
                TransaccionBuilder.con()
                    .monto(datos)
                    .descripcion(datos)
                    .frecuencia(datos)
                    .diaRecurrente(datos)
                    .diasFinal(datos)));
  }

  @Entonces("el verifica que el pago se haya editado correctamente")
  public void seVerificaQueElPagoSeHayaEditadoCorrectamente() {
    theActorInTheSpotlight().attemptsTo(Esperar.unTiempo(5000));
    Validacion validacion =
        theActorInTheSpotlight().recall(VERIFICAR_TRANSACCION.getVariableSesion());
    theActorInTheSpotlight()
        .should(
            seeThat(VerificarMensaje.esVisible(MENSAJE_EXITOSO_PAGO_ACTUALIZADO.getMensaje()))
                .orComplainWith(PagoProgramadoExitosoException.class, PAGO_NO_EDITADO));
    theActorInTheSpotlight()
        .attemptsTo(SeleccionarOpcion.conDescripcion(validacion.getProducto().getDescripcion()));
    theActorInTheSpotlight().should(seeThat(VerificarPagoEditado.exitosa(validacion)));
  }

  @Cuando("el elimina el pago programado")
  public void elEliminaElPagoProgramado() {
    theActorInTheSpotlight()
        .attemptsTo(
            IrAlMenu.deSaldosConsolidados(),
            IngresarOpcion.delMenu(BTN_PAGOS, BTN_PROGRAMADOS),
            EliminarTransaccion.programada());
  }

  @Entonces("se verifica que el pago se haya eliminado correctamente")
  public void seVerificaQueElPagoSeHayaEliminadoCorrectamente() {
    Validacion validacion =
        theActorInTheSpotlight().recall(VERIFICAR_TRANSACCION.getVariableSesion());
    theActorInTheSpotlight()
        .should(
            seeThat(
                    VerificarMensaje.esVisible(
                        MENSAJE_EXITOSO_PAGO_PROGRAMADO_ELIMINADO.getMensaje()))
                .orComplainWith(
                    PagoEliminadoExitosoException.class,
                    PagoEliminadoExitosoException.PAGO_NO_ELIMINADO));
    theActorInTheSpotlight()
        .should(
            seeThat(VerificarOpcionEliminada.exitosa(validacion))
                .orComplainWith(
                    PagoEliminadoExitosoException.class,
                    PagoEliminadoExitosoException.PAGO_NO_ELIMINADO));
  }

  @Entonces("^el pago a prestamo a terceros debe ser exitoso$")
  public void verificarPagoPrestamoTerceros() {
    Validacion validacion =
        theActorInTheSpotlight().recall(VERIFICAR_TRANSACCION.getVariableSesion());
    theActorInTheSpotlight()
        .should(
            seeThat(
                    VerificarTransaccionPrestamosTerceros.exitosa(
                        validacion, PAGO_EJECUTADO_EXITOSO.getMensaje()))
                .orComplainWith(PagoExitosoException.class, PagoExitosoException.PAGO_NO_EXITOSO));
  }

  @Entonces("^el pago a prestamo terceros deberia ser programado exitosamente$")
  public void verificarPagoPrestamoTercerosProgramado() {
    Validacion validacion =
        theActorInTheSpotlight().recall(VERIFICAR_TRANSACCION.getVariableSesion());
    theActorInTheSpotlight()
        .should(
            seeThat(
                    VerificarPagoDePrestamoProgramado.exitoso(
                        validacion, MENSAJE_EXITOSO_PAGO_PROGRAMADA.getMensaje()))
                .orComplainWith(PagoProgramadoExitosoException.class, PAGO_PROGRAMADO_NO_EXITOSO));
  }

  @Y("el programa con fecha futura la transaccion (.*) dias")
  public void programarFechaFutura(int dias) {
    theActorInTheSpotlight().attemptsTo(Programar.conFechaFutura(dias));
  }

  @Entonces("deberia ver el siguiente mensaje en pantalla: (.*)")
  public void verificarTransferenciaCuentasPropias(String mensaje) {
    theActorInTheSpotlight()
        .should(
            seeThat(ElementoEsperado.esVisible(MSG_APLICACION_SIN_FONDOS.of(mensaje)))
                .orComplainWith(
                    TransferenciaExitosaException.class,
                    TransferenciaExitosaException.TRANSFERENCIA_EXITOSA_NO_ENCONTRADO));
  }

  @Y("el programa con Recurrencia la transaccion")
  public void programarRecurrencia(List<Map<String, String>> datos) {
    theActorInTheSpotlight().attemptsTo(Programar.conRecurrente(datos));
  }
}
