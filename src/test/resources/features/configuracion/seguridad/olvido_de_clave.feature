#language:es

@OlvidoDeContraseña

Característica: Cambio imagen y frase
  Como usuario de app Banistmo SVP
  Quiero ingresar a Cambio imagen y frase de seguiridad
  Para modificar dichos datos

  @35177-1
  Escenario: Cambio exitoso de contrasena desde el login
    Dado que Ismael quiere recuperar su contrase con el usuario: Autotransferencia123_
    Cuando el ingresa el correo registrado: testqabanistmosvp@gmail.com
    Y el ingresa el código de recibido en el correo con la información: Recuperar Contraseña
    Cuando realiza el cambio de clave por Prueba321## desde la pantalla login
    Y observa el mensaje de cambio de contraseña exitoso
    Y Ismael ingresa con el usuario: Autotransferencia123_ y la clave: Prueba321##
    Entonces el puede observar sus productos
