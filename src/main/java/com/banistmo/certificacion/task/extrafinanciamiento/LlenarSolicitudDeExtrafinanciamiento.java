package com.banistmo.certificacion.task.extrafinanciamiento;

import static com.banistmo.certificacion.userinterface.PrincipalPage.BTN_MAS_INFO_EXTRAFINANCIAMIENTO;
import static com.banistmo.certificacion.userinterface.comunes.TransaccionesGeneralPage.*;
import static com.banistmo.certificacion.userinterface.extrafinanciamiento.ExtrafinanciamientoPage.*;
import static com.banistmo.certificacion.utils.enums.EnumVariablesSesion.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.banistmo.certificacion.interactions.ClickAleatorio;
import com.banistmo.certificacion.interactions.Escribir;
import com.banistmo.certificacion.interactions.SelecionarLista;
import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import com.banistmo.certificacion.models.builders.TransaccionBuilder;
import com.banistmo.certificacion.models.comun.Transaccion;
import com.banistmo.certificacion.models.comun.Validacion;
import com.banistmo.certificacion.utils.UtileriaString;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.questions.Text;

public class LlenarSolicitudDeExtrafinanciamiento implements Task {

  private final Transaccion transaccion;

  public LlenarSolicitudDeExtrafinanciamiento(Transaccion transaccion) {
    this.transaccion = transaccion;
  }

  public static LlenarSolicitudDeExtrafinanciamiento conLosDatos(TransaccionBuilder transaccion) {
    return instrumented(LlenarSolicitudDeExtrafinanciamiento.class, transaccion.build());
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        EsperarElemento.esClickable(BTN_MAS_INFO_EXTRAFINANCIAMIENTO),
        Click.on(BTN_MAS_INFO_EXTRAFINANCIAMIENTO),
        EsperarCarga.desaparezca(),
        EsperarElemento.esClickable(BTN_MOSTRAR_CUENTAS_DESTINO),
        Click.on(BTN_MOSTRAR_CUENTAS_DESTINO),
        EsperarCarga.desaparezca(),
        EsperarElemento.esClickable(LST_BTN_CUENTA_RETIRO_DESTINO),
        ClickAleatorio.enElemento(LST_BTN_CUENTA_RETIRO_DESTINO));
    actor.remember(
        SALDO_INICIAL_CUENTA.getVariableSesion(),
        UtileriaString.formatearNumeros(
            Text.of(LBL_SALDO_INICIAL_CUENTA_RETIRO).viewedBy(actor).asString()));
    actor.attemptsTo(
        EsperarElemento.esClickable(TXT_MONTO_A_SOLICITAR),
        JavaScriptClick.on(TXT_MONTO_A_SOLICITAR),
        Escribir.valorPlataforma(transaccion.getProducto().getMonto(), TXT_MONTO_A_SOLICITAR),
        EsperarElemento.esClickable(BTN_LST_CUOTAS),
        Click.on(BTN_LST_CUOTAS),
        SelecionarLista.unaOpcion(transaccion.getProducto().getCuotas(), LST_TIPO, true),
        EsperarCarga.desaparezca(),
        Enter.theValue(transaccion.getProducto().getDescripcion())
            .into(TXT_DESCRIPCION_EXTRAFINANCIAMIENTO));
    obtenerDatosExtrafinanciamiento(actor);
  }

  private void obtenerDatosExtrafinanciamiento(Actor actor) {
    Validacion validacion = new Validacion();
    validacion
        .getProducto()
        .setNumeroCuentaDestino(Text.of(LBL_NUMERO_CUENTA_DESTINO).viewedBy(actor).asString());
    validacion.getProducto().setCuotas(transaccion.getProducto().getCuotas());
    validacion.getProducto().setCuotaMensual(Text.of(LBL_COUTA_MENSUAL).viewedBy(actor).asString());
    validacion.getProducto().setDescripcion(transaccion.getProducto().getDescripcion());
    validacion.getProducto().setMonto(transaccion.getProducto().getMonto());
    actor.remember(VERIFICAR_TRANSACCION.getVariableSesion(), validacion);
  }
}
