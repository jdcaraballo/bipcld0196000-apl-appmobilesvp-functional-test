package com.banistmo.certificacion.stepdefinitions.configuracion.seguridad;

import static com.banistmo.certificacion.userinterface.autenticacion.RecuperarUsuarioPage.BTN_CONTINUAR_BACK_LOGIN;
import static com.banistmo.certificacion.userinterface.configuracion.seguridad.SeguridadPage.BTN_CAMBIAR_CONTRASENA;
import static com.banistmo.certificacion.utils.costantes.MensajesCostante.MENSAJE_CAMBIO_DECLAVE_EXITOSO;
import static com.banistmo.certificacion.utils.enums.EnumVariablesSesion.CONTRASENA;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import com.banistmo.certificacion.questions.VerificarMensaje;
import com.banistmo.certificacion.task.autenticacion.iniciosesion.IngresarUsuario;
import com.banistmo.certificacion.task.configuracion.IngresarAConfiguracion;
import com.banistmo.certificacion.task.configuracion.seguridad.CambiarContrasena;
import com.banistmo.certificacion.task.configuracion.seguridad.olvido.clave.IngresarCambioDeClave;
import com.banistmo.certificacion.utils.enums.EnumTexto;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Y;
import net.serenitybdd.screenplay.actions.Click;

public class CambioContrasenaStepDefinitions {

  @Cuando("el cambia la contraseña por (.*)")
  public void cambiarContrasena(String contrasena) {
    String clave = theActorInTheSpotlight().recall(CONTRASENA.getVariableSesion());
    cambioContrasena(clave, contrasena);
  }

  @Cuando("realiza el cambio de clave por (.*) desde la pantalla login")
  public void cambiarClaveDesdeElHome(String contrasenaNueva) {
    theActorInTheSpotlight().attemptsTo(IngresarCambioDeClave.nueva(contrasenaNueva));
  }

  @Y("observa el mensaje de cambio de contraseña exitoso")
  public void confirmarCambioDeClave() {
    theActorInTheSpotlight()
            .should(seeThat(VerificarMensaje.esVisible(MENSAJE_CAMBIO_DECLAVE_EXITOSO)));
    theActorInTheSpotlight().attemptsTo(Click.on(BTN_CONTINUAR_BACK_LOGIN));
  }

  @Cuando("que (.*) quiere recuperar su contrase con el usuario: (.*)")
    public void cambiarContrasenaDesdeElLogin(String nombreActor, String usuario) {
      theActorCalled(nombreActor).attemptsTo(IngresarUsuario.enSvp(usuario));
    }

  public static void cambioContrasena(String contrasenaActual, String contrasenaNueva) {
    theActorInTheSpotlight()
        .attemptsTo(

            IngresarAConfiguracion.deSeguridad(EnumTexto.TEXTO_SEGURIDAD.getTexto(), BTN_CAMBIAR_CONTRASENA),
            CambiarContrasena.porUnaNueva(contrasenaActual, contrasenaNueva));
  }
}
