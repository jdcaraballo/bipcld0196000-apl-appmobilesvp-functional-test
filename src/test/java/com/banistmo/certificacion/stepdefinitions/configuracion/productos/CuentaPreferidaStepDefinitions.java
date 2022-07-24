package com.banistmo.certificacion.stepdefinitions.configuracion.productos;

import static com.banistmo.certificacion.exceptions.configuracion.productos.CuentaPreferidaNoConfiguradaException.CUENTA_PREFERIDA_NO_CONFIGURADA;
import static com.banistmo.certificacion.userinterface.configuracion.administracion.AdministracionPage.BTN_CONFIGURAR_PRODUCTOS;
import static com.banistmo.certificacion.userinterface.menu.MenuPage.*;
import static com.banistmo.certificacion.userinterface.menu.MenuTransferenciasPage.BTN_ENTRE_CUENTAS_PROPIAS;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import com.banistmo.certificacion.exceptions.configuracion.productos.CuentaPreferidaNoConfiguradaException;
import com.banistmo.certificacion.interactions.Regresar;
import com.banistmo.certificacion.questions.configuracion.productos.VerificarProducto;
import com.banistmo.certificacion.task.comunes.Retroceder;
import com.banistmo.certificacion.task.configuracion.Entrar;
import com.banistmo.certificacion.task.configuracion.productos.preferida.CuentaPreferida;
import com.banistmo.certificacion.task.configuracion.productos.preferida.VerficarPreferida;
import com.banistmo.certificacion.task.menu.IngresarOpcion;
import com.banistmo.certificacion.utils.enums.EnumTexto;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;
import net.serenitybdd.screenplay.actions.Click;

public class CuentaPreferidaStepDefinitions {

  @Y("^el revisa que (.*) existe ninguna cuenta propia marcada como preferida$")
  public void elUsuarioAccedeALaConfiguracionDeCuentaasPropias(String condicion) {
    theActorInTheSpotlight().attemptsTo(VerficarPreferida.cuentaPropia(condicion));
  }

  @Cuando("^el (.*) una cuenta como preferida$")
  public void elUsuarioSeleccionaUnaCuentaComoPreferida(String accion) {
    theActorInTheSpotlight()
        .attemptsTo(
            Entrar.aConfiguracion(
                EnumTexto.TEXTO_ADMINISTRACION.getTexto(), BTN_CONFIGURAR_PRODUCTOS),
                Retroceder.hastaPantallaInicio(),
            CuentaPreferida.desdeConfiguracion(accion));
  }

  @Cuando("^el (.*) una cuenta como preferida desde detalles$")
  public void elUsuarioSeleccionaUnaCuentaComoPreferidaDesdeDetalles(String accion) {
    theActorInTheSpotlight().attemptsTo(CuentaPreferida.desdeDetalles(accion));
  }

  @Entonces("^el observa que la cuenta seleccionada queda como la preferida$")
  public void elUsuarioVerificaQueLaCuentaSeleccionadaQuedeComoLaPreferida() {
    theActorInTheSpotlight()
        .attemptsTo(Regresar.pantallaAnterior(), Click.on(BTN_MIS_PRODUCTOS),
                IngresarOpcion.delMenu(BTN_TRANSFERENCIAS, BTN_ENTRE_CUENTAS_PROPIAS));
    theActorInTheSpotlight()
        .should(
            seeThat(VerificarProducto.preferido())
                .orComplainWith(
                    CuentaPreferidaNoConfiguradaException.class, CUENTA_PREFERIDA_NO_CONFIGURADA));

  }  @Entonces("^el observa que la cuenta seleccionada queda como la preferida desde el home$")
  public void elUsuarioVerificaQueLaCuentaSeleccionadaQuedeComoLaPreferidaDesdeElHome$() {
    theActorInTheSpotlight()
        .attemptsTo(
                IngresarOpcion.delMenu(BTN_TRANSFERENCIAS, BTN_ENTRE_CUENTAS_PROPIAS));
    theActorInTheSpotlight()
        .should(
            seeThat(VerificarProducto.preferido())
                .orComplainWith(
                    CuentaPreferidaNoConfiguradaException.class, CUENTA_PREFERIDA_NO_CONFIGURADA));
  }
}
