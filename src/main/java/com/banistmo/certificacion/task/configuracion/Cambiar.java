package com.banistmo.certificacion.task.configuracion;

import static com.banistmo.certificacion.userinterface.autenticacion.LoginPage.SPN_CARGA;
import static com.banistmo.certificacion.userinterface.configuracion.seguridad.CambiarImagenFrasePage.*;
import static com.banistmo.certificacion.userinterface.configuracion.seguridad.CambiarImagenFrasePage.LBL_IMAGEN_FRASE;
import static com.banistmo.certificacion.utils.enums.EnumVariablesSesion.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;

import com.banistmo.certificacion.interactions.ClickAleatorio;
import com.banistmo.certificacion.interactions.Limpiar;
import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import java.util.Random;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class Cambiar implements Task {

  private String nuevaFrase;

  public Cambiar(String nuevaFrase) {
    this.nuevaFrase = nuevaFrase;
  }

  public static Cambiar imagenFrase(String nuevaFrace) {
    return instrumented(Cambiar.class, nuevaFrace);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    Random random = new Random();
    nuevaFrase = nuevaFrase + "" + random.nextInt(999);

    actor.remember(
            VERIFICAR_FRASE_ACTUAL.getVariableSesion(), Text.of(LBL_FRASE).viewedBy(actor).asString());
    actor.remember(
            VERIFICAR_IMAGEN_ACTUAL.getVariableSesion(),
            LBL_NUEVA_IMAGEN.resolveFor(actor).getAttribute("src"));

    actor.attemptsTo(
            Click.on(BTN_EDITAR_IMAGEN),
            WaitUntil.the(SPN_CARGA, isNotVisible()).forNoMoreThan(50).seconds(),
            EsperarCarga.desaparezca(),
            EsperarElemento.esClickable(LBL_IMAGEN_FRASE),
            ClickAleatorio.enElemento(LBL_OPCIONES_IMAGENES),
            EsperarCarga.desaparezca(),
            EsperarElemento.esClickable(BTN_EDITAR_FRASE),
            Click.on(BTN_EDITAR_FRASE),
            Limpiar.campo(INPUT_FRASE_DE_SEGURIDAD),
            Enter.theValue(nuevaFrase).into(INPUT_FRASE_DE_SEGURIDAD));

    actor.remember(VERIFICAR_FRASE_NUEVA.getVariableSesion(), nuevaFrase);
    actor.remember(
            VERIFICAR_IMAGEN_NUEVA.getVariableSesion(),
            LBL_NUEVA_IMAGEN.resolveFor(actor).getAttribute("src"));
  }
}
