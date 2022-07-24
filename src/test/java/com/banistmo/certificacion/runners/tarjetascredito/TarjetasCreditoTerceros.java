package com.banistmo.certificacion.runners.tarjetascredito;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    features = "src/test/resources/features/tarjetascredito/pago_tarjetas_credito_terceros.feature",
    glue = "com.banistmo.certificacion.stepdefinitions")
public class TarjetasCreditoTerceros {}
