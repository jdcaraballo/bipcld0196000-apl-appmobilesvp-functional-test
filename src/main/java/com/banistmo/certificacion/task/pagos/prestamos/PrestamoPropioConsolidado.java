package com.banistmo.certificacion.task.pagos.prestamos;

import static com.banistmo.certificacion.task.pagos.prestamos.PrestamoPropioDetalles.obtenerDatosPrestamosPropios;
import static com.banistmo.certificacion.userinterface.comunes.TransaccionesGeneralPage.BTN_MOSTRAR_CUENTAS_RETIRO;
import static com.banistmo.certificacion.userinterface.configuracion.administracion.producto.ConfiguracionProductoPage.LST_BTN_CUENTAS;

import com.banistmo.certificacion.interactions.ClickAleatorio;
import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import com.banistmo.certificacion.task.comunes.seleccionarproducto.SeleccionarProducto;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class PrestamoPropioConsolidado implements Task {
  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        SeleccionarProducto.propioDesdeConsolidado("Préstamo"),
        EsperarElemento.esClickable(BTN_MOSTRAR_CUENTAS_RETIRO),
        Click.on(BTN_MOSTRAR_CUENTAS_RETIRO),
        EsperarCarga.desaparezca(),
        ClickAleatorio.enElemento(LST_BTN_CUENTAS));
    obtenerDatosPrestamosPropios(actor);
  }
}
