package com.banistmo.certificacion.questions.recargas;

import static com.banistmo.certificacion.userinterface.comunes.ConfirmacionTransaccionGeneralPage.*;
import static com.banistmo.certificacion.userinterface.recargas.ComprobanteRecargasPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import com.banistmo.certificacion.models.comun.Validacion;
import com.banistmo.certificacion.questions.VerificarMensaje;
import java.time.Duration;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.Wait;

public class VerificarRecarga implements Question<Boolean> {
  private Validacion validacion;
  private String mensajeExitoso;

  public VerificarRecarga(Validacion validacion, String mensajeExitoso) {
    this.validacion = validacion;
    this.mensajeExitoso = mensajeExitoso;
  }

  public static VerificarRecarga exitosa(Validacion validacion, String mensajeExitoso) {
    return new VerificarRecarga(validacion, mensajeExitoso);
  }

  @Override
  public Boolean answeredBy(Actor actor) {
    actor.attemptsTo(
        Wait.until(the(LBL_NUMERO_CUENTA_RETIRO), isCurrentlyVisible())
            .forNoLongerThan(30)
            .seconds());
    return verificarDatosRecarga(actor)
        && verificarDatosComprobante(actor)
        && VerificarMensaje.esVisible(mensajeExitoso).answeredBy(actor);
  }

  public boolean verificarDatosRecarga(Actor actor) {
    actor.attemptsTo(EsperarCarga.desaparezca());
    String detallesComprobante = Text.of(LBL_DETALLES).viewedBy(actor).asString();
    String numeroRecargaComprobante = Text.of(LBL_NUMERO_RECARGA).viewedBy(actor).asString().trim();
    actor.attemptsTo(
        Ensure.that(detallesComprobante)
            .contains(validacion.getRecargas().getProducto().getDescripcion()),
        Ensure.that(numeroRecargaComprobante)
            .contains(validacion.getRecargas().getBeneficiario().getNumero()));
    return true;
  }

  public boolean verificarDatosComprobante(Actor actor) {
    actor.attemptsTo(
        EsperarElemento.esVisible(
            LBL_NUMERO_COMPROBANTE.waitingForNoMoreThan(Duration.ofSeconds(20))));
    actor.attemptsTo(Ensure.that(LBL_NUMERO_COMPROBANTE).text().isNotBlank());
    return true;
  }
}
