#language:es

@PrestamosProgramadosToken
Característica: Pago prestamos programados
  Yo como un usuario de la SVP
  Quiero realizar un pago programado de un prestamo

  @PagoPrastamoACHFechaFuturaToken
  Escenario: Pago programado con Fecha futura de prestamos a terceros ACH exitoso
    Dado que Fernando quiere inscribir token con usuario Autoprestamo123_ y clave Prueba123##
    Y el registra el token en el dispositivo con descripcion: PRESTAMOST
    Y el inicia sesion en la app
    Cuando el intenta pagar un prestamo a terceros ACH
      | Banco   | Cuenta   | Monto | Descripcion         |
      | Allbank | 12345679 | 0.03  | Prueba fecha futura |
    Y el programa con fecha futura la transaccion 2 dias
    Y el termina la transaccion con validacion del token
    Entonces el pago a prestamo terceros deberia ser programado exitosamente

  @PagoPrastamoACHFechaRecurrenteToken
  Esquema del escenario: Pago programado con Recurrencia exitoso de un prestamo de tercero ACH
    Dado que Fernando quiere inscribir token con usuario Autoprestamo123_ y clave Prueba123##
    Y el registra el token en el dispositivo con descripcion: PRESTAMOST
    Y el inicia sesion en la app
    Cuando el intenta pagar un prestamo a terceros ACH
      | Banco   | Cuenta   | Monto | Descripcion |
      | Allbank | 12345679 | 0.03  | Prueba auto |
    Y el programa con Recurrencia la transaccion
      | Frecuencia   | Dia   | Dias inicial   | Dias final   |
      | <Frecuencia> | <Dia> | <Dias inicial> | <Dias final> |
    Y el termina la transaccion con validacion del token
    Entonces el pago a prestamo terceros deberia ser programado exitosamente

    Ejemplos:
      | Frecuencia | Dia    | Dias inicial | Dias final |
      | Semanal    | Martes | 1            | 7          |
      | Quincenal  | 1-16   | 2            | 16         |
      | Mensual    | 20     | 1            | 90         |


  @EditarPagoFechaFuturaToken
  Escenario: Editar Pago programado con Fecha futura de prestamos a terceros ACH exitoso
    Dado que Fernando quiere inscribir token con usuario Autoprestamo123_ y clave Prueba123##
    Y el registra el token en el dispositivo con descripcion: PRESTAMOST
    Y el inicia sesion en la app
    Cuando el intenta pagar un prestamo a terceros ACH
      | Banco      | Cuenta   | Monto | Descripcion                |
      | Davivienda | 12345679 | 0.01  | Prueba editar fecha futura |
    Y el programa con fecha futura la transaccion 5 dias
    Y el termina la transaccion con validacion del token
    Y el edita el pago programado con fecha futura 1 dias
      | Monto | Descripcion                      |
      | 1.98  | Prueba editar fecha futura nueva |
    Entonces el verifica que el pago se haya editado correctamente

  @EditarPagoRecurrenteToken
  Escenario: Editar Pago programado con Recurrencia exitoso de un prestamo de tercero ACH
    Dado que Fernando quiere inscribir token con usuario Autoprestamo123_ y clave Prueba123##
    Y el registra el token en el dispositivo con descripcion: PRESTAMOST
    Y el inicia sesion en la app
    Cuando el intenta pagar un prestamo a terceros ACH
      | Banco      | Cuenta   | Monto | Descripcion                    |
      | Davivienda | 12345679 | 0.01  | Prueba editar fecha recurrente |
    Y el programa con Recurrencia la transaccion
      | Frecuencia | Dia    | Dias inicial | Dias final |
      | Semanal    | Martes | 2            | 7          |
    Y el termina la transaccion con validacion del token
    Y el edita el pago programado con fecha recurrente
      | Monto | Descripcion                         | Frecuencia | Dia    | Dias final |
      | 1.00  | Prueba nueva AUTO editar Recurrente | Semanal    | Jueves | 7          |
    Entonces el verifica que el pago se haya editado correctamente

  @EliminarPagoProgramadoToken
  Escenario: Eliminar Pago programado con Fecha futura de prestamos a terceros ACH exitoso
    Dado que Fernando quiere inscribir token con usuario Autoprestamo123_ y clave Prueba123##
    Y el registra el token en el dispositivo con descripcion: PRESTAMOST
    Y el inicia sesion en la app
    Cuando el intenta pagar un prestamo a terceros ACH
      | Banco      | Cuenta   | Monto | Descripcion            |
      | Davivienda | 12345679 | 0.01  | Prueba eliminado nuevo99 |
    Y el programa con fecha futura la transaccion 2 dias
    Y el termina la transaccion con validacion del token
    Y el elimina el pago programado
    Entonces se verifica que el pago se haya eliminado correctamente
