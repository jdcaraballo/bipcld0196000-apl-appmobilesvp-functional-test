package com.banistmo.certificacion.task.configuracion.notificaciones;

import static com.banistmo.certificacion.userinterface.configuracion.administracion.AdministrarNotificacionesPage.BTN_CONTINUAR;
import static com.banistmo.certificacion.userinterface.configuracion.notificaciones.DatosAdministrarNotificacionesPage.LBL_COMPLETADO;
import static com.banistmo.certificacion.utils.enums.EnumVariablesSesion.VERIFICAR_CONFIGURACION_INICIAL;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import com.banistmo.certificacion.models.comun.Validacion;
import com.banistmo.certificacion.models.notificaciones.DatosNotificacionBuilder;
import net.serenitybdd.markers.IsSilent;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class RevertirCambios implements IsSilent, Task {
  public static RevertirCambios ahora() {
    return instrumented(RevertirCambios.class);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    Validacion datosIniciales = actor.recall(VERIFICAR_CONFIGURACION_INICIAL.getVariableSesion());
    actor.attemptsTo(
        ModificarDatos.notificaciones(
            DatosNotificacionBuilder.con()
                .menu(datosIniciales.getDatosNotificacion().getMenu())
                .opcion(datosIniciales.getDatosNotificacion().getOpcion())
                .activa(datosIniciales.getDatosNotificacion().getActiva())
                .medioNotificacion(datosIniciales.getDatosNotificacion().getMedioNotificacion())
                .monto(datosIniciales.getDatosNotificacion().getMonto())));
    actor.attemptsTo(
        Click.on(BTN_CONTINUAR),
        Click.on(BTN_CONTINUAR),
        EsperarElemento.esVisible(LBL_COMPLETADO));
  }
}
