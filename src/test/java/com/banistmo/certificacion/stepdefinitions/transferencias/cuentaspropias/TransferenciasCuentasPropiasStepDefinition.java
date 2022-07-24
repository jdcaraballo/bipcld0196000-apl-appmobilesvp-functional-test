package com.banistmo.certificacion.stepdefinitions.transferencias.cuentaspropias;

import static com.banistmo.certificacion.exceptions.pagos.PagoEditadoExitosoException.PAGO_NO_EDITADO;
import static com.banistmo.certificacion.exceptions.pagos.PagoProgramadoExitosoException.PAGO_PROGRAMADO_NO_EXITOSO;
import static com.banistmo.certificacion.exceptions.transferencia.TransferenciaNoModificadaException.TRANSFERENCIA_MODIFICADA_NO_EXITOSA;
import static com.banistmo.certificacion.userinterface.autenticacion.LoginPage.MSG_APLICACION;
import static com.banistmo.certificacion.userinterface.autenticacion.LoginPage.MSG_APLICACION_SIN_PRODUCTOS;
import static com.banistmo.certificacion.userinterface.menu.MenuPage.BTN_TRANSFERENCIAS;
import static com.banistmo.certificacion.userinterface.menu.MenuTransferenciasPage.BTN_PROGRAMADAS;
import static com.banistmo.certificacion.utils.enums.EnumMensajes.*;
import static com.banistmo.certificacion.utils.enums.EnumVariablesSesion.VERIFICAR_TRANSACCION;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import com.banistmo.certificacion.exceptions.pagos.PagoEliminadoExitosoException;
import com.banistmo.certificacion.exceptions.pagos.PagoProgramadoExitosoException;
import com.banistmo.certificacion.exceptions.transferencia.TransferenciaExitosaException;
import com.banistmo.certificacion.exceptions.transferencia.TransferenciaNoModificadaException;
import com.banistmo.certificacion.interactions.CancelarSimple;
import com.banistmo.certificacion.interactions.esperas.Esperar;
import com.banistmo.certificacion.models.builders.TransaccionBuilder;
import com.banistmo.certificacion.models.comun.Validacion;
import com.banistmo.certificacion.questions.ElementoEsperado;
import com.banistmo.certificacion.questions.VerificarMensaje;
import com.banistmo.certificacion.questions.programados.VerificarOpcionEliminada;
import com.banistmo.certificacion.questions.programados.VerificarPagoEditado;
import com.banistmo.certificacion.questions.transferencias.cuentaspropias.VerificarModificacion;
import com.banistmo.certificacion.questions.transferencias.cuentaspropias.VerificarTransferenciaCuentasPropias;
import com.banistmo.certificacion.questions.transferencias.cuentaspropias.VerificarTransferenciaCuentasPropiasProgramadas;
import com.banistmo.certificacion.task.IrAlMenu;
import com.banistmo.certificacion.task.comunes.Terminar;
import com.banistmo.certificacion.task.comunes.programar.EliminarTransaccion;
import com.banistmo.certificacion.task.comunes.transacciones.Modificar;
import com.banistmo.certificacion.task.configuracion.favoritos.SeleccionarOpcion;
import com.banistmo.certificacion.task.menu.IngresarMisProductos;
import com.banistmo.certificacion.task.menu.IngresarOpcion;
import com.banistmo.certificacion.task.pagos.programados.EditarPago;
import com.banistmo.certificacion.task.transferencias.RealizarTransferencia;
import com.banistmo.certificacion.task.transferencias.cuentaspropias.TransferenciasPropias;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;

import java.util.List;
import java.util.Map;

public class TransferenciasCuentasPropiasStepDefinition {

  @Cuando("^el intenta realizar una transferencia entre cuentas propias desde (?:la|el) (.*)$")
  public void elUsuarioRealizaUnaTransaccion(
          String accesoTransferencia, List<Map<String, String>> datos) {
    theActorInTheSpotlight()
            .attemptsTo(
                    TransferenciasPropias.desde(accesoTransferencia),
                    RealizarTransferencia.cuentasPropias(
                            TransaccionBuilder.con().monto(datos).descripcion(datos)));
  }

  @Cuando("^el ingresa a mis productos$")
  public void ingresarMisProductos() {
    theActorInTheSpotlight().attemptsTo(IngresarMisProductos.desdeHome());
  }

  @Y("^el termina la transaccion$")
  public void terminarTransaccion() {
    theActorInTheSpotlight().attemptsTo(Terminar.transaccion());
  }

  @Entonces("deberia ver el siguiente mensaje: (.*)")
  public void verificarTransferenciaCuentasPropias(String mensaje) {
    theActorInTheSpotlight().attemptsTo(Esperar.unTiempo(4000));
    theActorInTheSpotlight().should(seeThat(ElementoEsperado.esVisible(MSG_APLICACION.of(mensaje)))
                            .orComplainWith(
                                    TransferenciaExitosaException.class,
                                    TransferenciaExitosaException.TRANSFERENCIA_EXITOSA_NO_ENCONTRADO));
  }

  @Entonces("deberia visualizar el siguiente mensaje: (.*)")
  public void verificarCuentaSinProducto(String mensaje) {
    theActorInTheSpotlight().attemptsTo(Esperar.unTiempo(4000));
    theActorInTheSpotlight().should(seeThat(ElementoEsperado.esVisible(MSG_APLICACION_SIN_PRODUCTOS.of(mensaje)))
            .orComplainWith(
                    TransferenciaExitosaException.class,
                    TransferenciaExitosaException.TRANSFERENCIA_EXITOSA_NO_ENCONTRADO));
  }


