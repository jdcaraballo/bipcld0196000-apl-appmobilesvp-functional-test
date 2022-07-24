#language:es

@PagoExitosoServiciosConToken
Característica: Pago de Servicios con token
  Yo como un usuario de la SVP
  Quiero realizar el pago de mis servicios

  @PagoExitosoServiciosNequiToken
  Escenario: Pago exitoso de servicios con token
    Dado que Camilo quiere inscribir token con usuario Autoservicio123_ y clave Prueba123##
    Y el registra el token en el dispositivo con descripcion: SERVICIOS
    Y el inicia sesion en la app
    Cuando el intenta realizar el pago de un servicio
      | Nombre servicio | Monto | Numero pago |
      | Nequi           | 10.00 | 67777742    |
    Y el termina la transaccion con validacion del token
    Entonces el pago al servicio deberia ser exitoso

  @PagoExitosoServicioConsultaToken
  Escenario: Pago exitoso con token de un servicio consulta
    Dado que Camilo quiere inscribir token con usuario Autoservicio123_ y clave Prueba123##
    Y el registra el token en el dispositivo con descripcion: TARJETAS
    Y el inicia sesion en la app
    Cuando el intenta realizar el pago de un servicio
      | Nombre servicio | Monto | Numero pago |
      | Mupa            | 2.00  | XY2121      |
    Y el termina la transaccion con validacion del token
    Entonces el pago al servicio deberia ser exitoso

  @TransaccionConCodigoDeOtroUsuarioToken
  Escenario: Transaccion con codigo de Otro Usuario
    Dado que Ismael quiere inscribir token con usuario Autoservicio123_ y clave Prueba123##
    Cuando el registra el token en el dispositivo con codigo recibido por correo con usuario AutoTDC123_ y clave Prueba123## y descripcion TOKENOTROUSE
    Y el puede ver el usuario registrado en el menu token
    Cuando Ismael ingresa con el usuario: Autoservicio123_ y la clave: Prueba123##
    Y el intenta realizar el pago de un servicio
      | Nombre servicio | Monto | Numero pago |
      | Mupa            | 2.00  | XY2121      |
    Y el termina de transaccionar
    Entonces deberia ver el siguiente mensaje: Ingresa tu número de Soft Token.

  @TransaccionConCodigoIcorrectoToken
  Escenario: Transaccion con codigo incorrecto
    Dado que Andres quiere ingresar con el usuario: Autoservicio123_ y la clave: Prueba123##
    Y el intenta realizar el pago de un servicio
      | Nombre servicio | Monto | Numero pago |
      | Nequi           | 10.00 | 67777712    |
    Cuando el termina de transaccionar con informacion de softtoken aleatoria
    Y el vera el siguiente mensaje: Token incorrecto. Ingresa el código nuevamente
    Cuando que Andres quiere inscribir el token con usuario Autoservicio123_ y clave Prueba123##
    Y el registra el token en el dispositivo con descripcion: ELIZATRANSFER
    Cuando Ismael ingresa con el usuario: Autoservicio123_ y la clave: Prueba123##
    Cuando el intenta realizar el pago de un servicio
      | Nombre servicio | Monto | Numero pago |
      | Nequi           | 10.00 | 67777712    |
    Y el termina la transaccion con validacion del token
    Entonces el pago al servicio deberia ser exitoso
