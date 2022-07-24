package com.banistmo.certificacion.runners.configuracion.productos;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    features = "src/test/resources/features/configuracion/productos/definicion_objetivo.feature",
    glue = "com.banistmo.certificacion.stepdefinitions")
public class DefinirObjetivo {}
