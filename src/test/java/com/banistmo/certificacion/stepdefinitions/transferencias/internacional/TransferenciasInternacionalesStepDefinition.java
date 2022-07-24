package com.banistmo.certificacion.stepdefinitions.transferencias.internacional;

import static com.banistmo.certificacion.exceptions.transferencia.TransferenciaExitosaException.TRANSFERENCIA_EXITOSA_NO_ENCONTRADO;
import static com.banistmo.certificacion.models.builders.TransaccionBuilder.con;
import static com.banistmo.certificacion.userinterface.menu.MenuPage.BTN_TRANSFERENCIAS;
import static com.banistmo.certificacion.userinterface.menu.MenuTransferenciasPage.BTN_INTERNACIONALES;
import static com.banistmo.certificacion.utils.enums.EnumVariablesSesion.VERIFICAR_TRANSACCION;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import com.banistmo.certificacion.exceptions.transferencia.TransferenciaExitosaException;
import com.banistmo.certificacion.models.builders.TransaccionBuilder;
import com.banistmo.certificacion.models.comun.Validacion;
import com.banistmo.certificacion.questions.transferencias.internacionales.VerificarTransaccionGuardadaInternacional;
import com.banistmo.certificacion.questions.transferencias.internacionales.VerificarTransaccionInternacional;
import com.banistmo.certificacion.task.comunes.transacciones.Modificar;
import com.banistmo.certificacion.task.menu.IngresarOpcion;
import com.banistmo.certificacion.task.transferencias.RealizarTransferencia;
import cucumber.api.java.ast.Cuando;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;
import java.util.List;
import java.util.Map;

public class TransferenciasInternacionalesStepDefinition {

  @Cuando("el intenta realizar una transferencia internacional")
  public void realizarTransferenciaInternacional(List<Map<String, String>> datos) {
    theActorInTheSpotlight()
        .attemptsTo(
            IngresarOpcion.delMenu(BTN_TRANSFERENCIAS, BTN_INTERNACIONALES),
            RealizarTransferencia.aCuentaNuevainternacional(
                con().pais(datos).banco(datos).numeroCuenta(datos).monto(datos)));
  }

  @Entonces("la transferencia internacional deberia ser exitosa")
  public void verificarTransferenciaInternacional() {
    Validacion validacion =
        theActorInTheSpotlight().recall(VERIFICAR_TRANSACCION.getVariableSesion());
    theActorInTheSpotlight()
        .should(
            seeThat(VerificarTransaccionInternacional.exitosa(validacion))
                .orComplainWith(
                    TransferenciaExitosaException.class, TRANSFERENCIA_EXITOSA_NO_ENCONTRADO));
  }

  @Cuando(
      "el intenta realizar una transaccion a una cuenta guardada internacional con un monto: (.*) y una descripcion: (.*)")
  public void verificarTransferenciaInternacionalGuardada(String monto, String descripcion) {
    theActorInTheSpotlight()
        .attemptsTo(
            IngresarOpcion.delMenu(BTN_TRANSFERENCIAS, BTN_INTERNACIONALES),
            RealizarTransferencia.aCuentainternacionalGuardada(
                con().monto(monto).descripcion(descripcion)));
  }

  @Y("el modifica los datos de la transferencia internacional")
  public void modificarTransferenciaTerceros(List<Map<String, String>> datos) {
    theActorInTheSpotlight()
        .attemptsTo(
            Modificar.transferenciaCuentasInternacional(
                TransaccionBuilder.con().monto(datos).descripcion(datos)));
  }

  @Entonces("la transferencia internacional guardada deberia ser exitosa")
  public void verificarTransferenciaGuardadaInternacional() {
    Validacion validacion =
        theActorInTheSpotlight().recall(VERIFICAR_TRANSACCION.getVariableSesion());
    theActorInTheSpotlight()
        .should(
            seeThat(VerificarTransaccionGuardadaInternacional.exitosa(validacion))
                .orComplainWith(
                    TransferenciaExitosaException.class, TRANSFERENCIA_EXITOSA_NO_ENCONTRADO));
  }
}
