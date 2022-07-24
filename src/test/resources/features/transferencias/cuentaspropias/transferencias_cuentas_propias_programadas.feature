#language:es

@TransferenciasCuentasPropiasProgramadas
Característica: Transferencias programadas cuentas propias
  Yo como un usuario de la SVP
  Quiero realizar transferencias monetarias entre las cuentas asociadas a mi usuario
  Para comprobar su correcto funcionamiento

  Escenario: Transferencia Programada con fecha futura a cuentas propias Banistmo
    Dado que Marlon quiere ingresar con el usuario: Autotransferencia123_ y la clave: Prueba123##
    Cuando el intenta realizar una transferencia entre cuentas propias desde el menu
      | Monto | Descripcion        |
      | 0.01  | pruebas programada |
    Y el programa con fecha futura la transaccion 180 dias
    Y el termina la transaccion
    Entonces la transferencia a cuentas propias deberia ser programada exitosamente

  Esquema del escenario: Transferencia programada con recurrencia a cuentas propias
    Dado que Marlon quiere ingresar con el usuario: Autotransferencia123_ y la clave: Prueba123##
    Cuando el intenta realizar una transferencia entre cuentas propias desde el menu
      | Monto | Descripcion        |
      | 0.01  | pruebas programada |
    Y el programa con Recurrencia la transaccion
      | Frecuencia   | Dia   | Dias inicial   | Dias final   |
      | <Frecuencia> | <Dia> | <Dias inicial> | <Dias final> |
    Y el termina la transaccion
    Entonces la transferencia a cuentas propias deberia ser programada exitosamente

    Ejemplos:
      | Frecuencia | Dia    | Dias inicial | Dias final |
      | Semanal    | Martes | 60           | 67         |
      | Quincenal  | 1 - 16 | 60           | 75         |
      | Mensual    | 20     | 60           | 90         |

  @EliminarTransferenciaProgramada
  Escenario: Eliminar transferencia propia con fecha futura
    Dado que Marlon quiere ingresar con el usuario: Autotransferencia123_ y la clave: Prueba123##
    Cuando el intenta realizar una transferencia entre cuentas propias desde el menu
      | Monto | Descripcion |
      | 0.01  | eliminar    |
    Y el programa con fecha futura la transaccion 180 dias
    Y el termina la transaccion
    Y el elimina la transferencia programada
    Entonces se verifica que la transferencia se haya eliminado correctamente

  @EditarTransferenciaFutura
  Escenario: Editar transferencia propia con fecha futura
    Dado que Marlon quiere ingresar con el usuario: Autotransferencia123_ y la clave: Prueba123##
    Cuando el intenta realizar una transferencia entre cuentas propias desde el menu
      | Monto | Descripcion |
      | 1.20  | editar futu |
    Y el programa con fecha futura la transaccion 180 dias
    Y el termina la transaccion
    Y el edita la transferencia programada con fecha futura 190 dias
      | Monto | Descripcion   |
      | 1.98  | editar futura |
    Entonces el verifica que la transferencia se haya editado correctamente

  @EditarTransferenciaRecurrente
  Escenario: Transferencia programada con recurrencia a cuentas propias
    Dado que Marlon quiere ingresar con el usuario: Autotransferencia123_ y la clave: Prueba123##
    Cuando el intenta realizar una transferencia entre cuentas propias desde el menu
      | Monto | Descripcion |
      | 0.01  | Editar recu |
    Y el programa con Recurrencia la transaccion
      | Frecuencia | Dia    | Dias inicial | Dias final |
      | Semanal    | Martes | 60           | 67          |
    Y el termina la transaccion
    Y el edita la transferencia programada con fecha recurrente
      | Monto | Descripcion                   | Frecuencia | Dia    | Dias final |
      | 1.00  | Prueba AUTO editar Recurrente | Semanal    | Jueves | 90         |
    Entonces el verifica que la transferencia se haya editado correctamente
