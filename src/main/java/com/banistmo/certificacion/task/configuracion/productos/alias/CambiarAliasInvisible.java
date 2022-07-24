package com.banistmo.certificacion.task.configuracion.productos.alias;

import static com.banistmo.certificacion.userinterface.configuracion.administracion.producto.ConfiguracionProductoPage.*;
import static com.banistmo.certificacion.utils.enums.EnumVariablesSesion.NOMBRE_ANTERIOR;
import static com.banistmo.certificacion.utils.enums.EnumVariablesSesion.NOMBRE_NUEVO;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.banistmo.certificacion.interactions.Limpiar;
import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import com.banistmo.certificacion.questions.driver.ObtenerPlataforma;
import net.serenitybdd.markers.IsSilent;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Visibility;

public class CambiarAliasInvisible implements IsSilent, Task {

  public static CambiarAliasInvisible enElReporte() {
    return instrumented(CambiarAliasInvisible.class);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    String nombreNuevo = actor.recall(NOMBRE_NUEVO.getVariableSesion());
    String nombreAnterior = actor.recall(NOMBRE_ANTERIOR.getVariableSesion());
    cambiarNombreCuenta(actor, nombreNuevo, nombreAnterior);
    actor.attemptsTo(Ensure.that(BTN_NOMBRE_CUENTAS.of(nombreAnterior)).isDisplayed());
  }

  public static <T extends Actor> void cambiarNombreCuenta(
      T actor, String nombreNuevo, String nombreAnterior) {
    actor.attemptsTo(
        Click.on(BTN_NOMBRE_CUENTAS.of(nombreNuevo)),
        EsperarCarga.desaparezca(),
        EsperarElemento.esClickable(BTN_EDITAR_NOMBRE_CUENTA),
        Click.on(BTN_EDITAR_NOMBRE_CUENTA),
        EsperarElemento.esClickable(TXT_NOMBRE_CUENTA),
        Limpiar.campo(TXT_NOMBRE_CUENTA),
        Enter.theValue(nombreAnterior).into(TXT_NOMBRE_CUENTA),
        Click.on(LBL_VALOR_DISPONIBLE_CUENTA),
        Check.whether("iOS".equalsIgnoreCase(ObtenerPlataforma.deEjecucion().answeredBy(actor)))
            .andIfSo(Click.on(BTN_EDITAR_NOMBRE_CUENTA)),
        EsperarElemento.esClickable(BTN_GUARDAR),
        Click.on(BTN_GUARDAR));
    if (!Visibility.of(BTN_CONFIRMAR_CAMBIO).viewedBy(actor).resolveAll().isEmpty()) {
      actor.attemptsTo(Click.on(BTN_CONFIRMAR_CAMBIO));
    }
    actor.attemptsTo(EsperarCarga.desaparezca());
  }
}
