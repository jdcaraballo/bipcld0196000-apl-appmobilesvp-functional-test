#language:es

@TDCTercerosProgramadasToken
Característica: Pago con token Tarjetas de credito terceros programadas
  Yo como un usuario de la SVP
  Quiero realizar el pago programado de tarjetas de credito terceros

  @TDCTP-1
  Escenario: Pago con token programado con Fecha futura a Tarjeta de credito terceros Banistmo s.a
    Dado que Jhonatan quiere inscribir token con usuario AutoTDC123_ y clave Prueba123##
    Y el registra el token en el dispositivo con descripcion: TARJETAS_TER_PROGRA
    Y el inicia sesion en la app
    Cuando el intenta pagar una tarjeta de credito terceros
      | Banco         | Cuenta           | Monto |
      | Banistmo S.a. | 4343305000032483 | 0.01  |
    Y el programa con fecha futura la transaccion 1 dias
    Y el termina la transaccion con validacion del token
    Entonces el pago terceros deberia ser programada exitosamente

  @TDCTP-2
  Esquema del escenario: Pago  con token programado con Recurrencia a Tarjeta de credito terceros Banistmo s.a
    Dado que Jhonatan quiere inscribir token con usuario AutoTDC123_ y clave Prueba123##
    Y el registra el token en el dispositivo con descripcion: TARJETAS_TER_PROGRA
    Y el inicia sesion en la app
    Cuando el intenta pagar una tarjeta de credito terceros
      | Banco         | Cuenta           | Monto |
      | Banistmo S.a. | 4343305000032483 | 0.01  |
    Y el programa con Recurrencia la transaccion
      | Frecuencia   | Dia   | Dias inicial   | Dias final   |
      | <Frecuencia> | <Dia> | <Dias inicial> | <Dias final> |
    Y el termina la transaccion con validacion del token
    Entonces el pago terceros deberia ser programada exitosamente

    Ejemplos:
      | Frecuencia | Dia    | Dias inicial | Dias final |
      | Semanal    | Martes | 20           | 45         |
      | Quincenal  | 1 - 16 | 5            | 80         |
      | Mensual    | 14     | 10           | 140        |

  @TDCTP-3
  Escenario: Pago con token programado con Fecha futura a Tarjeta de credito terceros ACH
    Dado que Jhonatan quiere inscribir token con usuario AutoTDC123_ y clave Prueba123##
    Y el registra el token en el dispositivo con descripcion: TARJETAS_TER_PROGRA
    Y el inicia sesion en la app
    Cuando el intenta pagar una tarjeta de credito terceros
      | Banco   | Cuenta          | Monto |
      | Banesco | 574839201233000 | 0.01  |
    Y el programa con fecha futura la transaccion 1 dias
    Y el termina la transaccion con validacion del token
    Entonces el pago terceros deberia ser programada exitosamente

  @TDCTP-4
  Esquema del escenario: Pago con token programado con Recurrencia a Tarjeta de credito terceros ACH
    Dado que Jhonatan quiere inscribir token con usuario AutoTDC123_ y clave Prueba123##
    Y el registra el token en el dispositivo con descripcion: TARJETAS_TER_PROGRA
    Y el inicia sesion en la app
    Cuando el intenta pagar una tarjeta de credito terceros
      | Banco   | Cuenta          | Monto |
      | Banesco | 574839201233000 | 0.01  |
    Y el programa con Recurrencia la transaccion
      | Frecuencia   | Dia   | Dias inicial   | Dias final   |
      | <Frecuencia> | <Dia> | <Dias inicial> | <Dias final> |
    Y el termina la transaccion con validacion del token
    Entonces el pago terceros deberia ser programada exitosamente

    Ejemplos:
      | Frecuencia | Dia    | Dias inicial | Dias final |
      | Semanal    | Martes | 20           | 45         |
      | Quincenal  | 1 - 16 | 5            | 80         |
      | Mensual    | 14     | 10           | 110        |