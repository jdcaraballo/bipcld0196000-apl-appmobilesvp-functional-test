#language:es

@TransferenciasTercerosConToken
Característica: Transferencias a terceros con token
  Yo como un usuario de la SVP
  Quiero realizar transferencias monetarias a cuentas terceros con token

  Escenario: Transferencia existosa a Tercero Banistmo
    Dado que Juan Felipe quiere inscribir token con usuario Autotransferencia123_ y clave Prueba123##
    Y el registra el token en el dispositivo con descripcion: TRANSFERENCIAST
    Y el inicia sesion en la app
    Cuando el intenta realizar una transferencia a teceros
      | Banco         | Cuenta     | Tipo producto     | Monto |
      | Banistmo s.a. | 0102781870 | Cuenta de ahorros | 0.10  |
    Y el termina la transaccion con validacion del token
    Entonces la transferencia a terceros deberia ser exitosa

  Escenario: Transferencia existosa a Tercero ACH
    Dado que Juan Felipe quiere inscribir token con usuario Autotransferencia123_ y clave Prueba123##
    Y el registra el token en el dispositivo con descripcion: TRANSFERENCIAST
    Y el inicia sesion en la app
    Cuando el intenta realizar una transferencia a teceros
      | Banco       | Cuenta     | Tipo producto     | Monto |
      | Globank | 8489002831 | Cuenta de ahorros | 0.10  |
    Y el termina la transaccion con validacion del token
    Entonces la transferencia a terceros deberia ser exitosa

  Escenario: Transferencia existosa a Tercero Banistmo cuentas propias
    Dado que Juan Felipe quiere inscribir token con usuario Autotransferencia123_ y clave Prueba123##
    Y el registra el token en el dispositivo con descripcion: TRANSFERENCIAST
    Y el inicia sesion en la app
    Cuando el intenta realizar una transferencia a teceros
      | Banco         | Cuenta     | Tipo producto     | Monto |
      | Banistmo s.a. | 0116017998 | Cuenta de ahorros | 0.10  |
    Y el termina la transaccion con validacion del token
    Entonces la transferencia a terceros deberia ser exitosa

  Escenario: Transferencia existosa a Tercero Banistmo cuentas juridicas
    Dado que Juan Felipe quiere inscribir token con usuario Autotransferencia123_ y clave Prueba123##
    Y el registra el token en el dispositivo con descripcion: TRANSFERENCIAST
    Y el inicia sesion en la app
    Cuando el intenta realizar una transferencia a teceros
      | Banco         | Cuenta     | Tipo producto     | Monto |
      | Banistmo s.a. | 0116016792 | Cuenta de ahorros | 0.10  |
    Y el termina la transaccion con validacion del token
    Entonces la transferencia a terceros deberia ser exitosa

  Escenario: Transferencia terceros Banistmo exitosa cuenta guardada
    Dado que Juan Felipe quiere inscribir token con usuario Autotransferencia123_ y clave Prueba123##
    Y el registra el token en el dispositivo con descripcion: TRANSFERENCIAST
    Y el inicia sesion en la app
    Cuando el intenta realizar una transferencia a una cuenta guardada terceros Banistmo con un monto: 0.01
    Y el termina la transaccion con validacion del token
    Entonces la transferencia a terceros deberia ser exitosa

  Escenario: Transferencia terceros ACH exitosa cuenta guardada
    Dado que Juan Felipe quiere inscribir token con usuario Autotransferencia123_ y clave Prueba123##
    Y el registra el token en el dispositivo con descripcion: TRANSFERENCIAST
    Y el inicia sesion en la app
    Cuando el intenta realizar una transferencia a una cuenta guardada terceros ACH con un monto: 0.01
    Y el termina la transaccion con validacion del token
    Entonces la transferencia a terceros deberia ser exitosa

  Escenario: Transaccion con codigo de Otro Usuario
    Dado que Ismael quiere inscribir token con usuario Autotransferencia123_ y clave Prueba123##
    Cuando el registra el token en el dispositivo con codigo recibido por correo con usuario Antonio123_ y clave Prueba123## y descripcion TOKENDEOTROUSER
    Y el puede ver el usuario registrado en el menu token
    Cuando Andres ingresa con el usuario: Autotransferencia123_ y la clave: Prueba123##
    Y el intenta realizar una transferencia a teceros
      | Banco         | Cuenta     | Tipo producto     | Monto |
      | Banistmo s.a. | 0102781870 | Cuenta de ahorros | 0.10  |
    Y el termina de transaccionar
    Entonces el deberia ver siguiente mensaje: Ingresa tu numero de Soft Token.

  Escenario: Transaccion con codigo incorrecto
    Dado que Andres quiere ingresar con el usuario: Autotransferencia123_ y la clave: Prueba123##
    Y el intenta realizar una transferencia a teceros
      | Banco         | Cuenta     | Tipo producto     | Monto |
      | Banistmo s.a. | 0102781870 | Cuenta de ahorros | 0.10  |
    Cuando el termina de transaccionar con informacion de softtoken aleatoria
    Y el vera el siguiente mensaje: Token incorrecto. Ingresa el código nuevamente
    Cuando que Andres quiere inscribir el token con usuario Autotransferencia123_ y clave Prueba123##
    Y el registra el token en el dispositivo con descripcion: ELIZATRANSFER
    Y el inicia sesion en la app
    Y el intenta realizar una transferencia a teceros
      | Banco         | Cuenta     | Tipo producto     | Monto |
      | Banistmo s.a. | 0102781870 | Cuenta de ahorros | 0.10  |
    Y el termina la transaccion con validacion del token
    Entonces la transferencia a terceros deberia ser exitosa