  @Entonces("la transferencia a cuentas propias deberia ser exitosa")
  public void verificarTransferenciaCuentasPropias() {
    Validacion validacion =
            theActorInTheSpotlight().recall(VERIFICAR_TRANSACCION.getVariableSesion());
    theActorInTheSpotlight()
            .should(
                    seeThat(
                            VerificarTransferenciaCuentasPropias.exitosa(
                                    validacion, TRANSFERENCIA_EXITOSA.getMensaje()))
                            .orComplainWith(
                                    TransferenciaExitosaException.class,
                                    TransferenciaExitosaException.TRANSFERENCIA_EXITOSA_NO_ENCONTRADO));
  }

  @Y("el cancela la transaccion en la pantalla de (.*)")
  public void cancelarTransaccion(String pantalla) {
    theActorInTheSpotlight().attemptsTo(CancelarSimple.transaccion(pantalla));
//    theActorInTheSpotlight().attemptsTo(Cancelar.transaccion(pantalla));
  }

  @Y("el modifica los datos de la transferencia entre cuentas propias")
  public void modificarTransferenciaCuentasPropias(List<Map<String, String>> datos) {
    theActorInTheSpotlight()
            .attemptsTo(
                    Modificar.transferenciaCuentasPropias(
                            TransaccionBuilder.con().monto(datos).descripcion(datos)));
  }

  @Entonces("el verifica que se modificaron lo datos de la transferencia")
  public void verificarModificacionTransaccion() {
    theActorInTheSpotlight()
            .should(
                    seeThat(VerificarModificacion.transaccion())
                            .orComplainWith(
                                    TransferenciaNoModificadaException.class, TRANSFERENCIA_MODIFICADA_NO_EXITOSA));
  }

  @Entonces("la transferencia a cuentas propias deberia ser programada exitosamente")
  public void verificarTransferenciaCuentasPropiasProgramada() {
    Validacion validacion =
            theActorInTheSpotlight().recall(VERIFICAR_TRANSACCION.getVariableSesion());
    theActorInTheSpotlight().attemptsTo(Esperar.unTiempo(5000));
    theActorInTheSpotlight()
            .should(
                    seeThat(
                            VerificarTransferenciaCuentasPropiasProgramadas.exitosa(
                                    validacion, MENSAJE_EXITOSO_TRANSFERENCIA_PROGRAMADA.getMensaje()))
                            .orComplainWith(PagoProgramadoExitosoException.class, PAGO_PROGRAMADO_NO_EXITOSO));
  }

  @Cuando("el elimina la transferencia programada")
  public void elEliminaElPagoProgramado() {
    theActorInTheSpotlight()
            .attemptsTo(
                    IrAlMenu.deSaldosConsolidados(),
                    IngresarOpcion.delMenu(BTN_TRANSFERENCIAS, BTN_PROGRAMADAS),
                    EliminarTransaccion.programada());
  }

  @Entonces("se verifica que la transferencia se haya eliminado correctamente")
  public void seVerificaQueElPagoSeHayaEliminadoCorrectamente() {
    Validacion validacion =
            theActorInTheSpotlight().recall(VERIFICAR_TRANSACCION.getVariableSesion());
    theActorInTheSpotlight().attemptsTo(Esperar.unTiempo(5000));
    theActorInTheSpotlight()
            .should(
                    seeThat(
                            VerificarMensaje.esVisible(
                                    MENSAJE_EXITOSO_TRANSFERENCIA_PROGRAMADA_ELIMINADA.getMensaje()))
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

  @Cuando("el edita la transferencia programada con fecha futura (.*) dias")
  public void elEditaElPagoProgramado(String dias, List<Map<String, String>> datos) {
    theActorInTheSpotlight()
            .attemptsTo(
                    IrAlMenu.deSaldosConsolidados(),
                    IngresarOpcion.delMenu(BTN_TRANSFERENCIAS, BTN_PROGRAMADAS),
                    EditarPago.fechaFutura(TransaccionBuilder.con().monto(datos).descripcion(datos), dias));
  }

  @Cuando("el edita la transferencia programada con fecha recurrente")
  public void elEditaElPagoProgramadoConFechaRecurrente(List<Map<String, String>> datos) {
    theActorInTheSpotlight()
            .attemptsTo(
                    IrAlMenu.deSaldosConsolidados(),
                    IngresarOpcion.delMenu(BTN_TRANSFERENCIAS, BTN_PROGRAMADAS),
                    EditarPago.fechaRecurrente(
                            TransaccionBuilder.con()
                                    .monto(datos)
                                    .descripcion(datos)
                                    .frecuencia(datos)
                                    .diaRecurrente(datos)
                                    .diasFinal(datos)));
  }

  @Entonces("el verifica que la transferencia se haya editado correctamente")
  public void seVerificaQueElPagoSeHayaEditadoCorrectamente() {
    Validacion validacion =
            theActorInTheSpotlight().recall(VERIFICAR_TRANSACCION.getVariableSesion());
    theActorInTheSpotlight().attemptsTo(Esperar.unTiempo(5000));
    theActorInTheSpotlight()
            .should(
                    seeThat(
                            VerificarMensaje.esVisible(
                                    TRANSFERENCIA_PROGRAMADA_EDITADA_EXITOSAMENTE.getMensaje()))
                            .orComplainWith(PagoProgramadoExitosoException.class, PAGO_NO_EDITADO));
    theActorInTheSpotlight()
            .attemptsTo(SeleccionarOpcion.conDescripcion(validacion.getProducto().getDescripcion()));
    theActorInTheSpotlight().should(seeThat(VerificarPagoEditado.exitosa(validacion)));
  }
}
