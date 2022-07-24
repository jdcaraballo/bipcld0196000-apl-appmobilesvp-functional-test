#language:es

@TransferenciasInternacionalesToken
Característica: Transferencias internacionales con token
  Yo como un usuario de la SVP
  Quiero realizar transferencias internacionales
  Para mover fondos entre cuentas a terceras personas de otros paises

  @TRANSFINTT-0
  Escenario: Transferencia internacional exitosa
    Dado que Juan Felipe quiere inscribir token con usuario Autotransferencia123_ y clave Prueba123##
    Y el registra el token en el dispositivo con descripcion: TRANSFERENCIAST
    Y el inicia sesion en la app
    Dado que Juan Felipe quiere ingresar con el usuario: Autotransferencia123_ y la clave: Prueba123##
    Cuando el intenta realizar una transferencia internacional
      | Pais   | Banco                              | Cuenta  | Monto |
      | Angola | BANCO ANGOLANO NEGOCIOS E COMERCIO | AB38920 | 40.00 |
    Y el termina la transaccion con validacion del token
    Entonces la transferencia internacional deberia ser exitosa

  @TRANSFINTT-1
  Escenario: Transferencia internacional con token exitosa cuenta guardada
    Dado que Juan Felipe quiere inscribir token con usuario Autotransferencia123_ y clave Prueba123##
    Y el registra el token en el dispositivo con descripcion: TRANSFERENCIAST
    Y el inicia sesion en la app
    Dado que Juan Felipe quiere ingresar con el usuario: Autotransferencia123_ y la clave: Prueba123##
    Cuando el intenta realizar una transaccion a una cuenta guardada internacional con un monto: 40.00 y una descripcion: Prueba automatica
    Y el termina la transaccion con validacion del token
    Entonces la transferencia internacional guardada deberia ser exitosa

  @TRANSFINTT-2
  Escenario: Modificacion transferencia internacional con token exitosa cuenta guardada
    Dado que Juan Felipe quiere inscribir token con usuario Autotransferencia123_ y clave Prueba123##
    Y el registra el token en el dispositivo con descripcion: TRANSFERENCIAST
    Y el inicia sesion en la app
    Cuando el intenta realizar una transaccion a una cuenta guardada internacional con un monto: 40.00 y una descripcion: Prueba automatica
    Y el modifica los datos de la transferencia internacional
      | Monto | Descripcion         |
      | 55.00 | Prueba Modificacion |
    Y el termina la transaccion con validacion del token
    Entonces la transferencia internacional guardada deberia ser exitosa



