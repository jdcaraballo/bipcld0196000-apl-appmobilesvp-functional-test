package com.banistmo.certificacion.stepdefinitions.configuracion.seguridad.token;

import static com.banistmo.certificacion.exceptions.configuracion.seguridad.EliminarTokenException.ELIMINAR_TOKEN_FALLIDO;
import static com.banistmo.certificacion.exceptions.configuracion.seguridad.InscribirTokenException.INSCRIPCION_DE_TOKEN_FALLIDA;
import static com.banistmo.certificacion.userinterface.comunes.TransaccionesGeneralPage.LBL_SOFTTOKEN;
import static com.banistmo.certificacion.userinterface.comunes.TransaccionesGeneralPage.LBL_SOFTTOKEN_INCORRECTO;
import static com.banistmo.certificacion.userinterface.configuracion.seguridad.CambiarImagenFrasePage.BTN_REGRESAR;
import static com.banistmo.certificacion.utils.enums.EnumMensajes.INSCRIPCION_TOKEN_EXITOSA;
import static com.banistmo.certificacion.utils.enums.EnumMensajes.TOKEN_ELIMINADO_EXITOSO;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;

import com.banistmo.certificacion.exceptions.configuracion.seguridad.EliminarTokenException;
import com.banistmo.certificacion.exceptions.configuracion.seguridad.InscribirTokenException;
import com.banistmo.certificacion.exceptions.transferencia.TransferenciaExitosaException;
import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import com.banistmo.certificacion.questions.EsperarModalToken;
import com.banistmo.certificacion.questions.VerificarMensaje;
import com.banistmo.certificacion.questions.VerificarMensajeAlRegresar;
import com.banistmo.certificacion.questions.configuracion.seguridad.TokenEliminado;
import com.banistmo.certificacion.questions.configuracion.seguridad.UsuarioRegistrado;
import com.banistmo.certificacion.stepdefinitions.configuracion.seguridad.Volver;
import com.banistmo.certificacion.task.autenticacion.iniciosesion.IngresarCrendenciales;
import com.banistmo.certificacion.task.comunes.Terminar;
import com.banistmo.certificacion.task.comunes.TerminarCon;
import com.banistmo.certificacion.task.comunes.TerminarSin;
import com.banistmo.certificacion.task.configuracion.seguridad.EliminarToken;
import com.banistmo.certificacion.task.configuracion.seguridad.InscribirToken;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;
import net.serenitybdd.screenplay.actions.Click;

import java.util.List;
import java.util.Map;

public class InscribirTokenStepdefinitions {

  @Dado("^que (.*) quiere inscribir token con usuario (.*) y clave (.*)$")
  public void ingresarCredencialesToken(String nombreActor, String usuario, String clave) {
    theActorCalled(nombreActor).attemptsTo(IngresarCrendenciales.paraToken(usuario, clave));
  }

  @Cuando(
      "^el registra el token en el dispositivo con codigo recibido por correo y descripcion (.*)$")
  public void registrarTokenEnDispositivoCodigo(String descripcionToken) {
    theActorInTheSpotlight().attemptsTo(InscribirToken.exitoso(descripcionToken));
  }

  @Entonces("^el puede ver el usuario registrado$")
  public void verificarElUsuarioRegistrado() {
    theActorInTheSpotlight()
        .should(
            seeThat(VerificarMensaje.esVisible(INSCRIPCION_TOKEN_EXITOSA.getMensaje()))
                .orComplainWith(InscribirTokenException.class, INSCRIPCION_DE_TOKEN_FALLIDA),
            seeThat(UsuarioRegistrado.correctamente())
                .orComplainWith(InscribirTokenException.class, INSCRIPCION_DE_TOKEN_FALLIDA));
  }

  @Y("^(.*) quiere inscribir el token con usuario (.*) y clave (.*)$")
  public void ingresarLasCredencialesToken(String nombreActor, String usuario, String clave) {
    theActorCalled(nombreActor).attemptsTo(IngresarCrendenciales.paraToken(usuario, clave));
  }

  @Y("^el puede ver el usuario registrado en el menu token$")
  public void verificarElUsuarioRegistradoEnElMenuToken() {
    theActorInTheSpotlight()
        .should(
            seeThat(VerificarMensajeAlRegresar.esVisible(INSCRIPCION_TOKEN_EXITOSA.getMensaje()))
                .orComplainWith(InscribirTokenException.class, INSCRIPCION_DE_TOKEN_FALLIDA),
            seeThat(UsuarioRegistrado.correctamente())
                .orComplainWith(InscribirTokenException.class, INSCRIPCION_DE_TOKEN_FALLIDA));
    {
      theActorInTheSpotlight()
          .attemptsTo(
              EsperarElemento.esVisible(BTN_REGRESAR),
              Click.on(BTN_REGRESAR),
              Click.on(BTN_REGRESAR));
    }
  }

