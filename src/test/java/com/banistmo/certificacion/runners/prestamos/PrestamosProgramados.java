package com.banistmo.certificacion.runners.prestamos;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    features = "src/test/resources/features/prestamos/prestamos_programados.feature",
    glue = "com.banistmo.certificacion.stepdefinitions")
public class PrestamosProgramados {}
