package com.banistmo.certificacion.stepdefinitions.transferencias.qr;

import static com.banistmo.certificacion.userinterface.menu.MenuPage.BTN_QR;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import com.banistmo.certificacion.task.compartir.CompartirQR;
import com.banistmo.certificacion.task.comunes.cancelartransaccion.CancelarQR;
import com.banistmo.certificacion.task.menu.IngresarOpcion;
import com.banistmo.certificacion.task.transferencias.qr.*;
import com.banistmo.certificacion.userinterface.menu.MenuPage;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Y;

public class GenerarQRStepdefinition {

  @Cuando("^el intenta generar código QR sin monto y con descripción (.*)$")
  public void generarCodigoQRSinMonto(String descripcion) {
    theActorInTheSpotlight()
        .attemptsTo(
            EsperarCarga.desaparezca(),
            EsperarElemento.esVisible(BTN_QR),
            IngresarOpcion.delMenu(BTN_QR, MenuPage.BTN_GENERAR_QR),
            PrepararQRSin.sinMonto(descripcion));
    theActorInTheSpotlight().should(seeThat(TerminarDatosQR.enQR()));
  }

  @Y("^el descargara (?:el|la) (.*) del resultado de la transaccion$")
  public void descargaraElPDFDelResultadoDeLaTransaccion(String archivoGenerar) {
    theActorInTheSpotlight().attemptsTo(CompartirQR.transaccionRealizada(archivoGenerar));
  }

  @Cuando("^el intenta generar código QR con monto (.*) y descripción (.*)$")
  public void generarCodigoQRConMonto(String monto, String descripcion) {
    theActorInTheSpotlight()
        .attemptsTo(
            EsperarCarga.desaparezca(),
            EsperarElemento.esVisible(BTN_QR),
            IngresarOpcion.delMenu(BTN_QR, MenuPage.BTN_GENERAR_QR),
            PrepararQRCon.conMonto(monto, descripcion));
    theActorInTheSpotlight().should(seeThat(TerminarDatosQR.enQR()));
  }

  @Y("^el modifica los datos del QR con monto (.*) y descripcion (.*)$")
  public void modificarDatosQR(String monto, String descripcion) {
    theActorInTheSpotlight().attemptsTo(ModificarDatosQR.deQR(monto, descripcion));
    theActorInTheSpotlight().should(seeThat(TerminarDatosQR.enQR()));
  }

  @Cuando("^el intenta llenar los datos del código QR monto (.*) descripcion: (.*)$")
  public void cancelarGeneracionQR(String monto, String descripcion) {
    theActorInTheSpotlight()
        .attemptsTo(
            EsperarCarga.desaparezca(),
            EsperarElemento.esVisible(BTN_QR),
            IngresarOpcion.delMenu(BTN_QR, MenuPage.BTN_GENERAR_QR),
            PrepararQRCon.conMonto(monto, descripcion));
  }

  @Y("^cancela la operación$")
  public void cancelaLaGeneracionDeQR() {
    theActorInTheSpotlight().attemptsTo(CancelarQR.generarQR());
  }

  @Cuando("^el intenta modificar código QR sin monto y con descripción (.*)$")
  public void llenaDatosModificarQR(String descripcion) {
    theActorInTheSpotlight()
        .attemptsTo(
            EsperarCarga.desaparezca(),
            EsperarElemento.esVisible(BTN_QR),
            IngresarOpcion.delMenu(BTN_QR, MenuPage.BTN_GENERAR_QR),
            PrepararQRSin.sinMonto(descripcion));
  }
}
