package com.banistmo.certificacion.task.configuracion.productos.preferida;

import static com.banistmo.certificacion.userinterface.PrincipalPage.*;
import static com.banistmo.certificacion.userinterface.configuracion.administracion.producto.ConfiguracionProductoPage.BTN_CUENTA_PREFERIDA;
import static com.banistmo.certificacion.userinterface.configuracion.administracion.producto.ConfiguracionProductoPage.BTN_GUARDAR;
import static com.banistmo.certificacion.userinterface.detalles.TransaccionesDetallesPage.BTN_CONFIGURACION;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.banistmo.certificacion.interactions.ClickAleatorio;
import com.banistmo.certificacion.interactions.esperas.Esperar;
import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import com.banistmo.certificacion.task.comunes.Retroceder;
import com.banistmo.certificacion.task.comunes.SeleccionarVista;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Visibility;

public class VerficarPreferida implements Task {

  private final String condicion;

  public VerficarPreferida(String condicion) {
    this.condicion = condicion;
  }

  public static VerficarPreferida cuentaPropia(String condicion) {
    return instrumented(VerficarPreferida.class, condicion);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
            SeleccionarVista.tipoCard(),
        EsperarElemento.esClickable(BTN_CUENTAS_DEPOSITOS_CARD),
        Click.on(BTN_CUENTAS_DEPOSITOS_CARD),
        EsperarCarga.desaparezca());
    if ("no".equals(condicion)) {
      if (!Visibility.of(ICONO_ESTRELLA).viewedBy(actor).resolveAll().isEmpty()) {
        actor.attemptsTo(
            Click.on(ICONO_ESTRELLA),
            EsperarCarga.desaparezca(),
            EsperarElemento.esClickable(BTN_CONFIGURACION),
            Click.on(BTN_CONFIGURACION),
            EsperarCarga.desaparezca(),
            EsperarElemento.esClickable(BTN_CUENTA_PREFERIDA),
            Click.on(BTN_CUENTA_PREFERIDA),
            EsperarElemento.esClickable(BTN_GUARDAR),
            Click.on(BTN_GUARDAR),
            EsperarCarga.desaparezca());
      }
    } else {
      if (!Visibility.of(ICONO_ESTRELLA).viewedBy(actor).asBoolean()) {
        actor.attemptsTo(
            ClickAleatorio.enElemento(LST_BNT_PRODUCTO_VISTA_CARD),
            EsperarCarga.desaparezca(),
            Click.on(BTN_CONFIGURACION),
            EsperarElemento.esClickable(BTN_CUENTA_PREFERIDA),
            Click.on(BTN_CUENTA_PREFERIDA),
            EsperarElemento.esClickable(BTN_GUARDAR),
            Click.on(BTN_GUARDAR),
            EsperarCarga.desaparezca());
      }
    }
    actor.attemptsTo(Retroceder.hastaPantallaInicio());
  }
}
