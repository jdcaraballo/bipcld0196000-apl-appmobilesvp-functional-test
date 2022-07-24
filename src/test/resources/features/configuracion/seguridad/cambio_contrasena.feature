#language:es

@CambioContrasena @35176 @RutaCriticaLote1
Característica: Cambio de Contrasena
  Como cliente y usuario de la aplicacion movil de Banistmo
  Quiero realizar el cambio de contrasena

  @35176-1
  Escenario: Cambio exitoso de contrasena
    Dado que Ismael quiere ingresar con el usuario: salvatore13_ y la clave: Prueba123##
    Cuando el cambia la contraseña por Prueba321##
    Y el cierra sesion en la aplicacion por la configuracion
    Y Ismael ingresa con el usuario: salvatore13_ y la clave: Prueba321##
    Entonces el puede observar sus productos
