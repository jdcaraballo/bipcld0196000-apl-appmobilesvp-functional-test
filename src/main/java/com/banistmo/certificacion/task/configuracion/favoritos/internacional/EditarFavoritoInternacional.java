package com.banistmo.certificacion.task.configuracion.favoritos.internacional;

import static com.banistmo.certificacion.userinterface.configuracion.FavoritosGeneralPage.BTN_GUARDAR_EDITAR_FAVORITO;
import static com.banistmo.certificacion.userinterface.configuracion.FavoritosGeneralPage.BTN_PRODUCTOS_ACTIVOS;
import static com.banistmo.certificacion.userinterface.configuracion.administracion.favoritos.internacional.EditarFavoritosInternacionalesPage.TXT_CIUDAD;
import static com.banistmo.certificacion.userinterface.configuracion.administracion.favoritos.internacional.EditarFavoritosInternacionalesPage.TXT_NOMBRE_BENEFICIARIO;
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

public class EditarFavoritoInternacional implements Task {

  private Transaccion datosModificadosFavorito;

  public EditarFavoritoInternacional(Transaccion transaccion) {
    this.datosModificadosFavorito = transaccion;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    Validacion datosFavorito =
        theActorInTheSpotlight().recall(VERIFICAR_TRANSACCION.getVariableSesion());
    actor.attemptsTo(
        Editar.favoritoActivo(datosFavorito.getProducto().getDescripcion()),
        EsperarElemento.esClickable(TXT_NOMBRE_BENEFICIARIO),
        Limpiar.campo(TXT_NOMBRE_BENEFICIARIO),
        Enter.theValue(datosModificadosFavorito.getBeneficiario().getNombre())
            .into(TXT_NOMBRE_BENEFICIARIO),
        Limpiar.campo(TXT_CIUDAD),
        Enter.theValue(datosModificadosFavorito.getBeneficiario().getCiudad()).into(TXT_CIUDAD),
        EsperarCarga.desaparezca(),
        Click.on(BTN_GUARDAR_EDITAR_FAVORITO),
        EsperarElemento.esVisible(BTN_PRODUCTOS_ACTIVOS));
    Validacion validacion = new Validacion(datosModificadosFavorito);
    validacion.getProducto().setDescripcion(datosFavorito.getProducto().getDescripcion());
    actor.remember(VERIFICAR_TRANSACCION.getVariableSesion(), validacion);
  }
}
