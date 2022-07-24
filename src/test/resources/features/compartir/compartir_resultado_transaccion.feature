#language:es

@CompartirResultadoDeTransaccion @35398
Característica: Compartir Resultado de Transacción APP
  Yo como un usuario del APP de Personas
  Quiero imprimir la pantalla de comprobante
  Para compartir una transacción, pago o recarga realizada

  @35398-1
  Escenario: Descargar en PDF Resultado de Transaccion
    Dado que Felipe quiere ingresar con el usuario: elizabeth1234 y la clave: Prueba123##
    Cuando el intenta realizar una transferencia entre cuentas propias desde la vista card
      | Monto | Descripcion                   |
      | 0.01  | Transferencia cuentas propias |
    Y el termina la transaccion
    Y el descarga el PDF del resultado de la transaccion
    Entonces el deberia visualizar un mensaje con descarga exitosa

  @35398-2
  Escenario: Descargar Imagen de Resultado de Transaccion
    Dado que Felipe quiere ingresar con el usuario: elizabeth1234 y la clave: Prueba123##
    Cuando el intenta realizar una transferencia entre cuentas propias desde la vista card
      | Monto | Descripcion                   |
      | 0.01  | Transferencia cuentas propias |
    Y el termina la transaccion
    Y el descarga la imagen del resultado de la transaccion
    Entonces el deberia visualizar un mensaje con descarga exitosa
