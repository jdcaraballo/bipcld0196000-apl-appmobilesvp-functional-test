package com.banistmo.certificacion.stepdefinitions.autenticacion;

import com.banistmo.certificacion.exceptions.autenticacion.MensajeErrorNoVisualizadoExeption;
import com.banistmo.certificacion.questions.VerificarMensaje;
import com.banistmo.certificacion.task.autenticacion.recuperarusuario.*;
import com.banistmo.certificacion.task.comunes.transaccion.IngresarDatos;
import com.banistmo.certificacion.userinterface.autenticacion.RecuperarUsuarioPage;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;
import net.serenitybdd.screenplay.ensure.Ensure;

import java.util.List;
import java.util.Map;

import static com.banistmo.certificacion.exceptions.autenticacion.MensajeErrorNoVisualizadoExeption.MENSAJE_ERROR_NO_ENCONTRADO;
import static com.banistmo.certificacion.utils.costantes.MensajesCostante.MENSAJE_RECUPERACION_USUARIO_EXITOSO;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class OlvidoUsuarioStepdefinitions {

  @Dado("^que (.*) quiere recordar su usuario de Banca en Linea Personas$")
  public void cargarOlvidoUsuario(String nombreActor) {
    theActorCalled(nombreActor).attemptsTo(IniciarOlvidoUsuario.enSvp());
  }

  @Cuando("^el ingresa los datos del proceso de recuperacion de usuario$")
  public void llenarDatosOlvidoUsuario(List<Map<String, String>> datos) {
    theActorInTheSpotlight().attemptsTo(IngresarDatos.recuperarUsuario(datos));
  }

  @Cuando("^el ingresa el correo registrado: (.*)$")
  public void ingresarCorreoRegistrado(String correo) {
    theActorInTheSpotlight().attemptsTo(IngresarCorreo.deUsuario(correo));
  }

  @Cuando("^el ingresa el código de recibido en el correo con información: (.*)$")
  public void consultaCodigoCorreoToken(String informacionDelCorreo) {
    theActorInTheSpotlight().attemptsTo(IngresarCodigo.inscripcionToken(informacionDelCorreo));
  }

  @Cuando("^el ingresa el código de recibido en el correo con la información: (.*)$")
  public void consultaCodigoCorreoOlvidoUsuario(String informacionDelCorreo) {
    theActorInTheSpotlight().attemptsTo(IngresarElCodigo.correo(informacionDelCorreo));
  }

  @Cuando("^el ingresa el código de recibido al correo con la información: (.*)$")
  public void consultaCodigoCorreoCambioClave(String informacionDelCorreo) {
    theActorInTheSpotlight().attemptsTo(IngresarElCodigo.correo(informacionDelCorreo));
  }

  @Entonces("^el puede ver el usuario (.*) en pantalla$")
  public void verificarUsuarioRecuperado(String usuarioRecuperado) {
    theActorInTheSpotlight()
        .should(seeThat(VerificarMensaje.esVisible(MENSAJE_RECUPERACION_USUARIO_EXITOSO)));
    theActorInTheSpotlight()
        .attemptsTo(
            Ensure.that(RecuperarUsuarioPage.LBL_USUARIO_RECUPERADO)
                .text()
                .containsIgnoringCase(usuarioRecuperado));
  }

  @Entonces("deberia ver el mensaje de error El estado de tu boleta es: (.*)")
  public void verificarMensajeError(String mensajeError) {
    theActorInTheSpotlight()
            .should(
                    seeThat(VerificarMensaje.esVisible(mensajeError))
                            .orComplainWith(
                                    MensajeErrorNoVisualizadoExeption.class, MENSAJE_ERROR_NO_ENCONTRADO));
  }


  @Y("^el ingresa un codigo aleatorio$")
  public void ingresaCodigoAleatorio() {}
}

