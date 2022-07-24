#language:es

@PrestamosProgramados
Característica: Pago prestamos programados
  Yo como un usuario de la SVP
  Quiero realizar un pago programado de un prestamo

  @PagoPrastamoACHFechaFutura
  Escenario: Pago programado con Fecha futura de prestamos a terceros ACH exitoso
    Dado que Sebastian quiere ingresar con el usuario: Autoprestamo123_ y la clave: Prueba123##
    Cuando el intenta pagar un prestamo a terceros ACH
      | Banco   | Cuenta   | Monto | Descripcion         |
      | Allbank | 12345679 | 0.03  | Prueba fecha futura |
    Y el programa con fecha futura la transaccion 180 dias
    Y el termina la transaccion
    Entonces el pago a prestamo terceros deberia ser programado exitosamente

  @PagoPrastamoACHFechaRecurrente
  Esquema del escenario: Pago programado con Recurrencia exitoso de un prestamo de tercero ACH
    Dado que Sebastian quiere ingresar con el usuario: Autoprestamo123_ y la clave: Prueba123##
    Cuando el intenta pagar un prestamo a terceros ACH
      | Banco   | Cuenta   | Monto | Descripcion |Tipo documento|||||||||
      | Allbank | 12345679 | 0.03  | Prueba auto |Pasaporte|     ||||||||
    Y el programa con Recurrencia la transaccion
      | Frecuencia   | Dia   | Dias inicial   | Dias final   |
      | <Frecuencia> | <Dia> | <Dias inicial> | <Dias final> |
    Y el termina la transaccion
    Entonces el pago a prestamo terceros deberia ser programado exitosamente

    Ejemplos:
      | Frecuencia | Dia    | Dias inicial | Dias final |
      | Semanal    | Martes | 60           | 67         |
      | Quincenal  | 1 - 16 | 60           | 75         |
      | Mensual    | 20     | 60           | 90         |

  @EditarPagoFechaFutura
  Escenario: Editar Pago programado con Fecha futura de prestamos a terceros ACH exitoso
    Dado que Sebastian quiere ingresar con el usuario: Autoprestamo123_ y la clave: Prueba123##
    Cuando el intenta pagar un prestamo a terceros ACH
      | Banco      | Cuenta   | Monto | Descripcion                |
      | Davivienda | 12345679 | 0.01  | Prueba editar fecha futura |
    Y el programa con fecha futura la transaccion 180 dias
    Y el termina la transaccion
    Y el edita el pago programado con fecha futura 187 dias
      | Monto | Descripcion                      |
      | 1.98  | Prueba editar fecha futura nueva |
    Entonces el verifica que el pago se haya editado correctamente

  @EditarPagoRecurrente
  Escenario: Editar Pago programado con Recurrencia exitoso de un prestamo de tercero ACH
    Dado que Sebastian quiere ingresar con el usuario: Autoprestamo123_ y la clave: Prueba123##
    Cuando el intenta pagar un prestamo a terceros ACH
      | Banco      | Cuenta   | Monto | Descripcion                    |
      | Davivienda | 12345679 | 0.01  | Prueba editar fecha recurrente |
    Y el programa con Recurrencia la transaccion
      | Frecuencia | Dia    | Dias inicial | Dias final |
      | Semanal    | Martes | 60           | 67         |
    Y el termina la transaccion
    Y el edita el pago programado con fecha recurrente
      | Monto | Descripcion                         | Frecuencia | Dia    | Dias final |
      | 1.00  | Prueba nueva AUTO editar Recurrente | Semanal    | Jueves | 90         |
    Entonces el verifica que el pago se haya editado correctamente

  @EliminarPagoProgramado
  Escenario: Eliminar Pago programado con Fecha futura de prestamos a terceros ACH exitoso
    Dado que Sebastian quiere ingresar con el usuario: Autoprestamo123_ y la clave: Prueba123##
    Cuando el intenta pagar un prestamo a terceros ACH
      | Banco      | Cuenta   | Monto | Descripcion              |
      | Davivienda | 12345679 | 0.01  | Prueba eliminado nuevo99 |
    Y el programa con fecha futura la transaccion 60 dias
    Y el termina la transaccion
    Y el elimina el pago programado
    Entonces se verifica que el pago se haya eliminado correctamente


