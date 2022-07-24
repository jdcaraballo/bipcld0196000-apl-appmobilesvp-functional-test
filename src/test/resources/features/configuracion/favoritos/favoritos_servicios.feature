#language:es

@AdministracionServiciosFavoritos @200
Característica: Administración de Favoritas APP - Servicios
  Yo como un usuario del APP de personas
  Quiero administrar los terceros beneficiarios
  Para que sea más rápido ejecutar las transacciones que hago a esas cuentas.

  @RutaCriticaLote1
  Escenario: Agregar un nuevo servicio favorito
    Dado que Carlos quiere ingresar con el usuario: Autoservicio123_ y la clave: Prueba123##
    Y el ingresa en las pestaña de favoritos a Servicios favoritos
    Y el elimina el favoritos con el nombre: ServicioFavoritoOdin
    Cuando el intenta crear un favorito servicios
      | Nombre servicio | Nombre beneficiario | Numero pago | Nombre favorito      |
      | COLEGIO CLARET  | Pedro               | 16262       | ServicioFavoritoOdin |
    Entonces la cuenta favorito se ha creado exitosamente

  Escenario: Inactivar un servicio favorita
    Dado que Carlos quiere ingresar con el usuario: Autoservicio123_ y la clave: Prueba123##
    Y el ingresa en las pestaña de favoritos a Servicios favoritos
    Y el elimina el favoritos con el nombre: ServicioFavoritoOdin
    Cuando el intenta crear un favorito servicios
      | Nombre servicio | Nombre beneficiario | Numero pago | Nombre favorito      |
      | COLEGIO CLARET  | Pedro               | 16262       | ServicioFavoritoOdin |
    Y el inactiva el favorito creado
    Entonces el favorito debio ser inactivado exitosamente

  Escenario: Activar un servicio favorita
    Dado que Carlos quiere ingresar con el usuario: Autoservicio123_ y la clave: Prueba123##
    Y el ingresa en las pestaña de favoritos a Servicios favoritos
    Y el elimina el favoritos con el nombre: ServicioFavoritoOdin
    Cuando el intenta crear un favorito servicios
      | Nombre servicio | Nombre beneficiario | Numero pago | Nombre favorito      |
      | COLEGIO CLARET  | Pedro               | 16262       | ServicioFavoritoOdin |
    Y el inactiva el favorito creado
    Y el activa el favorito inactivo
    Entonces el favorito debio ser activado exitosamente

  Escenario: eliminar un servicio favorita
    Dado que Carlos quiere ingresar con el usuario: Autoservicio123_ y la clave: Prueba123##
    Y el ingresa en las pestaña de favoritos a Servicios favoritos
    Y el elimina el favoritos con el nombre: ServicioFavoritoOdin
    Cuando el intenta crear un favorito servicios
      | Nombre servicio | Nombre beneficiario | Numero pago | Nombre favorito      |
      | COLEGIO CLARET  | Pedro               | 16262       | ServicioFavoritoOdin |
    Y el intenta eliminar una cuenta favorita
    Entonces se elimina exitosamente la cuenta favorita

  Escenario: editar un servicio favorita
    Dado que Carlos quiere ingresar con el usuario: Autoservicio123_ y la clave: Prueba123##
    Y el ingresa en las pestaña de favoritos a Servicios favoritos
    Y el elimina el favoritos con el nombre: ServicioFavoritoOdin
    Cuando el intenta crear un favorito servicios
      | Nombre servicio | Nombre beneficiario | Numero pago | Nombre favorito      |
      | COLEGIO CLARET  | Pedro               | 16262       | ServicioFavoritoOdin |
    Y el intenta editar un favorito servicio
      | Nombre beneficiario | Numero pago |
      | Juan                | 58397       |
    Entonces el favorito servicio debio ser editado exitosamente
