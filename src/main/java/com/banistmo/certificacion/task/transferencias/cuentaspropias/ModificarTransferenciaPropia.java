package com.banistmo.certificacion.task.transferencias.cuentaspropias;

import static com.banistmo.certificacion.userinterface.comunes.TransaccionesGeneralPage.BTN_CONTINUAR;
import static com.banistmo.certificacion.userinterface.comunes.VerificarTransaccionPage.BTN_MODIFICAR_TRANSACCION;
import static com.banistmo.certificacion.userinterface.transferencias.propias.CuentasPropiasPage.TXT_DETALLES;
import static com.banistmo.certificacion.userinterface.transferencias.propias.CuentasPropiasPage.TXT_MONTO;

import com.banistmo.certificacion.interactions.Escribir;
import com.banistmo.certificacion.interactions.Limpiar;
import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import com.banistmo.certificacion.models.comun.Transaccion;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class ModificarTransferenciaPropia implements Task {

  private Transaccion transferencia;

  public ModificarTransferenciaPropia(Transaccion transferencia) {
    this.transferencia = transferencia;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        EsperarElemento.esClickable(BTN_CONTINUAR),
        Click.on(BTN_CONTINUAR),
        EsperarElemento.esClickable(BTN_MODIFICAR_TRANSACCION),
        Click.on(BTN_MODIFICAR_TRANSACCION),
        EsperarCarga.desaparezca(),
        EsperarElemento.esClickable(TXT_MONTO),
        Limpiar.campo(TXT_MONTO),
        Escribir.valorPlataforma(transferencia.getProducto().getMonto(), TXT_MONTO),
        Limpiar.campo(TXT_DETALLES),
        Enter.theValue(transferencia.getProducto().getDescripcion()).into(TXT_DETALLES));
    actor.remember("DetallesModificado", transferencia.getProducto().getDescripcion());
    actor.remember("MontoModificado", transferencia.getProducto().getMonto());
  }
}
