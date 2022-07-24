package com.banistmo.certificacion.task.configuracion.favoritos.editar;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Editar {

  private Editar() {}

  public static FavoritoActivo favoritoActivo(String nombreFavorito) {
    return instrumented(FavoritoActivo.class, nombreFavorito);
  }

  public static FavoritoInactivo favoritoInactivo(String nombreFavorito) {
    return instrumented(FavoritoInactivo.class, nombreFavorito);
  }
}
