#language: es

@TDCTercerosToken
Característica: Pago Tarjetas de credito terceros con token
  Yo como un usuario de la SVP
  Quiero realizar el pago de tarjetas de credito terceros con validacion token

  @TDCT-1
  Escenario: Pago con token Tarjeta de credito terceros Banistmo s.a
    Dado que Ismael quiere inscribir token con usuario AutoTDC123_ y clave Prueba123##
    Y el registra el token en el dispositivo con descripcion: TARJETAS
    Y el inicia sesion en la app
    Cuando el intenta pagar una tarjeta de credito terceros
      | Banco         | Cuenta           | Monto |
      | Banistmo S.a. | 4343305000032483 | 0.01  |
    Y el termina la transaccion con validacion del token
    Entonces el pago a TDC a terceros debe ser exitoso

  @TDCT-2
  Escenario: Pago con token Tarjeta de credito terceros ACH
    Dado que Ismael quiere inscribir token con usuario AutoTDC123_ y clave Prueba123##
    Y el registra el token en el dispositivo con descripcion: TARJETAS
    Y el inicia sesion en la app
    Cuando el intenta pagar una tarjeta de credito terceros
      | Banco   | Cuenta          | Monto |
      | Banesco | 574839201233000 | 0.01  |
    Y el termina la transaccion con validacion del token
    Entonces el pago a TDC a terceros debe ser exitoso

  @TDCT-3
  Escenario: Pago con token Tarjeta de credito guardado a terceros ACH exitoso
    Dado que Ismael quiere inscribir token con usuario AutoTDC123_ y clave Prueba123##
    Y el registra el token en el dispositivo con descripcion: TARJETAS
    Y el inicia sesion en la app
    Cuando el intenta realizar un pago de una Tarjeta credito ACH con un monto: 0.01
    Y el termina la transaccion con validacion del token
    Entonces el pago a TDC a terceros debe ser exitoso

  @TDCT-4
  Escenario: Pago con token Tarjeta de credito guardado a terceros Banistmo exitoso
    Dado que Ismael quiere inscribir token con usuario AutoTDC123_ y clave Prueba123##
    Y el registra el token en el dispositivo con descripcion: TARJETAS1
    Y el inicia sesion en la app
    Cuando el intenta realizar un pago de una Tarjeta credito Banistmo con un monto: 0.01
    Y el termina la transaccion con validacion del token
    Entonces el pago a TDC a terceros debe ser exitoso