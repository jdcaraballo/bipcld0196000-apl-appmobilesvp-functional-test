package com.banistmo.certificacion.task.configuracion.notificaciones;

import static com.banistmo.certificacion.userinterface.configuracion.administracion.AdministrarNotificacionesPage.BTN_CONTINUAR;
import static com.banistmo.certificacion.userinterface.configuracion.notificaciones.DatosAdministrarNotificacionesPage.*;
import static com.banistmo.certificacion.utils.enums.EnumVariablesSesion.VERIFICAR_CONFIGURACION_NUEVA;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.banistmo.certificacion.interactions.esperas.Esperar;
import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import com.banistmo.certificacion.models.comun.Validacion;
import java.util.List;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.ensure.Ensure;

public class GuardarNuevaConfiguracion implements Task {

  private String menu;
  private String opcion;
  private String activa;
  private String medios = "";
  private String monto;
  private Validacion validacionNuevos;
  public static final String TEXTO_SI = "Si";
  public static final String TEXTO_NO = "No";
  public static final String TEXTO_FALSE = "false";
  public static final String TEXTO_TRUE = "true";

  public static GuardarNuevaConfiguracion exitosamente() {
    return instrumented(GuardarNuevaConfiguracion.class);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    validacionNuevos = actor.recall(VERIFICAR_CONFIGURACION_NUEVA.getVariableSesion());
    actor.attemptsTo(EsperarElemento.esClickable(BTN_CONTINUAR), Click.on(BTN_CONTINUAR));
    obtenerDatosComprobante(actor);
    actor.has(
        Ensure.that(menu).contains(validacionNuevos.getDatosNotificacion().getMenu()),
        Ensure.that(opcion).contains(validacionNuevos.getDatosNotificacion().getOpcion()),
        Check.whether(!validacionNuevos.getDatosNotificacion().getActiva().equals(TEXTO_FALSE))
            .andIfSo(
                Ensure.that(activa).contains(validacionNuevos.getDatosNotificacion().getActiva()),
                Ensure.that(monto).contains(validacionNuevos.getDatosNotificacion().getMonto()),
                Ensure.that(medios)
                    .contains(
                        validacionNuevos
                            .getDatosNotificacion()
                            .getMedioNotificacion()
                            .replace(",", ""))));
    actor.attemptsTo(
        EsperarElemento.esClickable(BTN_CONTINUAR),
        Click.on(BTN_CONTINUAR),
        EsperarElemento.esVisible(LBL_COMPLETADO),
        EsperarCarga.desaparezca(),
        Esperar.unTiempo(9000));
  }

  private <T extends Actor> void obtenerDatosComprobante(T actor) {
    List<WebElementFacade> datosConfirmar = LBL_DATOS_CONFIRMACION.resolveAllFor(actor);
    List<WebElementFacade> mediosConfirmar = LBL_MEDIOS_ACTIVAR.resolveAllFor(actor);
    menu = datosConfirmar.get(0).getText().split("\\|")[0].trim();
    opcion = datosConfirmar.get(0).getText().split("\\|")[1].trim();
    activa = datosConfirmar.get(1).getText().trim().replace("í", "i");
    for (WebElementFacade webElementFacade : mediosConfirmar) {
      medios = medios.concat(webElementFacade.getText());
    }
    monto = LBL_MONTO_MINIMO.resolveFor(actor).getText().replace("$", "").trim();
    if (validacionNuevos.getDatosNotificacion().getActiva().equals(TEXTO_FALSE)) {
      validacionNuevos.getDatosNotificacion().setActiva(TEXTO_NO);
    } else {
      validacionNuevos.getDatosNotificacion().setActiva(TEXTO_SI);
    }
  }
}
