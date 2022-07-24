package com.banistmo.certificacion.task.configuracion.productos.preferida;

import static com.banistmo.certificacion.userinterface.configuracion.administracion.producto.ConfiguracionProductoPage.*;
import static com.banistmo.certificacion.userinterface.configuracion.administracion.producto.ConfiguracionProductoPage.LBL_NUMERO_CUENTA_PREFERIDA;
import static com.banistmo.certificacion.utils.UtileriaString.formatearNumeros;

import com.banistmo.certificacion.interactions.ClickAleatorio;
import com.banistmo.certificacion.interactions.Regresar;
import com.banistmo.certificacion.interactions.esperas.Esperar;
import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import com.banistmo.certificacion.task.comunes.Retroceder;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.questions.Visibility;

public class CuentaPreferidaConfiguracion implements Task {

  private final String accion;

  public CuentaPreferidaConfiguracion(String accion) {
    this.accion = accion;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        Check.whether("selecciona".equals(accion))
            .andIfSo(
                EsperarElemento.esClickable(LST_BTN_CUENTAS),
                ClickAleatorio.enElemento(LST_BTN_CUENTAS))
            .otherwise(EsperarElemento.esClickable(LST_BTN_CUENTAS), Click.on(BTN_CUENTA_SEGUNDA)),
        EsperarCarga.desaparezca(),
        EsperarElemento.esClickable(BTN_CUENTA_PREFERIDA),
        Click.on(BTN_CUENTA_PREFERIDA),
        EsperarElemento.esClickable(BTN_GUARDAR),
        Click.on(BTN_GUARDAR),
        EsperarCarga.desaparezca());
    if (!Visibility.of(BTN_CONFIRMAR_CAMBIO).viewedBy(actor).resolveAll().isEmpty()) {
      actor.attemptsTo(Click.on(BTN_CONFIRMAR_CAMBIO));
    }
    actor.attemptsTo(
        Esperar.unTiempo(5000), EsperarElemento.esVisible(LBL_NUMERO_CUENTA_PREFERIDA));
    actor.remember(
        "NumeroCuentaPreferida",
        formatearNumeros(Text.of(LBL_NUMERO_CUENTA_PREFERIDA).viewedBy(actor).asString()));
    actor.attemptsTo(
            Retroceder.hastaPantallaInicio());
  }
}
