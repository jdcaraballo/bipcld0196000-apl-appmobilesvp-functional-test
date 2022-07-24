package com.banistmo.certificacion.questions.configuracion.seguridad;

import com.banistmo.certificacion.interactions.esperas.Esperar;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.ensure.Ensure;

public class NuevaPestania implements Question<Boolean> {

  public static NuevaPestania abreCorrectamente() {
    return new NuevaPestania();
  }

  @Override
  public Boolean answeredBy(Actor actor) {
    actor.attemptsTo(Esperar.unTiempo(10000));
    Object[] newTab = BrowseTheWeb.as(actor).getDriver().getWindowHandles().toArray();
    actor.attemptsTo(
        Switch.toWindow(newTab[newTab.length - 1].toString()),
        Ensure.thatTheCurrentPage().currentUrl().contains("https://hidra.banistmolabs.com/"));
    return true;
  }
}
