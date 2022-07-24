package com.banistmo.certificacion.task.configuracion.favoritos.recargas;

import static com.banistmo.certificacion.userinterface.comunes.TransaccionesGeneralPage.BTN_CONTINUAR;
import static com.banistmo.certificacion.userinterface.configuracion.FavoritosGeneralPage.*;
import static com.banistmo.certificacion.userinterface.configuracion.administracion.favoritos.recargas.CreacionFavoritoRecargasPage.*;
import static com.banistmo.certificacion.utils.enums.EnumVariablesSesion.VERIFICAR_TRANSACCION;

import com.banistmo.certificacion.interactions.SelecionarLista;
import com.banistmo.certificacion.interactions.esperas.Esperar;
import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import com.banistmo.certificacion.models.comun.Validacion;
import com.banistmo.certificacion.models.productos.Recargas;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.questions.Visibility;

public class FavoritosRecargas implements Task {

  private Recargas datosFavorito;

  public FavoritosRecargas(Recargas recargas) {
    this.datosFavorito = recargas;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        EsperarElemento.esClickable(BTN_NUEVO_FAVORITO),
        Click.on(BTN_NUEVO_FAVORITO),
        EsperarCarga.desaparezca(),
        Click.on(BTN_TIPO_RECARGA),
        Esperar.unTiempo(3000),
        EsperarElemento.esClickable(LST_BTN_TIPOS_RECARGAS_PROVEEDOR),
        SelecionarLista.unaOpcion(
            datosFavorito.getProducto().getTipoProducto(), LST_BTN_TIPOS_RECARGAS_PROVEEDOR, true),
        EsperarCarga.desaparezca(),
        EsperarElemento.esClickable(TXT_NUMERO_PRODUCTO),
        Enter.theValue(datosFavorito.getBeneficiario().getNumero()).into(TXT_NUMERO_PRODUCTO));
    if (Boolean.TRUE.equals(Visibility.of(BTN_PROVEEDOR).viewedBy(actor).asBoolean())) {
      actor.attemptsTo(
          EsperarElemento.esClickable(BTN_PROVEEDOR),
          Click.on(BTN_PROVEEDOR),
          Esperar.unTiempo(3000),
          EsperarElemento.esClickable(LST_BTN_TIPOS_RECARGAS_PROVEEDOR),
          SelecionarLista.unaOpcion(
              datosFavorito.getNombreOperador(), LST_BTN_TIPOS_RECARGAS_PROVEEDOR, true));
    }
    actor.attemptsTo(
        EsperarCarga.desaparezca(),
        EsperarElemento.esClickable(TXT_NOMBRE_FAVORITO_RECARGAS_SERVICIOS),
        Enter.theValue(datosFavorito.getProducto().getDescripcion())
            .into(TXT_NOMBRE_FAVORITO_RECARGAS_SERVICIOS),
        EsperarCarga.desaparezca(),
        EsperarElemento.esClickable(BTN_CONTINUAR),
        Click.on(BTN_CONTINUAR),
        EsperarCarga.desaparezca(),
        EsperarElemento.esVisible(BTN_PRODUCTOS_ACTIVOS));
    Validacion validacion = new Validacion(datosFavorito.getProducto());
    actor.remember(VERIFICAR_TRANSACCION.getVariableSesion(), validacion);
  }
}
