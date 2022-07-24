package com.banistmo.certificacion.stepdefinitions.configuracion.favoritos;

import static com.banistmo.certificacion.exceptions.configuracion.favoritos.MensajeEdicionFavoritoNoVisualizadoException.MENSAJE_EDICION_FAVORITOS_NO_VISUALIZADO;
import static com.banistmo.certificacion.utils.enums.EnumVariablesSesion.VERIFICAR_TRANSACCION;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import com.banistmo.certificacion.exceptions.configuracion.favoritos.MensajeEdicionFavoritoNoVisualizadoException;
import com.banistmo.certificacion.models.builders.ServicioBuilder;
import com.banistmo.certificacion.models.comun.Validacion;
import com.banistmo.certificacion.questions.configuracion.favoritos.VerificarModificacionServicios;
import com.banistmo.certificacion.task.configuracion.favoritos.RealizarCreacion;
import com.banistmo.certificacion.task.configuracion.favoritos.SeleccionarOpcion;
import com.banistmo.certificacion.task.configuracion.favoritos.editar.RealizarModificacion;
import cucumber.api.java.ast.Cuando;
import cucumber.api.java.ast.Y;
import cucumber.api.java.es.Entonces;
import java.util.List;
import java.util.Map;

public class FavoritosServiciosStepDefinition {

  @Cuando("^el intenta crear un favorito servicios$")
  public void crearFavoritoInternacional(List<Map<String, String>> datos) {
    theActorInTheSpotlight()
        .attemptsTo(
            RealizarCreacion.deFavoritoServicios(
                ServicioBuilder.con()
                    .servicio(datos)
                    .numero(datos)
                    .nombreCliente(datos)
                    .nombreFavorito(datos)));
  }

  @Y("^el intenta editar un favorito servicio$")
  public void editarFavoritoRecargas(List<Map<String, String>> datos) {
    theActorInTheSpotlight()
        .attemptsTo(
            RealizarModificacion.deFavoritoServicio(
                ServicioBuilder.con().nombreCliente(datos).numero(datos)));
  }

  @Entonces("^el favorito servicio debio ser editado exitosamente$")
  public void verificarModificacionFavoritoServicio() {
    Validacion validacion =
        theActorInTheSpotlight().recall(VERIFICAR_TRANSACCION.getVariableSesion());
    theActorInTheSpotlight()
        .attemptsTo(SeleccionarOpcion.favoritos(validacion.getProducto().getDescripcion()));
    theActorInTheSpotlight()
        .should(
            seeThat(VerificarModificacionServicios.favoritos(validacion))
                .orComplainWith(
                    MensajeEdicionFavoritoNoVisualizadoException.class,
                    MENSAJE_EDICION_FAVORITOS_NO_VISUALIZADO));
  }
}
