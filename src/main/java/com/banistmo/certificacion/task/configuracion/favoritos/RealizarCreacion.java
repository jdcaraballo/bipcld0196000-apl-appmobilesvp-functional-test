package com.banistmo.certificacion.task.configuracion.favoritos;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.banistmo.certificacion.models.builders.RecargasBuilder;
import com.banistmo.certificacion.models.builders.ServicioBuilder;
import com.banistmo.certificacion.models.builders.TransaccionBuilder;
import com.banistmo.certificacion.task.configuracion.favoritos.internacional.FavoritoInternacional;
import com.banistmo.certificacion.task.configuracion.favoritos.recargas.FavoritosRecargas;
import com.banistmo.certificacion.task.configuracion.favoritos.servicios.CrearFavoritosServicios;
import com.banistmo.certificacion.task.configuracion.favoritos.terceros.CrearFavoritoTransferencias;
import com.banistmo.certificacion.task.configuracion.favoritos.terceros.FavoritoTerceros;

public class RealizarCreacion {

  private RealizarCreacion() {}

  public static FavoritoInternacional deFavoritoInternacional(
      TransaccionBuilder transaccionBuilder) {
    return instrumented(FavoritoInternacional.class, transaccionBuilder.build());
  }

  public static FavoritoTerceros deFavoritoTerceros(TransaccionBuilder transaccionBuilder) {
    return instrumented(FavoritoTerceros.class, transaccionBuilder.build());
  }

  public static CrearFavoritoTransferencias deFavoritoTercerosDesdeTransferencias(
      TransaccionBuilder transaccionBuilder) {
    return instrumented(CrearFavoritoTransferencias.class, transaccionBuilder.build());
  }

  public static FavoritosRecargas deFavoritoRecargas(RecargasBuilder recargasBuilder) {
    return instrumented(FavoritosRecargas.class, recargasBuilder.build());
  }

  public static CrearFavoritosServicios deFavoritoServicios(ServicioBuilder servicioBuilder) {
    return instrumented(CrearFavoritosServicios.class, servicioBuilder.build());
  }
}
