package com.banistmo.certificacion.runners.token.servicios;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    features = "src/test/resources/features/servicios/token/servicios_programados_token.feature",
    glue = "com.banistmo.certificacion.stepdefinitions")
public class ServiciosProgramadosToken {}
