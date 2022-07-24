package com.banistmo.certificacion.task.transferencias.terceros;

import static com.banistmo.certificacion.userinterface.comunes.TransaccionesGeneralPage.*;
import static com.banistmo.certificacion.userinterface.transferencias.terceros.TercerosPage.TXT_DESCRIPCION;
import static com.banistmo.certificacion.userinterface.transferencias.terceros.TercerosPage.TXT_MONTO;
import static com.banistmo.certificacion.utils.enums.EnumVariablesSesion.VERIFICAR_TRANSACCION;

import com.banistmo.certificacion.interactions.Escribir;
import com.banistmo.certificacion.models.comun.Transaccion;
import com.banistmo.certificacion.models.comun.Validacion;
import com.banistmo.certificacion.task.comunes.seleccionarcuentas.SeleccionarCuenta;
import com.banistmo.certificacion.utils.UtileriaString;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.questions.Text;

public class CuentaGuardadaTerceros implements Task {

  private Transaccion transferencia;
  private String tipoCuentaTerceros;

  public CuentaGuardadaTerceros(Transaccion transferencia, String tipoCuentaTerceros) {
    this.transferencia = transferencia;
    this.tipoCuentaTerceros = tipoCuentaTerceros;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        SeleccionarCuenta.transaccion(tipoCuentaTerceros),
        Escribir.valorPlataforma(transferencia.getProducto().getMonto(), TXT_MONTO),
        Enter.theValue(transferencia.getProducto().getDescripcion()).into(TXT_DESCRIPCION));
    obtenerDatosGuardadaTerceros(actor, transferencia);
  }

  public static void obtenerDatosGuardadaTerceros(Actor actor, Transaccion transferencia) {
    Validacion validacion = new Validacion(transferencia);
    validacion
        .getProducto()
        .setNumeroCuentaRetiro(
            UtileriaString.formatearCuentasRetiro(
                Text.of(LBL_NUMERO_CUENTA_RETIROS).viewedBy(actor).asString()));
    validacion.getProducto().setBanco(Text.of(LBL_BANCO_DESTINO).viewedBy(actor).asString());
    validacion
        .getProducto()
        .setNumeroCuentaDestino(Text.of(LBL_NUMERO_CUENTA_DESTINO).viewedBy(actor).asString());
    actor.remember(VERIFICAR_TRANSACCION.getVariableSesion(), validacion);
  }
}
