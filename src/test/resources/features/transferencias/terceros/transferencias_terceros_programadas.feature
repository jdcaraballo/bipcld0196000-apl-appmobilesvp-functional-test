#language:es

@TransferenciasTercerosProgramadas
Característica: Transferencias programadas a terceros
  Yo como un usuario de la SVP
  Quiero realizar transferencias programadas a cuentas terceros

  @FechafuturaTerceroBanistmo
  Escenario: Transferencia programada con fecha futura a tercero Banistmo
    Dado que Mauricio quiere ingresar con el usuario: Autotransferencia123_ y la clave: Prueba123##
    Cuando el intenta realizar una transferencia a teceros
      | Banco         | Cuenta     | Tipo producto     | Monto |
      | Banistmo s.a. | 0102781870 | Cuenta de ahorros | 1.10  |
    Y el programa con fecha futura la transaccion 180 dias
    Y el termina la transaccion
    Entonces la transferencia a terceros deberia ser programada exitosamente

  @FechaRecurrenteTerceroBanistmo
  Esquema del escenario: Transferencia programada con recurrencia a tercero Banistmo
    Dado que Mauricio quiere ingresar con el usuario: Autotransferencia123_ y la clave: Prueba123##
    Cuando el intenta realizar una transferencia a teceros
      | Banco         | Cuenta     | Tipo producto     | Monto |
      | Banistmo s.a. | 0102781870 | Cuenta de ahorros | 1.10  |
    Y el programa con Recurrencia la transaccion
      | Frecuencia   | Dia   | Dias inicial   | Dias final   |
      | <Frecuencia> | <Dia> | <Dias inicial> | <Dias final> |
    Y el termina la transaccion
    Entonces la transferencia a terceros deberia ser programada exitosamente

    Ejemplos:
      | Frecuencia | Dia    | Dias inicial | Dias final |
      | Semanal    | Martes | 60           | 67         |
      | Quincenal  | 1-16   | 60           | 75         |
      | Mensual    | 20     | 60           | 90         |

  @FechafuturaTerceroACH
  Escenario: Transferencia programada con fecha futura a tercero ACH
    Dado que Mauricio quiere ingresar con el usuario: Autotransferencia123_ y la clave: Prueba123##
    Cuando el intenta realizar una transferencia a teceros
      | Banco   | Cuenta     | Tipo producto     | Monto |
      | Globank | 8489002831 | Cuenta de ahorros | 0.10  |
    Y el programa con fecha futura la transaccion 180 dias
    Y el termina la transaccion
    Entonces la transferencia a terceros deberia ser programada exitosamente

  @FechaRecurrenteTerceroACH
  Esquema del escenario: Transferencia programada con recurrencia a tercero ACH
    Dado que Mauricio quiere ingresar con el usuario: Autotransferencia123_ y la clave: Prueba123##
    Cuando el intenta realizar una transferencia a teceros
      | Banco   | Cuenta     | Tipo producto     | Monto |
      | Globank | 8489002831 | Cuenta de ahorros | 1.10  |
    Y el programa con Recurrencia la transaccion
      | Frecuencia   | Dia   | Dias inicial   | Dias final   |
      | <Frecuencia> | <Dia> | <Dias inicial> | <Dias final> |
    Y el termina la transaccion
    Entonces la transferencia a terceros deberia ser programada exitosamente

    Ejemplos:
      | Frecuencia | Dia    | Dias inicial | Dias final |
      | Semanal    | Martes | 60           | 67         |
      | Quincenal  | 1-16   | 60           | 75         |
      | Mensual    | 20     | 60           | 90         |

  @FechafuturaTercerosCuentasPropias
  Escenario: Transferencia programada con fecha futura a tercero Banistmo: Cuentas propias
    Dado que Mauricio quiere ingresar con el usuario: Autotransferencia123_ y la clave: Prueba123##
    Cuando el intenta realizar una transferencia a teceros
      | Banco         | Cuenta     | Tipo producto     | Monto |
      | Banistmo s.a. | 0116016792 | Cuenta de ahorros | 1.10  |
    Y el programa con fecha futura la transaccion 180 dias
    Y el termina la transaccion
    Entonces la transferencia a terceros deberia ser programada exitosamente

  @FechaRecurrenteTerceroCuentasPropias
  Esquema del escenario: Transferencia programada con recurrencia a tercero Banistmo: Cuentas propias
    Dado que Mauricio quiere ingresar con el usuario: Autotransferencia123_ y la clave: Prueba123##
    Cuando el intenta realizar una transferencia a teceros
      | Banco         | Cuenta     | Tipo producto     | Monto |
      | Banistmo s.a. | 0116016792 | Cuenta de ahorros | 1.10  |
    Y el programa con Recurrencia la transaccion
      | Frecuencia   | Dia   | Dias inicial   | Dias final   |
      | <Frecuencia> | <Dia> | <Dias inicial> | <Dias final> |
    Y el termina la transaccion
    Entonces la transferencia a terceros deberia ser programada exitosamente

    Ejemplos:
      | Frecuencia | Dia    | Dias inicial | Dias final |
      | Semanal    | Martes | 60           | 67         |
      | Quincenal  | 1-16   | 60           | 75         |
      | Mensual    | 20     | 60           | 90         |

  @FechafuturaTercerosJuridicas
  Escenario: Transferencia programada con fecha futura a tercero Banistmo: Cuentas juridicas
    Dado que Mauricio quiere ingresar con el usuario: Autotransferencia123_ y la clave: Prueba123##
    Cuando el intenta realizar una transferencia a teceros
      | Banco         | Cuenta     | Tipo producto     | Monto |
      | Banistmo s.a. | 0110394294 | Cuenta de ahorros | 1.10  |
    Y el programa con fecha futura la transaccion 180 dias
    Y el termina la transaccion
    Entonces la transferencia a terceros deberia ser programada exitosamente

  @FechaRecurrenteTerceroJuridicas
  Esquema del escenario: Transferencia programada con Recurrencia a tercero Banistmo: Cuentas juridicas
    Dado que Mauricio quiere ingresar con el usuario: Autotransferencia123_ y la clave: Prueba123##
    Cuando el intenta realizar una transferencia a teceros
      | Banco         | Cuenta     | Tipo producto     | Monto |
      | Banistmo s.a. | 0110394294 | Cuenta de ahorros | 1.10  |
    Y el programa con Recurrencia la transaccion
      | Frecuencia   | Dia   | Dias inicial   | Dias final   |
      | <Frecuencia> | <Dia> | <Dias inicial> | <Dias final> |
    Y el termina la transaccion
    Entonces la transferencia a terceros deberia ser programada exitosamente

    Ejemplos:
      | Frecuencia | Dia    | Dias inicial | Dias final |
      | Semanal    | Martes | 60           | 67         |
      | Quincenal  | 1-16   | 60           | 75         |
      | Mensual    | 20     | 60           | 90         |

  @FechafuturaTerceroBanistmoGuardada
  Escenario: Transferencia terceros programada fecha futura Banistmo exitosa cuenta guardada
    Dado que Mauricio quiere ingresar con el usuario: Autotransferencia123_ y la clave: Prueba123##
    Cuando el intenta realizar una transferencia a una cuenta guardada terceros Banistmo con un monto: 1.01
    Y el programa con fecha futura la transaccion 180 dias
    Y el termina la transaccion
    Entonces la transferencia a terceros deberia ser programada exitosamente

  @FechaRecurrenteTerceroBanistmoGuardada
  Esquema del escenario: Transferencia terceros programada Recurrente Banistmo exitosa cuenta guardada
    Dado que Mauricio quiere ingresar con el usuario: Autotransferencia123_ y la clave: Prueba123##
    Cuando el intenta realizar una transferencia a una cuenta guardada terceros Banistmo con un monto: 1.01
    Y el programa con Recurrencia la transaccion
      | Frecuencia   | Dia   | Dias inicial   | Dias final   |
      | <Frecuencia> | <Dia> | <Dias inicial> | <Dias final> |
    Y el termina la transaccion
    Entonces la transferencia a terceros deberia ser programada exitosamente

    Ejemplos:
      | Frecuencia | Dia    | Dias inicial | Dias final |
      | Semanal    | Martes | 60           | 67          |

  @FechafuturaTerceroACHGuardada
  Escenario: Transferencia terceros programada fecha futura ACH exitosa cuenta guardada
    Dado que Mauricio quiere ingresar con el usuario: Autotransferencia123_ y la clave: Prueba123##
    Cuando el intenta realizar una transferencia a una cuenta guardada terceros ACH con un monto: 1.01
    Y el programa con fecha futura la transaccion 180 dias
    Y el termina la transaccion
    Entonces la transferencia a terceros deberia ser programada exitosamente

  @FechaRecurrenteTerceroACHGuardada
  Esquema del escenario: Transferencia terceros programada Recurrente ACH exitosa cuenta guardada
    Dado que Mauricio quiere ingresar con el usuario: Autotransferencia123_ y la clave: Prueba123##
    Cuando el intenta realizar una transferencia a una cuenta guardada terceros ACH con un monto: 1.01
    Y el programa con Recurrencia la transaccion
      | Frecuencia   | Dia   | Dias inicial   | Dias final   |
      | <Frecuencia> | <Dia> | <Dias inicial> | <Dias final> |
    Y el termina la transaccion
    Entonces la transferencia a terceros deberia ser programada exitosamente

    Ejemplos:
      | Frecuencia | Dia    | Dias inicial | Dias final |
      | Semanal    | Martes | 60           | 67         |
      | Quincenal  | 1-16   | 60           | 75         |
      | Mensual    | 20     | 60           | 90         |

