package com.banistmo.certificacion.runners.extrafinanciamiento;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    features =
        "src/test/resources/features/extrafinanciamiento/oferta_y_toma_de_extrafinanciamiento.feature:31",
    glue = "com.banistmo.certificacion.stepdefinitions")
public class Extrafinanciamiento {}
