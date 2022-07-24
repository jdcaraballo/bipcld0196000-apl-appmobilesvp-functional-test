package com.banistmo.certificacion.questions.prestamos.programados;

import static com.banistmo.certificacion.task.comunes.programar.FechaFutura.TEXTO_FECHA_FUTURA;
import static com.banistmo.certificacion.userinterface.comunes.ConfirmacionTransaccionGeneralPage.*;
import static com.banistmo.certificacion.userinterface.comunes.ProgramadasPage.BTN_IR_A_CONSOLIDADOS;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import com.banistmo.certificacion.models.comun.Validacion;
import com.banistmo.certificacion.questions.VerificarMensaje;
import com.banistmo.certificacion.utils.UtileriaString;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.Wait;

public class VerificarPagoDePrestamoProgramado implements Question<Boolean> {
  private Validacion validacion;
  private String mensajeExitoso;

  public VerificarPagoDePrestamoProgramado(Validacion validacion, String mensaje) {
    this.validacion = validacion;
    this.mensajeExitoso = mensaje;
  }

  public static VerificarPagoDePrestamoProgramado exitoso(Validacion validacion, String mensaje) {
    return new VerificarPagoDePrestamoProgramado(validacion, mensaje);
  }

  @Override
  public Boolean answeredBy(Actor actor) {
    actor.attemptsTo(EsperarElemento.esVisible(BTN_IR_A_CONSOLIDADOS));
    return verificarCuentas(actor)
        && verificarComprobante(actor)
        && verificarComprobanteConFecha(actor);
  }

  public boolean verificarCuentas(Actor actor) {
    actor.attemptsTo(
        Wait.until(the(LBL_NUMERO_CUENTA_RETIRO), isCurrentlyVisible())
            .forNoLongerThan(30)
            .seconds());
    String numeroCuentaRetiro = Text.of(LBL_NUMERO_CUENTA_RETIRO).viewedBy(actor).asString().trim();
    String montoComprobante =
        (UtileriaString.eliminarPalabra(
            Text.of(LBL_MONTO_COMPROBANTE).viewedBy(actor).asString(), "$"));

    actor.attemptsTo(
        Ensure.that(numeroCuentaRetiro).contains(validacion.getProducto().getNumeroCuentaRetiro()),
        Ensure.that(montoComprobante).isEqualTo(validacion.getProducto().getMonto()));
    return true;
  }

  public boolean verificarComprobante(Actor actor) {
    actor.attemptsTo(
        Wait.until(the(LBL_NUMERO_CUENTA_RETIRO), isCurrentlyVisible())
            .forNoLongerThan(30)
            .seconds());
    actor.attemptsTo(Ensure.that(LBL_NUMERO_COMPROBANTE).text().isNotBlank());
    return true;
  }

  public boolean verificarComprobanteConFecha(Actor actor) {

    if (validacion.getProducto().getTipoTransaccion().equals(TEXTO_FECHA_FUTURA)) {
      return Text.of(LBL_NUMERO_COMPROBANTE).viewedBy(actor).asString() != null
          && VerificarMensaje.esVisible(mensajeExitoso).answeredBy(actor)
          && Text.of(LBL_COMPROBANTE.of("Fecha de pago"))
              .viewedBy(actor)
              .asString()
              .equals(validacion.getProducto().getFechaFuturo());

    } else {

      Boolean resultadoComprobanteMensajeFechaInicial =
          Text.of(LBL_NUMERO_COMPROBANTE).viewedBy(actor).asString() != null
              && VerificarMensaje.esVisible(mensajeExitoso).answeredBy(actor)
              && Text.of(LBL_COMPROBANTE.of("Fecha inicial"))
                  .viewedBy(actor)
                  .asString()
                  .equals(validacion.getProducto().getFechaFuturo());

      Boolean resultadoFechaFinalDiaYFrecuencia =
          Text.of(LBL_COMPROBANTE.of("Fecha final"))
                  .viewedBy(actor)
                  .asString()
                  .equals(validacion.getProducto().getFechaFuturoFin())
              && Text.of(LBL_COMPROBANTE.of("Día"))
                  .viewedBy(actor)
                  .asString()
                  .equals(validacion.getProducto().getDiaRecurrente())
              && Text.of(LBL_COMPROBANTE.of("Frecuencia"))
                  .viewedBy(actor)
                  .asString()
                  .equals(validacion.getProducto().getFrecuencia());
      return resultadoComprobanteMensajeFechaInicial && resultadoFechaFinalDiaYFrecuencia;
    }
  }
}
