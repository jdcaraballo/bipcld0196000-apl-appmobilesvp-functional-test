#language:es

@20140 @CuentaPreferida
Característica: Cuenta de Depósito preferida APP
  Yo como cliente de APP de Personas
  Quiero seleccionar una de mis cuentas de depósito como cuenta preferida
  Para utilizarla como la primera opción al realizar transacciones financiera

  @20140-1
  Escenario: Seleccion de cuenta preferida por configuraciones de la cuenta
    Dado que Felipe quiere ingresar con el usuario: EXTRAFIN11_ y la clave: Prueba123##
    Y el revisa que no existe ninguna cuenta propia marcada como preferida
    Cuando el selecciona una cuenta como preferida
    Entonces el observa que la cuenta seleccionada queda como la preferida

  @20140-2
  Escenario: Seleccion de cuenta preferida por detalles de la cuenta
    Dado que Felipe quiere ingresar con el usuario: EXTRAFIN11_ y la clave: Prueba123##
    Y el revisa que no existe ninguna cuenta propia marcada como preferida
    Cuando el selecciona una cuenta como preferida desde detalles
    Y el se devuelve hasta la pantalla de inicio
    Entonces el observa que la cuenta seleccionada queda como la preferida desde el home

  @20140-3
  Escenario: Cambio de cuenta preferida por configuraciones de la cuenta
    Dado que Felipe quiere ingresar con el usuario: EXTRAFIN11_ y la clave: Prueba123##
    Y el revisa que si existe ninguna cuenta propia marcada como preferida
    Cuando el cambia una cuenta como preferida
    Entonces el observa que la cuenta seleccionada queda como la preferida

  @20140-4
  Escenario: Cambio de cuenta preferida por detalles de la cuenta
    Dado que Felipe quiere ingresar con el usuario: EXTRAFIN11_ y la clave: Prueba123##
    Y el revisa que si existe ninguna cuenta propia marcada como preferida
    Cuando el cambia una cuenta como preferida desde detalles
    Y el se devuelve hasta la pantalla de inicio
    Entonces el observa que la cuenta seleccionada queda como la preferida desde el home

