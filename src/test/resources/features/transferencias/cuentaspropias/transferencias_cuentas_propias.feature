#language:es

@TransferenciasCuentasPropias @18018
Característica: Transferencias a cuentas propias
  Yo como usuario de la aplicacion movil de Banistmo
  Quiero realizar transferencias monetarias entre las cuentas asociadas a mi usuario
  Para comprobar su correcto funcionamiento

  @18018-1  @RutaCriticaLote3
  Esquema del escenario: Transferencia exitosa desde cuentas propias
    Dado que Wilson quiere ingresar con el usuario: Autotransferencia123_ y la clave: Prueba123##
    Cuando el intenta realizar una transferencia entre cuentas propias desde el <opcion>
      | Monto | Descripcion                   |
      | 10.00 | Transferencia cuentas propias |
    Y el termina la transaccion
    Entonces la transferencia a cuentas propias deberia ser exitosa

    Ejemplos:
      | opcion      |
      | menu        |
      | vista lista |
      | vista card  |

  @18018-2
  Escenario: Transferencia cuentas propias con un valor superior al disponible
    Dado que Wilson quiere ingresar con el usuario: Autotransferencia123_ y la clave: Prueba123##
    Cuando el intenta realizar una transferencia entre cuentas propias desde el menu
      | Monto    | Descripcion                   |
      | 99999999 | Transferencia cuentas propias |
    Y el termina la transaccion
    Entonces deberia ver el siguiente mensaje: No cuenta con fondos suficientes para realizar esta transacción.

  @18018-3
  Escenario: Cancelacion de Transferencia desde cuentas propias banistmo en la pantalla de verificacion
    Dado que Wilson quiere ingresar con el usuario: Autotransferencia123_ y la clave: Prueba123##
    Cuando el intenta realizar una transferencia entre cuentas propias desde el menu
      | Monto | Descripcion                   |
      | 10.00 | Transferencia cuentas propias |
    Y el cancela la transaccion en la pantalla de Verificación
    Entonces el puede observar sus productos

  @18018-4
  Escenario: Cancelacion de Transferencia desde cuentas propias banistmo en la pantalla de preparacion
    Dado que Wilson quiere ingresar con el usuario: Autotransferencia123_ y la clave: Prueba123##
    Cuando el intenta realizar una transferencia entre cuentas propias desde el menu
      | Monto | Descripcion                   |
      | 10.00 | Transferencia cuentas propias |
    Y el cancela la transaccion en la pantalla de Preparación
    Entonces el puede observar sus productos

  @18018-5
  Escenario: Transferencia a cuentas propias modificada
    Dado que Wilson quiere ingresar con el usuario: Autotransferencia123_ y la clave: Prueba123##
    Cuando el intenta realizar una transferencia entre cuentas propias desde el menu
      | Monto | Descripcion                   |
      | 10.00 | Transferencia cuentas propias |
    Y el modifica los datos de la transferencia entre cuentas propias
      | Monto | Descripcion         |
      | 10.00 | Prueba Modificacion |
    Y el termina la transaccion
    Entonces el verifica que se modificaron lo datos de la transferencia

  @18018-6
  Escenario: Transferencia fallida por falta de productos
    Dado que Wilson quiere ingresar con el usuario: YENNY123_ y la clave: Banistmo2019#
    Cuando el ingresa a mis productos
    Entonces deberia visualizar el siguiente mensaje: Nos alegra que esté nuevamente en la Banca en línea
