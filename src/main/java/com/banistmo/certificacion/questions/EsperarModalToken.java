package com.banistmo.certificacion.questions;

import static com.banistmo.certificacion.userinterface.PrincipalPage.BTN_ACEPTAR_CIERRE_SESION;
import static com.banistmo.certificacion.userinterface.comunes.TransaccionesGeneralPage.*;
import static com.banistmo.certificacion.userinterface.menu.MenuConfiguracionPage.BTN_CERRAR_SESION;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Visibility;
import net.serenitybdd.screenplay.targets.Target;

public class EsperarModalToken implements Question<Boolean> {

  Target elemento;

  public EsperarModalToken(Target elemento) {
    this.elemento = elemento;
  }

  public static EsperarModalToken esVisible(Target elemento) {
    return new EsperarModalToken(elemento);
  }

  @Override
  public Boolean answeredBy(Actor actor) {
    boolean resultado = elemento.resolveFor(actor).isVisible();
    if (!Visibility.of(LBL_INGRESA_SOFTTOKEN).viewedBy(actor).resolveAll().isEmpty()) {
      theActorInTheSpotlight()
          .attemptsTo(
              EsperarElemento.esVisible(LBL_INGRESA_SOFTTOKEN),
              Click.on(BTN_VOLVER_SOFTTOKEN),
              Click.on(BTN_VOLVER_ANTERIOR),
              EsperarElemento.esVisible(BTN_ENTENDIDO_ANTERIOR),
              Click.on(BTN_ENTENDIDO_ANTERIOR),
              EsperarElemento.esClickable(BTN_CONFIGURACION),
              Click.on(BTN_CONFIGURACION),
              EsperarElemento.esClickable(BTN_CERRAR_SESION),
              Click.on(BTN_CERRAR_SESION),
              EsperarCarga.desaparezca(),
              EsperarElemento.esClickable(BTN_ACEPTAR_CIERRE_SESION),
              Click.on(BTN_ACEPTAR_CIERRE_SESION));
    }
    return resultado;
  }
}
