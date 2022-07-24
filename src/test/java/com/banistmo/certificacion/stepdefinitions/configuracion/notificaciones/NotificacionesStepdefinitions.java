package com.banistmo.certificacion.stepdefinitions.configuracion.notificaciones;

import static com.banistmo.certificacion.userinterface.configuracion.administracion.AdministracionPage.BTN_ADMINISTRAR_NOTIFICACIONES;
import static com.banistmo.certificacion.utils.enums.EnumMensajes.GUARDADO_CORRECTAMENTE;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import com.banistmo.certificacion.models.notificaciones.DatosNotificacionBuilder;
import com.banistmo.certificacion.questions.VerificarMensaje;
import com.banistmo.certificacion.questions.configuracion.notificaciones.VerificarDatosNotificacion;
import com.banistmo.certificacion.task.configuracion.Ingresar;
import com.banistmo.certificacion.task.configuracion.notificaciones.GuardarNuevaConfiguracion;
import com.banistmo.certificacion.task.configuracion.notificaciones.ModificarDatos;
import com.banistmo.certificacion.task.configuracion.notificaciones.RevertirCambios;
import com.banistmo.certificacion.utils.enums.EnumTexto;
import cucumber.api.java.ast.Cuando;
import cucumber.api.java.es.Entonces;
import java.util.List;
import java.util.Map;

public class NotificacionesStepdefinitions {

  @Cuando("^el modifica los datos de la configuracion de notificaciones$")
  public void modificarDatosNotificaciones(List<Map<String, String>> datos) {
    theActorInTheSpotlight()
        .attemptsTo(
            Ingresar.aConfiguracion(
                EnumTexto.TEXTO_CONFIGURACION.getTexto(), BTN_ADMINISTRAR_NOTIFICACIONES),
            ModificarDatos.notificaciones(
                DatosNotificacionBuilder.con()
                    .menu(datos)
                    .opcion(datos)
                    .activa(datos)
                    .medioNotificacion(datos)
                    .monto(datos)));
  }

  @Cuando("^el guarda los cambios realizados en notificaciones$")
  public void guardarCambiosNotificaciones() {
    theActorInTheSpotlight().attemptsTo(GuardarNuevaConfiguracion.exitosamente());
  }

  @Entonces("^el puede observar los cambios en la configuración de notificaciones$")
  public void verificarCambiosRealizados() {
    theActorInTheSpotlight()
        .should(
            seeThat(VerificarMensaje.esVisible(GUARDADO_CORRECTAMENTE.getMensaje())),
            seeThat(VerificarDatosNotificacion.nuevos()));
    theActorInTheSpotlight().has(RevertirCambios.ahora());
  }
}
