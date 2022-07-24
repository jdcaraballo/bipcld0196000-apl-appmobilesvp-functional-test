package com.banistmo.certificacion.questions.configuracion.productos;

import static com.banistmo.certificacion.userinterface.configuracion.FavoritosGeneralPage.BTN_FAVORITO_ACTIVA;

import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;

public class VerificarCreacion implements Question<Boolean> {

  private String nombreFavorito;

  public VerificarCreacion(String nombreFavorito) {
    this.nombreFavorito = nombreFavorito;
  }

  public static VerificarCreacion deFavorito(String nombreFavorito) {
    return new VerificarCreacion(nombreFavorito);
  }

  @Override
  public Boolean answeredBy(Actor actor) {
    actor.attemptsTo(EsperarCarga.desaparezca());
    return Visibility.of(BTN_FAVORITO_ACTIVA.of(nombreFavorito)).viewedBy(actor).asBoolean();
  }
}
