package com.banistmo.certificacion.task.pagos.tarjetascredito.propias;

import static com.banistmo.certificacion.userinterface.tarjetascreditos.TarjetasCreditoPage.*;

import com.banistmo.certificacion.interactions.Escribir;
import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import com.banistmo.certificacion.models.comun.Transaccion;
import com.banistmo.certificacion.task.comunes.seleccionarcuentas.SeleccionarCuenta;
import com.banistmo.certificacion.task.transferencias.cuentaspropias.CuentaPropia;
import com.banistmo.certificacion.task.transferencias.terceros.CuentaGuardadaTerceros;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;

public class TarjetaCreditoGuardada implements Task {

  private Transaccion transaccion;
  private String tipoTarjeta;

  public TarjetaCreditoGuardada(Transaccion transaccion, String tipoTarjeta) {
    this.transaccion = transaccion;
    this.tipoTarjeta = tipoTarjeta;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        SeleccionarCuenta.transaccion(tipoTarjeta),
        Check.whether("propio".equals(tipoTarjeta))
            .andIfSo(
            EsperarElemento.esClickable(TXT_MONTO)),
        Escribir.valorPlataforma(transaccion.getProducto().getMonto(), TXT_MONTO),
        Enter.theValue(transaccion.getProducto().getDescripcion()).into(TXT_DESCRIPCION));
    if ("propio".equals(tipoTarjeta)) {
      CuentaPropia.obtenerDatosProductosPropios(actor, transaccion);
    } else {
      CuentaGuardadaTerceros.obtenerDatosGuardadaTerceros(actor, transaccion);
    }
  }
}
