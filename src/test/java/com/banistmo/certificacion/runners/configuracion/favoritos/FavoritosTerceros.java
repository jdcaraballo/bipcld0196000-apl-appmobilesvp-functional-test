package com.banistmo.certificacion.runners.configuracion.favoritos;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    features =
        "src/test/resources/features/configuracion/favoritos/favoritos_cuentas_terceros.feature",
    glue = "com.banistmo.certificacion.stepdefinitions")
public class FavoritosTerceros {}
