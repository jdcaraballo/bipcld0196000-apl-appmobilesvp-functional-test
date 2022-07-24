package com.banistmo.certificacion.task.configuracion.productos.objetivo;

import static com.banistmo.certificacion.userinterface.configuracion.administracion.producto.ConfiguracionProductoPage.*;
import static com.banistmo.certificacion.utils.UtileriaString.eliminarPalabra;
import static com.banistmo.certificacion.utils.enums.EnumVariablesSesion.NUMERO_CUENTA;
import static com.banistmo.certificacion.utils.enums.EnumVariablesSesion.VALOR_AHORRO;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.banistmo.certificacion.interactions.ClickAleatorio;
import com.banistmo.certificacion.interactions.Escribir;
import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import java.util.List;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.questions.Visibility;
import org.openqa.selenium.Keys;

public class DefinirObjetivo implements Task {

  private String tipoEscenario;

  public DefinirObjetivo(String tipoEscenario) {
    this.tipoEscenario = tipoEscenario;
  }

  public static DefinirObjetivo deAhorro(String tipoEscenario) {
    return instrumented(DefinirObjetivo.class, tipoEscenario);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    quitarObjetivosAhorro(actor);
    actor.attemptsTo(ClickAleatorio.enElemento(LST_BTN_CUENTAS));
    String saldoActual =
        Text.of(LBL_VALOR_DISPONIBLE_CUENTA)
            .viewedBy(actor)
            .asString()
            .replace("$", "")
            .replace(",", "");
    double valorAhorro = valorAhorro(saldoActual);
    actor.remember(
        NUMERO_CUENTA.getVariableSesion(),
        eliminarPalabra(
            eliminarPalabra(
                Text.of(LBL_NUMERO_CUENTA).viewedBy(actor).asString(), "Cuenta corriente "),
            "Cuenta de ahorros "));
    actor.remember(VALOR_AHORRO.getVariableSesion(), valorAhorro);
    actor.attemptsTo(
        EsperarCarga.desaparezca(),
        EsperarElemento.esClickable(CHK_DEFINIR_OBJETIVO),
        Click.on(CHK_DEFINIR_OBJETIVO),
        EsperarCarga.desaparezca(),
        EsperarElemento.esClickable(TXT_MONTO_AHORRO),
        Escribir.valorPlataforma(String.valueOf(valorAhorro), TXT_MONTO_AHORRO),
        Click.on(LBL_VALOR_DISPONIBLE_CUENTA),
        Check.whether("exitoso".equals(tipoEscenario))
            .andIfSo(Click.on(BTN_GUARDAR))
            .otherwise(Enter.keyValues(Keys.BACK_SPACE).into(TXT_MONTO_AHORRO)),
        EsperarCarga.desaparezca());
  }

  private <T extends Actor> void quitarObjetivosAhorro(T actor) {
    List<WebElementFacade> productos = LST_BTN_CUENTAS.resolveAllFor(actor);
    for (int i = 0; i < productos.size(); i++) {
      productos = LST_BTN_CUENTAS.resolveAllFor(actor);
      actor.attemptsTo(
          Click.on(productos.get(i)), EsperarElemento.esClickable(BTN_EDITAR_NOMBRE_CUENTA));
      if (!Visibility.of(CHK_DEFINIR_OBJETIVO_ACTIVADA).viewedBy(actor).resolveAll().isEmpty()) {
        actor.attemptsTo(
            Click.on(CHK_DEFINIR_OBJETIVO),
            Click.on(BTN_GUARDAR),
            EsperarCarga.desaparezca(),
            EsperarCarga.desaparezca());
      } else {
        actor.attemptsTo(
            EsperarCarga.desaparezca(),
            EsperarElemento.esClickable(BTN_CANCELAR),
            Click.on(BTN_CANCELAR),
            EsperarCarga.desaparezca());
      }
    }
  }

  private double valorAhorro(String saldoActual) {
    if ("exitoso".equals(tipoEscenario)) {
      return Double.parseDouble(saldoActual) * 2;
    } else {
      return Double.parseDouble(saldoActual) - 1;
    }
  }
}
