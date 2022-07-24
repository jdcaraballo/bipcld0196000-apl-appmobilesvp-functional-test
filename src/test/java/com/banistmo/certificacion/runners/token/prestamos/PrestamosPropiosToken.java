package com.banistmo.certificacion.runners.token.prestamos;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    features = "src/test/resources/features/prestamos/token/pago_prestamos_propios_token.feature",
    glue = "com.banistmo.certificacion.stepdefinitions")
public class PrestamosPropiosToken {}
