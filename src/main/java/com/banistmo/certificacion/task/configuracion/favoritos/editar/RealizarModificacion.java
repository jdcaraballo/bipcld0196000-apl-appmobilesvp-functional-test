package com.banistmo.certificacion.task.configuracion.favoritos.editar;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.banistmo.certificacion.models.builders.RecargasBuilder;
import com.banistmo.certificacion.models.builders.ServicioBuilder;
import com.banistmo.certificacion.models.builders.TransaccionBuilder;
import com.banistmo.certificacion.task.configuracion.favoritos.internacional.EditarFavoritoInternacional;
import com.banistmo.certificacion.task.configuracion.favoritos.recargas.EditarFavoritoRecargas;
import com.banistmo.certificacion.task.configuracion.favoritos.servicios.EditarFavoritoServicio;
import com.banistmo.certificacion.task.configuracion.favoritos.terceros.EditarFavoritoTerceros;

public class RealizarModificacion {

  private RealizarModificacion() {}

  public static EditarFavoritoInternacional deFavoritoInternacional(TransaccionBuilder builder) {
    return instrumented(EditarFavoritoInternacional.class, builder.build());
  }

  public static EditarFavoritoTerceros deFavoritoTerceros(TransaccionBuilder transaccionBuilder) {
    return instrumented(EditarFavoritoTerceros.class, transaccionBuilder.build());
  }

  public static EditarFavoritoRecargas deFavoritoRecargas(RecargasBuilder recargasBuilder) {
    return instrumented(EditarFavoritoRecargas.class, recargasBuilder.build());
  }

  public static EditarFavoritoServicio deFavoritoServicio(ServicioBuilder servicioBuilder) {
    return instrumented(EditarFavoritoServicio.class, servicioBuilder.build());
  }
}