  @Y("^el registra el token en el dispositivo con descripcion: (.*)$")
  public void registrarTokenEnDispositivoParaLogin(String descripcionToken) {
    theActorInTheSpotlight().attemptsTo(InscribirToken.exitoso(descripcionToken), Volver.alLogin());
  }

  @Y("^el ingresa los datos registrados para obtener codigo por correo$")
  public void elIngresaLosDatosRegistradosParaObtenerCodigoPorCorreo(List<Map<String, String>> datos) {
//    theActorInTheSpotlight().attemptsTo(IngresarDatos.recuperarUsuario(datos));
  }

  @Cuando(
      "^el registra el token en el dispositivo con tarjeta debito (.*) y clave (.*) y descripcion (.*)$")
  public void registrarTokenEnDispositivoTarjetaDebito(
      String tarjetaDebito, String claveCajeroAutomatico, String descripcionToken) {
    theActorInTheSpotlight()
        .attemptsTo(InscribirToken.exitoso(tarjetaDebito, claveCajeroAutomatico, descripcionToken));
  }

  @Y("^el elimina el token registrado$")
  public void eliminarTokenRegistrado() {
    theActorInTheSpotlight().attemptsTo(EliminarToken.registrado());
  }

  @Entonces("^el verifica que el registro fue eliminado$")
  public void verRegistroEliminado() {
    theActorInTheSpotlight()
        .should(
            seeThat(VerificarMensaje.esVisible(TOKEN_ELIMINADO_EXITOSO.getMensaje()))
                .orComplainWith(EliminarTokenException.class, ELIMINAR_TOKEN_FALLIDO),
            seeThat(TokenEliminado.exitoso())
                .orComplainWith(EliminarTokenException.class, ELIMINAR_TOKEN_FALLIDO));
  }

  @Cuando("^el registra el token en el dispositivo con codigo errado (.*)$")
  public void registrarTokenEnDispositivoCodigoFallido(String codigo) {
    theActorInTheSpotlight().attemptsTo(InscribirToken.fallido(codigo));
  }

  @Cuando("^el registra el token en el dispositivo con tarjeta debito (.*) y clave (.*) errados$")
  public void registrarTokenEnDispositivoTarjetaDebitoFallido(
      String tarjetaDebito, String claveCajeroAutomatico) {
    theActorInTheSpotlight()
        .attemptsTo(InscribirToken.fallido(tarjetaDebito, claveCajeroAutomatico));
  }

  @Y("^el termina la transaccion con validacion del token$")
  public void finalizaTranssaccionConToken() {
    theActorInTheSpotlight().attemptsTo(Terminar.trasanccionConToken());
  }

  @Cuando(
      "^el registra el token en el dispositivo con codigo recibido por correo con usuario (.*) y clave (.*) y descripcion (.*)$")
  public void registrarTokenEnDispositivoConOtroUsuario(
      String otroUsuario, String claveOtroUsuario, String descripcionToken) {
    theActorInTheSpotlight()
        .attemptsTo(InscribirToken.exitosa(otroUsuario, claveOtroUsuario, descripcionToken));
  }

  @Y("^el termina de transaccionar$")
  public void elTerminaDeTransaccionar() {
    theActorInTheSpotlight().attemptsTo(TerminarSin.esperar());
  }

  @Y("^el termina de transaccionar con informacion de softtoken aleatoria$")
  public void elTerminaDeTransaccionarConValorAleatoro() {
    theActorInTheSpotlight().attemptsTo(TerminarCon.tokenAleatorio());
  }

  @Entonces("el deberia ver siguiente mensaje: (.*)")
  public void verificarMensajeMostradoEnPantalla(String mensaje) {
    theActorInTheSpotlight()
        .should(
            seeThat(EsperarModalToken.esVisible(LBL_SOFTTOKEN.of(mensaje)))
                .orComplainWith(
                    TransferenciaExitosaException.class,
                    TransferenciaExitosaException.MODAL_DE_SOFTTOKEN_NO_ENCONTRADO));
  }

  @Entonces("el vera el siguiente mensaje: (.*)")
  public void elVeraElSiguienteMensaje(String mensaje) {
    theActorInTheSpotlight()
        .should(
            seeThat(EsperarModalToken.esVisible(LBL_SOFTTOKEN_INCORRECTO.of(mensaje)))
                .orComplainWith(
                    TransferenciaExitosaException.class,
                    TransferenciaExitosaException.MODAL_DE_SOFTTOKEN_NO_ENCONTRADO));
  }
}
