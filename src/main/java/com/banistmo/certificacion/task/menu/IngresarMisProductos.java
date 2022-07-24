package com.banistmo.certificacion.task.menu;

import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.banistmo.certificacion.userinterface.menu.MenuPage.BTN_MIS_PRODUCTOS;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class IngresarMisProductos implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                EsperarCarga.desaparezca(),
                EsperarElemento.esClickable(BTN_MIS_PRODUCTOS),
                Click.on(BTN_MIS_PRODUCTOS),
                EsperarCarga.desaparezca()
        );

    }
    public static IngresarMisProductos desdeHome() {
        return instrumented(IngresarMisProductos.class);
    }
}
