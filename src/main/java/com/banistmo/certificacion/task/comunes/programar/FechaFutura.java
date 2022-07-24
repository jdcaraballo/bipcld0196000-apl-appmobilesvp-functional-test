package com.banistmo.certificacion.task.comunes.programar;

import static com.banistmo.certificacion.userinterface.comunes.DatosProgramacionPage.TXT_FECHA_FUTURA_PAGO;
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
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;

public class FechaFutura implements Task {

  private int dias;
  public static final String TEXTO_FECHA_FUTURA = "Fecha futura";

  public FechaFutura(int dias) {
    this.dias = dias;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        EsperarElemento.esVisible(BTN_TIPO_TRANSACCION),
        Click.on(BTN_TIPO_TRANSACCION),
        EsperarCarga.desaparezca(),
        EsperarElemento.esVisible(LST_TIPO),
        SelecionarLista.unaOpcion(TEXTO_FECHA_FUTURA, LST_TIPO, true),
        EsperarCarga.desaparezca(),
        EsperarElemento.esClickable(BTN_CALENDARIO),
        Check.whether("iOS".equalsIgnoreCase(getPlataformaEjecucion()))
            .andIfSo(ClickCambiando.elContexto(BTN_CALENDARIO_NATIVO_IOS))
            .otherwise(Click.on(BTN_CALENDARIO)),
        EsperarCarga.desaparezca(),
        EsperarCarga.desaparezca(),
        SeleccionarFechaFutura.enCalendario(dias));
    obtenerDatosFechaFutura(actor);
  }

  private void obtenerDatosFechaFutura(Actor actor) {
    Validacion validacion = actor.recall(VERIFICAR_TRANSACCION.getVariableSesion());
    validacion.getProducto().setTipoTransaccion(TEXTO_FECHA_FUTURA);
    validacion
        .getProducto()
        .setFechaFuturo(ObtenerValor.elemento(TXT_FECHA_FUTURA_PAGO).answeredBy(actor));
    actor.remember(VERIFICAR_TRANSACCION.getVariableSesion(), validacion);
  }
}
