package com.banistmo.certificacion.stepdefinitions.recargas;

import static com.banistmo.certificacion.exceptions.recargas.RecargaExitosaException.RECARGA_NO_EXITOSA;
import static com.banistmo.certificacion.models.builders.RecargasBuilder.con;
import static com.banistmo.certificacion.userinterface.menu.MenuPage.BTN_RECARGAS;
import static com.banistmo.certificacion.userinterface.menu.MenuRecargasPage.*;
import static com.banistmo.certificacion.utils.enums.EnumMensajes.RECARGA_EXITOSA;
import static com.banistmo.certificacion.utils.enums.EnumVariablesSesion.VERIFICAR_TRANSACCION;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import com.banistmo.certificacion.exceptions.recargas.RecargaExitosaException;
import com.banistmo.certificacion.interactions.esperas.Esperar;
import com.banistmo.certificacion.models.comun.Validacion;
import com.banistmo.certificacion.questions.recargas.VerificarRecarga;
import com.banistmo.certificacion.task.menu.IngresarOpcion;
import com.banistmo.certificacion.task.recargas.RealizarRecarga;
import cucumber.api.java.ast.Cuando;
import cucumber.api.java.es.Entonces;
import java.util.List;
import java.util.Map;

public class RecargasStepDefinition {


    @Cuando("el intenta realizar una recarga con a Claro")
  public void recargaOperadorMobilClaro(List<Map<String, String>> datos) {
    theActorInTheSpotlight().attemptsTo(
                    IngresarOpcion.delMenu(BTN_RECARGAS, BTN_CLARO),
                    RealizarRecarga.nueva(con().numeroCelular(datos).monto(datos)));
  }

  @Cuando("el intenta realizar una recarga de claro guardada con un monto: (.*)")
  public void recargaAClaroGuardado(String datos) {
    theActorInTheSpotlight().attemptsTo(
            IngresarOpcion.delMenu(BTN_RECARGAS, BTN_CLARO),
                    RealizarRecarga.guardada(con().monto(datos).nombreOperador("Claro")));
  }

    @Cuando("el intenta realizar una recarga con a Digicel")
  public void recargaOperadorMobilDigicel(List<Map<String, String>> datos) {
    theActorInTheSpotlight().attemptsTo(
                    IngresarOpcion.delMenu(BTN_RECARGAS, BTN_DIGICEL),
                    RealizarRecarga.nueva(con().numeroCelular(datos).monto(datos)));
  }

  @Cuando("el intenta realizar una recarga de Digicel guardada con un monto: (.*)")
  public void recargaADigicelGuardado(String datos) {
    theActorInTheSpotlight().attemptsTo(
            IngresarOpcion.delMenu(BTN_RECARGAS, BTN_DIGICEL),
            RealizarRecarga.guardada(con().monto(datos).nombreOperador("Digicel")));
  }

  @Cuando("el intenta realizar una recarga con a Más Móvil")
  public void recargaOperadorMobilMasMovil(List<Map<String, String>> datos) {
    theActorInTheSpotlight().attemptsTo(
            IngresarOpcion.delMenu(BTN_RECARGAS, BTN_MAS_MOVIL),
            RealizarRecarga.nueva(con().numeroCelular(datos).monto(datos)));
  }

  @Cuando("el intenta realizar una recarga de Mas Movil guardada con un monto: (.*)")
  public void recargaAMasMovilGuardado(String datos) {
    theActorInTheSpotlight().attemptsTo(
            IngresarOpcion.delMenu(BTN_RECARGAS, BTN_MAS_MOVIL),
            RealizarRecarga.guardada(con().monto(datos).nombreOperador("Más Móvil")));
  }

    @Cuando("el intenta realizar una recarga con a Metro y Metrobus")
  public void recargaMetrobus(List<Map<String, String>> datos) {
    theActorInTheSpotlight()
        .attemptsTo(
            IngresarOpcion.delMenu(BTN_RECARGAS, BTN_METRO_METROBUS),
                RealizarRecarga.nueva(con().numeroTarjeta(datos).monto(datos)));
  }

  @Cuando("el intenta realizar una recarga de Metro y Metrobus guardada con un monto: (.*)")
  public void recargaAMetrobusGuardado(String datos) {
    theActorInTheSpotlight().attemptsTo(
            IngresarOpcion.delMenu(BTN_RECARGAS, BTN_METRO_METROBUS),
            RealizarRecarga.guardada(con().monto(datos).nombreOperador("Metro y Metrobus")));
  }

    @Cuando("el intenta realizar una recarga con Nequi")
  public void recargaOperadorNequi(List<Map<String, String>> datos) {
    theActorInTheSpotlight().attemptsTo(
            IngresarOpcion.delMenu(BTN_RECARGAS, BTN_NEQUI),
            RealizarRecarga.nueva(con().numeroCelular(datos).monto(datos)));
  }

  @Cuando("el intenta realizar una recarga de Nequi guardada con un monto: (.*)")
  public void recargaANequiGuardado(String datos) {
    theActorInTheSpotlight().attemptsTo(
            IngresarOpcion.delMenu(BTN_RECARGAS, BTN_NEQUI),
            RealizarRecarga.guardada(con().monto(datos).nombreOperador("Nequi")));
  }

    @Cuando("el intenta realizar una recarga a Panapass")
  public void recargaPanapass(List<Map<String, String>> datos) {
    theActorInTheSpotlight()
        .attemptsTo(
            IngresarOpcion.delMenu(BTN_RECARGAS, BTN_PANAPASS),
            RealizarRecarga.nueva(con().numeroPanapass(datos).monto(datos)));
  }

  @Cuando("el intenta realizar una recarga de Panapass guardada con un monto: (.*)")
  public void recargaAPanapassGuardado(String datos) {
    theActorInTheSpotlight().attemptsTo(
            IngresarOpcion.delMenu(BTN_RECARGAS, BTN_PANAPASS),
            RealizarRecarga.guardada(con().monto(datos).nombreOperador("Panapass")));
  }

  @Cuando("el intenta realizar una recarga con a Tigo")
  public void recargaOperadorMobilTigo(List<Map<String, String>> datos) {
    theActorInTheSpotlight()
        .attemptsTo(
            IngresarOpcion.delMenu(BTN_RECARGAS, BTN_TIGO),
            RealizarRecarga.nueva(con().numeroCelular(datos).monto(datos)));
  }

  @Cuando("el intenta realizar una recarga de Tigo guardada con un monto: (.*)")
  public void recargaATigoGuardado(String datos) {
    theActorInTheSpotlight().attemptsTo(
            IngresarOpcion.delMenu(BTN_RECARGAS, BTN_TIGO),
            RealizarRecarga.guardada(con().monto(datos).nombreOperador("Tigo")));
  }

  @Entonces("la recarga deberia ser exitosa")
  public void verificarRecargaExitosa() {
    theActorInTheSpotlight().attemptsTo(Esperar.unTiempo(3000));
    theActorInTheSpotlight().recall(VERIFICAR_TRANSACCION.getVariableSesion());
    Validacion validacion =
        theActorInTheSpotlight().recall(VERIFICAR_TRANSACCION.getVariableSesion());
    theActorInTheSpotlight()
        .should(
            seeThat(VerificarRecarga.exitosa(validacion, RECARGA_EXITOSA.getMensaje()))
                .orComplainWith(RecargaExitosaException.class, RECARGA_NO_EXITOSA));
  }
}
