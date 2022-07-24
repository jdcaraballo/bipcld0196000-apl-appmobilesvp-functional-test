package com.banistmo.certificacion.runners.servicios;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    features = "src/test/resources/features/servicios/pago_servicios.feature:72",
    glue = "com.banistmo.certificacion.stepdefinitions")
public class PagosServicios {}
