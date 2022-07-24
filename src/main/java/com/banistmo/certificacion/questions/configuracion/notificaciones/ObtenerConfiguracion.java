package com.banistmo.certificacion.questions.configuracion.notificaciones;

import static com.banistmo.certificacion.userinterface.configuracion.administracion.AdministrarNotificacionesPage.*;

import com.banistmo.certificacion.models.comun.Validacion;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Attribute;

public class ObtenerConfiguracion implements Question<Validacion> {

  private String menu;
  private String opcion;
  private String variableSesion;

  public ObtenerConfiguracion(String menu, String opcion, String variableSesion) {
    this.menu = menu;
    this.opcion = opcion;
    this.variableSesion = variableSesion;
  }

  public static ObtenerConfiguracion actual(String menu, String opcion, String variableSesion) {
    return new ObtenerConfiguracion(menu, opcion, variableSesion);
  }

  public static String valorStatusCheck(Actor actor, String opcion) {
    return Attribute.of(STS_CHK_NOTIFICACION.of(opcion))
        .named("ng-reflect-value-check")
        .viewedBy(actor)
        .resolve()
        .toString();
  }

  @Override
  public Validacion answeredBy(Actor actor) {
    Validacion datosActuales = new Validacion();
    datosActuales.getDatosNotificacion().setActiva(valorStatusCheck(actor, opcion));
    datosActuales
        .getDatosNotificacion()
        .setMedioNotificacion(
            LST_CHK_MEDIOS_ACTIVOS
                .of(opcion)
                .resolveFor(actor)
                .getAttribute("ng-reflect-value-input"));
    datosActuales
        .getDatosNotificacion()
        .setMonto(
            Attribute.of(TXT_MONTO_MINIMO_NOTIFICAR.of(opcion))
                .named("ng-reflect-model")
                .viewedBy(actor)
                .resolve()
                .toString());
    datosActuales.getDatosNotificacion().setOpcion(opcion);
    datosActuales.getDatosNotificacion().setMenu(menu);
    actor.remember(variableSesion, datosActuales);
    return datosActuales;
  }
}
