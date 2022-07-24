#language: es
Característica: Pago de Impuestos
  Yo como cliente de la SVP
  Quiero ver el pago de impuesto con la nueva línea gráfica
  Para realizar el pago de los impuestos de la DGI desde este canal

  @PagoDGIExitoso
  Escenario:  Pago de impuesto exitoso
    Dado que Carlos quiere ingresar con el usuario: autoimpuestos123_ y la clave: Prueba123##
    Cuando el intenta consultar impuestos DGI con el nro de boleta
    Y el termina la transaccion
    Entonces el pago a prestamo a terceros debe impuestos debe ser exitoso

  @PagoDGIInvalida
  Esquema del escenario: Pago de impuesto con nro de boleta invalidas
    Dado que Carlos quiere ingresar con el usuario: autoimpuestos123_ y la clave: Prueba123##
    Cuando el intenta consultar impuestos DGI con el nro de boleta <boleta>
    Entonces deberia ver el mensaje de error El estado de tu boleta es: <mensajeEsperado>

    Ejemplos:
      | boleta       | mensajeEsperado                                                 |
      | 9999999      | No existe un registro de boleta vigente con el código ingresado |
      | 202112331039 | Boleta: Pagada                                                  |
      | 202104459042 | Boleta: Anulada                                                 |



