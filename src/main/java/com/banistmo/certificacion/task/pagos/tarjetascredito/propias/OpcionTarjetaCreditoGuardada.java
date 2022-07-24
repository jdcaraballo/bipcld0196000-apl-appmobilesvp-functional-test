package com.banistmo.certificacion.task.pagos.tarjetascredito.propias;

import static com.banistmo.certificacion.task.transferencias.cuentaspropias.CuentaPropia.obtenerDatosProductosPropios;
import static com.banistmo.certificacion.userinterface.comunes.TransaccionesGeneralPage.*;
import static com.banistmo.certificacion.userinterface.tarjetascreditos.TarjetasCreditoPage.*;
import static com.banistmo.certificacion.userinterface.tarjetascreditos.TarjetasCreditoPage.TXT_DESCRIPCION;
import static com.banistmo.certificacion.utils.enums.EnumVariablesSesion.VERIFICAR_TRANSACCION;

import com.banistmo.certificacion.interactions.ClickAleatorio;
import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import com.banistmo.certificacion.models.comun.Transaccion;
import com.banistmo.certificacion.models.comun.Validacion;
import com.banistmo.certificacion.task.comunes.seleccionarcuentas.SeleccionarCuenta;
import com.banistmo.certificacion.utils.UtileriaString;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.questions.Text;

public class OpcionTarjetaCreditoGuardada implements Task {

  private String tipoPago;

  public OpcionTarjetaCreditoGuardada(String tipoPago) {
    this.tipoPago = tipoPago;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        SeleccionarCuenta.transaccion("propio"),
        Click.on(BTN_MOSTRAR_CUENTAS_RETIRO),
        EsperarElemento.esClickable(LST_BTN_CUENTA_RETIRO_DESTINO),
        ClickAleatorio.enElemento(LST_BTN_CUENTA_RETIRO_DESTINO),
        EsperarElemento.esClickable(RBT_PAGO.of(tipoPago)),
        Click.on(RBT_PAGO.of(tipoPago)),
        Enter.theValue("Prueba").into(TXT_DESCRIPCION));
    obtenerDatosPagos(actor);
  }

  private void obtenerDatosPagos(Actor actor) {
    Transaccion transaccion = new Transaccion();
    actor.attemptsTo(EsperarElemento.esVisible(LBL_NUMERO_CUENTA_RETIROS));
    obtenerDatosProductosPropios(actor, transaccion);
    Validacion validacion = actor.recall(VERIFICAR_TRANSACCION.getVariableSesion());
    validacion
        .getProducto()
        .setMonto(
            UtileriaString.eliminarPalabra(
                Text.of(LBL_MONTO_PAGO.of(tipoPago)).viewedBy(actor).asString(), "$"));
    actor.remember(VERIFICAR_TRANSACCION.getVariableSesion(), validacion);
  }
}
