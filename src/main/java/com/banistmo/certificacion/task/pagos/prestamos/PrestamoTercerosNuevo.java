package com.banistmo.certificacion.task.pagos.prestamos;

import static com.banistmo.certificacion.userinterface.prestamos.PrestamosPage.LBL_CUENTA_RETIRO_PRESTAMOS;

import com.banistmo.certificacion.interactions.Escribir;
import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import com.banistmo.certificacion.models.comun.Transaccion;
import com.banistmo.certificacion.models.comun.Validacion;
import com.banistmo.certificacion.task.comunes.seleccionarcuentas.SeleccionarCuenta;
import com.banistmo.certificacion.userinterface.comunes.TransaccionesGeneralPage;
import com.banistmo.certificacion.userinterface.transferencias.terceros.DatosTercerosPage;
import com.banistmo.certificacion.userinterface.transferencias.terceros.TercerosPage;
import com.banistmo.certificacion.utils.UtileriaString;
import com.banistmo.certificacion.utils.enums.EnumVariablesSesion;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.questions.Text;

public class PrestamoTercerosNuevo implements Task {

  private Transaccion prestamo;

  public PrestamoTercerosNuevo(Transaccion prestamo) {
    this.prestamo = prestamo;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        SeleccionarCuenta.destinoNueva(),
        IngresarDatosPrestamo.nuevo(prestamo),
        Click.on(DatosTercerosPage.BTN_AGREGAR),
        EsperarCarga.desaparezca(),
        EsperarElemento.esClickable(TransaccionesGeneralPage.TXT_MONTO),
        Escribir.valorPlataforma(prestamo.getProducto().getMonto(), TercerosPage.TXT_MONTO),
        Enter.theValue(prestamo.getProducto().getDescripcion()).into(TercerosPage.TXT_DESCRIPCION));
    obtenerDatosPrestamoTerceros(actor);
  }

  private void obtenerDatosPrestamoTerceros(Actor actor) {
    Validacion validacion = new Validacion(prestamo);
    validacion
        .getProducto()
        .setNumeroCuentaRetiro(
            UtileriaString.formatearCuentasRetiro(
                Text.of(LBL_CUENTA_RETIRO_PRESTAMOS).viewedBy(actor).asString()));
    validacion.getProducto().setTipoProducto("Préstamo");
    actor.remember(EnumVariablesSesion.VERIFICAR_TRANSACCION.getVariableSesion(), validacion);
  }
}
