package com.banistmo.certificacion.runners.configuracion.notificaciones;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    features =
        "src/test/resources/features/configuracion/notificaciones/configuracion_de_alertas_y_notificaciones.feature",
    glue = "com/banistmo/certificacion/stepdefinitions")
public class ConfigurarNotificaciones {}
