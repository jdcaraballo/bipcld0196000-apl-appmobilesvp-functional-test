package com.banistmo.certificacion.stepdefinitions.configuracion.seguridad;

import static com.banistmo.certificacion.exceptions.configuracion.seguridad.NuevaPestanaException.NUEVA_PESTANIA_NO_ENCONTRADA;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import com.banistmo.certificacion.exceptions.configuracion.seguridad.NuevaPestanaException;
import com.banistmo.certificacion.questions.configuracion.seguridad.NuevaPestania;
import com.banistmo.certificacion.task.configuracion.seguridad.ActualizacionDatos;
import com.banistmo.certificacion.task.configuracion.seguridad.ActualizarDatos;
import com.banistmo.certificacion.task.configuracion.seguridad.token.ActualizarDatosHomeToken;
import com.banistmo.certificacion.task.configuracion.seguridad.token.ActualizarDatosToken;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;

public class ActualizacionDatosStepDefinition {

  @Cuando("^el se dirige a Actualización de datos$")
  public void actualizacionDeDatos() {
    theActorInTheSpotlight().attemptsTo(ActualizarDatos.desdeConfiguracion());
  }

  @Cuando("^el se dirige a Actualización de datos desde el home$")
  public void actualizacionDeDatosDesdeElHome() {
    theActorInTheSpotlight().attemptsTo(ActualizacionDatos.desdeHome());
  }

  @Cuando("^el se dirige a Actualización de datos con validacion token$")
  public void actualizacionDeDatosConToken() {
    theActorInTheSpotlight().attemptsTo(ActualizarDatosToken.desdeConfiguracion());
  }

  @Cuando("^el se dirige a Actualización de datos desde el home con validacion token$")
  public void actualizacionDeDatosDelHomeConToken() {
    theActorInTheSpotlight().attemptsTo(ActualizarDatosHomeToken.desdeHome());
  }

  @Entonces("^el puede confirmar que accede a nueva pestaña de datos del cliente$")
  public void confirmarNuevaPestaniaDatosCliente() {
    theActorInTheSpotlight()
        .should(
            seeThat(NuevaPestania.abreCorrectamente())
                .orComplainWith(NuevaPestanaException.class, NUEVA_PESTANIA_NO_ENCONTRADA));
  }
}
