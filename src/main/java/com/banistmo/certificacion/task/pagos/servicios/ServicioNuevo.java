package com.banistmo.certificacion.task.pagos.servicios;

import static com.banistmo.certificacion.userinterface.recargas.RecargasPage.LBL_NUMERO_GUARDADO;
import static com.banistmo.certificacion.userinterface.recargas.RecargasPage.TXT_DESCRIPCION;
import static com.banistmo.certificacion.userinterface.servicios.ComprobanteServiciosPage.LBL_NUMERO_CUENTA_RETIROS;
import static com.banistmo.certificacion.userinterface.servicios.DatosServiciosPage.BTN_SERVICIO;
import static com.banistmo.certificacion.userinterface.servicios.DatosServiciosPage.TXT_BUSCAR_SERVICIOS;
import static com.banistmo.certificacion.userinterface.servicios.ServiciosPage.*;
import static com.banistmo.certificacion.userinterface.tarjetascreditos.TarjetasCreditoPage.TXT_MONTO;
import static com.banistmo.certificacion.utils.enums.EnumVariablesSesion.VERIFICAR_TRANSACCION;

import com.banistmo.certificacion.interactions.Escribir;
import com.banistmo.certificacion.interactions.Limpiar;
import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import com.banistmo.certificacion.models.comun.Validacion;
import com.banistmo.certificacion.models.productos.Servicio;
import com.banistmo.certificacion.task.comunes.seleccionarcuentas.SeleccionarCuenta;
import com.banistmo.certificacion.utils.UtileriaString;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.questions.Visibility;

public class ServicioNuevo implements Task {

  private Servicio servicio;

  public ServicioNuevo(Servicio servicio) {
    this.servicio = servicio;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        SeleccionarCuenta.destinoNueva(),
        EsperarCarga.desaparezca(),
        EsperarElemento.esClickable(TXT_BUSCAR_SERVICIOS),
        Enter.theValue(servicio.getNombreServicio()).into(TXT_BUSCAR_SERVICIOS),
        EsperarElemento.esClickable(BTN_SERVICIO),
        Click.on(BTN_SERVICIO),
        EsperarCarga.desaparezca());
    if (!Visibility.of(BTN_CONSULTAR).viewedBy(actor).resolveAll().isEmpty()) {
      actor.attemptsTo(
          EsperarElemento.esClickable(TXT_NUMERO_CONSULTA),
          Enter.theValue(servicio.getBeneficiario().getNumero()).into(TXT_NUMERO_CONSULTA),
          Click.on(BTN_CONSULTAR),
          EsperarCarga.desaparezca(),
          EsperarElemento.esClickable(TXT_MONTO),
          Limpiar.campo(TXT_MONTO));
    } else {
      actor.attemptsTo(
          EsperarElemento.esClickable(TXT_NUMERO_TELEFONO),
          Enter.theValue(servicio.getBeneficiario().getNumero()).into(TXT_NUMERO_TELEFONO));
    }
    actor.attemptsTo(
        Escribir.valorPlataforma(servicio.getProducto().getMonto(), TXT_MONTO),
        Enter.theValue(servicio.getProducto().getDescripcion()).into(TXT_DESCRIPCION));
    obtenerDatosServicio(actor);
  }

  private void obtenerDatosServicio(Actor actor) {
    Validacion validacion = new Validacion(servicio);
    validacion.getProducto().setBanco("");
    validacion
        .getProducto()
        .setNumeroCuentaRetiro(
            UtileriaString.formatearCuentasRetiro(
                Text.of(LBL_NUMERO_CUENTA_RETIROS).viewedBy(actor).asString()));
    validacion
        .getServicio()
        .setCodigoServicio(
            UtileriaString.eliminarPalabra(
                Text.of(LBL_NUMERO_GUARDADO).viewedBy(actor).asString(), "Codigo: "));
    actor.remember(VERIFICAR_TRANSACCION.getVariableSesion(), validacion);
  }
}
