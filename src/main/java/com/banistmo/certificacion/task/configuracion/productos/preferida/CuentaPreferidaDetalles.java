package com.banistmo.certificacion.task.configuracion.productos.preferida;

import static com.banistmo.certificacion.userinterface.PrincipalPage.*;
import static com.banistmo.certificacion.userinterface.configuracion.administracion.producto.ConfiguracionProductoPage.*;
import static com.banistmo.certificacion.userinterface.configuracion.administracion.producto.ConfiguracionProductoPage.BTN_GUARDAR;
import static com.banistmo.certificacion.userinterface.detalles.TransaccionesDetallesPage.BTN_CONFIGURACION;
import static com.banistmo.certificacion.userinterface.detalles.TransaccionesDetallesPage.BTN_CONFIGURACION_SEGUNDA_CUENTA;
import static com.banistmo.certificacion.utils.UtileriaString.formatearNumeros;

import com.banistmo.certificacion.interactions.esperas.Esperar;
import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.questions.Visibility;

public class CuentaPreferidaDetalles implements Task {

  private final String accion;

  public CuentaPreferidaDetalles(String accion) {
    this.accion = accion;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        EsperarCarga.desaparezca(),
        EsperarElemento.esClickable(BTN_VISTA_CARD),
        Click.on(BTN_VISTA_CARD),
        EsperarCarga.desaparezca(),
        Click.on(BTN_VISTA_CARD),
        EsperarCarga.desaparezca(),
        EsperarElemento.esClickable(BTN_CUENTAS_DEPOSITOS_CARD),
        Click.on(BTN_CUENTAS_DEPOSITOS_CARD),
        Check.whether("selecciona".equals(accion))
            .andIfSo(
                Esperar.unTiempo(3000),
                EsperarElemento.esClickable(LST_BNT_PRODUCTO_VISTA_CARD),
                Click.on(LST_BNT_PRODUCTO_VISTA_CARD),
                EsperarCarga.desaparezca(),
                EsperarElemento.esClickable(BTN_CONFIGURACION),
                Click.on(BTN_CONFIGURACION))
            .otherwise(
                EsperarCarga.desaparezca(),
                EsperarElemento.esClickable(LST_BNT_PRODUCTO_VISTA_CARD),
                Click.on(BNT_CUENTA_DEPOSITO_VISTA_CARD_SECUNDA),
                EsperarCarga.desaparezca(),
                EsperarElemento.esClickable(BTN_CONFIGURACION_SEGUNDA_CUENTA),
                Click.on(BTN_CONFIGURACION_SEGUNDA_CUENTA)),
        Esperar.unTiempo(5000));
    actor.remember(
        "NumeroCuentaPreferida",
        formatearNumeros(Text.of(LBL_NUMERO_CUENTA).viewedBy(actor).asString()));
    actor.attemptsTo(
        EsperarElemento.esVisible(BTN_CUENTA_PREFERIDA),
        Click.on(BTN_CUENTA_PREFERIDA),
        EsperarElemento.esClickable(BTN_GUARDAR),
        Click.on(BTN_GUARDAR));
    if (!Visibility.of(BTN_CONFIRMAR_CAMBIO).viewedBy(actor).resolveAll().isEmpty()) {
      actor.attemptsTo(Click.on(BTN_CONFIRMAR_CAMBIO));
    }
    actor.attemptsTo(Esperar.unTiempo(3000), EsperarCarga.desaparezca());
  }
}
