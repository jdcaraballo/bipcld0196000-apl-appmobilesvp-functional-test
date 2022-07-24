package com.banistmo.certificacion.task.comunes;

import com.banistmo.certificacion.task.comunes.vista.TipoDeVista;
import com.banistmo.certificacion.task.comunes.vista.TipoVista;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SeleccionarVista {

    private SeleccionarVista() {}

    public static TipoDeVista tipoCard() {
        return instrumented(TipoDeVista.class);
    }

    public static TipoVista tipoLista() {
        return instrumented(TipoVista.class);

    }

}
