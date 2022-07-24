#language:es

@AdministracionCuentasTercerasFavoritas @20016
Característica: Administración de Favoritas APP - Cuentas terceras
  Yo como un usuario del APP de personas
  Quiero administrar los terceros beneficiarios
  Para que sea más rápido ejecutar las transacciones que hago a esas cuentas.

  @20016-1 @RutaCriticaLote1
  Escenario: Agregar un nuevo favorito en Cuentas de terceros favoritas
    Dado que Carlos quiere ingresar con el usuario: Autotransferencia123_ y la clave: Prueba123##
    Y el ingresa en las pestaña de favoritos a Cuentas de terceros favoritas
    Y el elimina el favoritos con el nombre: MiFavoritoOdin
    Cuando el intenta crear un favorito terceros
      | Nombre beneficiario | Correo electronico | Banco   | Tipo producto     | Cuenta     | Nombre favorito |
      | Tomas               | test@gmail.com     | Allbank | Cuenta de ahorros | 8489002831 | MiFavoritoOdin  |
    Entonces la cuenta favorito se ha creado exitosamente

  @20016-2
  Escenario: Editar un favorito terceros
    Dado que Carlos quiere ingresar con el usuario: Autotransferencia123_ y la clave: Prueba123##
    Y el ingresa en las pestaña de favoritos a Cuentas de terceros favoritas
    Y el elimina el favoritos con el nombre: MiFavoritoOdin
    Cuando el intenta crear un favorito terceros
      | Nombre beneficiario | Correo electronico | Banco   | Tipo producto     | Cuenta     | Nombre favorito |
      | Tomas               | test@gmail.com     | Allbank | Cuenta de ahorros | 8489002831 | MiFavoritoOdin  |
    Y el intenta editar un favorito terceros
      | Nombre beneficiario | Correo electronico     |
      | Juan                | testBanistmo@gmail.com |
    Entonces el favorito terceros debio ser editado exitosamente

  @20016-3
  Escenario: Inactivar un favorito terceros
    Dado que Felipe quiere ingresar con el usuario: Autotransferencia123_ y la clave: Prueba123##
    Y el ingresa en las pestaña de favoritos a Cuentas de terceros favoritas
    Y el elimina el favoritos con el nombre: MiFavoritoOdin
    Cuando el intenta crear un favorito terceros
      | Nombre beneficiario | Correo electronico | Banco   | Tipo producto     | Cuenta     | Nombre favorito |
      | Tomas               | test@gmail.com     | Allbank | Cuenta de ahorros | 8489002831 | MiFavoritoOdin  |
    Y el inactiva el favorito creado
    Entonces el favorito debio ser inactivado exitosamente

  @20016-4
  Escenario: Activar un favorito terceros
    Dado que Felipe quiere ingresar con el usuario: Autotransferencia123_ y la clave: Prueba123##
    Y el ingresa en las pestaña de favoritos a Cuentas de terceros favoritas
    Y el elimina el favoritos con el nombre: MiFavoritoOdin
    Cuando el intenta crear un favorito terceros
      | Nombre beneficiario | Correo electronico | Banco   | Tipo producto     | Cuenta     | Nombre favorito |
      | Tomas               | test@gmail.com     | Allbank | Cuenta de ahorros | 8489002831 | MiFavoritoOdin  |
    Y el inactiva el favorito creado
    Y el activa el favorito inactivo
    Entonces el favorito debio ser activado exitosamente

  @20016-5 @RutaCritica
  Escenario: Crear favorito desde transaccion
    Dado que Felipe quiere ingresar con el usuario: Autotransferencia123_ y la clave: Prueba123##
    Y el ingresa en las pestaña de favoritos a Cuentas de terceros favoritas
    Y el elimina el favoritos con el nombre: MiFavoritoOdin
    Cuando el intenta crear un favorito terceros desde transferencias
      | Nombre beneficiario | Correo electronico | Banco         | Tipo producto    | Cuenta     | Nombre favorito |
      | JuanFe              | test@gmail.com     | Banistmo S.a. | Cuenta corriente | 0105068499 | MiFavoritoOdin  |
    Entonces el favorito debio ser editado exitosamente desde transferencias

  @20016-6
  Escenario: eliminar favorito terceros
    Dado que Felipe quiere ingresar con el usuario: Autotransferencia123_ y la clave: Prueba123##
    Y el ingresa en las pestaña de favoritos a Cuentas de terceros favoritas
    Y el elimina el favoritos con el nombre: MiFavoritoOdin
    Cuando el intenta crear un favorito terceros
      | Nombre beneficiario | Correo electronico | Banco   | Tipo producto     | Cuenta     | Nombre favorito |
      | Tomas               | test@gmail.com     | Allbank | Cuenta de ahorros | 8489002831 | MiFavoritoOdin  |
    Y el intenta eliminar una cuenta favorita
    Entonces se elimina exitosamente la cuenta favorita