package com.banistmo.certificacion.stepdefinitions.configuracion.productos;

import static com.banistmo.certificacion.exceptions.configuracion.productos.ObjetivoAhorroNoConfiguradoException.OBJETIVO_AHORRO_NO_CONFIGURADO;
import static com.banistmo.certificacion.userinterface.configuracion.administracion.AdministracionPage.BTN_CONFIGURAR_PRODUCTOS;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import com.banistmo.certificacion.exceptions.configuracion.productos.ObjetivoAhorroNoConfiguradoException;
import com.banistmo.certificacion.questions.configuracion.productos.VerificarObjetivo;
import com.banistmo.certificacion.task.configuracion.Ingresar;
import com.banistmo.certificacion.task.configuracion.productos.objetivo.DefinirObjetivo;
import com.banistmo.certificacion.utils.enums.EnumTexto;
import cucumber.api.java.ast.Cuando;
import cucumber.api.java.es.Entonces;

public class DefinirObjetivoStepDefinitions {

  @Cuando("^el defina un objetivo (.*) de ahorro en una cuenta$")
  public void definirObjetivoAhorro(String tipoEscenario) {
    theActorInTheSpotlight()
        .attemptsTo(
            Ingresar.aConfiguracion(
                EnumTexto.TEXTO_CONFIGURACION.getTexto(), BTN_CONFIGURAR_PRODUCTOS),
            DefinirObjetivo.deAhorro(tipoEscenario));
  }

  @Entonces("^la cuenta tiene el objetivo de ahorro correctamente$")
  public void objetivoAhorroCorrectamente() {
    theActorInTheSpotlight()
        .should(
            seeThat(VerificarObjetivo.deAhorro())
                .orComplainWith(
                    ObjetivoAhorroNoConfiguradoException.class, OBJETIVO_AHORRO_NO_CONFIGURADO));
  }
}
