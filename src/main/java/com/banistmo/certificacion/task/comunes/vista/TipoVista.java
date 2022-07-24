package com.banistmo.certificacion.task.comunes.vista;

import com.banistmo.certificacion.interactions.esperas.Esperar;
import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Presence;

import static com.banistmo.certificacion.userinterface.PrincipalPage.*;

public class TipoVista implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Esperar.unTiempo(5000),
                EsperarCarga.desaparezca());
        if (!Presence.of(BTN_VISTA_LISTA).viewedBy(actor).resolveAll().isEmpty()) {
            actor.attemptsTo(Click.on(BTN_VISTA_LISTA));
        } else {
            actor.attemptsTo(
                    EsperarElemento.esClickable(BTN_VISTA_LISTA_2),
                    Click.on(BTN_VISTA_LISTA_2));
        }
    }
}
