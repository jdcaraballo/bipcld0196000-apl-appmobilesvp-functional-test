package com.banistmo.certificacion.stepdefinitions.configuracion.favoritos;

import static com.banistmo.certificacion.exceptions.configuracion.favoritos.FavoritoNoActivadoException.FAVORITOS_NO_ACTIVADO;
import static com.banistmo.certificacion.exceptions.configuracion.favoritos.FavoritoNoInactivadoException.FAVORITOS_NO_INACTIVADO;
import static com.banistmo.certificacion.exceptions.configuracion.favoritos.FavoritoNoVisualizadoException.FAVORITO_NO_VISUALIZADO;
import static com.banistmo.certificacion.exceptions.configuracion.favoritos.MensajeCreacionFavoritoNoVisualizadoException.MENSAJE_CREACION_FAVORITOS_NO_VISUALIZADO;
import static com.banistmo.certificacion.exceptions.configuracion.favoritos.MensajeEdicionFavoritoNoVisualizadoException.MENSAJE_EDICION_FAVORITOS_NO_VISUALIZADO;
import static com.banistmo.certificacion.exceptions.configuracion.favoritos.MensajeEliminacionFavoritosNoVisualizadoException.MENSAJE_ELIMINACION_FAVORITOS_NO_VISUALIZADO;
import static com.banistmo.certificacion.models.builders.TransaccionBuilder.con;
import static com.banistmo.certificacion.userinterface.configuracion.FavoritosGeneralPage.*;
import static com.banistmo.certificacion.userinterface.configuracion.administracion.AdministracionPage.BTN_MIS_FAVORITOS;
import static com.banistmo.certificacion.userinterface.transferencias.terceros.TercerosPage.MSG_CREACION_EXITOS_FAVORITO;
import static com.banistmo.certificacion.utils.enums.EnumVariablesSesion.VERIFICAR_TRANSACCION;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

import com.banistmo.certificacion.exceptions.configuracion.favoritos.*;
import com.banistmo.certificacion.models.comun.Validacion;
import com.banistmo.certificacion.questions.ElementoEsperado;
import com.banistmo.certificacion.questions.configuracion.favoritos.VerificarActivacion;
import com.banistmo.certificacion.questions.configuracion.favoritos.VerificarInactivacion;
import com.banistmo.certificacion.questions.configuracion.favoritos.VerificarModificacionInternacional;
import com.banistmo.certificacion.questions.configuracion.productos.VerificarCreacion;
import com.banistmo.certificacion.task.configuracion.Ingresar;
import com.banistmo.certificacion.task.configuracion.favoritos.*;
import com.banistmo.certificacion.task.configuracion.favoritos.RealizarCreacion;
import com.banistmo.certificacion.task.configuracion.favoritos.editar.RealizarModificacion;
import com.banistmo.certificacion.task.configuracion.favoritos.eliminar.Eliminar;
import com.banistmo.certificacion.task.configuracion.favoritos.eliminar.EliminarFavoritoAntes;
import com.banistmo.certificacion.task.configuracion.favoritos.inactivar.ActivarFavorito;
import com.banistmo.certificacion.task.configuracion.favoritos.inactivar.InactivarFavorito;
import com.banistmo.certificacion.utils.enums.EnumTexto;
import cucumber.api.java.ast.Cuando;
import cucumber.api.java.ast.Y;
import cucumber.api.java.es.Entonces;
import java.util.List;
import java.util.Map;

public class FavoritosInternacionalesStepDefinition {

  @Y("^el ingresa en las pestaña de favoritos a (.*)$")
  public void ingresarPestanaFavoritos(String pestanaFavoritos) {
    theActorInTheSpotlight()
        .attemptsTo(
            Ingresar.aConfiguracion(EnumTexto.TEXTO_ADMINISTRACION.getTexto(), BTN_MIS_FAVORITOS),
            IngresarFavorito.opcion(pestanaFavoritos));
  }

  @Y("^el elimina el favoritos con el nombre: (.*)$")
  public void eliminarFavorito(String nombre) {
    theActorInTheSpotlight().attemptsTo(EliminarFavoritoAntes.deLaPrueba(nombre));
  }

  @Cuando("^el intenta crear una cuenta favorita internacional$")
  public void crearFavoritoInternacional(List<Map<String, String>> datos) {
    theActorInTheSpotlight()
        .attemptsTo(
            RealizarCreacion.deFavoritoInternacional(
                con()
                    .pais(datos)
                    .banco(datos)
                    .numeroCuenta(datos)
                    .nombreBeneficiario(datos)
                    .paisBeneficiario(datos)
                    .ciudad(datos)
                    .direccion(datos)
                    .correo(datos)
                    .nombreFavorito(datos)));
  }

