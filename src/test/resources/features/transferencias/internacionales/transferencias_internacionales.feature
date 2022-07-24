#language:es

@TransferenciasInternacionales @35380
Característica: Transferencias internacionales
  Yo como un usuario de la SVP
  Quiero realizar transferencias internacionales
  Para mover fondos entre cuentas a terceras personas de otros paises

  @35380-1  @RutaCriticaLote3
  Escenario: Transferencia internacional exitosa
    Dado que Juan Felipe quiere ingresar con el usuario: Autotransferencia123_ y la clave: Prueba123##
    Cuando el intenta realizar una transferencia internacional
      | Pais   | Banco                              | Cuenta  | Monto |
      | Angola | BANCO ANGOLANO NEGOCIOS E COMERCIO | AB38920 | 40.00 |
    Y el termina la transaccion
    Entonces la transferencia internacional deberia ser exitosa


  @35380-2
  Escenario: Transferencia internacional con un valor superior al disponible
    Dado que Juan Felipe quiere ingresar con el usuario: Autotransferencia123_ y la clave: Prueba123##
    Cuando el intenta realizar una transferencia internacional
      | Pais   | Banco                              | Cuenta  | Monto     |
      | Angola | BANCO ANGOLANO NEGOCIOS E COMERCIO | AB38920 | 999999999 |
    Y el termina la transaccion
    Entonces deberia ver el siguiente mensaje: No cuenta con fondos suficientes para realizar esta transacción.

  @35380-3
  Escenario: Transferencia internacional con un valor inferior al valido
    Dado que Juan Felipe quiere ingresar con el usuario: Autotransferencia123_ y la clave: Prueba123##
    Cuando el intenta realizar una transferencia internacional
      | Pais   | Banco                              | Cuenta  | Monto |
      | Angola | BANCO ANGOLANO NEGOCIOS E COMERCIO | AB38920 | 5.00  |
    Y el termina la transaccion
    Entonces deberia ver el siguiente mensaje: Este campo es requerido. Se requiere un monto mayor a

  @35380-4
  Escenario: Transferencia internacional exitosa cuenta guardada
    Dado que Juan Felipe quiere ingresar con el usuario: Autotransferencia123_ y la clave: Prueba123##
    Cuando el intenta realizar una transaccion a una cuenta guardada internacional con un monto: 40.00 y una descripcion: Prueba automatica
    Y el termina la transaccion
    Entonces la transferencia internacional guardada deberia ser exitosa

  @35380-5
  Escenario: Cancelacion de Transferencia internacional en la pantalla de verificacion
    Dado que Juan Felipe quiere ingresar con el usuario: Autotransferencia123_ y la clave: Prueba123##
    Cuando el intenta realizar una transaccion a una cuenta guardada internacional con un monto: 40.00 y una descripcion: Prueba automatica
    Y el cancela la transaccion en la pantalla de Verificación
    Entonces el puede observar sus productos

  @35380-6
  Escenario: Cancelacion de Transferencia internacional en la pantalla de preparacion
    Dado que Juan Felipe quiere ingresar con el usuario: Autotransferencia123_ y la clave: Prueba123##
    Cuando el intenta realizar una transaccion a una cuenta guardada internacional con un monto: 40.00 y una descripcion: Prueba automatica
    Y el cancela la transaccion en la pantalla de Preparación
    Entonces el puede observar sus productos

  @35380-7
  Escenario: Modificacion transferencia internacional exitosa cuenta guardada
    Dado que Juan Felipe quiere ingresar con el usuario: Autotransferencia123_ y la clave: Prueba123##
    Cuando el intenta realizar una transaccion a una cuenta guardada internacional con un monto: 40.00 y una descripcion: Prueba automatica
    Y el modifica los datos de la transferencia internacional
      | Monto | Descripcion         |
      | 55.00 | Prueba Modificacion |
    Y el termina la transaccion
    Entonces la transferencia internacional guardada deberia ser exitosa

