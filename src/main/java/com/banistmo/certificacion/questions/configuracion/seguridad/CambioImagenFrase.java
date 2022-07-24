package com.banistmo.certificacion.questions.configuracion.seguridad;

import static com.banistmo.certificacion.userinterface.configuracion.seguridad.CambiarImagenFrasePage.*;
import static com.banistmo.certificacion.utils.enums.EnumMensajes.CAMBIO_DE_IMAGEN_FRASE_EXITOSO;
import static com.banistmo.certificacion.utils.enums.EnumVariablesSesion.VERIFICAR_FRASE_NUEVA;
import static com.banistmo.certificacion.utils.enums.EnumVariablesSesion.VERIFICAR_IMAGEN_NUEVA;

import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import com.banistmo.certificacion.task.configuracion.seguridad.CerrarSesion;
import com.banistmo.certificacion.task.configuracion.seguridad.IngresarUsuario;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Text;

public class CambioImagenFrase implements Question<Boolean> {

  @Override
  public Boolean answeredBy(Actor actor) {

    actor.attemptsTo(
        EsperarElemento.esVisible(MENSAJE_IMAGEN_ACTUALIZADA),
        Ensure.that(MENSAJE_IMAGEN_ACTUALIZADA).isDisplayed(),
        Ensure.that(MENSAJE_IMAGEN_ACTUALIZADA)
            .text()
            .contains(CAMBIO_DE_IMAGEN_FRASE_EXITOSO.getMensaje()),
        CerrarSesion.desdeConfiguracion(),
        IngresarUsuario.hastaClave());

    String frase = actor.recall(VERIFICAR_FRASE_NUEVA.getVariableSesion());
    String srcImagen = actor.recall(VERIFICAR_IMAGEN_NUEVA.getVariableSesion());

    actor.attemptsTo(
        Ensure.that(Text.of(LBL_FRASE_MODIFICADA).viewedBy(actor).asString()).contains(frase),
        Ensure.that(LBL_NUEVA_IMAGEN.resolveFor(actor).getAttribute("src")).contains(srcImagen));
    return true;
  }
}
