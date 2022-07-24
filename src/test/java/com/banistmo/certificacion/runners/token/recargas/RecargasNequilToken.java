package com.banistmo.certificacion.runners.token.recargas;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    features = "src/test/resources/features/recargas/token/recargas_nequi_token.feature",
    glue = "com.banistmo.certificacion.stepdefinitions")
public class RecargasNequilToken {}
