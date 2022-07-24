#language:es

@CambioContrasenaToken @35176 @RutaCritica
Característica: Cambio de Contrasena con token
  Como cliente y usuario de la aplicacion movil de Banistmo
  Quiero realizar el cambio de contrasena

  @35176-1
  Escenario: Cambio exitoso de contrasena con token
    Dado que Isamel quiere inscribir token con usuario salvatore13_ y clave Prueba123##
    Y el registra el token en el dispositivo con descripcion: CAMBIOCONTRASENA
    Y el inicia sesion en la app
    Cuando el cambie la contraseña por Prueba321## con validacion token
    Y el cierra sesion en la aplicacion por la configuracion
    Y Ismael ingresa con el usuario: salvatore13_ y la clave: Prueba321##
    Entonces el puede observar sus productos