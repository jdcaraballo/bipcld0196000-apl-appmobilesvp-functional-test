package com.banistmo.certificacion.task.pagos.programados;

import static com.banistmo.certificacion.task.comunes.programar.FechaFutura.TEXTO_FECHA_FUTURA;
import static com.banistmo.certificacion.userinterface.comunes.EditarProgramadoPage.*;
import static com.banistmo.certificacion.userinterface.comunes.TransaccionesGeneralPage.*;
import static com.banistmo.certificacion.utils.UtileriaDriver.getPlataformaEjecucion;
import static com.banistmo.certificacion.utils.enums.EnumVariablesSesion.VERIFICAR_TRANSACCION;

import com.banistmo.certificacion.interactions.ClickCambiando;
import com.banistmo.certificacion.interactions.Escribir;
import com.banistmo.certificacion.interactions.Limpiar;
import com.banistmo.certificacion.interactions.SeleccionarFechaFutura;
import com.banistmo.certificacion.interactions.esperas.Esperar;
import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import com.banistmo.certificacion.models.comun.Transaccion;
import com.banistmo.certificacion.models.comun.Validacion;
import com.banistmo.certificacion.questions.ObtenerValor;
import com.banistmo.certificacion.task.configuracion.favoritos.SeleccionarOpcion;
import com.banistmo.certificacion.userinterface.comunes.TransaccionesGeneralPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;

public class EditarPagoFechaFutura implements Task {
  private Transaccion edicion;
  private int diasFechaFutura;

  public EditarPagoFechaFutura(Transaccion edicion, String dias) {
    this.edicion = edicion;
    this.diasFechaFutura = Integer.parseInt(dias);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    Validacion datosIngresados = actor.recall(VERIFICAR_TRANSACCION.getVariableSesion());
    actor.attemptsTo(
        SeleccionarOpcion.conDescripcion(datosIngresados.getProducto().getDescripcion()),
        Limpiar.campo(TXT_MONTO),
        Escribir.valorPlataforma(edicion.getProducto().getMonto(), TXT_MONTO),
        EsperarCarga.desaparezca(),
        EsperarElemento.esClickable(TXT_DESCRIPCION_EDITAR),
        Limpiar.campo(TXT_DESCRIPCION_EDITAR),
        Enter.theValue(edicion.getProducto().getDescripcion()).into(TXT_DESCRIPCION_EDITAR),
        Check.whether("iOS".equalsIgnoreCase(getPlataformaEjecucion()))
            .andIfSo(ClickCambiando.elContexto(BTN_CALENDARIO_NATIVO_IOS))
            .otherwise(Click.on(BTN_CALENDARIO_EDITAR_FECHA_FUTURA)),
        SeleccionarFechaFutura.enCalendario(diasFechaFutura));
    obtenerDatosEditarFechaFutura(actor);
    actor.attemptsTo(
        Click.on(TransaccionesGeneralPage.BTN_CONTINUAR),
        Esperar.unTiempo(3000),
        EsperarCarga.desaparezca());
  }

  private void obtenerDatosEditarFechaFutura(Actor actor) {
    Validacion validacion = actor.recall(VERIFICAR_TRANSACCION.getVariableSesion());
    validacion.getProducto().setTipoTransaccion(TEXTO_FECHA_FUTURA);
    validacion.getProducto().setMonto(ObtenerValor.elemento(TXT_MONTO).answeredBy(actor));
    validacion
        .getProducto()
        .setDescripcion(ObtenerValor.elemento(TXT_DESCRIPCION_EDITAR).answeredBy(actor));
    validacion
        .getProducto()
        .setFechaFuturo(
            ObtenerValor.elemento(TXT_CALENDARIO_EDITAR_FECHA_FUTURA).answeredBy(actor));
    actor.remember(VERIFICAR_TRANSACCION.getVariableSesion(), validacion);
  }
}
