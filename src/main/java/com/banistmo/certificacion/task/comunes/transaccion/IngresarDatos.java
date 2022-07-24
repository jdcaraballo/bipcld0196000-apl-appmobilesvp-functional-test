package com.banistmo.certificacion.task.comunes.transaccion;

import static com.banistmo.certificacion.userinterface.configuracion.administracion.favoritos.terceros.CreacionFavoritosTercerosPage.BTN_BANCO_DESTINO;
import static com.banistmo.certificacion.userinterface.configuracion.administracion.favoritos.terceros.CreacionFavoritosTercerosPage.LST_BTN_BANCOS_PRODUCTOS;
import static com.banistmo.certificacion.userinterface.prestamos.PrestamosPage.*;
import static com.banistmo.certificacion.userinterface.transferencias.terceros.DatosTercerosPage.*;
import static com.banistmo.certificacion.utils.enums.EnumProductos.TARJETA_CREDITO;
import static com.banistmo.certificacion.utils.enums.EnumVariablesSesion.VERIFICAR_TRANSACCION;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.banistmo.certificacion.interactions.SelecionarLista;
import com.banistmo.certificacion.models.comun.Transaccion;
import com.banistmo.certificacion.models.comun.Validacion;
import com.banistmo.certificacion.task.autenticacion.recuperarusuario.IngresarOlvidoUsuario;
import com.banistmo.certificacion.userinterface.comunes.TransaccionesGeneralPage;
import com.banistmo.certificacion.utils.UtileriaString;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.questions.Text;

import java.util.List;
import java.util.Map;

public class IngresarDatos implements Task {

  private Transaccion producto;

  public IngresarDatos(Transaccion producto) {
    this.producto = producto;
  }

  public static IngresarDatos terceros(Transaccion producto) {
    return instrumented(IngresarDatos.class, producto);
  }

  public static IngresarOlvidoUsuario recuperarUsuario(List<Map<String, String>> datos) {
    return instrumented(IngresarOlvidoUsuario.class, datos);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        Enter.theValue(producto.getBeneficiario().getNombre()).into(TXT_NOMBRE),
        Enter.theValue(producto.getBeneficiario().getCorreo()).into(TXT_CORREO),
        Click.on(BTN_BANCO_DESTINO),
        SelecionarLista.unaOpcion(
            producto.getProducto().getBanco(), LST_BTN_BANCOS_PRODUCTOS, true),
        Enter.theValue(producto.getProducto().getNumeroCuentaDestino()).into(TXT_NUMERO_CUENTA),
        Click.on(TransaccionesGeneralPage.BTN_CONTINUAR),
        Enter.theValue(producto.getProducto().getMonto()).into(TransaccionesGeneralPage.TXT_MONTO),
        Enter.theValue(producto.getProducto().getDescripcion())
            .into(TransaccionesGeneralPage.TXT_DESCRIPCION));
    obtenerDatosTercerosPagos(actor);
  }

  private void obtenerDatosTercerosPagos(Actor actor) {
    Validacion validacion = new Validacion(producto);
    validacion
        .getProducto()
        .setNumeroCuentaRetiro(
            UtileriaString.formatearCuentasRetiro(
                UtileriaString.obtenerNumeroProducto(
                    Text.of(TransaccionesGeneralPage.LBL_NUMERO_CUENTA_RETIROS)
                        .viewedBy(actor)
                        .asString())));
    if (TARJETA_CREDITO
        .getProducto()
        .equals(
            Text.of(LBL_TIPO_PRODUCTO.of(LST_TIPO_PRODUCTO.resolveFor(actor).getValue()))
                .viewedBy(actor)
                .asString()
                .trim())) {
      validacion
          .getProducto()
          .setNumeroCuentaDestino(
              UtileriaString.formatearTarjeta(validacion.getProducto().getNumeroCuentaDestino()));
    }
    validacion
        .getProducto()
        .setTipoProducto(
            Text.of(LBL_TIPO_PRODUCTO.of(LST_TIPO_PRODUCTO.resolveFor(actor).getValue()))
                .viewedBy(actor)
                .asString()
                .trim());
    actor.remember(VERIFICAR_TRANSACCION.getVariableSesion(), validacion);
  }
}
