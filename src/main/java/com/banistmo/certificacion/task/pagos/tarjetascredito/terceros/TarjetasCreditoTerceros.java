package com.banistmo.certificacion.task.pagos.tarjetascredito.terceros;

import static com.banistmo.certificacion.task.transferencias.terceros.CuentaNuevaTercero.obtenerDatosTerceros;
import static com.banistmo.certificacion.userinterface.tarjetascreditos.TarjetasCreditoPage.*;
import static com.banistmo.certificacion.userinterface.transferencias.terceros.DatosTercerosPage.BTN_AGREGAR;

import com.banistmo.certificacion.interactions.Escribir;
import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import com.banistmo.certificacion.models.comun.Transaccion;
import com.banistmo.certificacion.task.comunes.ingresardatosterceros.IngresarDatos;
import com.banistmo.certificacion.task.comunes.seleccionarcuentas.SeleccionarCuenta;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class TarjetasCreditoTerceros implements Task {

  private Transaccion producto;

  public TarjetasCreditoTerceros(Transaccion producto) {
    this.producto = producto;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        SeleccionarCuenta.destinoNueva(),
        IngresarDatos.terceros(producto),
        Click.on(BTN_AGREGAR),
        EsperarElemento.esClickable(TXT_MONTO),
        Escribir.valorPlataforma(producto.getProducto().getMonto(), TXT_MONTO),
        Enter.theValue(producto.getProducto().getDescripcion()).into(TXT_DESCRIPCION_TERCEROS));
    obtenerDatosTerceros(actor, producto);
  }
}
