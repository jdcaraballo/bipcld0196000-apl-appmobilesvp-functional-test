package com.banistmo.certificacion.questions.configuracion.seguridad;

import static com.banistmo.certificacion.userinterface.configuracion.seguridad.CambiarImagenFrasePage.LBL_FRASE_MODIFICADA;
import static com.banistmo.certificacion.userinterface.configuracion.seguridad.CambiarImagenFrasePage.LBL_NUEVA_IMAGEN;
import static com.banistmo.certificacion.utils.enums.EnumVariablesSesion.VERIFICAR_FRASE_ACTUAL;
import static com.banistmo.certificacion.utils.enums.EnumVariablesSesion.VERIFICAR_IMAGEN_ACTUAL;

import com.banistmo.certificacion.task.configuracion.seguridad.CerrarSesion;
import com.banistmo.certificacion.task.configuracion.seguridad.IngresarUsuario;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Text;

public class SinCambioImagenFrase implements Question<Boolean> {
  @Override
  public Boolean answeredBy(Actor actor) {
    actor.attemptsTo(CerrarSesion.desdeConfiguracion(), IngresarUsuario.hastaClave());
    String frase = actor.recall(VERIFICAR_FRASE_ACTUAL.getVariableSesion());
    String srcImagen = actor.recall(VERIFICAR_IMAGEN_ACTUAL.getVariableSesion());
    actor.attemptsTo(
        Ensure.that(Text.of(LBL_FRASE_MODIFICADA).viewedBy(actor).asString()).contains(frase),
        Ensure.that(LBL_NUEVA_IMAGEN.resolveFor(actor).getAttribute("src")).contains(srcImagen));
    return true;
  }
}
