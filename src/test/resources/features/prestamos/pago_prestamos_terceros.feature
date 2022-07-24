#language:es

@PrestamosTerceros
Característica: Pago de prestamos a terceros
  Yo como un usuario de la SVP
  quiero realizar los pagos de prestamos a terceros

  @PagoPrestamosTercerosACH @RutaCriticaLote2
  Escenario: Pago de prestamos a terceros ACH exitoso
    Dado que Fernando quiere ingresar con el usuario: antonio123_ y la clave: Prueba123##
    Cuando el intenta pagar un prestamo a terceros ACH
      | Banco      | Cuenta   | Monto | Descripcion |
      | Davivienda | 12345679 | 0.01  | Prueba      |
    Y el termina la transaccion
    Entonces el pago a prestamo a terceros debe ser exitoso

  @PagoPrestamosACHValorSuperior
  Escenario: Pago de prestamo ACH con valor superior al saldo disponible
    Dado que Fernando quiere ingresar con el usuario: Autoprestamo123_ y la clave: Prueba123##
    Cuando el intenta pagar un prestamo a terceros ACH
      | Banco       | Cuenta   | Monto    | Descripcion |
      | Banco Delta | 12345679 | 99999999 | Prueba      |
    Y el termina la transaccion
    Entonces deberia ver el siguiente mensaje: No cuenta con fondos suficientes para realizar esta transacción.

  @PagoPrestamosTercerosBanistmo @RutaCriticaLote2
  Escenario: Pago exitoso de un prestamo de tercero banistmo
    Dado que Fernando quiere ingresar con el usuario: antonio123_ y la clave: Prueba123##
    Cuando el intenta pagar un prestamo a terceros Banistmo
      | Banco         | Cuenta    | Monto | Descripcion |
      | Banistmo S.a. | 000502090 | 0.01  | Prueba      |
    Y el termina la transaccion
    Entonces el pago a prestamo a terceros debe ser exitoso

  @PagoPrestamosTercerosBanistmoValorSuperior
  Escenario: Pago de prestamo a terceros banistmo con valor superior al saldo disponible
    Dado que Fernando quiere ingresar con el usuario: Autoprestamo123_ y la clave: Prueba123##
    Cuando el intenta pagar un prestamo a terceros Banistmo
      | Banco         | Cuenta   | Monto    | Descripcion |
      | Banistmo S.a. | 12345679 | 99999999 | Prueba      |
    Y el termina la transaccion
    Entonces deberia ver el siguiente mensaje: No cuenta con fondos suficientes para realizar esta transacción.

  @PagoPrestamosGuardadosACH @RutaCriticaLote2
  Escenario: Pago de prestamos guardado a terceros ACH exitoso
    Dado que Fernando quiere ingresar con el usuario: antonio123_ y la clave: Prueba123##
    Cuando el intenta realizar un pago de un prestamo ACH con un monto: 0.01
    Y el termina la transaccion
    Entonces el pago a prestamo a terceros debe ser exitoso

  @PagoPrestamosGuardadosTercerosBanistmo @RutaCriticaLote2
  Escenario: Pago de prestamos guardado a terceros Banistmo exitoso
    Dado que Fernando quiere ingresar con el usuario: reina123_ y la clave: Prueba123##
    Cuando el intenta realizar un pago de un prestamo Banistmo con un monto: 0.01
    Y el termina la transaccion
    Entonces el pago a prestamo a terceros debe ser exitoso

  @CancelarPagoPrestamoACHVerificacion
  Escenario: Cancelacion del Pago del prestamo ACH pantalla verificacion
    Dado que Fernando quiere ingresar con el usuario: antonio123_ y la clave: Prueba123##
    Cuando el intenta realizar un pago de un prestamo ACH con un monto: 0.01
    Y el cancela la transaccion en la pantalla de Verificación
    Entonces el puede observar sus productos

  @CancelarPagoPrestamoACHPreparacion
  Escenario: Cancelacion del Pago del prestamo ACH antes de confirmarlo
    Dado que Fernando quiere ingresar con el usuario: antonio123_ y la clave: Prueba123##
    Cuando el intenta realizar un pago de un prestamo ACH con un monto: 0.01
    Y el cancela la transaccion en la pantalla de Preparación
    Entonces el puede observar sus productos




