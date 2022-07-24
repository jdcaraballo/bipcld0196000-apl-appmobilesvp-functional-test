package com.banistmo.certificacion.task.pagos.tarjetascredito;

import static com.banistmo.certificacion.userinterface.comunes.TransaccionesGeneralPage.BTN_CONTINUAR;
import static com.banistmo.certificacion.userinterface.comunes.VerificarTransaccionPage.BTN_MODIFICAR_TRANSACCION;
import static com.banistmo.certificacion.userinterface.tarjetascreditos.TarjetasCreditoPage.TXT_DESCRIPCION;
import static com.banistmo.certificacion.userinterface.tarjetascreditos.TarjetasCreditoPage.TXT_MONTO;

import com.banistmo.certificacion.interactions.Escribir;
import com.banistmo.certificacion.interactions.Limpiar;
import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import com.banistmo.certificacion.models.comun.Transaccion;
import com.banistmo.certificacion.task.transferencias.cuentaspropias.CuentaPropia;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class ModificarPagoTarjetasCredito implements Task {

  private Transaccion transaccion;

  public ModificarPagoTarjetasCredito(Transaccion transaccion) {
    this.transaccion = transaccion;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        EsperarElemento.esClickable(BTN_CONTINUAR),
        Click.on(BTN_CONTINUAR),
        EsperarElemento.esClickable(BTN_MODIFICAR_TRANSACCION),
        Click.on(BTN_MODIFICAR_TRANSACCION),
        Limpiar.campo(TXT_MONTO),
        Escribir.valorPlataforma(transaccion.getProducto().getMonto(), TXT_MONTO),
        Limpiar.campo(TXT_DESCRIPCION),
        Enter.theValue(transaccion.getProducto().getDescripcion()).into(TXT_DESCRIPCION));
    CuentaPropia.obtenerDatosProductosPropios(actor, transaccion);
  }
}
