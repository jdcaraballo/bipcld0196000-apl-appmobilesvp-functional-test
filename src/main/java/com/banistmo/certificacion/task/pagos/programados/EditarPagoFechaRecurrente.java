package com.banistmo.certificacion.task.pagos.programados;

import static com.banistmo.certificacion.userinterface.comunes.EditarProgramadoPage.*;
import static com.banistmo.certificacion.userinterface.comunes.TransaccionesGeneralPage.*;
import static com.banistmo.certificacion.utils.UtileriaDriver.getPlataformaEjecucion;
import static com.banistmo.certificacion.utils.enums.EnumVariablesSesion.VERIFICAR_TRANSACCION;

import com.banistmo.certificacion.interactions.*;
import com.banistmo.certificacion.interactions.esperas.Esperar;
import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import com.banistmo.certificacion.models.comun.Transaccion;
import com.banistmo.certificacion.models.comun.Validacion;
import com.banistmo.certificacion.questions.ObtenerValor;
import com.banistmo.certificacion.task.configuracion.favoritos.SeleccionarOpcion;
import com.banistmo.certificacion.userinterface.comunes.EditarProgramadoPage;
import com.banistmo.certificacion.userinterface.comunes.TransaccionesGeneralPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;

public class EditarPagoFechaRecurrente implements Task {
  private Transaccion edicion;

  public EditarPagoFechaRecurrente(Transaccion edicion) {
    this.edicion = edicion;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    Validacion datosIngresados = actor.recall(VERIFICAR_TRANSACCION.getVariableSesion());
    actor.attemptsTo(
        SeleccionarOpcion.conDescripcion(datosIngresados.getProducto().getDescripcion()),
        Limpiar.campo(TXT_MONTO),
        Escribir.valorPlataforma(edicion.getProducto().getMonto(), TXT_MONTO),
        Limpiar.campo(TXT_DESCRIPCION_EDITAR),
        Enter.theValue(edicion.getProducto().getDescripcion()).into(TXT_DESCRIPCION_EDITAR),
        EsperarCarga.desaparezca(),
        EsperarElemento.esClickable(BTN_FRECUENCIA_EDITAR),
        Click.on(BTN_FRECUENCIA_EDITAR),
        EsperarElemento.esClickable(LST_TIPO),
        SelecionarLista.unaOpcion(edicion.getProducto().getFrecuencia(), LST_TIPO, true),
        EsperarCarga.desaparezca(),
        Click.on(botonDiaPorFrecuencia(edicion.getProducto().getFrecuencia())),
        EsperarElemento.esClickable(LST_TIPO),
        SelecionarLista.unaOpcion(edicion.getProducto().getDiaRecurrente(), LST_TIPO, true),
        EsperarCarga.desaparezca(),
        Check.whether("iOS".equalsIgnoreCase(getPlataformaEjecucion()))
            .andIfSo(ClickCambiando.elContexto(BTN_CALENDARIO_FINAL_NATIVO_IOS))
            .otherwise(Click.on(BTN_CALENDARIO_FECHA_FINAL_EDITAR)),
        SeleccionarFechaFutura.enCalendario(datosIngresados.getProducto().getDiasFinal()));
    obtenerDatosEditarRecurrente(actor);
    actor.attemptsTo(
        Click.on(TransaccionesGeneralPage.BTN_CONTINUAR),
        Esperar.unTiempo(3000),
        EsperarCarga.desaparezca());
  }

  private Target botonDiaPorFrecuencia(String frecuencia) {
    final String FRECUENCIA_SEMANAL = "Semanal";
    final String FRECUENCIA_QUINCENAL = "Quincenal";
    final String FRECUENCIA_MENSUAL = "Mensual";
    switch (frecuencia) {
      case FRECUENCIA_SEMANAL:
        return EditarProgramadoPage.BTN_DIA_FRECUENCIA_SEMANAL_EDITAR;
      case FRECUENCIA_QUINCENAL:
        return EditarProgramadoPage.BTN_DIA_FRECUENCIA_QUINCENAL_EDITAR;
      case FRECUENCIA_MENSUAL:
        return EditarProgramadoPage.BTN_DIA_FRECUENCIA_MENSUAL_EDITAR;
      default:
        return null;
    }
  }

  private void obtenerDatosEditarRecurrente(Actor actor) {
    Validacion validacion = actor.recall(VERIFICAR_TRANSACCION.getVariableSesion());
    validacion.getProducto().setTipoTransaccion("Recurrente");
    validacion.getProducto().setMonto(TXT_MONTO.resolveFor(actor).getValue());
    validacion.getProducto().setDescripcion(TXT_DESCRIPCION_EDITAR.resolveFor(actor).getValue());
    validacion
        .getProducto()
        .setFrecuencia(Text.of(TXT_FRECUENCIA_EDITAR).viewedBy(actor).asString());
    validacion
        .getProducto()
        .setDiaRecurrente(Text.of(TXT_DIA_SEMANAL_EDITAR).viewedBy(actor).asString());
    validacion
        .getProducto()
        .setFechaFuturoFin(
            ObtenerValor.elemento(TXT_CALENDARIO_FECHA_FINAL_EDITAR).answeredBy(actor));
    actor.remember(VERIFICAR_TRANSACCION.getVariableSesion(), validacion);
  }
}
