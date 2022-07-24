package com.banistmo.certificacion.task.configuracion.productos.alias;

import static com.banistmo.certificacion.task.configuracion.productos.alias.CambiarAliasInvisible.cambiarNombreCuenta;
import static com.banistmo.certificacion.userinterface.configuracion.administracion.producto.ConfiguracionProductoPage.*;
import static com.banistmo.certificacion.utils.enums.EnumVariablesSesion.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import com.banistmo.certificacion.questions.configuracion.productos.ObtenerNombreCuenta;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class CambiarAlias implements Task {

  private String aliasProducto;

  public CambiarAlias(String aliasProducto) {
    this.aliasProducto = aliasProducto;
  }

  public static CambiarAlias producto(String aliasProducto) {
    return instrumented(CambiarAlias.class, aliasProducto);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(EsperarElemento.esClickable(LST_BTN_CUENTAS));
    String nombreCuentaFiltrado =
        ObtenerNombreCuenta.aleatorio(LST_LBL_NOMBRE_CUENTAS).answeredBy(actor);
    cambiarNombreCuenta(actor, nombreCuentaFiltrado, aliasProducto);
    actor.remember(NOMBRE_NUEVO.getVariableSesion(), aliasProducto);
    actor.remember(NOMBRE_ANTERIOR.getVariableSesion(), nombreCuentaFiltrado);
  }
}
