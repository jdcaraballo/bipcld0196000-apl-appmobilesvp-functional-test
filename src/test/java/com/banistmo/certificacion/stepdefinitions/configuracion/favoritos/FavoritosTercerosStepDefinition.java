package com.banistmo.certificacion.stepdefinitions.configuracion.favoritos;

import static com.banistmo.certificacion.exceptions.configuracion.favoritos.MensajeEdicionFavoritoNoVisualizadoException.MENSAJE_EDICION_FAVORITOS_NO_VISUALIZADO;
import static com.banistmo.certificacion.models.builders.TransaccionBuilder.con;
import static com.banistmo.certificacion.userinterface.configuracion.FavoritosGeneralPage.MSG_FAVORITO_CREADO_CORRECTAMENTE;
import static com.banistmo.certificacion.userinterface.menu.MenuPage.BTN_TRANSFERENCIAS;
import static com.banistmo.certificacion.userinterface.menu.MenuTransferenciasPage.BTN_TERCEROS;
import static com.banistmo.certificacion.utils.enums.EnumVariablesSesion.VERIFICAR_TRANSACCION;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import com.banistmo.certificacion.exceptions.configuracion.favoritos.MensajeEdicionFavoritoNoVisualizadoException;
import com.banistmo.certificacion.models.comun.Validacion;
import com.banistmo.certificacion.questions.ElementoEsperado;
import com.banistmo.certificacion.questions.configuracion.favoritos.VerificarModificacionTerceros;
import com.banistmo.certificacion.task.comunes.Retroceder;
import com.banistmo.certificacion.task.comunes.RetrocederDesdeFavoritos;
import com.banistmo.certificacion.task.configuracion.favoritos.RealizarCreacion;
import com.banistmo.certificacion.task.configuracion.favoritos.SeleccionarOpcion;
import com.banistmo.certificacion.task.configuracion.favoritos.editar.RealizarModificacion;
import com.banistmo.certificacion.task.menu.IngresarOpcion;
import cucumber.api.java.ast.Cuando;
import cucumber.api.java.ast.Y;
import cucumber.api.java.es.Entonces;
import java.util.List;
import java.util.Map;

public class FavoritosTercerosStepDefinition {

  @Cuando("^el intenta crear un favorito terceros$")
  public void crearFavoritoTerceros(List<Map<String, String>> datos) {
    theActorInTheSpotlight()
        .attemptsTo(
            RealizarCreacion.deFavoritoTerceros(
                con()
                    .nombreBeneficiario(datos)
                    .correo(datos)
                    .banco(datos)
                    .tipoProducto(datos)
                    .cuenta(datos)
                    .nombreFavorito(datos)));
  }

  @Cuando("^el intenta crear un favorito terceros desde transferencias$")
  public void crearFavoritoTercerosDesdeTransferencias(List<Map<String, String>> datos) {
    theActorInTheSpotlight()
        .attemptsTo(
            RetrocederDesdeFavoritos.hastaPantallaInicio(),
            IngresarOpcion.delMenu(BTN_TRANSFERENCIAS, BTN_TERCEROS),
            RealizarCreacion.deFavoritoTercerosDesdeTransferencias(
                con()
                    .nombreBeneficiario(datos)
                    .correo(datos)
                    .banco(datos)
                    .tipoProducto(datos)
                    .cuenta(datos)
                    .nombreFavorito(datos)));
  }

  @Y("^el intenta editar un favorito terceros$")
  public void editarFavoritoTerceros(List<Map<String, String>> datos) {
    theActorInTheSpotlight()
        .attemptsTo(
            RealizarModificacion.deFavoritoTerceros(con().nombreBeneficiario(datos).correo(datos)));
  }

  @Y("^el se devuelve hasta la pantalla de inicio$")
  public void devolversePantallaInicio() {
    theActorInTheSpotlight().attemptsTo(Retroceder.hastaPantallaInicio());
  }

  @Entonces("^el favorito terceros debio ser editado exitosamente$")
  public void verificarModificacionFavorito() {
    Validacion validacion =
        theActorInTheSpotlight().recall(VERIFICAR_TRANSACCION.getVariableSesion());
    theActorInTheSpotlight()
        .should(
            seeThat(ElementoEsperado.esVisible(MSG_FAVORITO_CREADO_CORRECTAMENTE))
                .orComplainWith(
                    MensajeEdicionFavoritoNoVisualizadoException.class,
                    MENSAJE_EDICION_FAVORITOS_NO_VISUALIZADO));
    theActorInTheSpotlight()
        .attemptsTo(SeleccionarOpcion.favoritos(validacion.getProducto().getDescripcion()));
    theActorInTheSpotlight()
        .should(
            seeThat(VerificarModificacionTerceros.favoritos(validacion))
                .orComplainWith(
                    MensajeEdicionFavoritoNoVisualizadoException.class,
                    MENSAJE_EDICION_FAVORITOS_NO_VISUALIZADO));
  }
}
