package com.banistmo.certificacion.task.transferencias.internacionales;

import static com.banistmo.certificacion.userinterface.comunes.TransaccionesGeneralPage.*;
import static com.banistmo.certificacion.userinterface.transferencias.internacionales.InternacionalesPage.*;
import static com.banistmo.certificacion.userinterface.transferencias.internacionales.InternacionalesPage.LBL_BANCO_DESTINO;
import static com.banistmo.certificacion.userinterface.transferencias.internacionales.InternacionalesPage.TXT_DESCRIPCION;
import static com.banistmo.certificacion.userinterface.transferencias.internacionales.InternacionalesPage.TXT_MONTO;
import static com.banistmo.certificacion.utils.enums.EnumVariablesSesion.VERIFICAR_TRANSACCION;

import com.banistmo.certificacion.interactions.ClickAleatorio;
import com.banistmo.certificacion.interactions.Escribir;
import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import com.banistmo.certificacion.models.comun.Transaccion;
import com.banistmo.certificacion.models.comun.Validacion;
import com.banistmo.certificacion.utils.UtileriaString;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.questions.Text;

public class CuentaGuardadaInternacional implements Task {

  private Transaccion transferencia;

  public CuentaGuardadaInternacional(Transaccion transferencia) {
    this.transferencia = transferencia;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        EsperarElemento.esClickable(BTN_MOSTRAR_CUENTAS_RETIRO),
        Click.on(BTN_MOSTRAR_CUENTAS_RETIRO),
        EsperarElemento.esClickable(LST_BTN_CUENTA_RETIRO_DESTINO),
        ClickAleatorio.enElemento(LST_BTN_CUENTA_RETIRO_DESTINO),
        Click.on(BTN_MOSTRAR_CUENTAS_DESTINO),
        EsperarElemento.esClickable(BTN_CUENTA_INTERNACIONAL_GUARDADA),
        ClickAleatorio.enElemento(BTN_CUENTA_INTERNACIONAL_GUARDADA),
        Escribir.valorPlataforma(transferencia.getProducto().getMonto(), TXT_MONTO),
        Enter.theValue(transferencia.getProducto().getDescripcion()).into(TXT_DESCRIPCION),
        Click.on(RBT_ASUMIR_COSTO));
    obtenerDatosTransferenciaInternacionalGuardada(actor);
  }

  private void obtenerDatosTransferenciaInternacionalGuardada(Actor actor) {
    Validacion validacion = new Validacion(transferencia);
    validacion
        .getProducto()
        .setNumeroCuentaRetiro(
            UtileriaString.formatearCuentasRetiro(
                Text.of(LBL_NUMERO_CUENTA_RETIROS).viewedBy(actor).asString()));
    validacion.getProducto().setPaisDestino(Text.of(LBL_PAIS_DESTINO).viewedBy(actor).asString());
    validacion.getProducto().setCodigoBanco(Text.of(LBL_CODIGO_BANCO).viewedBy(actor).asString());
    validacion.getProducto().setBanco(Text.of(LBL_BANCO_DESTINO).viewedBy(actor).asString());
    actor.remember(VERIFICAR_TRANSACCION.getVariableSesion(), validacion);
  }
}
