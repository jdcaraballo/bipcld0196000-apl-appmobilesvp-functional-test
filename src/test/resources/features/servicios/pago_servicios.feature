#language:es

@PagoServicios
Característica: Pago de Servicios
  Yo como un usuario de la SVP
  Quiero realizar el pago de mis servicios

  @PagoExitosoServiciosNequi @RutaCriticaLote2
  Escenario: Pago exitoso de servicios
    Dado que Camilo quiere ingresar con el usuario: Autoservicio123_ y la clave: Prueba123##
    Cuando el intenta realizar el pago de un servicio
      | Nombre servicio | Monto | Numero pago |
      | Claro panama    | 10.00 | 67777742    |
    Y el termina la transaccion
    Entonces el pago al servicio deberia ser exitoso

  @CancelacionPagoServicioVerificacion
  Escenario: Cancelacion pago de servicios pantalla verificacion
    Dado que Camilo quiere ingresar con el usuario: Autoservicio123_ y la clave: Prueba123##
    Cuando el intenta realizar el pago de un servicio
      | Nombre servicio | Monto | Numero pago |
      | Claro panama    | 10.00 | 67777742    |
    Y el cancela la transaccion en la pantalla de Verificación
    Entonces el puede observar sus productos

  @CancelacionPagoServicioPreparacion
  Escenario: Cancelacion pago de servicios pantalla preparacion
    Dado que Camilo quiere ingresar con el usuario: Autoservicio123_ y la clave: Prueba123##
    Cuando el intenta realizar el pago de un servicio
      | Nombre servicio | Monto | Numero pago |
      | Claro panama    | 10.00 | 67777742    |
    Y el cancela la transaccion en la pantalla de Preparación
    Entonces el puede observar sus productos

  @PagoServiciosValorSuperior
  Escenario: Pago de servicios con un valor superior al disponible
    Dado que Camilo quiere ingresar con el usuario: salvatore13_ y la clave: Prueba123##
    Cuando el intenta realizar el pago de un servicio
      | Nombre servicio | Monto | Numero pago |
      | Claro panama    | 99999999   | 67777742    |
    Y el termina la transaccion
    Entonces deberia ver el siguiente mensaje: No cuenta con fondos suficientes para realizar esta transacción

  @PagoExitosoServicioConsulta @RutaCriticaLote2
  Escenario: Pago exitoso de un servicio consulta
    Dado que Camilo quiere ingresar con el usuario: Autoservicio123_ y la clave: Prueba123##
    Cuando el intenta realizar el pago de un servicio
      | Nombre servicio | Monto | Numero pago |
      | Mupa            | 2.00  | 518461      |
    Y el termina la transaccion
    Entonces el pago al servicio deberia ser exitoso

  @CancelacionPagoServicioOnlineVerificacion
  Escenario: Cancelacion de un servicio consulta pantalla verificacion
    Dado que Camilo quiere ingresar con el usuario: Autoservicio123_ y la clave: Prueba123##
    Cuando el intenta realizar el pago de un servicio
      | Nombre servicio | Monto | Numero pago |
      | Mupa            | 2.00  | 518461      |
    Y el cancela la transaccion en la pantalla de Verificación
    Entonces el puede observar sus productos

  @CancelacionPagoServicioOnlinePreparacion
  Escenario: Cancelacion de un servicio consulta pantalla preparacion
    Dado que Camilo quiere ingresar con el usuario: Autoservicio123_ y la clave: Prueba123##
    Cuando el intenta realizar el pago de un servicio
      | Nombre servicio | Monto | Numero pago |
      | Mupa            | 2.00  | 518461      |
    Y el cancela la transaccion en la pantalla de Preparación
    Entonces el puede observar sus productos

  @PagoExitosoServicioConsultaValorSuperior
  Escenario: Pago de servicios consulta con un valor superior al disponible
    Dado que Camilo quiere ingresar con el usuario: Autoservicio123_ y la clave: Prueba123##
    Cuando el intenta realizar el pago de un servicio
      | Nombre servicio | Monto    | Numero pago |
      | Colegio Claret  | 99999999 | 518461      |
    Y el termina la transaccion
    Entonces deberia ver el siguiente mensaje: No cuenta con fondos suficientes para realizar esta transacción



