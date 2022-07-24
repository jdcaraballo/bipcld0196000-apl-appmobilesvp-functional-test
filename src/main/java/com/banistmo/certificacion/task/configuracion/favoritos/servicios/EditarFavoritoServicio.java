package com.banistmo.certificacion.task.configuracion.favoritos.servicios;

import static com.banistmo.certificacion.userinterface.configuracion.FavoritosGeneralPage.BTN_GUARDAR_EDITAR_FAVORITO;
import static com.banistmo.certificacion.userinterface.configuracion.FavoritosGeneralPage.BTN_PRODUCTOS_ACTIVOS;
import static com.banistmo.certificacion.userinterface.configuracion.administracion.favoritos.servicios.CreacionFavoritoServiciosPage.TXT_NOMBRE_CLIENTE;
import static com.banistmo.certificacion.userinterface.configuracion.administracion.favoritos.servicios.CreacionFavoritoServiciosPage.TXT_NUMERO_CLIENTE;
import static com.banistmo.certificacion.utils.enums.EnumVariablesSesion.VERIFICAR_TRANSACCION;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import com.banistmo.certificacion.interactions.Limpiar;
import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import com.banistmo.certificacion.models.comun.Validacion;
import com.banistmo.certificacion.models.productos.Servicio;
import com.banistmo.certificacion.task.configuracion.favoritos.editar.Editar;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class EditarFavoritoServicio implements Task {

  private Servicio datosModificadosFavorito;

  public EditarFavoritoServicio(Servicio transaccion) {
    this.datosModificadosFavorito = transaccion;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    Validacion datosFavorito =
        theActorInTheSpotlight().recall(VERIFICAR_TRANSACCION.getVariableSesion());
    actor.attemptsTo(
        Editar.favoritoActivo(datosFavorito.getProducto().getDescripcion()),
        EsperarElemento.esClickable(TXT_NOMBRE_CLIENTE),
        Limpiar.campo(TXT_NOMBRE_CLIENTE),
        Enter.theValue(datosModificadosFavorito.getBeneficiario().getNombre())
            .into(TXT_NOMBRE_CLIENTE),
        Limpiar.campo(TXT_NUMERO_CLIENTE),
        Enter.theValue(datosModificadosFavorito.getBeneficiario().getNumero())
            .into(TXT_NUMERO_CLIENTE),
        EsperarElemento.esClickable(BTN_GUARDAR_EDITAR_FAVORITO),
        Click.on(BTN_GUARDAR_EDITAR_FAVORITO),
        EsperarElemento.esVisible(BTN_PRODUCTOS_ACTIVOS));
    Validacion validacion = new Validacion(datosModificadosFavorito);
    validacion.getProducto().setDescripcion(datosFavorito.getProducto().getDescripcion());
    actor.remember(VERIFICAR_TRANSACCION.getVariableSesion(), validacion);
  }
}
