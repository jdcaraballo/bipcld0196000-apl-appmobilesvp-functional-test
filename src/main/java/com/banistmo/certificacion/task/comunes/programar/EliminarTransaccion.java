package com.banistmo.certificacion.task.comunes.programar;

import static com.banistmo.certificacion.userinterface.comunes.DatosProgramacionPage.LBL_MENSAJE_EXITOSO;
import static com.banistmo.certificacion.userinterface.comunes.ProgramadasPage.BTN_CONFIRMAR_ELIMINAR_PROGRAMADA;
import static com.banistmo.certificacion.userinterface.comunes.ProgramadasPage.BTN_ELIMINAR;
import static com.banistmo.certificacion.utils.enums.EnumVariablesSesion.VERIFICAR_TRANSACCION;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import com.banistmo.certificacion.models.comun.Validacion;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class EliminarTransaccion implements Task {

  public static Performable programada() {
    return instrumented(EliminarTransaccion.class);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    Validacion datosIngresados =
        theActorInTheSpotlight().recall(VERIFICAR_TRANSACCION.getVariableSesion());
    actor.attemptsTo(
        EsperarElemento.esClickable(
            BTN_ELIMINAR.of(datosIngresados.getProducto().getDescripcion())),
        Click.on(BTN_ELIMINAR.of(datosIngresados.getProducto().getDescripcion())),
        EsperarElemento.esVisible(BTN_CONFIRMAR_ELIMINAR_PROGRAMADA),
        Click.on(BTN_CONFIRMAR_ELIMINAR_PROGRAMADA),
        EsperarElemento.esVisible(LBL_MENSAJE_EXITOSO));
  }
}
