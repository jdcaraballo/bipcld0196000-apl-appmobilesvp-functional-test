package com.banistmo.certificacion.task.transferencias;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.banistmo.certificacion.models.builders.TransaccionBuilder;
import com.banistmo.certificacion.task.transferencias.cuentaspropias.CuentaPropia;
import com.banistmo.certificacion.task.transferencias.internacionales.CuentaGuardadaInternacional;
import com.banistmo.certificacion.task.transferencias.internacionales.CuentaNuevaInternacional;
import com.banistmo.certificacion.task.transferencias.terceros.CuentaGuardadaTerceros;
import com.banistmo.certificacion.task.transferencias.terceros.CuentaNuevaTercero;
import net.serenitybdd.screenplay.Performable;

public class RealizarTransferencia {

  private RealizarTransferencia() {}

  public static CuentaPropia cuentasPropias(TransaccionBuilder datosTransferencia) {
    return instrumented(CuentaPropia.class, datosTransferencia.build());
  }

  public static Performable aCuentaNuevaTerceros(TransaccionBuilder transferencia) {
    return instrumented(CuentaNuevaTercero.class, transferencia.build());
  }

  public static Performable aCuentaGuardadaTerceros(
      TransaccionBuilder transferencia, String tipoCuentaTerceros) {
    return instrumented(CuentaGuardadaTerceros.class, transferencia.build(), tipoCuentaTerceros);
  }

  public static Performable aCuentaNuevainternacional(TransaccionBuilder transferencia) {
    return instrumented(CuentaNuevaInternacional.class, transferencia.build());
  }

  public static Performable aCuentainternacionalGuardada(TransaccionBuilder transferencia) {
    return instrumented(CuentaGuardadaInternacional.class, transferencia.build());
  }
}
