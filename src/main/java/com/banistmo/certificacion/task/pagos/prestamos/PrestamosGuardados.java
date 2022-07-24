package com.banistmo.certificacion.task.pagos.prestamos;

import static com.banistmo.certificacion.utils.enums.EnumProductos.PROPIO;
import static com.banistmo.certificacion.utils.enums.EnumVariablesSesion.VERIFICAR_TRANSACCION;

import com.banistmo.certificacion.interactions.Escribir;
import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import com.banistmo.certificacion.models.comun.Transaccion;
import com.banistmo.certificacion.models.comun.Validacion;
import com.banistmo.certificacion.questions.ObtenerValor;
import com.banistmo.certificacion.task.comunes.seleccionarcuentas.SeleccionarCuenta;
import com.banistmo.certificacion.userinterface.comunes.TransaccionesGeneralPage;
import com.banistmo.certificacion.userinterface.prestamos.PrestamosPage;
import com.banistmo.certificacion.utils.UtileriaString;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.questions.Text;

public class PrestamosGuardados implements Task {

  private String tipoProducto;
  private Transaccion producto;

  public PrestamosGuardados(Transaccion producto, String tipoProducto) {
    this.tipoProducto = tipoProducto;
    this.producto = producto;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        EsperarCarga.desaparezca(),
        SeleccionarCuenta.transaccion(tipoProducto),
        Check.whether(PROPIO.getProducto().equals(tipoProducto))
            .otherwise(
                Escribir.valorPlataforma(
                    producto.getProducto().getMonto(), TransaccionesGeneralPage.TXT_MONTO)),
        Enter.theValue(producto.getProducto().getDescripcion())
            .into(PrestamosPage.TXT_DESCRIPCION_PRESTAMO));
    obtenerDatosPrestamosGuardado(actor);
  }

  private void obtenerDatosPrestamosGuardado(Actor actor) {
    Validacion validacion = new Validacion(producto);
    if (PROPIO.getProducto().equals(tipoProducto)) {
      validacion
          .getProducto()
          .setNumeroCuentaRetiro(
              UtileriaString.formatearCuentasRetiro(
                  UtileriaString.obtenerNumeroProducto(
                      Text.of(TransaccionesGeneralPage.LBL_NUMERO_CUENTA_RETIROS)
                          .viewedBy(actor)
                          .asString())));
      validacion
          .getProducto()
          .setMonto(
              UtileriaString.eliminarPalabra(
                  ObtenerValor.elemento(TransaccionesGeneralPage.TXT_MONTO).answeredBy(actor),
                  "$"));
      validacion.getProducto().setTipoProducto(tipoProducto);
    } else {
      validacion.getProducto().setTipoProducto("Préstamo");
      validacion
          .getProducto()
          .setNumeroCuentaRetiro(
              UtileriaString.formatearCuentasRetiro(
                  UtileriaString.obtenerNumeroProducto(
                      Text.of(TransaccionesGeneralPage.LBL_NUMERO_CUENTA_RETIROS)
                          .viewedBy(actor)
                          .asString())));
      validacion
          .getProducto()
          .setBanco(
              UtileriaString.eliminarPalabra(
                  Text.of(TransaccionesGeneralPage.LBL_BANCO_DESTINO).viewedBy(actor).asString(),
                  "Banco : "));
      validacion
          .getProducto()
          .setNumeroCuentaDestino(
              Text.of(PrestamosPage.LBL_NUMERO_PRESTAMO_PAGAR).viewedBy(actor).asString());
    }
    actor.remember(VERIFICAR_TRANSACCION.getVariableSesion(), validacion);
  }
}
