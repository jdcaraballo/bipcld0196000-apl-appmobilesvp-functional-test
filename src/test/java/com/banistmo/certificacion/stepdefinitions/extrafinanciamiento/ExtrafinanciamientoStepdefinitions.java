package com.banistmo.certificacion.stepdefinitions.extrafinanciamiento;

import static com.banistmo.certificacion.exceptions.extrafinanciamiento.ExtrafinanciamientoException.*;
import static com.banistmo.certificacion.models.builders.TransaccionBuilder.con;
import static com.banistmo.certificacion.utils.enums.EnumMensajes.TRANSACCION_EXITOSA;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import com.banistmo.certificacion.exceptions.extrafinanciamiento.ExtrafinanciamientoException;
import com.banistmo.certificacion.questions.VerificarMensaje;
import com.banistmo.certificacion.questions.extrafinanciamiento.MensajeDeExtrafinanciamiento;
import com.banistmo.certificacion.questions.extrafinanciamiento.VerificarDatosExtrafinanciamiento;
import com.banistmo.certificacion.questions.extrafinanciamiento.VerificarSaldo;
import com.banistmo.certificacion.task.comunes.Terminar;
import com.banistmo.certificacion.task.extrafinanciamiento.LlenarSolicitudDeExtrafinanciamiento;
import com.banistmo.certificacion.userinterface.PrincipalPage;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;
import net.serenitybdd.screenplay.ensure.Ensure;

public class ExtrafinanciamientoStepdefinitions {

  @Cuando("^el selecciona la opcion verDespues en el mensaje de extrafinanciamiento aprobado$")
  public void selecionaOpcionVerDespues() {
    theActorInTheSpotlight()
        .attemptsTo(
            com.banistmo.certificacion.task.extrafinanciamiento.MensajeDeExtrafinanciamiento
                .verDespues());
  }

  @Entonces("^el no deberia ver el mensaje de extrafinanciamiento$")
  public void noVeMensajeDeExtrafinanciamiento() {
    theActorInTheSpotlight()
        .attemptsTo(Ensure.that(PrincipalPage.LBL_MENSAJE_EXTRAFINANCIAMIENTO).isNotDisplayed());
  }

  @Entonces("^el deberia ver el mensaje de extrafinanciamiento$")
  public void veMensajeDeExtrafinanciamiento() {
    theActorInTheSpotlight()
        .should(
            seeThat(MensajeDeExtrafinanciamiento.reaparece())
                .orComplainWith(ExtrafinanciamientoException.class, MENSAJE_NO_VISIBLE));
  }

  @Cuando(
      "^el solicita el extrafinanciamiento por (.*) dolares a (.*) cuotas con descripcion (.*)$")
  public void solicitaExtrafinanciamiento(String monto, String cuotas, String descripcion) {
    theActorInTheSpotlight()
        .attemptsTo(
            LlenarSolicitudDeExtrafinanciamiento.conLosDatos(
                con().monto(monto).descripcion(descripcion).cuotas(cuotas)));
  }

  @Entonces("^el usuario verifica que el saldo de su cuenta no se modifico$")
  public void verificaSaldoDeLaCuentaNoSeModifica() {
    theActorInTheSpotlight()
        .should(
            seeThat(VerificarSaldo.inicial())
                .orComplainWith(ExtrafinanciamientoException.class, SALDO_INICIAL_DIFERENTE));
  }

  @Entonces("^el verifica que los datos del extrafinanciamiento$")
  public void verificarDatosExtrafinanciamiento() {
    theActorInTheSpotlight()
        .should(
            seeThat(VerificarMensaje.esVisible(TRANSACCION_EXITOSA.getMensaje()))
                .orComplainWith(ExtrafinanciamientoException.class, MENSAJE_EXITOSO_NO_VISIBLE),
            seeThat(VerificarDatosExtrafinanciamiento.solicitado())
                .orComplainWith(ExtrafinanciamientoException.class, DATOS_COMPROBANTE_ERRADOS));
  }

  @Y("^el verifica que el saldo de la cuenta aumentó en el monto aprobado$")
  public void verificarSaldoDeLaCuentaAumento() {
    theActorInTheSpotlight()
        .should(
            seeThat(VerificarSaldo.nuevo())
                .orComplainWith(ExtrafinanciamientoException.class, NUEVO_SALDO_ERRADO));
  }

  @Y("^el termina la transaccion de extrafinanciamiento$")
  public void elTerminaLaTransaccionDeExtrafinanciamiento() {
    theActorInTheSpotlight().attemptsTo(Terminar.extrafinanciamiento());
  }
}