  @Y("^el intenta editar un favorito internacional$")
  public void editarFavoritoInternacional(List<Map<String, String>> datos) {
    theActorInTheSpotlight()
        .attemptsTo(
            RealizarModificacion.deFavoritoInternacional(
                con().nombreBeneficiario(datos).ciudad(datos)));
  }

  @Entonces("^la cuenta favorito se ha creado exitosamente$")
  public void verificarCreacionFavoritos() {
    Validacion validacion =
        theActorInTheSpotlight().recall(VERIFICAR_TRANSACCION.getVariableSesion());
    theActorInTheSpotlight()
        .should(
            seeThat(VerificarCreacion.deFavorito(validacion.getProducto().getDescripcion()))
                .orComplainWith(FavoritoNoVisualizadoException.class, FAVORITO_NO_VISUALIZADO));
  }

  @Entonces("^el favorito internacional debio ser editado exitosamente$")
  public void verificarModificacionFavorito() {
    Validacion validacion =
        theActorInTheSpotlight().recall(VERIFICAR_TRANSACCION.getVariableSesion());
    theActorInTheSpotlight()
        .attemptsTo(SeleccionarOpcion.favoritos(validacion.getProducto().getDescripcion()));
    theActorInTheSpotlight()
        .should(
            seeThat(VerificarModificacionInternacional.favoritos(validacion))
                .orComplainWith(
                    MensajeEdicionFavoritoNoVisualizadoException.class,
                    MENSAJE_EDICION_FAVORITOS_NO_VISUALIZADO));
  }

  @Entonces("^el favorito debio ser editado exitosamente desde transferencias$")
  public void verificarCreacionFavoritoDesdeFavoritos() {
    theActorInTheSpotlight()
        .should(
            seeThat(ElementoEsperado.esVisible(MSG_CREACION_EXITOS_FAVORITO))
                .orComplainWith(
                    MensajeCreacionFavoritoNoVisualizadoException.class,
                    MENSAJE_CREACION_FAVORITOS_NO_VISUALIZADO));
  }

  @Y("^el inactiva el favorito creado$")
  public void inactivarFavorito() {
    theActorInTheSpotlight().attemptsTo(InactivarFavorito.creado());
  }

  @Y("^el activa el favorito inactivo$")
  public void activarFavorito() {
    theActorInTheSpotlight().attemptsTo(ActivarFavorito.inactivo());
  }

  @Entonces("^el favorito debio ser activado exitosamente$")
  public void verificarFavoritoActivado() {
    Validacion validacion =
        theActorInTheSpotlight().recall(VERIFICAR_TRANSACCION.getVariableSesion());
    theActorInTheSpotlight()
        .should(
            seeThat(VerificarActivacion.deFavoritos(validacion))
                .orComplainWith(FavoritoNoActivadoException.class, FAVORITOS_NO_ACTIVADO));
  }

  @Entonces("^el favorito debio ser inactivado exitosamente$")
  public void verificarFavoritoInactivado() {
    Validacion validacion =
        theActorInTheSpotlight().recall(VERIFICAR_TRANSACCION.getVariableSesion());
    theActorInTheSpotlight()
        .should(
            seeThat(VerificarInactivacion.deFavoritos(validacion))
                .orComplainWith(FavoritoNoInactivadoException.class, FAVORITOS_NO_INACTIVADO));
  }

  @Y("^el intenta eliminar una cuenta favorita$")
  public void eliminarFavoritos() {
    Validacion validacion =
        theActorInTheSpotlight().recall(VERIFICAR_TRANSACCION.getVariableSesion());
    theActorInTheSpotlight()
        .attemptsTo(Eliminar.favorito(validacion.getProducto().getDescripcion()));
  }

  @Entonces("^se elimina exitosamente la cuenta favorita$")
  public void verificarFavoritoEliminado() {
    Validacion validacion =
        theActorInTheSpotlight().recall(VERIFICAR_TRANSACCION.getVariableSesion());
    theActorInTheSpotlight()
        .should(
            seeThat(
                    the(BTN_FAVORITO_ACTIVA.of(validacion.getProducto().getDescripcion())),
                    isNotVisible())
                .orComplainWith(
                    MensajeEliminacionFavoritosNoVisualizadoException.class,
                    MENSAJE_ELIMINACION_FAVORITOS_NO_VISUALIZADO));
  }
}
