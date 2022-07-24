#language:es

Característica: Flujo de olvido de usuario
  Como usuario de Banistmo SVP
  Quiero ingresar mi datos personales y correo
  Para recordar el usuario que tengo registrado en el sistema

  @olvidoUsuarioExitoso
  Esquema del escenario: Olvido de usuario exitoso
    Dado que Robert quiere recordar su usuario de Banca en Linea Personas
    Cuando el ingresa los datos del proceso de recuperacion de usuario
      | tipo id   | nro id   | correo   |
      | <tipo id> | <nro id> | <correo> |
    Y el ingresa el código de recibido en el correo con la información: Olvidó usuario
    Entonces el puede ver el usuario <usuario> en pantalla

    Ejemplos:
      | tipo id   | nro id         | correo                      | usuario           |
      | Cédula    | 3-2314-1452    | testqabanistmosvp@gmail.com | Autoservicio123_  |
      | Pasaporte | T654321-654321 | testqabanistmosvp@gmail.com | autopasaporte123_ |

  @olvidoUsuarioFallido
  Esquema del escenario: Olvido de usuario fallido
    Dado que Robert quiere recordar su usuario de Banca en Linea Personas
    Cuando el ingresa los datos del proceso de recuperacion de usuario
      | tipo id   | nro id   | correo   |
      | <tipo id> | <nro id> | <correo> |
    Entonces deberia ver el mensaje de error: <mensaje>

    Ejemplos:
      | tipo id   | nro id      | correo                      | mensaje                                                                               |
      | Cédula    | 1-4428-9999 | correoinvalido@gmail.com    | El correo ingresado no coincide con el registrado. Por favor verifica la información. |
      | Pasaporte | 09500100A   | testqabanistmosvp@gmail.com | El correo ingresado no coincide con el registrado. Por favor verifica la información. |
