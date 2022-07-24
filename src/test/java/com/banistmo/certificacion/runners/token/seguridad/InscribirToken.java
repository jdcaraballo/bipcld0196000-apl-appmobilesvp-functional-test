package com.banistmo.certificacion.runners.token.seguridad;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    features = "src/test/resources/features/configuracion/seguridad/inscripcion_token.feature",
    glue = "com/banistmo/certificacion/stepdefinitions")
public class InscribirToken {}
