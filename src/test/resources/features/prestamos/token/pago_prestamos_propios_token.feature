#language:es

@PrestamosPropiosToken
Característica: Pago de prestamos propios con token
  Yo como un usuario de la SVP
  quiero realizar el pago de prestamos de terceros

  @PagoPrestamoPropioConsolidadoToken
  Escenario: Ingresar al Pago de prestamo con token desde Consolidado de productos
    Dado que Santiago quiere inscribir token con usuario Autoprestamo123_ y clave Prueba123##
    Y el registra el token en el dispositivo con descripcion: PRESTAMOST
    Y el inicia sesion en la app
    Cuando el intenta realizar el pago de un Préstamo por el consolidados de productos
    Y el termina la transaccion con validacion del token
    Entonces el pago a prestamo propio debe ser exitoso

  @PagoPrestamoPropioDetalleToken
  Escenario: Ingresar al Pago de prestamo con token desde detalles
    Dado que Santiago quiere inscribir token con usuario Autoprestamo123_ y clave Prueba123##
    Y el registra el token en el dispositivo con descripcion: PRESTAMOST
    Y el inicia sesion en la app
    Cuando el intenta realizar el pago de un Préstamo por detalles
    Y el termina la transaccion con validacion del token
    Entonces el pago a prestamo propio debe ser exitoso

  @PagoPrestamoPropioToken
  Escenario: Pago prestamos con token propio desde la seccion de pagos
    Dado que Santiago quiere inscribir token con usuario Autoprestamo123_ y clave Prueba123##
    Y el registra el token en el dispositivo con descripcion: PRESTAMOST
    Y el inicia sesion en la app
    Cuando el intenta realizar un pago de un prestamo propio con un monto: 0
    Y el termina la transaccion con validacion del token
    Entonces el pago a prestamo propio debe ser exitoso