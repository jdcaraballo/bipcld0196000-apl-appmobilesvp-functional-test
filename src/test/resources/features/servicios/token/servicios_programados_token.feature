#language:es

@ServiciosProgramadosToken
Característica: Pago de Servicios programados con token
  Yo como un usuario de la SVP
  Quiero realizar el pago de mis servicios

  @PagoServicioFechaFuturaToken
  Escenario: Pago programado con token con Fecha futura a servicios exitoso
    Dado que Camilo quiere inscribir token con usuario Autoservicio123_ y clave Prueba123##
    Y el registra el token en el dispositivo con descripcion: SERVICIOS
    Y el inicia sesion en la app
    Cuando el intenta realizar el pago de un servicio
      | Nombre servicio | Monto | Numero pago |
      | Nequi           | 10.00 | 67777742    |
    Y el programa con fecha futura la transaccion 1 dias
    Y el termina la transaccion con validacion del token
    Entonces el pago al servicio deberia ser programado con exito

  @PagoServicioRecurrenteToken
  Esquema del escenario: Pago programado con token con Recurrencia a servicios exitoso
    Dado que Camilo quiere inscribir token con usuario Autoservicio123_ y clave Prueba123##
    Y el registra el token en el dispositivo con descripcion: SERVICIOS
    Y el inicia sesion en la app
    Cuando el intenta realizar el pago de un servicio
      | Nombre servicio | Monto | Numero pago |
      | Nequi           | 10.00 | 67777742    |
    Y el programa con Recurrencia la transaccion
      | Frecuencia   | Dia   | Dias inicial   | Dias final   |
      | <Frecuencia> | <Dia> | <Dias inicial> | <Dias final> |
    Y el termina la transaccion con validacion del token
    Entonces el pago al servicio deberia ser programado con exito

    Ejemplos:
      | Frecuencia | Dia    | Dias inicial | Dias final |
      | Semanal    | Martes | 1            | 7          |
      | Quincenal  | 1-16   | 2            | 16         |
      | Mensual    | 20     | 1            | 90         |

  @PagoServicioConsultaFechaFuturaToken
  Escenario: Pago programado con token con Fecha futura a servicios con consulta exitoso
    Dado que Camilo quiere inscribir token con usuario Autoservicio123_ y clave Prueba123##
    Y el registra el token en el dispositivo con descripcion: SERVICIOS
    Y el inicia sesion en la app
    Cuando el intenta realizar el pago de un servicio
      | Nombre servicio | Monto | Numero pago |
      | Mupa            | 2.00  | 518461      |
    Y el programa con fecha futura la transaccion 1 dias
    Y el termina la transaccion con validacion del token
    Entonces el pago al servicio deberia ser programado con exito

  @PagoServicioConsultaRecurrenteToken
  Esquema del escenario: Pago programado con token con Recurrencia a servicios con consulta exitoso
    Dado que Camilo quiere inscribir token con usuario Autoservicio123_ y clave Prueba123##
    Y el registra el token en el dispositivo con descripcion: SERVICIOS
    Y el inicia sesion en la app
    Cuando el intenta realizar el pago de un servicio
      | Nombre servicio | Monto | Numero pago |
      | Mupa            | 2.00  | 518461      |
    Y el programa con Recurrencia la transaccion
      | Frecuencia   | Dia   | Dias inicial   | Dias final   |
      | <Frecuencia> | <Dia> | <Dias inicial> | <Dias final> |
    Y el termina la transaccion con validacion del token
    Entonces el pago al servicio deberia ser programado con exito

    Ejemplos:
      | Frecuencia | Dia    | Dias inicial | Dias final |
      | Semanal    | Martes | 1            | 7          |
      | Quincenal  | 1-16   | 2            | 16         |
      | Mensual    | 20     | 1            | 90         |
