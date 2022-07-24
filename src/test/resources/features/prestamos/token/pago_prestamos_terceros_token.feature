#language:es

@PrestamosToken
Característica: Pago de prestamos a terceros con token
  Yo como un usuario de la SVP
  quiero realizar los pagos de prestamos a terceros

  @PagoPrestamosTercerosACHToken
  Escenario: Pago de prestamos a terceros con token ACH exitoso
    Dado que Fernando quiere inscribir token con usuario Autoprestamo123_ y clave Prueba123##
    Y el registra el token en el dispositivo con descripcion: PRESTAMOST
    Y el inicia sesion en la app
    Cuando el intenta pagar un prestamo a terceros ACH
      | Banco      | Cuenta   | Monto | Descripcion |
      | Davivienda | 12345679 | 0.01  | Prueba      |
    Y el termina la transaccion con validacion del token
    Entonces el pago a prestamo a terceros debe ser exitoso

  @PagoPrestamosTercerosBanistmoToken
  Escenario: Pago exitoso de un prestamo de tercero banistmo con token
    Dado que Fernando quiere inscribir token con usuario Autoprestamo123_ y clave Prueba123##
    Y el registra el token en el dispositivo con descripcion: PRESTAMOST
    Y el inicia sesion en la app
    Cuando el intenta pagar un prestamo a terceros Banistmo
      | Banco         | Cuenta    | Monto | Descripcion |
      | Banistmo S.a. | 000502090 | 0.01  | Prueba      |
    Y el termina la transaccion con validacion del token
    Entonces el pago a prestamo a terceros debe ser exitoso

  @PagoPrestamosGuardadosACHToken
  Escenario: Pago de prestamos guardado a terceros ACH exitoso con token
    Dado que Fernando quiere inscribir token con usuario Autoprestamo123_ y clave Prueba123##
    Y el registra el token en el dispositivo con descripcion: PRESTAMOST
    Y el inicia sesion en la app
    Cuando el intenta realizar un pago de un prestamo ACH con un monto: 0.01
    Y el termina la transaccion con validacion del token
    Entonces el pago a prestamo a terceros debe ser exitoso

  @PagoPrestamosGuardadosTercerosBanistmoToken
  Escenario: Pago de prestamos guardado a terceros Banistmo exitoso con token
    Dado que Fernando quiere inscribir token con usuario Autoprestamo123_ y clave Prueba123##
    Y el registra el token en el dispositivo con descripcion: PRESTAMOST
    Y el inicia sesion en la app
    Cuando el intenta realizar un pago de un prestamo Banistmo con un monto: 0.01
    Y el termina la transaccion con validacion del token
    Entonces el pago a prestamo a terceros debe ser exitoso

  @TransaccionConCodigoDeOtroUsuarioToken
  Escenario: Transaccion con codigo de Otro Usuario
    Dado que Ismael quiere inscribir token con usuario elizabeth1234 y clave Prueba123##
    Cuando el registra el token en el dispositivo con codigo recibido por correo con usuario Autoprestamo123_ y clave Prueba123## y descripcion TOKENDEOTROUSER
    Entonces el puede ver el usuario registrado en el menu token
    Cuando Andres ingresa con el usuario: elizabeth1234 y la clave: Prueba123##
    Y el intenta pagar un prestamo a terceros ACH
      | Banco      | Cuenta   | Monto | Descripcion |
      | Davivienda | 12345679 | 0.01  | Prueba      |
    Y el termina de transaccionar
    Entonces deberia ver el siguiente mensaje: Ingresa tu número de Soft Token.

  @TransaccionConCodigoIcorrectoToken
  Escenario: Transaccion con codigo incorrecto
    Dado que Andres quiere ingresar con el usuario: Elizabeth1234 y la clave: Prueba123##
    Cuando el intenta pagar un prestamo a terceros ACH
      | Banco      | Cuenta   | Monto | Descripcion |
      | Davivienda | 12345679 | 0.01  | Prueba      |
    Cuando el termina de transaccionar con informacion de softtoken aleatoria
    Y el vera el siguiente mensaje: Token incorrecto. Ingresa el código nuevamente
    Y Andres quiere inscribir el token con usuario Elizabeth1234 y clave Prueba123##
    Cuando el registra el token en el dispositivo con descripcion: ELIZAPRESTA
    Cuando Andres ingresa con el usuario: elizabeth1234 y la clave: Prueba123##
    Cuando el intenta pagar un prestamo a terceros ACH
      | Banco      | Cuenta   | Monto | Descripcion |
      | Davivienda | 12345679 | 0.01  | Prueba      |
    Y el termina la transaccion con validacion del token
    Entonces el pago a prestamo a terceros debe ser exitoso