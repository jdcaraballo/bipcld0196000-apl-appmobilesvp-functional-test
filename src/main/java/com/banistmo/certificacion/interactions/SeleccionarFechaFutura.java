package com.banistmo.certificacion.interactions;

import static com.banistmo.certificacion.userinterface.comunes.CalendarioPage.*;
import static com.banistmo.certificacion.userinterface.comunes.TransaccionesGeneralPage.*;
import static com.banistmo.certificacion.utils.UtileriaDriver.cambiarContexto;
import static com.banistmo.certificacion.utils.UtileriaDriver.getPlataformaEjecucion;
import static com.banistmo.certificacion.utils.enums.EnumContextosDriver.NATIVA;
import static com.banistmo.certificacion.utils.enums.EnumContextosDriver.WEBVIEW;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.banistmo.certificacion.utils.Fechas;
import com.banistmo.certificacion.utils.enums.EnumFormatoFecha;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;

public class SeleccionarFechaFutura implements Interaction {

  private final int dias;

  public SeleccionarFechaFutura(int dias) {
    this.dias = dias;
  }

  public static SeleccionarFechaFutura enCalendario(int dias) {
    return instrumented(SeleccionarFechaFutura.class, dias);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    String fechaFuturaMes =
        Fechas.obtenerFechaFuturaDias(dias, EnumFormatoFecha.FORMATO_FECHA_MMM.getFormatoFecha());
    String fechaFuturaAnio =
        Fechas.obtenerFechaFuturaDias(dias, EnumFormatoFecha.FORMATO_FECHA_YYYY.getFormatoFecha());
    int loopMes = 0;
    if ("iOS".equalsIgnoreCase(getPlataformaEjecucion())) {
      fechaFuturaMes =
          Fechas.obtenerFechaFuturaDias(
              dias, EnumFormatoFecha.FORMATO_FECHA_MMMM.getFormatoFecha());
      fechaFuturaMes =
          Character.toUpperCase(fechaFuturaMes.charAt(0)) + fechaFuturaMes.substring(1);
      cambiarContexto(NATIVA);
      while (!ANIO_CALENDARIO_NATIVO_IOS.of(fechaFuturaAnio).resolveFor(actor).isVisible()) {
        actor.attemptsTo(Click.on(FLECHA_DERECHA_CALENDARIO_NATIVA_IOS));
      }
      while (!MES_CALENDARIO_NATIVO_IOS.of(fechaFuturaMes).resolveFor(actor).isVisible()
          || loopMes > 12) {
        actor.attemptsTo(Click.on(FLECHA_DERECHA_CALENDARIO_NATIVA_IOS));
        loopMes++;
      }
      actor.attemptsTo(
          Click.on(
              BTN_FECHA_CALENDARIO_NATIVO_IOS.of(
                  Fechas.obtenerFechaFuturaDias(
                      dias, EnumFormatoFecha.FORMATO_FECHA_DD.getFormatoFecha()))),
          Click.on(BTN_CONTINUAR_CALENDARIO_NATIVA_IOS));
      cambiarContexto(WEBVIEW);
    } else {
      while (!fechaFuturaAnio.equals(ANIO_CALENDARIO.resolveFor(actor).getText())) {
        actor.attemptsTo(Click.on(FLECHA_DERECHA_CALENDARIO));
      }
      while (!fechaFuturaMes
          .replace(".", "")
          .equalsIgnoreCase(
              MES_CALENDARIO.resolveFor(actor).getText().substring(0, 3).replace(".", ""))) {
        actor.attemptsTo(Click.on(FLECHA_DERECHA_CALENDARIO));
        loopMes++;
        if (loopMes == 12) {
          throw new RuntimeException("Fallo");
        }
      }
      actor.attemptsTo(
          Click.on(
              BTN_FECHA_CALENDARIO.of(
                  Fechas.obtenerFechaFuturaDias(
                      dias, EnumFormatoFecha.FORMATO_FECHA_DD.getFormatoFecha()))),
          Click.on(BTN_CONTINUAR_CALENDARIO));
    }
  }
}
