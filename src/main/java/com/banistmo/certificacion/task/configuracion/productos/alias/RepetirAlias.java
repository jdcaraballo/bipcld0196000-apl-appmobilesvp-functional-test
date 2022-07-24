package com.banistmo.certificacion.task.configuracion.productos.alias;

import static com.banistmo.certificacion.task.configuracion.productos.alias.CambiarAliasInvisible.cambiarNombreCuenta;
import static com.banistmo.certificacion.userinterface.configuracion.administracion.producto.ConfiguracionProductoPage.LST_BTN_CUENTAS;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.banistmo.certificacion.interactions.esperas.EsperarElemento;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class RepetirAlias implements Task {

  private String aliasProducto;
  private String aliasProductoRepetido;

  public RepetirAlias(String aliasProducto, String aliasProductoRepetido) {
    this.aliasProducto = aliasProducto;
    this.aliasProductoRepetido = aliasProductoRepetido;
  }

  public static RepetirAlias producto(String aliasProducto, String aliasProductoRepetido) {
    return instrumented(RepetirAlias.class, aliasProducto, aliasProductoRepetido);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(EsperarElemento.esClickable(LST_BTN_CUENTAS));
    cambiarNombreCuenta(actor, aliasProducto, aliasProductoRepetido);
  }
}
