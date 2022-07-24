#language:es

@Logout @18023 @RutaCriticaLote1
Característica: Hu logout
  Yo como un usuario de la app de personas
  Quiero cerrar sesión en el canal
  Para mantener segura mi información

  @18023-1
  Escenario: Logout desde pantalla inicio
    Dado Felipe ingresa con el usuario: luis123 y la clave: Prueba123##
    Cuando el cierra sesion en la aplicacion por la pantalla inicio
    Entonces el deberia regresar al ingreso de usuario

  @18023-2
  Escenario: Logout desde configuracion
    Dado Felipe ingresa con el usuario: luis123 y la clave: Prueba123##
    Cuando el cierra sesion en la aplicacion por la configuracion
    Entonces el deberia regresar al ingreso de usuario
