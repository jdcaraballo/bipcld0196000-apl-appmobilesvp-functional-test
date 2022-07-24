package com.banistmo.certificacion.stepdefinitions.servicios;

import static com.banistmo.certificacion.exceptions.pagos.PagoProgramadoExitosoException.PAGO_PROGRAMADO_NO_EXITOSO;
import static com.banistmo.certificacion.models.builders.ServicioBuilder.con;
import static com.banistmo.certificacion.userinterface.menu.MenuPage.BTN_PAGOS;
import static com.banistmo.certificacion.userinterface.menu.MenuPagosPage.BTN_SERVICIOS;
import static com.banistmo.certificacion.utils.enums.EnumMensajes.*;
import static com.banistmo.certificacion.utils.enums.EnumVariablesSesion.VERIFICAR_TRANSACCION;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import com.banistmo.certificacion.exceptions.pagos.PagoExitosoException;
import com.banistmo.certificacion.exceptions.pagos.PagoProgramadoExitosoException;
import com.banistmo.certificacion.models.comun.Validacion;
import com.banistmo.certificacion.questions.servicios.VerificarServicios;
import com.banistmo.certificacion.questions.servicios.VerificarServiciosProgramados;
import com.banistmo.certificacion.task.menu.IngresarOpcion;
import com.banistmo.certificacion.task.pagos.RealizarPago;
import cucumber.api.java.ast.Cuando;
import cucumber.api.java.es.Entonces;
import java.util.List;
import java.util.Map;

public class PagoServiciosStepDefinitions {
  @Cuando("^el intenta realizar el pago de un servicio$")
  public void realizarPagoServicio(List<Map<String, String>> datos) {
    theActorInTheSpotlight()
        .attemptsTo(
            IngresarOpcion.delMenu(BTN_PAGOS, BTN_SERVICIOS),
            RealizarPago.servicioNuevo(con().servicio(datos).telefono(datos).monto(datos)));
  }

  @Entonces("el pago al servicio deberia ser exitoso")
  public void verificarPagoServicio() {
    Validacion validacion =
        theActorInTheSpotlight().recall(VERIFICAR_TRANSACCION.getVariableSesion());
    theActorInTheSpotlight()
        .should(
            seeThat(
                    VerificarServicios.exitosa(
                        validacion, PAGO_EXITOSO_SEGUNDO_MENSAJE.getMensaje()))
                .orComplainWith(PagoExitosoException.class, PagoExitosoException.PAGO_NO_EXITOSO));
  }


  @Cuando("el pago al servicio deberia ser programado con exito")
  public void verificarPagoServicioProgramado() {
    Validacion validacion =
        theActorInTheSpotlight().recall(VERIFICAR_TRANSACCION.getVariableSesion());
    theActorInTheSpotlight()
        .should(
            seeThat(
                    VerificarServiciosProgramados.exitosa(
                        validacion, MENSAJE_EXITOSO_PAGO_SERVICIO_PROGRAMADA.getMensaje()))
                .orComplainWith(PagoProgramadoExitosoException.class, PAGO_PROGRAMADO_NO_EXITOSO));
  }
}
