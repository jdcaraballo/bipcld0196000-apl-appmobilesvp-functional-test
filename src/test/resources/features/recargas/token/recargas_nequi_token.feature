#language:es

@RecargasNequiToken
Característica: Recargas Nequi con token
  Yo como un usuario de la SVP
  Quiero realizar recargas de mis servicios

  Escenario: Recarga Nequi con token exitosa
    Dado que Marcelo quiere inscribir token con usuario Autorecarga12345_ y clave Prueba123##
    Y el registra el token en el dispositivo con descripcion: RECARGANEQUI
    Y el inicia sesion en la app
    Cuando el intenta realizar una recarga con Nequi
      | Numero de celular | Monto |
      | 18146266          | 11.00  |
    Y el termina la transaccion con validacion del token
    Entonces la recarga deberia ser exitosa

  Escenario: Recarga Nequi con token exitosa guardada
    Dado que Marcelo quiere inscribir token con usuario Autorecarga12345_ y clave Prueba123##
    Y el registra el token en el dispositivo con descripcion: RECARGANEQUI
    Y el inicia sesion en la app
    Cuando el intenta realizar una recarga de Nequi guardada con un monto: 11.00
    Y el termina la transaccion con validacion del token
    Entonces la recarga deberia ser exitosa

