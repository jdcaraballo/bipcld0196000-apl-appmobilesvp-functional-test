package com.banistmo.certificacion.runners.transferencias;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    features =
        "src/test/resources/features/transferencias/cuentaspropias/transferencias_cuentas_propias_programadas.feature",
    glue = "com.banistmo.certificacion.stepdefinitions")
public class TransferenciasPropiasProgramadas {}
