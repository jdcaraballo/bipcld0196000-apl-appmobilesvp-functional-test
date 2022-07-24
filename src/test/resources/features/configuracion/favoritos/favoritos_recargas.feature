#language:es

@AdministracionRecargasFavoritas
Característica: Administración de Favoritas APP - Recargas
  Yo como un usuario del APP de personas
  Quiero administrar los terceros beneficiarios
  Para que sea más rápido ejecutar las transacciones que hago a esas cuentas.

  @RutaCriticaLote1
  Escenario: Agregar un nuevo favorito en recargas
    Dado que Carlos quiere ingresar con el usuario: Autorecarga12345_ y la clave: Prueba123##
    Y el ingresa en las pestaña de favoritos a Recargas favoritas
    Y el elimina el favoritos con el nombre: RecargaFavoritaOdin
    Cuando el intenta crear un favorito recargas
      | Tipo producto | Numero  | Operador | Nombre favorito     |
      | Digicel       | 6257732 | Digicel  | RecargaFavoritaOdin |
    Entonces la cuenta favorito se ha creado exitosamente

  Escenario: Inactivar una recarga favorita
    Dado que Carlos quiere ingresar con el usuario: Autorecarga12345_ y la clave: Prueba123##
    Y el ingresa en las pestaña de favoritos a Recargas favoritas
    Y el elimina el favoritos con el nombre: RecargaFavoritaOdin
    Cuando el intenta crear un favorito recargas
      | Tipo producto | Numero  | Operador | Nombre favorito     |
      | Digicel       | 6257732 | Digicel  | RecargaFavoritaOdin |
    Y el inactiva el favorito creado
    Entonces el favorito debio ser inactivado exitosamente

  Escenario: Activar una recarga favorita
    Dado que Carlos quiere ingresar con el usuario: Autorecarga12345_ y la clave: Prueba123##
    Y el ingresa en las pestaña de favoritos a Recargas favoritas
    Y el elimina el favoritos con el nombre: RecargaFavoritaOdin
    Cuando el intenta crear un favorito recargas
      | Tipo producto | Numero  | Operador | Nombre favorito     |
      | Digicel       | 6257732 | Digicel  | RecargaFavoritaOdin |
    Y el inactiva el favorito creado
    Y el activa el favorito inactivo
    Entonces el favorito debio ser activado exitosamente

  Escenario: eliminar una recarga favorita
    Dado que Carlos quiere ingresar con el usuario: Autorecarga12345_ y la clave: Prueba123##
    Y el ingresa en las pestaña de favoritos a Recargas favoritas
    Y el elimina el favoritos con el nombre: RecargaFavoritaOdin
    Cuando el intenta crear un favorito recargas
      | Tipo producto | Numero  | Operador | Nombre favorito     |
      | Digicel       | 6257732 | Digicel  | RecargaFavoritaOdin |
    Y el intenta eliminar una cuenta favorita
    Entonces se elimina exitosamente la cuenta favorita

  Escenario: Editar una recarga favorita
    Dado que Carlos quiere ingresar con el usuario: Autorecarga12345_ y la clave: Prueba123##
    Y el ingresa en las pestaña de favoritos a Recargas favoritas
    Y el elimina el favoritos con el nombre: RecargaFavoritaOdin
    Cuando el intenta crear un favorito recargas
      | Tipo producto | Numero  | Operador | Nombre favorito     |
      | Digicel       | 6257732 | Digicel  | RecargaFavoritaOdin |
    Y el intenta editar un favorito recargas
      | Numero  |
      | 6257592 |
    Entonces el favorito recarga debio ser editado exitosamente

