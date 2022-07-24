#language:es

@RecargaADigicelToken
Característica: Recargas Digicel Con Token
  Yo como un usuario de la SVP
  Quiero realizar recargas de mis servicios

  Escenario: Recarga Digicel con token exitosa
    Dado que Marcelo quiere inscribir token con usuario Autorecarga12345_ y clave Prueba123##
    Y el registra el token en el dispositivo con descripcion: RECARGADIGICEL
    Y el inicia sesion en la app
    Cuando el intenta realizar una recarga con a Digicel
      | Numero de celular | Monto |
      | 61529178          | 11.00  |
    Y el termina la transaccion con validacion del token
    Entonces la recarga deberia ser exitosa

  Escenario: Recarga Digicel con token exitosa guardada
    Dado que Marcelo quiere inscribir token con usuario Autorecarga12345_ y clave Prueba123##
    Y el registra el token en el dispositivo con descripcion: RECARGADIGICEL
    Y el inicia sesion en la app
    Cuando el intenta realizar una recarga de Digicel guardada con un monto: 11.00
    Y el termina la transaccion con validacion del token
    Entonces la recarga deberia ser exitosa
