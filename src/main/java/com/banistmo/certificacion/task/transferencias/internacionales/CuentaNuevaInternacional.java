package com.banistmo.certificacion.task.transferencias.internacionales;

import static com.banistmo.certificacion.userinterface.comunes.TransaccionesGeneralPage.LBL_NUMERO_CUENTA_RETIROS;
import static com.banistmo.certificacion.userinterface.configuracion.administracion.favoritos.internacional.CreacionFavoritosInternacionalPage.LST_BTN_PAIS_RECEPTOR_IOS;
import static com.banistmo.certificacion.userinterface.transferencias.internacionales.DatosInternacionalesPage.*;
import static com.banistmo.certificacion.userinterface.transferencias.internacionales.InternacionalesPage.*;
import static com.banistmo.certificacion.utils.UtileriaDriver.getPlataformaEjecucion;
import static com.banistmo.certificacion.utils.enums.EnumVariablesSesion.VERIFICAR_TRANSACCION;

import com.banistmo.certificacion.interactions.ClickCambiando;
import com.banistmo.certificacion.interactions.Escribir;
import com.banistmo.certificacion.interactions.SelecionarLista;
import com.banistmo.certificacion.interactions.esperas.Esperar;
import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import com.banistmo.certificacion.models.comun.Transaccion;
import com.banistmo.certificacion.models.comun.Validacion;
import com.banistmo.certificacion.task.comunes.seleccionarcuentas.SeleccionarCuenta;
import com.banistmo.certificacion.utils.UtileriaString;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.questions.Text;
import org.openqa.selenium.Keys;

public class CuentaNuevaInternacional implements Task {

  private Transaccion transferencia;

  public CuentaNuevaInternacional(Transaccion transferencia) {
    this.transferencia = transferencia;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        SeleccionarCuenta.destinoNueva(),
        EsperarElemento.esClickable(BTN_PAIS_DESTINO),
        Click.on(BTN_PAIS_DESTINO),
        EsperarCarga.desaparezca(),
        SelecionarLista.unaOpcion(
            transferencia.getProducto().getPaisDestino(), LST_BTN_BANCOS_PAIS, true),
        EsperarCarga.desaparezca(),
        EsperarElemento.esClickable(BTN_NOMBRE_BANCO_DESTINO),
        Check.whether("iOS".equalsIgnoreCase(getPlataformaEjecucion()))
            .andIfSo(ClickCambiando.elContexto(LST_BTN_PAIS_RECEPTOR_IOS))
            .otherwise(Click.on(BTN_NOMBRE_BANCO_DESTINO)),
        EsperarCarga.desaparezca(),
        EsperarElemento.esClickable(TXT_BUSCAR_BANCO_DESTINO),
        Enter.theValue(transferencia.getProducto().getBanco())
            .into(TXT_BUSCAR_BANCO_DESTINO)
            .thenHit(Keys.ENTER),
        EsperarCarga.desaparezca(),
        EsperarElemento.esClickable(BTN_CARD_BANCO),
        Click.on(BTN_CARD_BANCO),
        EsperarCarga.desaparezca(),
        Enter.theValue(transferencia.getBeneficiario().getNombre()).into(TXT_NOMBRE),
        Enter.theValue(transferencia.getBeneficiario().getDireccion()).into(TXT_DIRECCION),
        Enter.theValue(transferencia.getBeneficiario().getCiudad()).into(TXT_CIUDAD),
        Enter.theValue(transferencia.getBeneficiario().getPais()).into(TXT_PAIS),
        Enter.theValue(transferencia.getBeneficiario().getNumero()).into(TXT_TELEFONO),
        Enter.theValue(transferencia.getBeneficiario().getCorreo()).into(TXT_CORREO),
        Enter.theValue(transferencia.getProducto().getNumeroCuentaDestino()).into(TXT_CUENTA),
        EsperarElemento.esClickable(BTN_CONTINUAR_TRANSFERENCIA),
        Click.on(BTN_CONTINUAR_TRANSFERENCIA),
        Esperar.unTiempo(2000),
        EsperarCarga.desaparezca(),
        EsperarElemento.esClickable(TXT_MONTO),
        Escribir.valorPlataforma(transferencia.getProducto().getMonto(), TXT_MONTO),
        Enter.theValue(transferencia.getProducto().getDescripcion()).into(TXT_DESCRIPCION),
        Click.on(RBT_ASUMIR_COSTO));
    obtenerDatosInternacional(actor);
  }

  private void obtenerDatosInternacional(Actor actor) {
    Validacion validacion = new Validacion(transferencia);
    validacion
        .getProducto()
        .setNumeroCuentaRetiro(
            UtileriaString.formatearCuentasRetiro(
                Text.of(LBL_NUMERO_CUENTA_RETIROS).viewedBy(actor).asString()));
    validacion.getProducto().setCodigoBanco(Text.of(LBL_CODIGO_BANCO).viewedBy(actor).asString());
    actor.remember(VERIFICAR_TRANSACCION.getVariableSesion(), validacion);
  }
}
