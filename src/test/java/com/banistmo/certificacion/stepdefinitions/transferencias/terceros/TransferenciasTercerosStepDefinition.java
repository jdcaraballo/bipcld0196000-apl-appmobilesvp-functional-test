package com.banistmo.certificacion.stepdefinitions.transferencias.terceros;

import static com.banistmo.certificacion.exceptions.pagos.PagoProgramadoExitosoException.PAGO_PROGRAMADO_NO_EXITOSO;
import static com.banistmo.certificacion.exceptions.transferencia.TransferenciaExitosaException.TRANSFERENCIA_EXITOSA_NO_ENCONTRADO;
import static com.banistmo.certificacion.exceptions.transferencia.TransferenciaNoModificadaException.DATOS_NO_MANTENIDOS_CORRECTAMENTE;
import static com.banistmo.certificacion.models.builders.TransaccionBuilder.con;
import static com.banistmo.certificacion.userinterface.menu.MenuPage.BTN_TRANSFERENCIAS;
import static com.banistmo.certificacion.userinterface.menu.MenuTransferenciasPage.BTN_TERCEROS;
import static com.banistmo.certificacion.utils.enums.EnumMensajes.*;
import static com.banistmo.certificacion.utils.enums.EnumVariablesSesion.VERIFICAR_TRANSACCION;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import com.banistmo.certificacion.exceptions.pagos.PagoProgramadoExitosoException;
import com.banistmo.certificacion.exceptions.transferencia.TransferenciaExitosaException;
import com.banistmo.certificacion.exceptions.transferencia.TransferenciaNoModificadaException;
import com.banistmo.certificacion.interactions.esperas.Esperar;
import com.banistmo.certificacion.models.comun.Validacion;
import com.banistmo.certificacion.questions.programados.VerificarTransaccionTercerosProgramada;
import com.banistmo.certificacion.questions.transferencias.terceros.VerificarDatosTransferenciasTerceros;
import com.banistmo.certificacion.questions.transferencias.terceros.VerificarTransaccionTerceros;
import com.banistmo.certificacion.task.comunes.transacciones.Modificar;
import com.banistmo.certificacion.task.menu.IngresarOpcion;
import com.banistmo.certificacion.task.transferencias.RealizarTransferencia;
import cucumber.api.java.ast.Cuando;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;
import java.util.List;
import java.util.Map;

public class TransferenciasTercerosStepDefinition {

  @Cuando("el intenta realizar una transferencia a teceros")
  public void realizarTransferenciaTerceros(List<Map<String, String>> datosPago) {
    theActorInTheSpotlight()
            .attemptsTo(
                    IngresarOpcion.delMenu(BTN_TRANSFERENCIAS, BTN_TERCEROS),
                    RealizarTransferencia.aCuentaNuevaTerceros(
                            con().banco(datosPago).cuenta(datosPago).tipoProducto(datosPago).monto(datosPago)));
  }

  @Cuando(
          "el intenta realizar una transferencia a una cuenta guardada terceros (.*) con un monto: (.*)")
  public void realizarTransferenciaTercerosGuardada(String tipoCuentaTerceros, String monto) {
    theActorInTheSpotlight()
            .attemptsTo(
                    IngresarOpcion.delMenu(BTN_TRANSFERENCIAS, BTN_TERCEROS),
                    RealizarTransferencia.aCuentaGuardadaTerceros(con().monto(monto), tipoCuentaTerceros));
  }

  @Entonces("la transferencia a terceros deberia ser exitosa")
  public void verificarDatosTransferenciaTerceros() {
    Validacion validacion =
            theActorInTheSpotlight().recall(VERIFICAR_TRANSACCION.getVariableSesion());
    theActorInTheSpotlight().attemptsTo(Esperar.unTiempo(5000));
    theActorInTheSpotlight()
            .should(
                    seeThat(
                            VerificarTransaccionTerceros.exitosa(
                                    validacion, TRANSFERENCIA_EXITOSA.getMensaje()))
                            .orComplainWith(
                                    TransferenciaExitosaException.class, TRANSFERENCIA_EXITOSA_NO_ENCONTRADO));
  }

  @Cuando("^el ingresa a cuentas terceros$")
  public void ingresarCuentasTerceros() {
    theActorInTheSpotlight().attemptsTo(IngresarOpcion.delMenu(BTN_TRANSFERENCIAS, BTN_TERCEROS));
  }

  @Y("el modifica los datos de la transferencia terceros")
  public void modificarTransferenciaTerceros() {
    theActorInTheSpotlight().attemptsTo(Modificar.transferenciaCuentasTerceros());
  }

  @Entonces("el verifica que los datos se mantienen")
  public void verificarDatosModificacionTerceros() {
    Validacion validacion =
            theActorInTheSpotlight().recall(VERIFICAR_TRANSACCION.getVariableSesion());
    theActorInTheSpotlight().attemptsTo(Esperar.unTiempo(5000));
    theActorInTheSpotlight()
            .should(
                    seeThat(VerificarDatosTransferenciasTerceros.exitosa(validacion))
                            .orComplainWith(
                                    TransferenciaNoModificadaException.class, DATOS_NO_MANTENIDOS_CORRECTAMENTE));
  }

  @Entonces("la transferencia a terceros deberia ser programada exitosamente")
  public void verificarDatosTransferenciaTercerosProgramada() {
    Validacion validacion =
            theActorInTheSpotlight().recall(VERIFICAR_TRANSACCION.getVariableSesion());
    theActorInTheSpotlight().attemptsTo(Esperar.unTiempo(8000));
    theActorInTheSpotlight()
            .should(
                    seeThat(
                            VerificarTransaccionTercerosProgramada.exitosa(
                                    validacion, MENSAJE_EXITOSO_TRANSFERENCIA_PROGRAMADA.getMensaje()))
                            .orComplainWith(PagoProgramadoExitosoException.class, PAGO_PROGRAMADO_NO_EXITOSO));
  }
}
