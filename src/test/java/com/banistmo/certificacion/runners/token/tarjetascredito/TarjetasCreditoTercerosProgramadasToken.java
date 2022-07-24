package com.banistmo.certificacion.runners.token.tarjetascredito;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    features =
        "src/test/resources/features/tarjetascredito/token/tarjetas_credito_terceros_programadas_token.feature",
    glue = "com.banistmo.certificacion.stepdefinitions")
public class TarjetasCreditoTercerosProgramadasToken {}
