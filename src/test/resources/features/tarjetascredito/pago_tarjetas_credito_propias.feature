#language:es

@TDCPropia
Característica: Pago Tarjetas de credito propias
  Yo como un usuario de la SVP
  Quiero realizar el pago de mis tarjetas de credito propias

  @RutaCriticaLote1
  Escenario: Pago de tarjeta de credito propia exitoso desde consolidados
    Dado que Andres quiere ingresar con el usuario: AutoTDC123_ y la clave: Prueba123##
    Cuando el intenta realizar el pago de Tarjetas de crédito por el consolidados de productos con un valor: 0.01
    Y el termina la transaccion
    Entonces el pago TDC propio debe ser exitoso

  Escenario: Pago de tarjeta de credito propia exitoso desde detalles
    Dado que Andres quiere ingresar con el usuario: AutoTDC123_ y la clave: Prueba123##
    Cuando el intenta realizar el pago de Tarjetas de crédito por detalles del producto con un valor: 0.01
    Y el termina la transaccion
    Entonces el pago TDC propio debe ser exitoso

  @RutaCriticaLote3
  Escenario: Pago de tarjeta de credito propia exitoso desde Pagos
    Dado que Andres quiere ingresar con el usuario: AutoTDC123_ y la clave: Prueba123##
    Cuando el intenta realizar un pago de una Tarjeta credito propio con un monto: 0.01
    Y el termina la transaccion
    Entonces el pago TDC propio debe ser exitoso

  Escenario: Pago Tarjeta de Credito propia con valor superior al saldo disponible
    Dado que Andres quiere ingresar con el usuario: AutoTDC123_ y la clave: Prueba123##
    Cuando el intenta realizar el pago de Tarjetas de crédito por el consolidados de productos con un valor: 99999999
    Y el termina la transaccion
    Entonces deberia ver el siguiente mensaje: No cuenta con fondos suficientes para realizar esta transacción.

  Escenario: Pago Tarjeta de Credito propia con valor superior al de la deuda
    Dado que Andres quiere ingresar con el usuario: AutoTDC123_ y la clave: Prueba123##
    Cuando el intenta realizar el pago de Tarjetas de crédito por el consolidados de productos con un valor: 10000
    Y el termina la transaccion
    Entonces deberia ver el siguiente mensaje: No puede pagar un monto mayor al saldo total

  Escenario: Cancelacion del Pago de la tarjeta de credito propia en la pantalla de verificacion
    Dado que Andres quiere ingresar con el usuario: AutoTDC123_ y la clave: Prueba123##
    Cuando el intenta realizar un pago de una Tarjeta credito propio con un monto: 0.01
    Y el cancela la transaccion en la pantalla de Verificación
    Entonces el puede observar sus productos

  Escenario: Cancelacion del Pago de la tarjeta de credito propia en la pantalla de preparacion
    Dado que Andres quiere ingresar con el usuario: AutoTDC123_ y la clave: Prueba123##
    Cuando el intenta realizar un pago de una Tarjeta credito propio con un monto: 0.01
    Y el cancela la transaccion en la pantalla de Preparación
    Entonces el puede observar sus productos

  @RutaCriticaLote3
  Escenario: Pago minimo de tarjeta de credito propia exitoso
    Dado que Andres quiere ingresar con el usuario: AutoTDC123_ y la clave: Prueba123##
    Cuando el intenta realizar el pago mínimo de una Tarjeta credito propia
    Y el termina la transaccion
    Entonces el pago TDC propio debe ser exitoso

  Escenario: Pago total de tarjeta de credito propia exitoso
    Dado que Andres quiere ingresar con el usuario: AutoTDC123_ y la clave: Prueba123##
    Cuando el intenta realizar el pago total de una Tarjeta credito propia
    Y el termina la transaccion
    Entonces el pago TDC propio debe ser exitoso

  Escenario: Pago tarjetas propias fallida por falta de productos
    Dado que Andres quiere ingresar con el usuario: YENNY123_ y la clave: Banistmo2019#
    Cuando el ingresa a mis productos
    Entonces deberia visualizar el siguiente mensaje: Nos alegra que esté nuevamente en la Banca en línea

  Escenario: Pago tarjeta de credito propia modificada
    Dado que Andres quiere ingresar con el usuario: AutoTDC123_ y la clave: Prueba123##
    Cuando el intenta realizar un pago de una Tarjeta credito propio con un monto: 0.01
    Y el modifica los datos del pago a tarjetas propias
      | Monto | Descripcion         |
      | 0.03  | Prueba Modificacion |
    Y el termina la transaccion
    Entonces el pago TDC propio debe ser exitoso



