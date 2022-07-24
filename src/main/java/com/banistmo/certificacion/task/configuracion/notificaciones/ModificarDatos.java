package com.banistmo.certificacion.task.configuracion.notificaciones;

import static com.banistmo.certificacion.questions.configuracion.notificaciones.ObtenerConfiguracion.valorStatusCheck;
import static com.banistmo.certificacion.task.configuracion.notificaciones.GuardarNuevaConfiguracion.TEXTO_TRUE;
import static com.banistmo.certificacion.userinterface.configuracion.administracion.AdministrarNotificacionesPage.*;
import static com.banistmo.certificacion.utils.enums.EnumVariablesSesion.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.banistmo.certificacion.interactions.Escribir;
import com.banistmo.certificacion.interactions.Limpiar;
import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import com.banistmo.certificacion.models.comun.Validacion;
import com.banistmo.certificacion.models.notificaciones.DatosNotificacion;
import com.banistmo.certificacion.models.notificaciones.DatosNotificacionBuilder;
import com.banistmo.certificacion.questions.configuracion.notificaciones.ObtenerConfiguracion;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;

public class ModificarDatos implements Task {

  private DatosNotificacion datosNuevos;
  private String nombreMenu;
  private String opcion;
  private String monto;
  private String activa;
  private String medio;

  public ModificarDatos(DatosNotificacion datosNuevos) {
    this.datosNuevos = datosNuevos;
    this.opcion = datosNuevos.getOpcion();
    this.nombreMenu = datosNuevos.getMenu();
    this.activa = datosNuevos.getActiva();
    this.monto = datosNuevos.getMonto();
    this.medio = datosNuevos.getMedioNotificacion();
  }

  public static ModificarDatos notificaciones(DatosNotificacionBuilder datosNuevos) {
    return instrumented(ModificarDatos.class, datosNuevos.build());
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        EsperarElemento.esClickable(OPC_MENU.of(nombreMenu)),
            Click.on(OPC_MENU.of(nombreMenu)));
    actor
        .describedAs("Guardo la configuración inicial")
        .asksFor(
            ObtenerConfiguracion.actual(
                nombreMenu, opcion, VERIFICAR_CONFIGURACION_INICIAL.getVariableSesion()));
    actor.attemptsTo(
        Check.whether(!valorStatusCheck(actor, opcion).equals(activa))
            .andIfSo(Click.on(CHK_NOTIFICACION.of(opcion))));
    actor.attemptsTo(
        Check.whether(activa.equals(TEXTO_TRUE))
            .andIfSo(Click.on(BTN_MEDIO.of(opcion)), ActivarMedios.notificaciones(medio, opcion)));
    actor.attemptsTo(
        Check.whether(activa.equals(TEXTO_TRUE) && !monto.isEmpty())
            .andIfSo(
                EsperarElemento.esClickable(TXT_MONTO_MINIMO_NOTIFICAR.of(opcion)),
                Limpiar.campo(TXT_MONTO_MINIMO_NOTIFICAR.of(opcion)),
                Escribir.valorPlataforma(monto, TXT_MONTO_MINIMO_NOTIFICAR.of(opcion))));

    actor.remember(VERIFICAR_CONFIGURACION_NUEVA.getVariableSesion(), new Validacion(datosNuevos));
  }
}
