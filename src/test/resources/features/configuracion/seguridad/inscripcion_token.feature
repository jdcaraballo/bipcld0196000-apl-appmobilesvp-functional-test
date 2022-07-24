#language:es

@InscripcionToken
Característica: Inscribir soft token app Banistmo
  Como cliente y usuario de la aplicacion movil de Banistmo
  Quiero realizar la inscripción del soft token en la app

  @InscribirTokenCodigo @RutaCriticaLote1
  Escenario: Inscribir token con codigo exitoso con Verificacion Email
    Dado que Ismael quiere inscribir token con usuario hemen123_  y clave Prueba123##
    Cuando el ingresa el correo registrado: testqabanistmosvp@gmail.com
    Y el ingresa el código de recibido en el correo con información: Inscripción de Token
    Cuando el registra el token en el dispositivo con tarjeta debito 2521 y clave 0045 y descripcion INSCRIPTOKEN1
    Entonces el puede ver el usuario registrado

  @InscribirTokenCodigoFallido @RutaCriticaLote1
  Escenario: Inscribir token con tarjeta debito fallido
    Dado que Ismael quiere inscribir token con usuario hemen123_  y clave Prueba123##
    Cuando el ingresa el correo registrado: testqabanistmosvp@gmail.com
    Y el ingresa el código de recibido en el correo con información: Inscripción de Token
    Cuando el registra el token en el dispositivo con tarjeta debito 2500 y clave 9149 errados
    Entonces deberia ver el siguiente mensaje: Los datos ingresados no son correctos. Por favor verifica la información.

  @EliminarTokenRegistradoCodigo
  Escenario: Eliminar token con codigo exitoso
    Dado que Ismael quiere inscribir token con usuario hemen123_  y clave Prueba123##
    Cuando el ingresa el correo registrado: testqabanistmosvp@gmail.com
    Y el ingresa el código de recibido en el correo con información: Inscripción de Token
    Cuando el registra el token en el dispositivo con tarjeta debito 2521 y clave 0045 y descripcion INSCRIPTOKEN2
    Y el elimina el token registrado
    Entonces el verifica que el registro fue eliminado

  @InscribirTokenTDD @RutaCriticaLote1
  Escenario: Inscribir token con tarjeta de debito exitoso
    Dado que Patricia quiere inscribir token con usuario reina123_ y clave Prueba123##
    Cuando el ingresa el correo registrado: testqabanistmosvp@gmail.com
    Y el ingresa el código de recibido en el correo con información: Inscripción de Token
    Cuando el registra el token en el dispositivo con tarjeta debito 2562 y clave 9148 y descripcion INSCRIPTOKEN3
    Entonces el puede ver el usuario registrado

  @InscribirTokenConOtroUsuario
  Escenario: Inscribir token con codigo de otro usuario
    Dado que Ismael quiere inscribir token con usuario elizabeth1234 y clave Prueba123##
    Cuando el registra el token en el dispositivo con codigo recibido por correo con usuario Antonio123_ y clave Prueba123## y descripcion TOKENOTROUSE1
    Entonces el puede ver el usuario registrado

  @EliminarTokenRegistradoTDD
  Escenario: Eliminar token con tarjeta de debito exitoso
    Dado que Patricia quiere inscribir token con usuario hemen123_ y clave Prueba321##
    Cuando el ingresa el correo registrado: testqabanistmosvp@gmail.com
    Y el ingresa el código de recibido en el correo con información: Inscripción de Token
    Cuando el registra el token en el dispositivo con tarjeta debito 2521 y clave 0045 y descripcion INSCRIPTOKEN
    Y el elimina el token registrado
    Entonces el verifica que el registro fue eliminado

  @InscribirTokenCodigoErrado
  Escenario: Inscribir token con codigo fallido
    Dado que Ismael quiere inscribir token con usuario hemen123_  y clave Prueba123##
    Cuando el ingresa el correo registrado: testqabanistmosvp@gmail.com
    Cuando el registra el token en el dispositivo con codigo errado XXXXPPPP
    Entonces deberia ver el siguiente mensaje: El código es inválido

  @InscribirTokenUsuarioClaveFallido
  Escenario: Inscribir token con usuario o clave errado
    Cuando que Ismael quiere inscribir token con usuario antonio999 y clave Prueba123##
    Entonces deberia ver el siguiente mensaje: Los datos ingresados no son correctos. Por favor verifica la información e intenta de nuevo.
