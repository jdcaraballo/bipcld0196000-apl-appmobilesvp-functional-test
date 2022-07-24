#language:es

@RecargasMetrobusToken
Característica: Recargas Tigo con token
  Yo como un usuario de la SVP
  Quiero realizar recargas de mis servicios

  Escenario: Recarga Tigo con token exitosa
    Dado que Marcelo quiere inscribir token con usuario elizabeth1234 y clave Prueba123##
    Y el registra el token en el dispositivo con descripcion: RECARGATIGO
    Y el inicia sesion en la app
    Cuando el intenta realizar una recarga con a Tigo
      | Numero de Tarjeta | Monto |
      | 18146266          | 11.00  |
    Y el termina la transaccion con validacion del token
    Entonces la recarga deberia ser exitosa

  Escenario: Recarga Tigo con token exitosa guardada
    Dado que Marcelo quiere inscribir token con usuario Autorecarga12345_ y clave Prueba123##
    Y el registra el token en el dispositivo con descripcion: RECARGATIGO
    Y el inicia sesion en la app
    Cuando el intenta realizar una recarga de Tigo guardada con un monto: 11.00
    Y el termina la transaccion con validacion del token
    Entonces la recarga deberia ser exitosa
