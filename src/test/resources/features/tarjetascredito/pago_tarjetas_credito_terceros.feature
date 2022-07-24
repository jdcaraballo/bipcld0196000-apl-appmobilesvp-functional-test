#language: es

@TDCTerceros
Característica: Pago Tarjetas de credito terceros
  Yo como un usuario de la SVP
  Quiero realizar el pago de tarjetas de credito terceros

  @RutaCriticaLote3
  Escenario: Pago Tarjeta de credito terceros Banistmo s.a
    Dado que Juan Pablo quiere ingresar con el usuario: AutoTDC123_ y la clave: Prueba123##
    Cuando el intenta pagar una tarjeta de credito terceros
      | Banco         | Cuenta           | Monto |
      | Banistmo S.a. | 4343305000032483 | 0.01  |
    Y el termina la transaccion
    Entonces el pago a TDC a terceros debe ser exitoso

  @RutaCriticaLote3
  Escenario: Pago Tarjeta de credito terceros ACH
    Dado que Juan Pablo quiere ingresar con el usuario: Salvatore13_ y la clave: Prueba123##
    Cuando el intenta pagar una tarjeta de credito terceros
      | Banco   | Cuenta          | Monto |
      | Banesco | 574839201233000 | 11.00  |
    Y el termina la transaccion
    Entonces el pago a TDC a terceros debe ser exitoso

  Escenario: Pago Tarjeta de credito terceros ACH con un valor superior al disponible
    Dado que Juan Pablo quiere ingresar con el usuario: AutoTDC123_ y la clave: Prueba123##
    Cuando el intenta pagar una tarjeta de credito terceros
      | Banco   | Cuenta          | Monto     |
      | Banesco | 574839201233000 | 999999999 |
    Y el termina la transaccion
    Entonces deberia ver el siguiente mensaje: No cuenta con fondos suficientes para realizar esta transacción.

  @RutaCriticaLote3
  Escenario: Pago Tarjeta de credito guardado a terceros ACH exitoso
    Dado que Juan Pablo quiere ingresar con el usuario: Salvatore13_ y la clave: Prueba123##
    Cuando el intenta realizar un pago de una Tarjeta credito ACH con un monto: 11.00
    Y el termina la transaccion
    Entonces el pago a TDC a terceros debe ser exitoso

  @RutaCriticaLote3
  Escenario: Pago Tarjeta de credito guardado a terceros Banistmo exitoso
    Dado que Juan Pablo quiere ingresar con el usuario: Salvatore13_ y la clave: Prueba123##
    Cuando el intenta realizar un pago de una Tarjeta credito Banistmo con un monto: 11.00
    Y el termina la transaccion
    Entonces el pago a TDC a terceros debe ser exitoso

  Escenario: Cancelacion del Pago a Tarjeta de credito ACH en la pantalla de verificacion
    Dado que Juan Pablo quiere ingresar con el usuario: AutoTDC123_ y la clave: Prueba123##
    Cuando el intenta pagar una tarjeta de credito terceros
      | Banco   | Cuenta          | Monto |
      | Banesco | 574839201233000 | 11.00 |
    Y el cancela la transaccion en la pantalla de Verificación
    Entonces el puede observar sus productos

  Escenario: Cancelacion del Pago a Tarjeta de credito ACH en la pantalla de preparacion
    Dado que Juan Pablo quiere ingresar con el usuario: AutoTDC123_ y la clave: Prueba123##
    Cuando el intenta pagar una tarjeta de credito terceros
      | Banco   | Cuenta          | Monto |
      | Banesco | 574839201233000 | 11.00   |
    Y el cancela la transaccion en la pantalla de Preparación
    Entonces el puede observar sus productos


