package com.banistmo.certificacion.task.configuracion.favoritos.editar;

import static com.banistmo.certificacion.userinterface.configuracion.FavoritosGeneralPage.*;

import com.banistmo.certificacion.interactions.Limpiar;
import com.banistmo.certificacion.interactions.esperas.Esperar;
import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class FavoritoActivo implements Task {

  private final String nombreFavorito;

  public FavoritoActivo(String nombreFavorito) {
    this.nombreFavorito = nombreFavorito;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        Esperar.unTiempo(2000),
        EsperarCarga.desaparezca(),
        Limpiar.campo(TXT_BUSCAR_FAVORITO_ACTIVO),
        Enter.theValue(nombreFavorito).into(TXT_BUSCAR_FAVORITO_ACTIVO),
        EsperarElemento.esClickable(BTN_FAVORITO_ACTIVA.of(nombreFavorito)),
        Click.on(BTN_FAVORITO_ACTIVA.of(nombreFavorito)),
        EsperarCarga.desaparezca());
  }
}
