package com.banistmo.certificacion.questions.configuracion.notificaciones;

import static com.banistmo.certificacion.task.configuracion.notificaciones.GuardarNuevaConfiguracion.*;
import static com.banistmo.certificacion.userinterface.configuracion.administracion.AdministracionPage.BTN_ADMINISTRAR_NOTIFICACIONES;
import static com.banistmo.certificacion.userinterface.configuracion.administracion.AdministrarNotificacionesPage.OPC_MENU;
import static com.banistmo.certificacion.userinterface.configuracion.seguridad.CambiarImagenFrasePage.BTN_REGRESAR;
import static com.banistmo.certificacion.userinterface.menu.MenuPage.*;
import static com.banistmo.certificacion.utils.enums.EnumVariablesSesion.VERIFICAR_CONFIGURACION_ACTUAL;
import static com.banistmo.certificacion.utils.enums.EnumVariablesSesion.VERIFICAR_CONFIGURACION_NUEVA;

import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import com.banistmo.certificacion.models.comun.Validacion;
import com.banistmo.certificacion.task.configuracion.Ingresar;
import com.banistmo.certificacion.utils.enums.EnumTexto;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.ensure.Ensure;

public class VerificarDatosNotificacion implements Question<Boolean> {

  private Validacion validacionNuevos;
  private String nombreMenu;
  private String opcion;
  private String monto;
  private String activa;
  private String medio;

  public static VerificarDatosNotificacion nuevos() {
    return new VerificarDatosNotificacion();
  }

  @Override
  public Boolean answeredBy(Actor actor) {
    String textoSi = "Sí";
    validacionNuevos = actor.recall(VERIFICAR_CONFIGURACION_NUEVA.getVariableSesion());
    nombreMenu = validacionNuevos.getDatosNotificacion().getMenu();
    opcion = validacionNuevos.getDatosNotificacion().getOpcion();
    monto = validacionNuevos.getDatosNotificacion().getMonto();
    activa = validacionNuevos.getDatosNotificacion().getActiva();
    medio = validacionNuevos.getDatosNotificacion().getMedioNotificacion();
    actor
        .describedAs("Refrescar informacion")
        .attemptsTo(
            Click.on(BTN_REGRESAR),
                Click.on(BTN_MIS_PRODUCTOS),
                Ingresar.aConfiguracion(
                        EnumTexto.TEXTO_CONFIGURACION.getTexto(), BTN_ADMINISTRAR_NOTIFICACIONES),
            EsperarElemento.esClickable(OPC_MENU.of(nombreMenu)),
            Click.on(OPC_MENU.of(nombreMenu)));
    actor.asksFor(
        ObtenerConfiguracion.actual(
            nombreMenu, opcion, VERIFICAR_CONFIGURACION_ACTUAL.getVariableSesion()));

    Validacion datosActuales = actor.recall(VERIFICAR_CONFIGURACION_ACTUAL.getVariableSesion());

    if (activa.equalsIgnoreCase(TEXTO_SI)) {
      validacionNuevos.getDatosNotificacion().setActiva(TEXTO_TRUE);
      activa = TEXTO_TRUE;
    } else {
      validacionNuevos.getDatosNotificacion().setActiva(TEXTO_FALSE);
      activa = TEXTO_FALSE;
    }

    actor.attemptsTo(
        Check.whether(
                validacionNuevos.getDatosNotificacion().getActiva().equalsIgnoreCase(TEXTO_SI)
                    || validacionNuevos.getDatosNotificacion().getActiva().equalsIgnoreCase(textoSi)
                    || validacionNuevos
                        .getDatosNotificacion()
                        .getActiva()
                        .equalsIgnoreCase(TEXTO_TRUE))
            .andIfSo(
                Ensure.that(medio)
                    .contains(datosActuales.getDatosNotificacion().getMedioNotificacion()),
                Ensure.that(monto)
                    .contains(datosActuales.getDatosNotificacion().getMonto().replace("$", "")),
                Ensure.that(activa).contains(datosActuales.getDatosNotificacion().getActiva()))
            .otherwise(
                Ensure.that(activa).contains(datosActuales.getDatosNotificacion().getActiva())));
    return true;
  }
}
