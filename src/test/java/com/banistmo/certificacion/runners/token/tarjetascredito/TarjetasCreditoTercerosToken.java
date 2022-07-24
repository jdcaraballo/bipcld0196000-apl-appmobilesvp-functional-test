package com.banistmo.certificacion.runners.token.tarjetascredito;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    features =
        "src/test/resources/features/tarjetascredito/token/pago_tarjetas_credito_terceros_token.feature",
    glue = "com.banistmo.certificacion.stepdefinitions")
public class TarjetasCreditoTercerosToken {}
