package com.banistmo.certificacion.task.pagos.prestamos;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.banistmo.certificacion.interactions.SelecionarLista;
import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import com.banistmo.certificacion.models.comun.Transaccion;
import com.banistmo.certificacion.userinterface.transferencias.terceros.DatosTercerosPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class IngresarDatosPrestamo implements Task {

  private Transaccion prestamo;

  public IngresarDatosPrestamo(Transaccion prestamo) {
    this.prestamo = prestamo;
  }

  public static IngresarDatosPrestamo nuevo(Transaccion prestamo) {
    return instrumented(IngresarDatosPrestamo.class, prestamo);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        Enter.theValue(prestamo.getBeneficiario().getNombre()).into(DatosTercerosPage.TXT_NOMBRE),
        Enter.theValue(prestamo.getBeneficiario().getCorreo()).into(DatosTercerosPage.TXT_CORREO),
        Click.on(DatosTercerosPage.BTN_BANCO),
        EsperarCarga.desaparezca(),
        EsperarElemento.esClickable(DatosTercerosPage.LST_BTN_BANCO_PRODUCTOS),
        SelecionarLista.unaOpcion(
            prestamo.getProducto().getBanco(), DatosTercerosPage.LST_BTN_BANCO_PRODUCTOS, true),
        EsperarCarga.desaparezca(),
        EsperarElemento.esClickable(DatosTercerosPage.TXT_NUMERO_CUENTA),
        Enter.theValue(prestamo.getProducto().getNumeroCuentaDestino())
            .into(DatosTercerosPage.TXT_NUMERO_CUENTA));
  }
}
