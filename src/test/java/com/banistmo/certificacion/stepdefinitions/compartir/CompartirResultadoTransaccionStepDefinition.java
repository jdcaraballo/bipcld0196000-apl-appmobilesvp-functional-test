package com.banistmo.certificacion.stepdefinitions.compartir;

import static com.banistmo.certificacion.userinterface.comunes.ConfirmacionTransaccionGeneralPage.MSG_DESCARGA_COMPLETA;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import com.banistmo.certificacion.exceptions.compartir.MensajeDescargaNoVisualizadoException;
import com.banistmo.certificacion.questions.ElementoEsperado;
import com.banistmo.certificacion.task.compartir.Compartir;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;

public class CompartirResultadoTransaccionStepDefinition {

  @Y("^el descarga (?:el|la) (.*) del resultado de la transaccion$")
  public void descargaElPDFDelResultadoDeLaTransaccion(String archivoGenerar) {
    theActorInTheSpotlight().attemptsTo(Compartir.transaccionRealizada(archivoGenerar));
  }

  @Entonces("^el deberia visualizar un mensaje con descarga exitosa$")
  public void elUsuarioDeberiaVisualizarUnMensajeConDescargaExitosa() {
    theActorInTheSpotlight()
        .should(
            seeThat(ElementoEsperado.esVisible(MSG_DESCARGA_COMPLETA))
                .orComplainWith(
                    MensajeDescargaNoVisualizadoException.class,
                    MensajeDescargaNoVisualizadoException.MENSAJE_COMPARTIR_NO_ENCONTRADO));
  }
}
