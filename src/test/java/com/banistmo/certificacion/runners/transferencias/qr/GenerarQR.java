package com.banistmo.certificacion.runners.transferencias.qr;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    features = "src/test/resources/features/transferencias/generar_qr/generar_qr.feature",
    glue = "com.banistmo.certificacion.stepdefinitions")
public class GenerarQR {}
