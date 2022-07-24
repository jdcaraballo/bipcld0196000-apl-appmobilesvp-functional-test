package com.banistmo.certificacion.task.configuracion.favoritos.servicios;

import static com.banistmo.certificacion.userinterface.comunes.TransaccionesGeneralPage.BTN_CONTINUAR;
import static com.banistmo.certificacion.userinterface.configuracion.FavoritosGeneralPage.*;
import static com.banistmo.certificacion.userinterface.configuracion.administracion.favoritos.servicios.CreacionFavoritoServiciosPage.*;
import static com.banistmo.certificacion.utils.enums.EnumVariablesSesion.VERIFICAR_TRANSACCION;

import com.banistmo.certificacion.interactions.ClickCambiando;
import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import com.banistmo.certificacion.models.comun.Validacion;
import com.banistmo.certificacion.models.productos.Servicio;
import com.banistmo.certificacion.questions.driver.ObtenerPlataforma;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import org.openqa.selenium.Keys;

public class CrearFavoritosServicios implements Task {

  private Servicio datosFavorito;

  public CrearFavoritosServicios(Servicio servicio) {
    this.datosFavorito = servicio;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        EsperarElemento.esClickable(BTN_NUEVO_FAVORITO),
        Click.on(BTN_NUEVO_FAVORITO),
        EsperarCarga.desaparezca(),
        EsperarElemento.esClickable(BTN_TIPO_PRODUCTO),
        Click.on(BTN_TIPO_PRODUCTO),
        EsperarCarga.desaparezca(),
        EsperarElemento.esClickable(BTN_PAGO_SERVICIOS),
        Click.on(BTN_PAGO_SERVICIOS),
        EsperarElemento.esClickable(TXT_NOMBRE_SERVICIO),
        Check.whether("iOS".equalsIgnoreCase(ObtenerPlataforma.deEjecucion().answeredBy(actor)))
            .andIfSo(ClickCambiando.elContexto(TXT_NOMBRE_SERVICIO_NATIVO_IOS))
            .otherwise(Click.on(TXT_NOMBRE_SERVICIO)),
        EsperarCarga.desaparezca(),
        EsperarElemento.esClickable(TXT_BUSCAR_SERVICIO),
        Enter.theValue(datosFavorito.getNombreServicio())
            .into(TXT_BUSCAR_SERVICIO)
            .thenHit(Keys.ENTER),
        EsperarCarga.desaparezca(),
        EsperarElemento.esClickable(BTN_SELECCIONAR_SERVICIO),
        Click.on(BTN_SELECCIONAR_SERVICIO),
        EsperarCarga.desaparezca(),
        EsperarElemento.esClickable(TXT_NOMBRE_CLIENTE),
        Enter.theValue(datosFavorito.getBeneficiario().getNombre()).into(TXT_NOMBRE_CLIENTE),
        Enter.theValue(datosFavorito.getBeneficiario().getNumero()).into(TXT_NUMERO_CLIENTE),
        Enter.theValue(datosFavorito.getProducto().getDescripcion())
            .into(TXT_NOMBRE_FAVORITO_RECARGAS_SERVICIOS),
        EsperarElemento.esClickable(BTN_CONTINUAR),
        Click.on(BTN_CONTINUAR),
        EsperarCarga.desaparezca(),
        EsperarElemento.esVisible(BTN_PRODUCTOS_ACTIVOS));
    Validacion validacion = new Validacion(datosFavorito.getProducto());
    actor.remember(VERIFICAR_TRANSACCION.getVariableSesion(), validacion);
  }
}
