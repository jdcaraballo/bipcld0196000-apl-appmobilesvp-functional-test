#language:es

@TransferenciasTerceros @19421
Característica: Transferencias a terceros
  Yo como un usuario de la SVP
  Quiero realizar transferencias monetarias a cuentas terceros

  @19421-1 @RutaCriticaLote3
  Escenario: Transferencia existosa a Tercero Banistmo
    Dado que Alberto quiere ingresar con el usuario: Autotransferencia123_ y la clave: Prueba123##
    Cuando el intenta realizar una transferencia a teceros
      | Banco         | Cuenta     | Tipo producto     | Monto |
      | Banistmo s.a. | 0102781870 | Cuenta de ahorros | 0.10  |
    Y el termina la transaccion
    Entonces la transferencia a terceros deberia ser exitosa

  @19421-2
  Escenario: Transferencia a tercero con un valor superior al disponible Banistmo
    Dado que Alberto quiere ingresar con el usuario: Autotransferencia123_ y la clave: Prueba123##
    Cuando el intenta realizar una transferencia a teceros
      | Banco         | Cuenta     | Tipo producto     | Monto     |
      | Banistmo s.a. | 0102781870 | Cuenta de ahorros | 999999999 |
    Entonces deberia ver el siguiente mensaje: El monto de la transacción supera los límites transaccionales

  @19421-3
  @22129-1 @RutaCriticaLote3
  Escenario: Transferencia existosa a Tercero ACH
    Dado que Alberto quiere ingresar con el usuario: Autotransferencia123_ y la clave: Prueba123##
    Cuando el intenta realizar una transferencia a teceros
      | Banco       | Cuenta     | Tipo producto     | Monto |
      | Globank | 8489002831 | Cuenta de ahorros | 0.10  |
    Y el termina la transaccion
    Entonces la transferencia a terceros deberia ser exitosa

  @19421-4
  @70804-1
  Escenario: Transferencia existosa a Tercero Banistmo cuentas propias
    Dado que Alberto quiere ingresar con el usuario: Autotransferencia123_ y la clave: Prueba123##
    Cuando el intenta realizar una transferencia a teceros
      | Banco         | Cuenta     | Tipo producto     | Monto |
      | Banistmo s.a. | 0116017998 | Cuenta de ahorros | 0.10  |
    Y el termina la transaccion
    Entonces la transferencia a terceros deberia ser exitosa

  @19421-5
  @70804-2
  Escenario: Transferencia existosa a Tercero Banistmo cuentas juridicas
    Dado que Alberto quiere ingresar con el usuario: Autotransferencia123_ y la clave: Prueba123##
    Cuando el intenta realizar una transferencia a teceros
      | Banco         | Cuenta     | Tipo producto     | Monto |
      | Banistmo s.a. | 0116016792 | Cuenta de ahorros | 0.10  |
    Y el termina la transaccion
    Entonces la transferencia a terceros deberia ser exitosa

  @19421-6
  @70804-3 @RutaCriticaLote3
  Escenario: Transferencia terceros Banistmo exitosa cuenta guardada
    Dado que Alberto quiere ingresar con el usuario: Autotransferencia123_ y la clave: Prueba123##
    Cuando el intenta realizar una transferencia a una cuenta guardada terceros Banistmo con un monto: 1.00
    Y el termina la transaccion
    Entonces la transferencia a terceros deberia ser exitosa

  @19421-7
  @70804-4 @RutaCriticaLote3
  Escenario: Transferencia terceros ACH exitosa cuenta guardada
    Dado que Alberto quiere ingresar con el usuario: Autotransferencia123_ y la clave: Prueba123##
    Cuando el intenta realizar una transferencia a una cuenta guardada terceros ACH con un monto: 1.00
    Y el termina la transaccion
    Entonces la transferencia a terceros deberia ser exitosa

  @19421-8
  Escenario: Cancelacion de Transferencia terceros en la pantalla de verificacion
    Dado que Alberto quiere ingresar con el usuario: Autotransferencia123_ y la clave: Prueba123##
    Cuando el intenta realizar una transferencia a una cuenta guardada terceros ACH con un monto: 1.00
    Y el cancela la transaccion en la pantalla de Verificación
    Entonces el puede observar sus productos


  @19421-9
  Escenario: Cancelacion de Transferencia terceros en la pantalla de preparacion
    Dado que Alberto quiere ingresar con el usuario: luis123 y la clave: Prueba123##
    Cuando el intenta realizar una transferencia a una cuenta guardada terceros ACH con un monto: 1.00
    Y el cancela la transaccion en la pantalla de Preparación
    Entonces el puede observar sus productos

  @19421-10
  Escenario: Transferencia a cuentas propias modificada
    Dado que Alberto quiere ingresar con el usuario: Autotransferencia123_ y la clave: Prueba123##
    Cuando el intenta realizar una transferencia a teceros
      | Banco         | Cuenta     | Tipo producto     | Monto |
      | Banistmo s.a. | 0116016792 | Cuenta de ahorros | 0.10  |
    Y el modifica los datos de la transferencia terceros
    Entonces el verifica que los datos se mantienen

  @19421-11
  Escenario: Transferencia fallida por falta de productos
    Dado que Alberto quiere ingresar con el usuario: YENNY123_ y la clave: Banistmo2019#
    Cuando el ingresa a mis productos
    Entonces deberia visualizar el siguiente mensaje: Nos alegra que esté nuevamente en la Banca en línea
