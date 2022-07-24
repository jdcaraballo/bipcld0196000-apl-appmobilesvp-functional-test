package com.banistmo.certificacion.stepdefinitions.configuracion.seguridad;

import static com.banistmo.certificacion.exceptions.configuracion.seguridad.CambioImagenFraseException.ERROR_CAMBIO_IMAGE_FRASE;
import static com.banistmo.certificacion.userinterface.configuracion.seguridad.CambiarImagenFrasePage.SUB_OPT_CAMBIO_IMAGEN_FRASE;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import com.banistmo.certificacion.exceptions.configuracion.seguridad.CambioImagenFraseException;
import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import com.banistmo.certificacion.questions.configuracion.seguridad.DatosImagenFrase;
import com.banistmo.certificacion.task.configuracion.Aplicar;
import com.banistmo.certificacion.task.configuracion.Cambiar;
import com.banistmo.certificacion.task.configuracion.IngresarAConfiguracion;
import com.banistmo.certificacion.utils.enums.EnumTexto;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;

public class CambioImagenFraseStepDefinition {
  @Cuando("^el realiza el cambio de imagen y nueva frase de seguridad (.*)$")
  public void cambioImagenFraseDeSeguridad(String nuevaFrase) {
    theActorInTheSpotlight().attemptsTo(
            IngresarAConfiguracion.deSeguridad(
                    EnumTexto.TEXTO_SEGURIDAD.getTexto(), SUB_OPT_CAMBIO_IMAGEN_FRASE),
            EsperarCarga.desaparezca(),
                    Cambiar.imagenFrase(nuevaFrase));
  }

  @Entonces("^el confirma que los datos de seguridad fueron modificados exitosamente$")
  public void confirmarDatosDeSeguridadModificadosExitosamente() {
    theActorInTheSpotlight()
        .should(
            seeThat(DatosImagenFrase.nuevos())
                .orComplainWith(CambioImagenFraseException.class, ERROR_CAMBIO_IMAGE_FRASE));
  }

  @Y("^el (.*) los cambios realizados de imagen y frase$")
  public void aplicarCambiosImagenFrase(String accion) {
    theActorInTheSpotlight().attemptsTo(Aplicar.cambioImagenFrase(accion));
  }

  @Entonces("^el puede ver que los datos de seguridad no fueron modificados$")
  public void verificaLosDatosDeSeguridadNoModificados() {
    theActorInTheSpotlight().should(seeThat(DatosImagenFrase.sinCambio()));
  }
}
