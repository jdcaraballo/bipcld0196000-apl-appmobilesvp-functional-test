#language:es

@TDCTercerosProgramadas
Característica: Pago Tarjetas de credito terceros programadas
  Yo como un usuario de la SVP
  Quiero realizar el pago programado de tarjetas de credito terceros

  Escenario: Pago programado con Fecha futura a Tarjeta de credito terceros Banistmo s.a
    Dado que Jonathan quiere ingresar con el usuario: AutoTDC123_ y la clave: Prueba123##
    Cuando el intenta pagar una tarjeta de credito terceros
      | Banco         | Cuenta           | Monto |
      | Banistmo S.a. | 4343305000032483 | 0.01  |
    Y el programa con fecha futura la transaccion 2 dias
    Y el termina la transaccion
    Entonces el pago terceros deberia ser programada exitosamente

  Esquema del escenario: Pago programado con Recurrencia a Tarjeta de credito terceros Banistmo s.a
    Dado que Jonathan quiere ingresar con el usuario: AutoTDC123_ y la clave: Prueba123##
    Cuando el intenta pagar una tarjeta de credito terceros
      | Banco         | Cuenta           | Monto |
      | Banistmo S.a. | 4343305000032483 | 0.01  |
    Y el programa con Recurrencia la transaccion
      | Frecuencia   | Dia   | Dias inicial   | Dias final   |
      | <Frecuencia> | <Dia> | <Dias inicial> | <Dias final> |
    Y el termina la transaccion
    Entonces el pago terceros deberia ser programada exitosamente

    Ejemplos:
      | Frecuencia | Dia    | Dias inicial | Dias final |
      | Semanal    | Martes | 20           | 45         |
      | Quincenal  | 1 - 16 | 5            | 80         |
      | Mensual    | 14     | 10           | 140        |

  Escenario: Pago programado con Fecha futura a Tarjeta de credito terceros ACH
    Dado que Jonathan quiere ingresar con el usuario: AutoTDC123_ y la clave: Prueba123##
    Cuando el intenta pagar una tarjeta de credito terceros
      | Banco   | Cuenta          | Monto |
      | Banesco | 574839201233000 | 0.01  |
    Y el programa con fecha futura la transaccion 1 dias
    Y el termina la transaccion
    Entonces el pago terceros deberia ser programada exitosamente

  Esquema del escenario: Pago programado con Recurrencia a Tarjeta de credito terceros ACH
    Dado que Jonathan quiere ingresar con el usuario: AutoTDC123_ y la clave: Prueba123##
    Cuando el intenta pagar una tarjeta de credito terceros
      | Banco   | Cuenta          | Monto |
      | Banesco | 574839201233000 | 0.01  |
    Y el programa con Recurrencia la transaccion
      | Frecuencia   | Dia   | Dias inicial   | Dias final   |
      | <Frecuencia> | <Dia> | <Dias inicial> | <Dias final> |
    Y el termina la transaccion
    Entonces el pago terceros deberia ser programada exitosamente

    Ejemplos:
      | Frecuencia | Dia    | Dias inicial | Dias final |
      | Semanal    | Martes | 20           | 45         |
      | Quincenal  | 1 - 16 | 5            | 80         |
      | Mensual    | 14     | 10           | 140        |
