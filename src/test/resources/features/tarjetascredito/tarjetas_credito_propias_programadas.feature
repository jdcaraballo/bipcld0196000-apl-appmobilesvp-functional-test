#language:es

@TDCPropiasProgramadas
Característica: Pago Tarjetas de credito propias programadas
  Yo como un usuario de la SVP
  Quiero realizar el pago progamado de mis tarjetas de credito propias

  Escenario: Pago programado con Fecha futura a tarjeta de credito propia exitoso
    Dado que Juan Felipe quiere ingresar con el usuario: Salvatore13_ y la clave: Prueba123##
    Cuando el intenta realizar un pago de una Tarjeta credito propio con un monto: 0.01
    Y el programa con fecha futura la transaccion 2 dias
    Y el termina la transaccion
    Entonces el pago propio deberia ser programado exitosamente

  Esquema del escenario: Pago programado con Recurrencia a tarjeta de credito propia exitoso
    Dado que Juan Felipe quiere ingresar con el usuario: Salvatore13_ y la clave: Prueba123##
    Cuando el intenta realizar un pago de una Tarjeta credito propio con un monto: 0.01
    Y el programa con Recurrencia la transaccion
      | Frecuencia   | Dia   | Dias inicial   | Dias final   |
      | <Frecuencia> | <Dia> | <Dias inicial> | <Dias final> |
    Y el termina la transaccion
    Entonces el pago propio deberia ser programado exitosamente

    Ejemplos:
      | Frecuencia | Dia    | Dias inicial | Dias final |
      | Semanal    | Martes | 1            | 7          |
      | Quincenal  | 1 - 16 | 2            | 16         |
      | Mensual    | 20     | 1            | 90         |
