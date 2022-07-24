package com.banistmo.certificacion.runners.token.transferencias;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    features =
        "src/test/resources/features/transferencias/internacionales/token/transferencias_internacionales_token.feature",
    glue = "com.banistmo.certificacion.stepdefinitions")
public class TransferenciasInternacionalesToken {}
