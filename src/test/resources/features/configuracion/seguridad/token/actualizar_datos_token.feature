#language:es

Característica: Actualización de datos Con Token

  Como usuario de Banistmo SVP
  Quiero ingresar a Actualización de datos
  Para verificar pestaña ventana

  @ActualizacionDatos
  Escenario: Actualización de datos
    Dado que Sebastian quiere ingresar con el usuario: elizabeth1234 y la clave: Prueba123##
    Cuando el se dirige a Actualización de datos con validacion token

  @ActualizacionDatosHome
  Escenario: Actualización de datos desde el Home
    Dado que Sebastian quiere ingresar con el usuario: elizabeth1234 y la clave: Prueba123##
    Cuando el se dirige a Actualización de datos desde el home con validacion token
    Entonces el puede confirmar que accede a nueva pestaña de datos del cliente
