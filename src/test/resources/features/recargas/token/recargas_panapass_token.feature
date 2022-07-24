#language:es

@RecargasPanapassToken
Característica: Recargas Panapass con token
  Yo como un usuario de la SVP
  Quiero realizar recargas de mis servicios

  Escenario: Recarga Panapass con token exitosa
    Dado que Juan quiere inscribir token con usuario Autorecarga12345_ y clave Prueba123##
    Y el registra el token en el dispositivo con descripcion: RECARGAPANAPASS
    Y el inicia sesion en la app
    Cuando el intenta realizar una recarga a Panapass
      | Numero Panapass | Monto |
      | 133080          | 11.00  |
    Y el termina la transaccion con validacion del token
    Entonces la recarga deberia ser exitosa

  Escenario: Recarga Panapass con token guardada
    Dado que Juan quiere inscribir token con usuario Autorecarga12345_ y clave Prueba123##
    Y el registra el token en el dispositivo con descripcion: RECARGAPANAPASS
    Y el inicia sesion en la app
    Cuando el intenta realizar una recarga de Panapass guardada con un monto: 11.00
    Y el termina la transaccion con validacion del token
    Entonces la recarga deberia ser exitosa
