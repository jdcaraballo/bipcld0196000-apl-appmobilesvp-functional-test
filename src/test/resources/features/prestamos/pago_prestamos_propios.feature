#language:es

@PrestamosPropios
Característica: Pago de prestamos propios
  Yo como un usuario de la SVP
  quiero realizar el pago de prestamos de terceros

  @PagoPrestamoPropioConsolidado
  Escenario: Ingresar al Pago de prestamo desde Consolidado de productos
    Dado que Santiago quiere ingresar con el usuario: elizabeth1234 y la clave: Prueba123##
    Cuando el intenta realizar el pago de un Préstamo por el consolidados de productos
    Y el termina la transaccion
    Entonces el pago a prestamo propio debe ser exitoso

  @PagoPrestamoPropioDetalle
  Escenario: Ingresar al Pago de prestamo desde detalles
    Dado que Santiago quiere ingresar con el usuario: salvatore13_ y la clave: Prueba123##
    Cuando el intenta realizar el pago de un Préstamo por detalles
    Y el termina la transaccion
    Entonces el pago a prestamo propio debe ser exitoso

  @PagoPrestamoPropio @RutaCriticaLote2
  Escenario: Pago prestamos propio desde la seccion de pagos
    Dado que Santiago quiere ingresar con el usuario: elizabeth1234 y la clave: Prueba123##
    Cuando el intenta realizar un pago de un prestamo propio con un monto: 0.01
    Y el termina la transaccion
    Entonces el pago a prestamo propio debe ser exitoso

  @CancelarPrestamoPropioVerificacion
  Escenario: Cancelacion del Pago del prestamo propio pantalla Verificacion
    Dado que Santiago quiere ingresar con el usuario: elizabeth1234 y la clave: Prueba123##
    Cuando el intenta realizar un pago de un prestamo propio con un monto: 0.01
    Y el cancela la transaccion en la pantalla de Verificación
    Entonces el puede observar sus productos

  @CancelarPrestamoPropioPreparacion
  Escenario: Cancelacion del Pago del prestamo propio antes de confirmarlo
    Dado que Santiago quiere ingresar con el usuario: salvatore13_ y la clave: Prueba123##
    Cuando el intenta realizar un pago de un prestamo propio con un monto: 0.01
    Y el cancela la transaccion en la pantalla de Preparación
    Entonces el puede observar sus productos

