package com.banistmo.certificacion.task.comunes.ingresardatosterceros;

import static com.banistmo.certificacion.userinterface.transferencias.terceros.DatosTercerosPage.*;
import static com.banistmo.certificacion.userinterface.transferencias.terceros.DatosTercerosPage.TXT_NUMERO_CUENTA;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.banistmo.certificacion.interactions.SelecionarLista;
import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import com.banistmo.certificacion.models.comun.Transaccion;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class IngresarDatos implements Task {

  private Transaccion transferencia;

  public IngresarDatos(Transaccion transferencia) {
    this.transferencia = transferencia;
  }

  public static IngresarDatos terceros(Transaccion transferencia) {
    return instrumented(IngresarDatos.class, transferencia);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        Enter.theValue(transferencia.getBeneficiario().getNombre()).into(TXT_NOMBRE),
        Enter.theValue(transferencia.getBeneficiario().getCorreo()).into(TXT_CORREO),
        Click.on(BTN_BANCO),
        EsperarCarga.desaparezca(),
        EsperarElemento.esClickable(LST_BTN_BANCO_PRODUCTOS),
        SelecionarLista.unaOpcion(
            transferencia.getProducto().getBanco(), LST_BTN_BANCO_PRODUCTOS, true),
        EsperarCarga.desaparezca(),
        Click.on(BTN_CUENTA),
        EsperarCarga.desaparezca(),
        EsperarElemento.esClickable(LST_BTN_BANCO_PRODUCTOS),
        SelecionarLista.unaOpcion(
            transferencia.getProducto().getTipoProducto(), LST_BTN_BANCO_PRODUCTOS, true),
        EsperarCarga.desaparezca(),
        EsperarCarga.desaparezca(),
        EsperarElemento.esClickable(TXT_NUMERO_CUENTA),
        Enter.theValue(transferencia.getProducto().getNumeroCuentaDestino())
            .into(TXT_NUMERO_CUENTA));
  }
}
