package com.banistmo.certificacion.task.transferencias.terceros;

import static com.banistmo.certificacion.userinterface.comunes.TransaccionesGeneralPage.LBL_NUMERO_CUENTA_RETIROS;
import static com.banistmo.certificacion.userinterface.transferencias.terceros.DatosTercerosPage.*;
import static com.banistmo.certificacion.userinterface.transferencias.terceros.TercerosPage.TXT_DESCRIPCION;
import static com.banistmo.certificacion.userinterface.transferencias.terceros.TercerosPage.TXT_MONTO;
import static com.banistmo.certificacion.utils.enums.EnumVariablesSesion.VERIFICAR_TRANSACCION;

import com.banistmo.certificacion.interactions.Escribir;
import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import com.banistmo.certificacion.models.comun.Transaccion;
import com.banistmo.certificacion.models.comun.Validacion;
import com.banistmo.certificacion.task.comunes.ingresardatosterceros.IngresarDatos;
import com.banistmo.certificacion.task.comunes.seleccionarcuentas.SeleccionarCuenta;
import com.banistmo.certificacion.utils.UtileriaString;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.questions.Text;

public class CuentaNuevaTercero implements Task {

  private Transaccion transferencia;

  public CuentaNuevaTercero(Transaccion transferencia) {
    this.transferencia = transferencia;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        SeleccionarCuenta.destinoNueva(),
        IngresarDatos.terceros(transferencia),
        Click.on(BTN_AGREGAR),
        EsperarElemento.esClickable(TXT_MONTO),
        EsperarCarga.desaparezca(),
        Escribir.valorPlataforma(transferencia.getProducto().getMonto(), TXT_MONTO),
        Enter.theValue(transferencia.getProducto().getDescripcion()).into(TXT_DESCRIPCION));
    obtenerDatosTerceros(actor, transferencia);
  }

  public static void obtenerDatosTerceros(Actor actor, Transaccion transferencia) {
    Validacion validacion = new Validacion(transferencia);
    validacion
        .getProducto()
        .setNumeroCuentaRetiro(
            UtileriaString.formatearCuentasRetiro(
                Text.of(LBL_NUMERO_CUENTA_RETIROS).viewedBy(actor).asString()));
    actor.remember(VERIFICAR_TRANSACCION.getVariableSesion(), validacion);
  }
}
