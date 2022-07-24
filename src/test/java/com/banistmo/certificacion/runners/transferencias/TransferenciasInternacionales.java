package com.banistmo.certificacion.runners.transferencias;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    features =
        "src/test/resources/features/transferencias/internacionales/transferencias_internacionales.feature:38",
    glue = "com.banistmo.certificacion.stepdefinitions")
public class TransferenciasInternacionales {}
