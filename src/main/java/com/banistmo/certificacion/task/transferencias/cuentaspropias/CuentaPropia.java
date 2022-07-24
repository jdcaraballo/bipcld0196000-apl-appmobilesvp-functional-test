package com.banistmo.certificacion.task.transferencias.cuentaspropias;

import static com.banistmo.certificacion.userinterface.comunes.TransaccionesGeneralPage.*;
import static com.banistmo.certificacion.userinterface.transferencias.propias.CuentasPropiasPage.TXT_DETALLES;
import static com.banistmo.certificacion.userinterface.transferencias.propias.CuentasPropiasPage.TXT_MONTO;
import static com.banistmo.certificacion.utils.enums.EnumVariablesSesion.VERIFICAR_TRANSACCION;

import com.banistmo.certificacion.interactions.ClickAleatorio;
import com.banistmo.certificacion.interactions.Escribir;
import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import com.banistmo.certificacion.models.comun.Transaccion;
import com.banistmo.certificacion.models.comun.Validacion;
import com.banistmo.certificacion.utils.UtileriaString;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.questions.Text;

public class CuentaPropia implements Task {

  private Transaccion transferencia;

  public CuentaPropia(Transaccion transferencia) {
    this.transferencia = transferencia;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        EsperarCarga.desaparezca(),
        EsperarElemento.esClickable(BTN_MOSTRAR_CUENTAS_RETIRO),
        Click.on(BTN_MOSTRAR_CUENTAS_RETIRO),
        EsperarCarga.desaparezca(),
        EsperarElemento.esClickable(LST_BTN_CUENTA_RETIRO_DESTINO),
        ClickAleatorio.enElemento(LST_BTN_CUENTA_RETIRO_DESTINO),
        EsperarCarga.desaparezca(),
        EsperarElemento.esClickable(BTN_MOSTRAR_CUENTAS_DESTINO),
        Click.on(BTN_MOSTRAR_CUENTAS_DESTINO),
        EsperarCarga.desaparezca(),
        EsperarElemento.esClickable(LST_BTN_CUENTA_RETIRO_DESTINO),
        Click.on(LST_BTN_CUENTA_RETIRO_DESTINO),
        EsperarElemento.esClickable(TXT_MONTO),
        Escribir.valorPlataforma(transferencia.getProducto().getMonto(), TXT_MONTO),
        EsperarCarga.desaparezca(),
        Enter.theValue(transferencia.getProducto().getDescripcion()).into(TXT_DETALLES));
    obtenerDatosProductosPropios(actor, transferencia);
  }

  public static void obtenerDatosProductosPropios(Actor actor, Transaccion transferencia) {
    Validacion validacion = new Validacion(transferencia);
    validacion
        .getProducto()
        .setNumeroCuentaRetiro(
            UtileriaString.formatearCuentasRetiro(
                Text.of(LBL_NUMERO_CUENTA_RETIROS).viewedBy(actor).asString()));
    validacion
        .getProducto()
        .setNumeroCuentaDestino(Text.of(LBL_NUMERO_CUENTA_DESTINO).viewedBy(actor).asString());
    actor.remember(VERIFICAR_TRANSACCION.getVariableSesion(), validacion);
  }
}
