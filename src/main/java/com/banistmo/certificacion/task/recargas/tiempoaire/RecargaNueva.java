package com.banistmo.certificacion.task.recargas.tiempoaire;

import static com.banistmo.certificacion.userinterface.comunes.TransaccionesGeneralPage.BTN_CONTINUAR;
import static com.banistmo.certificacion.userinterface.comunes.TransaccionesGeneralPage.LBL_NUMERO_CUENTA_RETIROS;
import static com.banistmo.certificacion.userinterface.recargas.DatosRecargasPage.*;
import static com.banistmo.certificacion.userinterface.recargas.RecargasPage.TXT_DESCRIPCION;
import static com.banistmo.certificacion.userinterface.recargas.RecargasPage.TXT_MONTO;
import static com.banistmo.certificacion.utils.enums.EnumVariablesSesion.VERIFICAR_TRANSACCION;

import com.banistmo.certificacion.interactions.Escribir;
import com.banistmo.certificacion.interactions.SelecionarLista;
import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import com.banistmo.certificacion.models.comun.Validacion;
import com.banistmo.certificacion.models.productos.Recargas;
import com.banistmo.certificacion.task.comunes.seleccionarcuentas.SeleccionarCuenta;
import com.banistmo.certificacion.utils.UtileriaString;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.questions.Text;

public class RecargaNueva implements Task {

  private Recargas datosRecarga;

  public RecargaNueva(Recargas datosRecarga) {
    this.datosRecarga = datosRecarga;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        SeleccionarCuenta.destinoNueva(),
        EsperarCarga.desaparezca(),
        Check.whether(!datosRecarga.getNombreOperador().isEmpty())
            .andIfSo(
                EsperarElemento.esClickable(BTN_NOMBRE_OPERADOR),
                Click.on(BTN_NOMBRE_OPERADOR),
                EsperarCarga.desaparezca(),
                EsperarElemento.esClickable(LST_BTN_OPERADOR),
                SelecionarLista.unaOpcion(datosRecarga.getNombreOperador(), LST_BTN_OPERADOR, true),
                EsperarCarga.desaparezca()),
        EsperarElemento.esClickable(TXT_NUMERO_CELULAR),
        Enter.theValue(datosRecarga.getBeneficiario().getNumero()).into(TXT_NUMERO_CELULAR),
        EsperarCarga.desaparezca(),
        Click.on(BTN_CONTINUAR),
        EsperarCarga.desaparezca(),
        EsperarElemento.esClickable(TXT_MONTO),
        Escribir.valorPlataforma(datosRecarga.getProducto().getMonto(), TXT_MONTO),
        Enter.theValue(datosRecarga.getProducto().getDescripcion()).into(TXT_DESCRIPCION));
    obtenerDatosRecarga(actor);
  }

  private void obtenerDatosRecarga(Actor actor) {
    Validacion validacion = new Validacion(datosRecarga);
    validacion
        .getProducto()
        .setNumeroCuentaRetiro(
            UtileriaString.formatearCuentasRetiro(
                Text.of(LBL_NUMERO_CUENTA_RETIROS).viewedBy(actor).asString()));
    actor.remember(VERIFICAR_TRANSACCION.getVariableSesion(), validacion);
  }
}
