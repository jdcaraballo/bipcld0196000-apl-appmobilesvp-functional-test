package com.banistmo.certificacion.questions.prestamos;

import static com.banistmo.certificacion.userinterface.comunes.ConfirmacionTransaccionGeneralPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import com.banistmo.certificacion.models.comun.Validacion;
import com.banistmo.certificacion.questions.VerificarMensaje;
import com.banistmo.certificacion.utils.UtileriaString;
import java.time.Duration;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.Wait;

public class VerificarTransaccionPrestamosTerceros implements Question<Boolean> {
  private Validacion validacion;
  private String mensajeExitoso;

  public VerificarTransaccionPrestamosTerceros(Validacion validacion, String mensajeExitoso) {
    this.validacion = validacion;
    this.mensajeExitoso = mensajeExitoso;
  }

  public static VerificarTransaccionPrestamosTerceros exitosa(
      Validacion validacion, String mensajeExitoso) {
    return new VerificarTransaccionPrestamosTerceros(validacion, mensajeExitoso);
  }

  @Override
  public Boolean answeredBy(Actor actor) {
    actor.attemptsTo(
        Wait.until(the(LBL_NUMERO_CUENTA_RETIRO), isCurrentlyVisible())
            .forNoLongerThan(30)
            .seconds());
    return verificarDatosComprobante(actor)
        && verificarDatosBeneficiario(actor)
        && verificarDatosBeneficiarioCuenta(actor)
        && VerificarMensaje.esVisible(mensajeExitoso).answeredBy(actor);
  }

  public boolean verificarDatosComprobante(Actor actor) {
    actor.attemptsTo(
        EsperarElemento.esVisible(
            LBL_NUMERO_COMPROBANTE.waitingForNoMoreThan(Duration.ofSeconds(20))));
    actor.attemptsTo(Ensure.that(LBL_NUMERO_COMPROBANTE).text().isNotBlank());
    return true;
  }

  public boolean verificarDatosBeneficiario(Actor actor) {
    String montoComprobante = Text.of(LBL_MONTO_COMPROBANTE).viewedBy(actor).asString().trim();
    actor.attemptsTo(Ensure.that(montoComprobante).contains(validacion.getProducto().getMonto()));
    return true;
  }

  public boolean verificarDatosBeneficiarioCuenta(Actor actor) {
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
}
