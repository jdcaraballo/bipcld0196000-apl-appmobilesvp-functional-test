package com.banistmo.certificacion.task.configuracion.favoritos.terceros;

import static com.banistmo.certificacion.userinterface.transferencias.terceros.DatosTercerosPage.*;
import static com.banistmo.certificacion.utils.enums.EnumVariablesSesion.VERIFICAR_TRANSACCION;

import com.banistmo.certificacion.interactions.esperas.EsperarCarga;
import com.banistmo.certificacion.models.comun.Transaccion;
import com.banistmo.certificacion.models.comun.Validacion;
import com.banistmo.certificacion.task.comunes.ingresardatosterceros.IngresarDatos;
import com.banistmo.certificacion.task.comunes.seleccionarcuentas.SeleccionarCuenta;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class CrearFavoritoTransferencias implements Task {

  private Transaccion datosFavorito;

  public CrearFavoritoTransferencias(Transaccion transaccion) {
    this.datosFavorito = transaccion;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        SeleccionarCuenta.destinoNueva(),
        EsperarCarga.desaparezca(),
        IngresarDatos.terceros(datosFavorito),
        Click.on(CHK_GUARDAR_FAVORITO),
        Enter.theValue(datosFavorito.getProducto().getDescripcion()).into(TXT_NOMBRE_FAVORITO),
        Click.on(BTN_AGREGAR),
        EsperarCarga.desaparezca());
    Validacion validacion = new Validacion(datosFavorito);
    actor.remember(VERIFICAR_TRANSACCION.getVariableSesion(), validacion);
  }
}
