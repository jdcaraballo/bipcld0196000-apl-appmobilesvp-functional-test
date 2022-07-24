#language:es

@AdministracionCuentasInternacionalesFavoritas @39980
Característica: Administración de Favoritas APP - Internacionales
  Yo como un usuario de la APP de personas
  Quiero administrar los terceros beneficiarios de tipo internacional
  Para que sea más rápido ejecutar las transacciones que hago a esas cuentas.

  @39980-1 @RutaCriticaLote1
  Escenario: Agregar un nuevo favorito internacional
    Dado que Felipe quiere ingresar con el usuario: Autotransferencia123_ y la clave: Prueba123##
    Y el ingresa en las pestaña de favoritos a Cuentas internacionales favoritas
    Y el elimina el favoritos con el nombre: IntlFavoritoOdin
    Cuando el intenta crear una cuenta favorita internacional
      | Pais     | Banco            | Cuenta | Nombre beneficiario | Pais beneficiario | Ciudad beneficiario | Direccion beneficiario | Correo electronico  | Nombre favorito  |
      | Colombia | BANCOLOMBIA S.A. | 121212 | Juan                | Colombia          | Medellin            | Calle 4                | testqa@banistmo.com | IntlFavoritoOdin |
    Entonces la cuenta favorito se ha creado exitosamente

  @39980-2
  Escenario: Editar un favorito internacional
    Dado que Felipe quiere ingresar con el usuario: Autotransferencia123_ y la clave: Prueba123##
    Y el ingresa en las pestaña de favoritos a Cuentas internacionales favoritas
    Y el elimina el favoritos con el nombre: IntlFavoritoOdin
    Cuando el intenta crear una cuenta favorita internacional
      | Pais     | Banco            | Cuenta | Nombre beneficiario | Pais beneficiario | Ciudad beneficiario | Direccion beneficiario | Correo electronico  | Nombre favorito  |
      | Colombia | BANCOLOMBIA S.A. | 121212 | Juan                | Colombia          | Medellin            | Calle 4                | testqa@banistmo.com | IntlFavoritoOdin |
    Y el intenta editar un favorito internacional
      | Nombre beneficiario | Ciudad beneficiario |
      | Pablo               | Bogota              |
    Entonces el favorito internacional debio ser editado exitosamente

  @39980-3
  Escenario: Inactivar un favorito internacional
    Dado que Felipe quiere ingresar con el usuario: Autotransferencia123_ y la clave: Prueba123##
    Y el ingresa en las pestaña de favoritos a Cuentas internacionales favoritas
    Y el elimina el favoritos con el nombre: IntlFavoritoOdin
    Cuando el intenta crear una cuenta favorita internacional
      | Pais     | Banco            | Cuenta | Nombre beneficiario | Pais beneficiario | Ciudad beneficiario | Direccion beneficiario | Correo electronico  | Nombre favorito  |
      | Colombia | BANCOLOMBIA S.A. | 121212 | Juan                | Colombia          | Medellin            | Calle 4                | testqa@banistmo.com | IntlFavoritoOdin |
    Y el inactiva el favorito creado
    Entonces el favorito debio ser inactivado exitosamente

  @39980-4
  Escenario: Activar un favorito internacional
    Dado que Felipe quiere ingresar con el usuario: Autotransferencia123_ y la clave: Prueba123##
    Y el ingresa en las pestaña de favoritos a Cuentas internacionales favoritas
    Y el elimina el favoritos con el nombre: IntlFavoritoOdin
    Cuando el intenta crear una cuenta favorita internacional
      | Pais     | Banco            | Cuenta | Nombre beneficiario | Pais beneficiario | Ciudad beneficiario | Direccion beneficiario | Correo electronico  | Nombre favorito  |
      | Colombia | BANCOLOMBIA S.A. | 121212 | Juan                | Colombia          | Medellin            | Calle 4                | testqa@banistmo.com | IntlFavoritoOdin |
    Y el inactiva el favorito creado
    Y el activa el favorito inactivo
    Entonces el favorito debio ser activado exitosamente

  @39980-5
  Escenario: eliminar cuenta favorita internacional
    Dado que Maicol quiere ingresar con el usuario: Autotransferencia123_ y la clave: Prueba123##
    Y el ingresa en las pestaña de favoritos a Cuentas internacionales favoritas
    Y el elimina el favoritos con el nombre: IntlFavoritoOdin
    Cuando el intenta crear una cuenta favorita internacional
      | Pais     | Banco            | Cuenta | Nombre beneficiario | Pais beneficiario | Ciudad beneficiario | Direccion beneficiario | Correo electronico  | Nombre favorito  |
      | Colombia | BANCOLOMBIA S.A. | 121212 | Juan                | Colombia          | Medellin            | Calle 4                | testqa@banistmo.com | IntlFavoritoOdin |
    Y el intenta eliminar una cuenta favorita
    Entonces se elimina exitosamente la cuenta favorita




