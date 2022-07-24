#language:es

@Login @18027
Característica: Hu login
  Como usuario de la aplicacion movil de Banistmo
  Quiero realizar el logueo en la app
  Para verificar el funcionamiento de sus componentes

  @18027-1
  Escenario: Auntenticacion Exitosa
    Cuando Andres ingresa con el usuario: elizabeth1234 y la clave: Prueba123##
    Entonces el puede observar sus productos

  @18027-2
  Escenario: Logueo con credenciales incorrectas
    Cuando Andres ingresa con el usuario: elizabeth1234 y la clave: Prueba1234
    Entonces la autenticacion deberia de ser fallida por credenciales incorrectas

  @18027-3
  Escenario: Login con usuario bloqueado
    Cuando Andres ingresa con el usuario: aura123_ y la clave: Prueba123##
    Entonces la autenticacion deberia de ser fallida por usuario bloqueado

  @18027-4
  Escenario: Visualizacion de clave
    Cuando Andres ingresa las creneciales usuario: luis123, clave: Prueba123## y activa la opcion de visualizar clave
    Entonces el visualiza su clave ingresada: Prueba123##

  @18027-5
  Escenario: Cancelacion de logueo
    Cuando Andres ingresa las creneciales usuario: luis123, clave: Prueba123## y se cancela
    Entonces el deberia regresar al ingreso de usuario
