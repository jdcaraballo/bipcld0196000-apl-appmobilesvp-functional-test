package com.banistmo.certificacion.stepdefinitions.configuracion.productos;

import static com.banistmo.certificacion.exceptions.configuracion.productos.CambioAliasNoRealizadoException.CAMBIO_ALIAS_NO_REALIZADO;
import static com.banistmo.certificacion.userinterface.configuracion.administracion.AdministracionPage.BTN_CONFIGURAR_PRODUCTOS;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import com.banistmo.certificacion.exceptions.configuracion.productos.CambioAliasNoRealizadoException;
import com.banistmo.certificacion.questions.configuracion.productos.VerificarCambio;
import com.banistmo.certificacion.task.configuracion.Ingresar;
import com.banistmo.certificacion.task.configuracion.productos.alias.CambiarAlias;
import com.banistmo.certificacion.task.configuracion.productos.alias.CambiarAliasInvisible;
import com.banistmo.certificacion.task.configuracion.productos.alias.RepetirAlias;
import com.banistmo.certificacion.utils.enums.EnumTexto;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;

public class DefinirAliasStepDefinition {

  @Cuando("^el cambie el alias del producto por: (.*)$")
  public void elUsuarioSeleccionaUnaCuentaComoPreferida(String alias) {
    theActorInTheSpotlight()
        .attemptsTo(
            Ingresar.aConfiguracion(
                EnumTexto.TEXTO_CONFIGURACION.getTexto(), BTN_CONFIGURAR_PRODUCTOS),
            CambiarAlias.producto(alias));
  }

  @Cuando("^el cambie el alias del producto (.*) por: (.*)$")
  public void elUsuarioSeleccionaUnaCuentaComoPreferida(String nombreCuenta, String alias) {
    theActorInTheSpotlight()
        .attemptsTo(
            Ingresar.aConfiguracion(
                EnumTexto.TEXTO_CONFIGURACION.getTexto(), BTN_CONFIGURAR_PRODUCTOS),
            RepetirAlias.producto(nombreCuenta, alias));
  }

  @Entonces("^el observara el nuevo Alias$")
  public void verificarCambioAlias() {
    theActorInTheSpotlight()
        .should(
            seeThat(VerificarCambio.aliasProducto())
                .orComplainWith(CambioAliasNoRealizadoException.class, CAMBIO_ALIAS_NO_REALIZADO));
    theActorInTheSpotlight().attemptsTo(CambiarAliasInvisible.enElReporte());
  }



}
