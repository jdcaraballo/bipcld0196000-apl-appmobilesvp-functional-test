package com.banistmo.certificacion.task.configuracion.favoritos.terceros;

import static com.banistmo.certificacion.userinterface.comunes.TransaccionesGeneralPage.BTN_CONTINUAR;
import static com.banistmo.certificacion.userinterface.configuracion.FavoritosGeneralPage.BTN_NUEVO_FAVORITO;
import static com.banistmo.certificacion.userinterface.configuracion.FavoritosGeneralPage.BTN_PRODUCTOS_ACTIVOS;
import static com.banistmo.certificacion.userinterface.configuracion.administracion.favoritos.terceros.CreacionFavoritosTercerosPage.*;
import static com.banistmo.certificacion.utils.enums.EnumVariablesSesion.VERIFICAR_TRANSACCION;

import com.banistmo.certificacion.interactions.SelecionarLista;
import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import com.banistmo.certificacion.models.comun.Transaccion;
import com.banistmo.certificacion.models.comun.Validacion;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class FavoritoTerceros implements Task {

  private Transaccion datosFavorito;

  public FavoritoTerceros(Transaccion transaccion) {
    this.datosFavorito = transaccion;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        EsperarElemento.esClickable(BTN_NUEVO_FAVORITO),
        Click.on(BTN_NUEVO_FAVORITO),
        EsperarCarga.desaparezca(),
        Enter.theValue(datosFavorito.getBeneficiario().getNombre()).into(TXT_NOMBRE),
        Enter.theValue(datosFavorito.getBeneficiario().getCorreo()).into(TXT_CORREO_ELECTRONICO),
        EsperarElemento.esClickable(BTN_BANCO_DESTINO),
        Click.on(BTN_BANCO_DESTINO),
        EsperarElemento.esClickable(LST_BTN_BANCOS_PRODUCTOS),
        SelecionarLista.unaOpcion(
            datosFavorito.getProducto().getBanco(), LST_BTN_BANCOS_PRODUCTOS, true),
        EsperarCarga.desaparezca(),
        EsperarCarga.desaparezca(),
        EsperarElemento.esClickable(BTN_TIPO_PRODUCTO),
        Click.on(BTN_TIPO_PRODUCTO),
        EsperarElemento.esClickable(LST_BTN_BANCOS_PRODUCTOS),
        SelecionarLista.unaOpcion(
            datosFavorito.getProducto().getTipoProducto(), LST_BTN_BANCOS_PRODUCTOS, true),
        EsperarCarga.desaparezca(),
        EsperarElemento.esClickable(TXT_NUMERO_PRODUCTO),
        Enter.theValue(datosFavorito.getProducto().getNumeroCuentaDestino())
            .into(TXT_NUMERO_PRODUCTO),
        Enter.theValue(datosFavorito.getProducto().getDescripcion())
            .into(TXT_NOMBRE_FAVORITO_TERCEROS),
        EsperarCarga.desaparezca(),
        EsperarElemento.esClickable(BTN_CONTINUAR),
        Click.on(BTN_CONTINUAR),
        EsperarElemento.esVisible(BTN_PRODUCTOS_ACTIVOS));
    Validacion validacion = new Validacion(datosFavorito);
    actor.remember(VERIFICAR_TRANSACCION.getVariableSesion(), validacion);
  }
}
