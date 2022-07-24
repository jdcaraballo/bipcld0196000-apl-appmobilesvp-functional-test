package com.banistmo.certificacion.task.pagos;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.banistmo.certificacion.models.builders.ServicioBuilder;
import com.banistmo.certificacion.models.builders.TransaccionBuilder;
import com.banistmo.certificacion.task.pagos.prestamos.PrestamoPropioConsolidado;
import com.banistmo.certificacion.task.pagos.prestamos.PrestamoPropioDetalles;
import com.banistmo.certificacion.task.pagos.prestamos.PrestamoTercerosNuevo;
import com.banistmo.certificacion.task.pagos.prestamos.PrestamosGuardados;
import com.banistmo.certificacion.task.pagos.servicios.ServicioNuevo;
import com.banistmo.certificacion.task.pagos.tarjetascredito.propias.OpcionTarjetaCreditoGuardada;
import com.banistmo.certificacion.task.pagos.tarjetascredito.propias.TarjetaCreditoGuardada;
import com.banistmo.certificacion.task.pagos.tarjetascredito.propias.TarjetaCreditoPropiosConsolidado;
import com.banistmo.certificacion.task.pagos.tarjetascredito.propias.TarjetaCreditoPropiosDetalles;
import com.banistmo.certificacion.task.pagos.tarjetascredito.terceros.TarjetasCreditoTerceros;

public class RealizarPago {

  private RealizarPago() {}

  public static PrestamoTercerosNuevo prestamoNuevoTerceros(TransaccionBuilder prestamo) {
    return instrumented(PrestamoTercerosNuevo.class, prestamo.build());
  }

  public static PrestamoPropioConsolidado prestamosPropiosDesdeConsolidado() {
    return instrumented(PrestamoPropioConsolidado.class);
  }

  public static PrestamoPropioDetalles prestamosPropiosDesdeDetalles() {
    return instrumented(PrestamoPropioDetalles.class);
  }

  public static PrestamosGuardados prestamosGuardados(
      TransaccionBuilder transaccion, String tipoCuentaTerceros) {
    return instrumented(PrestamosGuardados.class, transaccion.build(), tipoCuentaTerceros);
  }

  public static ServicioNuevo servicioNuevo(ServicioBuilder servicio) {
    return instrumented(ServicioNuevo.class, servicio.build());
  }

  public static TarjetaCreditoPropiosConsolidado tarjetasCreditoPropiasDesdeConsolidado(
      TransaccionBuilder transaccion) {
    return instrumented(TarjetaCreditoPropiosConsolidado.class, transaccion.build());
  }

  public static TarjetaCreditoPropiosDetalles tarjetasCreditoPropiasDesdeDetalles(
      TransaccionBuilder transaccion) {
    return instrumented(TarjetaCreditoPropiosDetalles.class, transaccion.build());
  }

  public static TarjetaCreditoGuardada tarjetaCreditoGuardada(
      TransaccionBuilder transaccion, String tipoTarjeta) {
    return instrumented(TarjetaCreditoGuardada.class, transaccion.build(), tipoTarjeta);
  }

  public static OpcionTarjetaCreditoGuardada opcionTarjetaCreditoGuardada(String tipoPago) {
    return instrumented(OpcionTarjetaCreditoGuardada.class, tipoPago);
  }

  public static TarjetasCreditoTerceros tarjetasCreditoTerceros(TransaccionBuilder producto) {
    return instrumented(TarjetasCreditoTerceros.class, producto.build());
  }
}
