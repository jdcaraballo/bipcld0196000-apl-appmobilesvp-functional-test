package com.banistmo.certificacion.task.comunes.programar;

import static com.banistmo.certificacion.userinterface.comunes.DatosProgramacionPage.LBL_FECHA_FIN_RECURRENTE;
import static com.banistmo.certificacion.userinterface.comunes.DatosProgramacionPage.LBL_FECHA_INICIO_RECURRENTE;
import static com.banistmo.certificacion.userinterface.comunes.ProgramadasPage.*;
import static com.banistmo.certificacion.userinterface.comunes.TransaccionesGeneralPage.*;
import static com.banistmo.certificacion.utils.UtileriaDriver.getPlataformaEjecucion;
import static com.banistmo.certificacion.utils.enums.EnumVariablesSesion.VERIFICAR_TRANSACCION;

import com.banistmo.certificacion.interactions.ClickCambiando;
import com.banistmo.certificacion.interactions.SeleccionarFechaFutura;
import com.banistmo.certificacion.interactions.SelecionarLista;
import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import com.banistmo.certificacion.models.comun.Validacion;
import com.banistmo.certificacion.questions.ObtenerValor;
import java.util.List;
import java.util.Map;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.targets.Target;

public class Recurrente implements Task {

  private final List<Map<String, String>> datosRecurrencia;
  private static final String RECURRENTE = "Recurrente";

  public Recurrente(List<Map<String, String>> datos) {
    this.datosRecurrencia = datos;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {

    Validacion datosProgramada = asignarDatosRecurrencia(actor, datosRecurrencia);
    actor.attemptsTo(
        EsperarCarga.desaparezca(),
        EsperarElemento.esVisible(BTN_TIPO_TRANSACCION),
        Click.on(BTN_TIPO_TRANSACCION),
        EsperarCarga.desaparezca(),
        SelecionarLista.unaOpcion(RECURRENTE, LST_TIPO, true),
        EsperarCarga.desaparezca(),
        Click.on(BTN_TIPO_FRECUENCIA),
        EsperarCarga.desaparezca(),
        SelecionarLista.unaOpcion(datosProgramada.getProducto().getFrecuencia(), LST_TIPO, true),
        EsperarCarga.desaparezca(),
        EsperarElemento.esClickable(botonDiaPor(datosProgramada.getProducto().getFrecuencia())),
        EsperarCarga.desaparezca(),
        Click.on(botonDiaPor(datosProgramada.getProducto().getFrecuencia())),
        EsperarCarga.desaparezca(),
        EsperarElemento.esClickable(LST_TIPO),
        SelecionarLista.unaOpcion(datosProgramada.getProducto().getDiaRecurrente(), LST_TIPO, true),
        EsperarCarga.desaparezca(),
        Check.whether("iOS".equalsIgnoreCase(getPlataformaEjecucion()))
            .andIfSo(ClickCambiando.elContexto(BTN_CALENDARIO_INICIAL_NATIVO_IOS))
            .otherwise(Click.on(BTN_CALENDARIO_INICIAL)),
        SeleccionarFechaFutura.enCalendario(datosProgramada.getProducto().getDiasInicial()),
        EsperarCarga.desaparezca(),
        EsperarCarga.desaparezca(),
        Check.whether("iOS".equalsIgnoreCase(getPlataformaEjecucion()))
            .andIfSo(ClickCambiando.elContexto(BTN_CALENDARIO_FINAL_NATIVO_IOS))
            .otherwise(Click.on(BTN_CALENDARIO_FINAL)),
        SeleccionarFechaFutura.enCalendario(datosProgramada.getProducto().getDiasFinal()),
        EsperarCarga.desaparezca());
    obtenerDatosRecurrente(actor, datosProgramada);
  }

  private Validacion asignarDatosRecurrencia(
      Actor actor, List<Map<String, String>> datosRecurrencia) {
    Validacion datosProgramada = actor.recall(VERIFICAR_TRANSACCION.getVariableSesion());
    datosProgramada.getProducto().setFrecuencia(datosRecurrencia.get(0).get("Frecuencia"));
    datosProgramada.getProducto().setDiaRecurrente(datosRecurrencia.get(0).get("Dia"));
    datosProgramada.getProducto().setDiasFinal(datosRecurrencia.get(0).get("Dias final"));
    datosProgramada.getProducto().setDiasInicial(datosRecurrencia.get(0).get("Dias inicial"));
    return datosProgramada;
  }

  private Target botonDiaPor(String frecuencia) {
    final String FRECUENCIA_SEMANAL = "Semanal";
    final String FRECUENCIA_QUINCENAL = "Quincenal";
    final String FRECUENCIA_MENSUAL = "Mensual";
    switch (frecuencia) {
      case FRECUENCIA_SEMANAL:
        return BTN_DIA_FRECUENCIA_SEMANAL;
      case FRECUENCIA_QUINCENAL:
        return BTN_DIA_FRECUENCIA_QUINCENAL;
      case FRECUENCIA_MENSUAL:
        return BTN_DIA_FRECUENCIA_MENSUAL;
      default:
        return null;
    }
  }

  private void obtenerDatosRecurrente(Actor actor, Validacion datosProgramada) {
    datosProgramada.getProducto().setTipoTransaccion(RECURRENTE);
    datosProgramada
        .getProducto()
        .setFechaFuturo(ObtenerValor.elemento(LBL_FECHA_INICIO_RECURRENTE).answeredBy(actor));
    datosProgramada
        .getProducto()
        .setFechaFuturoFin(ObtenerValor.elemento(LBL_FECHA_FIN_RECURRENTE).answeredBy(actor));
    actor.remember(VERIFICAR_TRANSACCION.getVariableSesion(), datosProgramada);
  }
}
