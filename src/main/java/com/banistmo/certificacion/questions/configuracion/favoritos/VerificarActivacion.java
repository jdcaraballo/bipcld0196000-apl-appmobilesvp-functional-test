package com.banistmo.certificacion.questions.configuracion.favoritos;

import static com.banistmo.certificacion.userinterface.configuracion.FavoritosGeneralPage.*;

import com.banistmo.certificacion.interactions.Limpiar;
import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import com.banistmo.certificacion.models.comun.Validacion;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.questions.Visibility;

public class VerificarActivacion implements Question<Boolean> {

  private Validacion validacion;

  public VerificarActivacion(Validacion validacion) {
    this.validacion = validacion;
  }

  public static VerificarActivacion deFavoritos(Validacion validacion) {
    return new VerificarActivacion(validacion);
  }

  @Override
  public Boolean answeredBy(Actor actor) {
    actor.attemptsTo(
        EsperarElemento.esClickable(BTN_PRODUCTOS_ACTIVOS),
        Click.on(BTN_PRODUCTOS_ACTIVOS),
        Limpiar.campo(TXT_BUSCAR_FAVORITO_ACTIVO),
        Enter.theValue(validacion.getProducto().getDescripcion()).into(TXT_BUSCAR_FAVORITO_ACTIVO));
    return Visibility.of(BTN_FAVORITO_ACTIVA.of(validacion.getProducto().getDescripcion()))
        .viewedBy(actor)
        .asBoolean();
  }
}
