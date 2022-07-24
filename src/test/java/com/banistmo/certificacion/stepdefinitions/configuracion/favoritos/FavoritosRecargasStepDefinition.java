package com.banistmo.certificacion.stepdefinitions.configuracion.favoritos;

import static com.banistmo.certificacion.exceptions.configuracion.favoritos.MensajeEdicionFavoritoNoVisualizadoException.MENSAJE_EDICION_FAVORITOS_NO_VISUALIZADO;
import static com.banistmo.certificacion.utils.enums.EnumVariablesSesion.VERIFICAR_TRANSACCION;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import com.banistmo.certificacion.exceptions.configuracion.favoritos.MensajeEdicionFavoritoNoVisualizadoException;
import com.banistmo.certificacion.models.builders.RecargasBuilder;
import com.banistmo.certificacion.models.comun.Validacion;
import com.banistmo.certificacion.questions.configuracion.favoritos.VerificarModificacionRecargas;
import com.banistmo.certificacion.task.configuracion.favoritos.RealizarCreacion;
import com.banistmo.certificacion.task.configuracion.favoritos.SeleccionarOpcion;
import com.banistmo.certificacion.task.configuracion.favoritos.editar.RealizarModificacion;
import cucumber.api.java.ast.Cuando;
import cucumber.api.java.ast.Y;
import cucumber.api.java.es.Entonces;
import java.util.List;
import java.util.Map;

public class FavoritosRecargasStepDefinition {

  @Cuando("^el intenta crear un favorito recargas$")
  public void crearFavoritoInternacional(List<Map<String, String>> datos) {
    theActorInTheSpotlight()
        .attemptsTo(
            RealizarCreacion.deFavoritoRecargas(
                RecargasBuilder.con()
                    .tipoProducto(datos)
                    .numero(datos)
                    .nombreFavorito(datos)
                    .nombreOperador(datos)));
  }

  @Y("^el intenta editar un favorito recargas$")
  public void editarFavoritoRecargas(List<Map<String, String>> datos) {
    theActorInTheSpotlight()
        .attemptsTo(RealizarModificacion.deFavoritoRecargas(RecargasBuilder.con().numero(datos)));
  }

  @Entonces("^el favorito recarga debio ser editado exitosamente$")
  public void verificarModificacionFavoritoRecarga() {
    Validacion validacion =
        theActorInTheSpotlight().recall(VERIFICAR_TRANSACCION.getVariableSesion());
    theActorInTheSpotlight()
        .attemptsTo(SeleccionarOpcion.favoritos(validacion.getProducto().getDescripcion()));
    theActorInTheSpotlight()
        .should(
            seeThat(VerificarModificacionRecargas.favoritos(validacion))
                .orComplainWith(
                    MensajeEdicionFavoritoNoVisualizadoException.class,
                    MENSAJE_EDICION_FAVORITOS_NO_VISUALIZADO));
  }
}
