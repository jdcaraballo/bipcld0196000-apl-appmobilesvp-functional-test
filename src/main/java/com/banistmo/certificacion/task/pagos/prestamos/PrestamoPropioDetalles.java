package com.banistmo.certificacion.task.pagos.prestamos;

import static com.banistmo.certificacion.userinterface.comunes.TransaccionesGeneralPage.BTN_MOSTRAR_CUENTAS_RETIRO;
import static com.banistmo.certificacion.userinterface.comunes.TransaccionesGeneralPage.TXT_MONTO;
import static com.banistmo.certificacion.userinterface.configuracion.administracion.producto.ConfiguracionProductoPage.LST_BTN_CUENTAS;
import static com.banistmo.certificacion.userinterface.prestamos.PrestamosPage.LBL_TITULO_PRESTAMO;
import static com.banistmo.certificacion.utils.enums.EnumVariablesSesion.VERIFICAR_TRANSACCION;

import com.banistmo.certificacion.interactions.ClickAleatorio;
import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import com.banistmo.certificacion.models.comun.Validacion;
import com.banistmo.certificacion.questions.ObtenerValor;
import com.banistmo.certificacion.task.comunes.seleccionarproducto.SeleccionarProducto;
import com.banistmo.certificacion.userinterface.comunes.TransaccionesGeneralPage;
import com.banistmo.certificacion.utils.UtileriaString;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Text;

public class PrestamoPropioDetalles implements Task {

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        SeleccionarProducto.propioDesdeDetalles("Préstamo"),
        EsperarElemento.esVisible(LBL_TITULO_PRESTAMO),
        EsperarElemento.esVisible(BTN_MOSTRAR_CUENTAS_RETIRO),
        Click.on(BTN_MOSTRAR_CUENTAS_RETIRO),
        EsperarCarga.desaparezca(),
        ClickAleatorio.enElemento(LST_BTN_CUENTAS),
        EsperarCarga.desaparezca());
    obtenerDatosPrestamosPropios(actor);
  }

  public static void obtenerDatosPrestamosPropios(Actor actor) {
    Validacion validacion = new Validacion();
    validacion
        .getProducto()
        .setNumeroCuentaRetiro(
            UtileriaString.formatearCuentasRetiro(
                UtileriaString.obtenerNumeroProducto(
                    Text.of(TransaccionesGeneralPage.LBL_NUMERO_CUENTA_RETIROS)
                        .viewedBy(actor)
                        .asString())));
    actor.attemptsTo(EsperarCarga.desaparezca());
    validacion
        .getProducto()
        .setMonto(
            UtileriaString.eliminarPalabra(
                ObtenerValor.elemento(TXT_MONTO).answeredBy(actor), "$"));
    actor.remember(VERIFICAR_TRANSACCION.getVariableSesion(), validacion);
  }
}
