package com.banistmo.certificacion.task.configuracion.favoritos.editar;

import static com.banistmo.certificacion.userinterface.configuracion.FavoritosGeneralPage.*;
import static com.banistmo.certificacion.userinterface.configuracion.FavoritosGeneralPage.TXT_BUSCAR_FAVORITO_INACTIVO;

import com.banistmo.certificacion.interactions.Limpiar;
import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class FavoritoInactivo implements Task {

  private final String nombreFavorito;

  public FavoritoInactivo(String nombreFavorito) {
    this.nombreFavorito = nombreFavorito;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        EsperarCarga.desaparezca(),
        Click.on(BTN_PRODUCTOS_INACTIVOS),
        Limpiar.campo(TXT_BUSCAR_FAVORITO_INACTIVO),
        Enter.theValue(nombreFavorito).into(TXT_BUSCAR_FAVORITO_INACTIVO),
        EsperarElemento.esClickable(BTN_FAVORITO_INACTIVA.of(nombreFavorito)),
        Click.on(BTN_FAVORITO_INACTIVA.of(nombreFavorito)),
        EsperarCarga.desaparezca());
  }
}
