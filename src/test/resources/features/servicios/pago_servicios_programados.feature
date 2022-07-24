#language:es

@ServiciosProgramados
Característica: Pago de Servicios
  Yo como un usuario de la SVP
  Quiero realizar el pago de mis servicios

  @PagoServicioFechaFutura
  Escenario: Pago programado con Fecha futura a servicios exitoso
    Dado que Carlos quiere ingresar con el usuario: Autoservicio123_ y la clave: Prueba123##
    Cuando el intenta realizar el pago de un servicio
      | Nombre servicio | Monto | Numero pago |
      | Claro panama    | 10.00 | 67777742    |
    Y el programa con fecha futura la transaccion 180 dias
    Y el termina la transaccion
    Entonces el pago al servicio deberia ser programado con exito

  @PagoServicioRecurrente
  Esquema del escenario: Pago programado con Recurrencia a servicios exitoso
    Dado que Carlos quiere ingresar con el usuario: Autoservicio123_ y la clave: Prueba123##
    Cuando el intenta realizar el pago de un servicio
      | Nombre servicio | Monto | Numero pago |
      | Claro panama    | 10.00 | 67777742    |
    Y el programa con Recurrencia la transaccion
      | Frecuencia   | Dia   | Dias inicial   | Dias final   |
      | <Frecuencia> | <Dia> | <Dias inicial> | <Dias final> |
    Y el termina la transaccion
    Entonces el pago al servicio deberia ser programado con exito

    Ejemplos:
      | Frecuencia | Dia    | Dias inicial | Dias final |
      | Semanal    | Martes | 60           | 67         |
      | Quincenal  | 1 - 16 | 60           | 75         |
      | Mensual    | 20     | 60           | 90         |

  @PagoServicioConsultaFechaFutura
  Escenario: Pago programado con Fecha futura a servicios con consulta exitoso
    Dado que Carlos quiere ingresar con el usuario: Autoservicio123_ y la clave: Prueba123##
    Cuando el intenta realizar el pago de un servicio
      | Nombre servicio | Monto | Numero pago |
      | Mupa            | 2.00  | 518461      |
    Y el programa con fecha futura la transaccion 180 dias
    Y el termina la transaccion
    Entonces el pago al servicio deberia ser programado con exito

  @PagoServicioConsultaRecurrente
  Esquema del escenario: Pago programado con Recurrencia a servicios con consulta exitoso
    Dado que Carlos quiere ingresar con el usuario: Autoservicio123_ y la clave: Prueba123##
    Cuando el intenta realizar el pago de un servicio
      | Nombre servicio | Monto | Numero pago |
      | Mupa            | 2.00  | 518461      |
    Y el programa con Recurrencia la transaccion
      | Frecuencia   | Dia   | Dias inicial   | Dias final   |
      | <Frecuencia> | <Dia> | <Dias inicial> | <Dias final> |
    Y el termina la transaccion
    Entonces el pago al servicio deberia ser programado con exito

    Ejemplos:
      | Frecuencia | Dia    | Dias inicial | Dias final |
      | Semanal    | Martes | 60           | 67         |
      | Quincenal  | 1 - 16 | 60           | 75         |
      | Mensual    | 20     | 60           | 90         |
