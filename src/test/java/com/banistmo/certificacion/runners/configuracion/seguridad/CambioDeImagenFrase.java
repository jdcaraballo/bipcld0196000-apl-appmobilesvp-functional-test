package com.banistmo.certificacion.runners.configuracion.seguridad;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    features = "src/test/resources/features/configuracion/seguridad/cambio_imagen_frase.feature",
    glue = "com/banistmo/certificacion/stepdefinitions")
public class CambioDeImagenFrase {}
