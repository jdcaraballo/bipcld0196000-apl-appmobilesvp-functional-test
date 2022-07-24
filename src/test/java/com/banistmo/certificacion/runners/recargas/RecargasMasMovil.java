package com.banistmo.certificacion.runners.recargas;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    features = "src/test/resources/features/recargas/recargas_mas_movil.feature",
    glue = "com.banistmo.certificacion.stepdefinitions")
public class RecargasMasMovil {}
