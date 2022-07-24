package com.banistmo.certificacion.task.configuracion.favoritos.internacional;

import static com.banistmo.certificacion.userinterface.comunes.TransaccionesGeneralPage.BTN_CONTINUAR;
import static com.banistmo.certificacion.userinterface.configuracion.FavoritosGeneralPage.BTN_NUEVO_FAVORITO;
import static com.banistmo.certificacion.userinterface.configuracion.FavoritosGeneralPage.BTN_PRODUCTOS_ACTIVOS;
import static com.banistmo.certificacion.userinterface.configuracion.administracion.favoritos.internacional.CreacionFavoritosInternacionalPage.*;
import static com.banistmo.certificacion.utils.enums.EnumVariablesSesion.VERIFICAR_TRANSACCION;

import com.banistmo.certificacion.interactions.ClickCambiando;
import com.banistmo.certificacion.interactions.SelecionarLista;
import com.banistmo.certificacion.interactions.esperas.Esperar;
import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import com.banistmo.certificacion.models.comun.Transaccion;
import com.banistmo.certificacion.models.comun.Validacion;
import com.banistmo.certificacion.questions.driver.ObtenerPlataforma;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import org.openqa.selenium.Keys;

public class FavoritoInternacional implements Task {

  private Transaccion datosFavorito;

  public FavoritoInternacional(Transaccion transaccion) {
    this.datosFavorito = transaccion;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        EsperarElemento.esClickable(BTN_NUEVO_FAVORITO),
        Click.on(BTN_NUEVO_FAVORITO),
        EsperarCarga.desaparezca(),
        EsperarElemento.esClickable(BTN_PAIS),
        Click.on(BTN_PAIS),
        EsperarElemento.esClickable(LST_BTN_PAIS_RECEPTOR),
        SelecionarLista.unaOpcion(
            datosFavorito.getProducto().getPaisDestino(), LST_BTN_PAIS_RECEPTOR, true),
        EsperarElemento.esClickable(TXT_BANCO_DESTINO),
        Check.whether("iOS".equalsIgnoreCase(ObtenerPlataforma.deEjecucion().answeredBy(actor)))
            .andIfSo(ClickCambiando.elContexto(LST_BTN_PAIS_RECEPTOR_IOS))
            .otherwise(Click.on(TXT_BANCO_DESTINO)),
        Esperar.unTiempo(2000),
        EsperarElemento.esClickable(TXT_BUSCAR_BANCO_DESTINO),
        Enter.theValue(datosFavorito.getProducto().getBanco())
            .into(TXT_BUSCAR_BANCO_DESTINO)
            .thenHit(Keys.ENTER),
        EsperarElemento.esVisible(BTN_BANCO_DESTINO),
        EsperarElemento.esClickable(BTN_BANCO_DESTINO),
        Click.on(BTN_BANCO_DESTINO),
        EsperarCarga.desaparezca(),
        EsperarElemento.esClickable(TXT_NOMBRE_BENEFICIARIO),
        Enter.theValue(datosFavorito.getBeneficiario().getNombre()).into(TXT_NOMBRE_BENEFICIARIO),
        Enter.theValue(datosFavorito.getBeneficiario().getPais()).into(TXT_PAIS_RESIDENCIA),
        Enter.theValue(datosFavorito.getBeneficiario().getCiudad()).into(TXT_CIUDAD),
        Enter.theValue(datosFavorito.getBeneficiario().getDireccion())
            .into(TXT_DIRECCION_BENEFICIARIO),
        Enter.theValue(datosFavorito.getBeneficiario().getCorreo()).into(TXT_CORREO_ELECTRONICO),
        Enter.theValue(datosFavorito.getProducto().getNumeroCuentaDestino())
            .into(TXT_NUMERO_CUENTA),
        Enter.theValue(datosFavorito.getProducto().getDescripcion())
            .into(TXT_NOMBRE_FAVORITO_INTERNACIONAL),
        EsperarElemento.esClickable(BTN_CONTINUAR),
        Click.on(BTN_CONTINUAR),
        EsperarCarga.desaparezca(),
        EsperarElemento.esVisible(BTN_PRODUCTOS_ACTIVOS));
    Validacion validacion = new Validacion(datosFavorito);
    actor.remember(VERIFICAR_TRANSACCION.getVariableSesion(), validacion);
  }
}
