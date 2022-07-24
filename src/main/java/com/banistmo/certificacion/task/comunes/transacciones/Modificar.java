package com.banistmo.certificacion.task.comunes.transacciones;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.banistmo.certificacion.models.builders.TransaccionBuilder;
import com.banistmo.certificacion.task.pagos.tarjetascredito.ModificarPagoTarjetasCredito;
import com.banistmo.certificacion.task.transferencias.cuentaspropias.ModificarTransferenciaPropia;
import com.banistmo.certificacion.task.transferencias.internacionales.ModificarTransferenciaInternacional;
import com.banistmo.certificacion.task.transferencias.terceros.ModificarTransferenciaTerceros;

public class Modificar {

  private Modificar() {}

  public static ModificarTransferenciaPropia transferenciaCuentasPropias(
      TransaccionBuilder datosTransferencia) {
    return instrumented(ModificarTransferenciaPropia.class, datosTransferencia.build());
  }

  public static ModificarTransferenciaTerceros transferenciaCuentasTerceros() {
    return instrumented(ModificarTransferenciaTerceros.class);
  }

  public static ModificarTransferenciaInternacional transferenciaCuentasInternacional(
      TransaccionBuilder datosTransferencia) {
    return instrumented(ModificarTransferenciaInternacional.class, datosTransferencia.build());
  }

  public static ModificarPagoTarjetasCredito pagoTarjetasCredito(TransaccionBuilder datosPagos) {
    return instrumented(ModificarPagoTarjetasCredito.class, datosPagos.build());
  }
}
