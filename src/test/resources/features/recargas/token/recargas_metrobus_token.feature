#language:es

@RecargasMetrobusToken
Característica: Recargas Metro y Metrobus con token
  Yo como un usuario de la SVP
  Quiero realizar recargas de mis servicios

  Escenario: Recarga Metrobus con token exitosa
    Dado que Marcelo quiere inscribir token con usuario Autorecarga12345_ y clave Prueba123##
    Y el registra el token en el dispositivo con descripcion: RECARGAMETRO
    Y el inicia sesion en la app
    Cuando el intenta realizar una recarga con a Metro y Metrobus
      | Numero de Tarjeta | Monto |
      | 18146266          | 11.00  |
    Y el termina la transaccion con validacion del token
    Entonces la recarga deberia ser exitosa

  Escenario: Recarga Metrobus con token exitosa guardada
    Dado que Marcelo quiere inscribir token con usuario Autorecarga12345_ y clave Prueba123##
    Y el registra el token en el dispositivo con descripcion: RECARGAMETRO
    Y el inicia sesion en la app
    Cuando el intenta realizar una recarga de Metro y Metrobus guardada con un monto: 11.00
    Y el termina la transaccion con validacion del token
    Entonces la recarga deberia ser exitosa

