#language: es

@CodigoQR
Característica: Generar QR
  Yo como un usuario de la SVP
  Quiero realizar la generación de código QR para recibir transferencias
  Para comprobar su correcto funcionamiento

  @CodigoQrSinMonto
  Escenario: Generar QR en PDF sin monto exitosamente
    Dado que Gustavo quiere ingresar con el usuario: Autotransferencia123_ y la clave: Prueba123##
    Cuando el intenta generar código QR sin monto y con descripción QR sin monto AUT
    Y el descargara el PDF del resultado de la transaccion
    Entonces el deberia visualizar un mensaje con descarga exitosa

  @CodigoQrConMonto
  Escenario: Generar QR con monto exitosamente
    Dado que Gustavo quiere ingresar con el usuario: Autotransferencia123_ y la clave: Prueba123##
    Cuando el intenta generar código QR con monto 531.00 y descripción QR con monto AUT JSON
    Y el descargara el PDF del resultado de la transaccion
    Entonces el deberia visualizar un mensaje con descarga exitosa

  @ModificarQR
  Escenario: Modificar datos QR exitosamente
    Dado que Gustavo quiere ingresar con el usuario: Autotransferencia123_ y la clave: Prueba123##
    Cuando el intenta modificar código QR sin monto y con descripción QR nuevo
    Y el modifica los datos del QR con monto 500.00 y descripcion QR Modificado
    Y el descargara el PDF del resultado de la transaccion
    Entonces el deberia visualizar un mensaje con descarga exitosa

  @CancelarQR
  Escenario: Cancelar generación de QR
    Dado que Gustavo quiere ingresar con el usuario: Autotransferencia123_ y la clave: Prueba123##
    Cuando el intenta llenar los datos del código QR monto 1000.00 descripcion: Cancelar QR
    Y cancela la operación
    Entonces el puede observar sus productos


