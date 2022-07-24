package com.banistmo.certificacion.runners.token.seguridad;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    features =
        "src/test/resources/features/configuracion/seguridad/token/actualizar_datos_token.feature:@ActualizacionDatosHome",
    glue = "com.banistmo.certificacion.stepdefinitions")
public class ActualizarDatosToken {}
