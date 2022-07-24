#language:es

@TransferenciasTercerosProgramadasToken
Característica: Transferencias programadas a terceros
  Yo como un usuario de la SVP
  Quiero realizar transferencias programadas a cuentas terceros


  @TRANSTERPRO-1
  Escenario: Transferencia programada con Token  con fecha futura a tercero Banistmo
    Dado que Juan Felipe quiere inscribir token con usuario Autotransferencia123_ y clave Prueba123##
    Y el registra el token en el dispositivo con descripcion: TRANSFERENCIAST
    Y el inicia sesion en la app
    Cuando el intenta realizar una transferencia a teceros
      | Banco         | Cuenta     | Tipo producto     | Monto |
      | Banistmo s.a. | 0102781870 | Cuenta de ahorros | 0.10  |
    Y el programa con fecha futura la transaccion 1 dias
    Y el termina la transaccion con validacion del token
    Entonces la transferencia a terceros deberia ser programada exitosamente

  @TRANSTERPRO-2
  Esquema del escenario: Transferencia programada con Token con recurrencia a tercero Banistmo
    Dado que Mauricio quiere inscribir token con usuario Autotransferencia123_ y clave Prueba123##
    Y el registra el token en el dispositivo con descripcion: TRANSFERENCIAST
    Y el inicia sesion en la app
    Cuando el intenta realizar una transferencia a teceros
      | Banco         | Cuenta     | Tipo producto     | Monto |
      | Banistmo s.a. | 0102781870 | Cuenta de ahorros | 0.10  |
    Y el programa con Recurrencia la transaccion
      | Frecuencia   | Dia   | Dias inicial   | Dias final   |
      | <Frecuencia> | <Dia> | <Dias inicial> | <Dias final> |
    Y el termina la transaccion con validacion del token
    Entonces la transferencia a terceros deberia ser programada exitosamente

    Ejemplos:
      | Frecuencia | Dia    | Dias inicial | Dias final |
      | Semanal    | Martes | 1            | 7          |
      | Quincenal  | 1-16   | 2            | 16         |
      | Mensual    | 20     | 1            | 90         |

  @TRANSTERPRO-3
  Escenario: Transferencia programada con Token con fecha futura a tercero ACH
    Dado que Mauricio quiere inscribir token con usuario Autotransferencia123_ y clave Prueba123##
    Y el registra el token en el dispositivo con descripcion: TRANSFERENCIAST
    Y el inicia sesion en la app
    Cuando el intenta realizar una transferencia a teceros
      | Banco       | Cuenta     | Tipo producto     | Monto |
      | Globank | 8489002831 | Cuenta de ahorros | 0.10  |
    Y el programa con fecha futura la transaccion 1 dias
    Y el termina la transaccion con validacion del token
    Entonces la transferencia a terceros deberia ser programada exitosamente

  @TRANSTERPRO-4
  Esquema del escenario: Transferencia programada con Token con recurrencia a tercero ACH
    Dado que Mauricio quiere inscribir token con usuario Autotransferencia123_ y clave Prueba123##
    Y el registra el token en el dispositivo con descripcion: TRANSFERENCIAST
    Y el inicia sesion en la app
    Cuando el intenta realizar una transferencia a teceros
      | Banco       | Cuenta     | Tipo producto     | Monto |
      | Globank | 8489002831 | Cuenta de ahorros | 0.10  |
    Y el programa con Recurrencia la transaccion
      | Frecuencia   | Dia   | Dias inicial   | Dias final   |
      | <Frecuencia> | <Dia> | <Dias inicial> | <Dias final> |
    Y el termina la transaccion con validacion del token
    Entonces la transferencia a terceros deberia ser programada exitosamente

    Ejemplos:
      | Frecuencia | Dia    | Dias inicial | Dias final |
      | Semanal    | Martes | 1            | 7          |
      | Quincenal  | 1-16   | 2            | 16         |
      | Mensual    | 20     | 1            | 90         |

  @TRANSTERPRO-5
  Escenario: Transferencia programada con Token con fecha futura a tercero Banistmo: Cuentas propias
    Dado que Mauricio quiere inscribir token con usuario Autotransferencia123_ y clave Prueba123##
    Y el registra el token en el dispositivo con descripcion: TRANSFERENCIAST
    Y el inicia sesion en la app
    Cuando el intenta realizar una transferencia a teceros
      | Banco         | Cuenta     | Tipo producto     | Monto |
      | Banistmo s.a. | 0116016792 | Cuenta de ahorros | 0.10  |
    Y el programa con fecha futura la transaccion 1 dias
    Y el termina la transaccion con validacion del token
    Entonces la transferencia a terceros deberia ser programada exitosamente

  @TRANSTERPRO-6
  Esquema del escenario: Transferencia programada con Token con recurrencia a tercero Banistmo: Cuentas propias
    Dado que Mauricio quiere inscribir token con usuario Autotransferencia123_ y clave Prueba123##
    Y el registra el token en el dispositivo con descripcion: TRANSFERENCIAST
    Y el inicia sesion en la app
    Cuando el intenta realizar una transferencia a teceros
      | Banco         | Cuenta     | Tipo producto     | Monto |
      | Banistmo s.a. | 0116016792 | Cuenta de ahorros | 0.10  |
    Y el programa con Recurrencia la transaccion
      | Frecuencia   | Dia   | Dias inicial   | Dias final   |
      | <Frecuencia> | <Dia> | <Dias inicial> | <Dias final> |
    Y el termina la transaccion con validacion del token
    Entonces la transferencia a terceros deberia ser programada exitosamente

    Ejemplos:
      | Frecuencia | Dia    | Dias inicial | Dias final |
      | Semanal    | Martes | 1            | 7          |
      | Quincenal  | 1-16   | 2            | 16         |
      | Mensual    | 20     | 1            | 90         |

  @TRANSTERPRO-7
  Escenario: Transferencia programada con con Token fecha futura a tercero Banistmo: Cuentas juridicas
    Dado que Mauricio quiere inscribir token con usuario Autotransferencia123_ y clave Prueba123##
    Y el registra el token en el dispositivo con descripcion: TRANSFERENCIAST
    Y el inicia sesion en la app
    Cuando el intenta realizar una transferencia a teceros
      | Banco         | Cuenta     | Tipo producto     | Monto |
      | Banistmo s.a. | 0110394294 | Cuenta de ahorros | 0.10  |
    Y el programa con fecha futura la transaccion 1 dias
    Y el termina la transaccion con validacion del token
    Entonces la transferencia a terceros deberia ser programada exitosamente

  @TRANSTERPRO-8
  Esquema del escenario: Transferencia programada con Token con Recurrencia a tercero Banistmo: Cuentas juridicas
    Dado que Mauricio quiere inscribir token con usuario Autotransferencia123_ y clave Prueba123##
    Y el registra el token en el dispositivo con descripcion: TRANSFERENCIAST
    Y el inicia sesion en la app
    Cuando el intenta realizar una transferencia a teceros
      | Banco         | Cuenta     | Tipo producto     | Monto |
      | Banistmo s.a. | 0110394294 | Cuenta de ahorros | 0.10  |
    Y el programa con Recurrencia la transaccion
      | Frecuencia   | Dia   | Dias inicial   | Dias final   |
      | <Frecuencia> | <Dia> | <Dias inicial> | <Dias final> |
    Y el termina la transaccion con validacion del token
    Entonces la transferencia a terceros deberia ser programada exitosamente

    Ejemplos:
      | Frecuencia | Dia    | Dias inicial | Dias final |
      | Semanal    | Martes | 1            | 7          |
      | Quincenal  | 1-16   | 2            | 16         |
      | Mensual    | 20     | 1            | 90         |

  @TRANSTERPRO-9
  Escenario: Transferencia terceros programada con Token fecha futura Banistmo exitosa cuenta guardada
    Dado que Mauricio quiere inscribir token con usuario Autotransferencia123_ y clave Prueba123##
    Y el registra el token en el dispositivo con descripcion: TRANSFERENCIAST
    Y el inicia sesion en la app
    Cuando el intenta realizar una transferencia a una cuenta guardada terceros Banistmo con un monto: 0.01
    Y el programa con fecha futura la transaccion 1 dias
    Y el termina la transaccion con validacion del token
    Entonces la transferencia a terceros deberia ser programada exitosamente

  @TRANSTERPRO-10
  Esquema del escenario: Transferencia terceros programada con Token Recurrente Banistmo exitosa cuenta guardada
    Dado que Mauricio quiere inscribir token con usuario Autotransferencia123_ y clave Prueba123##
    Y el registra el token en el dispositivo con descripcion: TRANSFERENCIAST
    Y el inicia sesion en la app
    Cuando el intenta realizar una transferencia a una cuenta guardada terceros Banistmo con un monto: 0.01
    Y el programa con Recurrencia la transaccion
      | Frecuencia   | Dia   | Dias inicial   | Dias final   |
      | <Frecuencia> | <Dia> | <Dias inicial> | <Dias final> |
    Y el termina la transaccion con validacion del token
    Entonces la transferencia a terceros deberia ser programada exitosamente

    Ejemplos:
      | Frecuencia | Dia    | Dias inicial | Dias final |
      | Semanal    | Martes | 2            | 7          |

  @TRANSTERPRO-11
  Escenario: Transferencia terceros programada con Token con fecha futura ACH exitosa cuenta guardada
    Dado que Mauricio quiere inscribir token con usuario Autotransferencia123_ y clave Prueba123##
    Y el registra el token en el dispositivo con descripcion: TRANSFERENCIAST
    Y el inicia sesion en la app
    Cuando el intenta realizar una transferencia a una cuenta guardada terceros ACH con un monto: 0.01
    Y el programa con fecha futura la transaccion 1 dias
    Y el termina la transaccion con validacion del token
    Entonces la transferencia a terceros deberia ser programada exitosamente

  @TRANSTERPRO-12
  Esquema del escenario: Transferencia terceros programada con Token Recurrente ACH exitosa cuenta guardada
    Dado que Mauricio quiere inscribir token con usuario Autotransferencia123_ y clave Prueba123##
    Y el registra el token en el dispositivo con descripcion: TRANSFERENCIAST
    Y el inicia sesion en la app
    Cuando el intenta realizar una transferencia a una cuenta guardada terceros ACH con un monto: 0.01
    Y el programa con Recurrencia la transaccion
      | Frecuencia   | Dia   | Dias inicial   | Dias final   |
      | <Frecuencia> | <Dia> | <Dias inicial> | <Dias final> |
    Y el termina la transaccion con validacion del token
    Entonces la transferencia a terceros deberia ser programada exitosamente

    Ejemplos:
      | Frecuencia | Dia    | Dias inicial | Dias final |
      | Semanal    | Martes | 1            | 7          |
      | Quincenal  | 1-16   | 2            | 16         |
      | Mensual    | 20     | 1            | 90         |
