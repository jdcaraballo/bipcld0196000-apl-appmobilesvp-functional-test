package com.banistmo.certificacion.task.transferencias.internacionales;

import static com.banistmo.certificacion.userinterface.comunes.TransaccionesGeneralPage.BTN_CONTINUAR;
import static com.banistmo.certificacion.userinterface.comunes.VerificarTransaccionPage.BTN_MODIFICAR_TRANSACCION;
import static com.banistmo.certificacion.userinterface.transferencias.internacionales.InternacionalesPage.*;
import static com.banistmo.certificacion.utils.enums.EnumVariablesSesion.VERIFICAR_TRANSACCION;

import com.banistmo.certificacion.interactions.Escribir;
import com.banistmo.certificacion.interactions.Limpiar;
import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import com.banistmo.certificacion.models.comun.Transaccion;
import com.banistmo.certificacion.models.comun.Validacion;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class ModificarTransferenciaInternacional implements Task {

  private Transaccion transferencia;

  public ModificarTransferenciaInternacional(Transaccion transferencia) {
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
        Limpiar.campo(TXT_MONTO),
        Escribir.valorPlataforma(transferencia.getProducto().getMonto(), TXT_MONTO),
        Limpiar.campo(TXT_DESCRIPCION),
        Enter.theValue(transferencia.getProducto().getDescripcion()).into(TXT_DESCRIPCION));
    obtenerDatosInternacionalModificados(actor);
  }

  private void obtenerDatosInternacionalModificados(Actor actor) {
    Validacion validacion = actor.recall(VERIFICAR_TRANSACCION.getVariableSesion());
    validacion.getProducto().setMonto(transferencia.getProducto().getMonto());
    validacion.getProducto().setDescripcion(transferencia.getProducto().getDescripcion());
    actor.remember(VERIFICAR_TRANSACCION.getVariableSesion(), validacion);
  }
}
