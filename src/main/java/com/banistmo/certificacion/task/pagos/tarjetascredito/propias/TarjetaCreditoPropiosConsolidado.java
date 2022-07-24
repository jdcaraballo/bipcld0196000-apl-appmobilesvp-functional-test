package com.banistmo.certificacion.task.pagos.tarjetascredito.propias;

import static com.banistmo.certificacion.userinterface.comunes.TransaccionesGeneralPage.BTN_MOSTRAR_CUENTAS_RETIRO;
import static com.banistmo.certificacion.userinterface.comunes.TransaccionesGeneralPage.LST_BTN_CUENTA_RETIRO_DESTINO;
import static com.banistmo.certificacion.userinterface.tarjetascreditos.TarjetasCreditoPage.*;
import static com.banistmo.certificacion.utils.enums.EnumProductos.TARJETAS_CREDITO;

import com.banistmo.certificacion.interactions.ClickAleatorio;
import com.banistmo.certificacion.interactions.Escribir;
import com.banistmo.certificacion.interactions.Scroll;
import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import com.banistmo.certificacion.models.comun.Transaccion;
import com.banistmo.certificacion.task.comunes.seleccionarproducto.SeleccionarProducto;
import com.banistmo.certificacion.task.transferencias.cuentaspropias.CuentaPropia;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class TarjetaCreditoPropiosConsolidado implements Task {

  private Transaccion producto;

  public TarjetaCreditoPropiosConsolidado(Transaccion producto) {
    this.producto = producto;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        SeleccionarProducto.propioDesdeConsolidado(TARJETAS_CREDITO.getProducto()),
        EsperarCarga.desaparezca(),
        Click.on(BTN_MOSTRAR_CUENTAS_RETIRO),
        EsperarElemento.esClickable(LST_BTN_CUENTA_RETIRO_DESTINO),
        ClickAleatorio.enElemento(LST_BTN_CUENTA_RETIRO_DESTINO),
        EsperarElemento.esClickable(RBT_OTRO_VALOR),
        Click.on(RBT_OTRO_VALOR),
        EsperarElemento.esClickable(TXT_MONTO),
        Escribir.valorPlataforma(producto.getProducto().getMonto(), TXT_MONTO),
        Enter.theValue(producto.getProducto().getDescripcion()).into(TXT_DESCRIPCION));
    CuentaPropia.obtenerDatosProductosPropios(actor, producto);
  }
}
