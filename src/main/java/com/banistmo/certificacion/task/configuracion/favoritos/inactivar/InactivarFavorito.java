package com.banistmo.certificacion.task.configuracion.favoritos.inactivar;

import static com.banistmo.certificacion.userinterface.configuracion.FavoritosGeneralPage.*;
import static com.banistmo.certificacion.utils.enums.EnumVariablesSesion.VERIFICAR_TRANSACCION;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import com.banistmo.certificacion.models.comun.Validacion;
import com.banistmo.certificacion.task.configuracion.favoritos.editar.Editar;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class InactivarFavorito implements Task {

  public static InactivarFavorito creado() {
    return instrumented(InactivarFavorito.class);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    Validacion nombreFavorito = actor.recall(VERIFICAR_TRANSACCION.getVariableSesion());
    actor.attemptsTo(
        EsperarCarga.desaparezca(),
        Editar.favoritoActivo(nombreFavorito.getProducto().getDescripcion()),
        EsperarElemento.esClickable(BTN_ACTIVAR_INACTIVAR_FAVORITO),
        Click.on(BTN_ACTIVAR_INACTIVAR_FAVORITO),
        Click.on(BTN_GUARDAR_EDITAR_FAVORITO),
        EsperarCarga.desaparezca(),
        EsperarElemento.esVisible(BTN_PRODUCTOS_ACTIVOS));
  }
}
