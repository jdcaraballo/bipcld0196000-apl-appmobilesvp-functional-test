package com.banistmo.certificacion.task.configuracion.favoritos.terceros;

import static com.banistmo.certificacion.userinterface.configuracion.FavoritosGeneralPage.BTN_GUARDAR_EDITAR_FAVORITO;
import static com.banistmo.certificacion.userinterface.configuracion.FavoritosGeneralPage.BTN_PRODUCTOS_ACTIVOS;
import static com.banistmo.certificacion.userinterface.configuracion.administracion.favoritos.terceros.EditarFavoritosTercerosPage.TXT_CORREO_ELECTRONICO;
import static com.banistmo.certificacion.userinterface.configuracion.administracion.favoritos.terceros.EditarFavoritosTercerosPage.TXT_NOMBRE;
import static com.banistmo.certificacion.utils.enums.EnumVariablesSesion.VERIFICAR_TRANSACCION;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import com.banistmo.certificacion.interactions.Limpiar;
import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import com.banistmo.certificacion.models.comun.Transaccion;
import com.banistmo.certificacion.models.comun.Validacion;
import com.banistmo.certificacion.task.configuracion.favoritos.editar.Editar;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class EditarFavoritoTerceros implements Task {

  private Transaccion datosModificadosFavorito;

  public EditarFavoritoTerceros(Transaccion transaccion) {
    this.datosModificadosFavorito = transaccion;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    Validacion datosFavorito =
        theActorInTheSpotlight().recall(VERIFICAR_TRANSACCION.getVariableSesion());
    actor.attemptsTo(
        Editar.favoritoActivo(datosFavorito.getProducto().getDescripcion()),
        EsperarElemento.esClickable(TXT_NOMBRE),
        Limpiar.campo(TXT_NOMBRE),
        Enter.theValue(datosModificadosFavorito.getBeneficiario().getNombre()).into(TXT_NOMBRE),
        Limpiar.campo(TXT_CORREO_ELECTRONICO),
        Enter.theValue(datosModificadosFavorito.getBeneficiario().getCorreo())
            .into(TXT_CORREO_ELECTRONICO),
        EsperarElemento.esClickable(BTN_GUARDAR_EDITAR_FAVORITO),
        Click.on(BTN_GUARDAR_EDITAR_FAVORITO),
        EsperarCarga.desaparezca(),
        EsperarElemento.esVisible(BTN_PRODUCTOS_ACTIVOS));
    Validacion validacion = new Validacion(datosModificadosFavorito);
    validacion.getProducto().setDescripcion(datosFavorito.getProducto().getDescripcion());
    actor.remember(VERIFICAR_TRANSACCION.getVariableSesion(), validacion);
  }
}
