package com.banistmo.certificacion.runners.tarjetascredito;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    features = "src/test/resources/features/tarjetascredito/pago_tarjetas_credito_propias.feature:65",
    glue = "com.banistmo.certificacion.stepdefinitions")
public class TarjetasCreditoPropias {}
