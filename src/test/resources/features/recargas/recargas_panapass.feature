#language:es

@RecargasPanapass
Característica: Recargas Panapass
  Yo como un usuario de la SVP
  Quiero realizar recargas de mis servicios

  @RutaCriticaLote2
  Escenario: Recarga Panapass exitosa
    Dado que el Actor quiere ingresar con el usuario: Autorecarga12345_ y la clave: Prueba123##
    Cuando el intenta realizar una recarga a Panapass
      | Numero Panapass | Monto |
      | 000460          | 11.00  |
    Y el termina la transaccion
    Entonces la recarga deberia ser exitosa

  Escenario: Recarga Panapass con un valor inferior al permitido
    Dado que el Actor quiere ingresar con el usuario: Autorecarga12345_ y la clave: Prueba123##
    Cuando el intenta realizar una recarga a Panapass
      | Numero Panapass | Monto |
      | 000460          | 0.01  |
    Y el termina la transaccion
    Entonces deberia ver el siguiente mensaje: El mínimo para la recarga es de

  Escenario: Recarga Panapass con un valor superior al permitido
    Dado que el Actor quiere ingresar con el usuario: Autorecarga12345_ y la clave: Prueba123##
    Cuando el intenta realizar una recarga a Panapass
      | Numero Panapass | Monto    |
      | 000460          | 99999999 |
    Y el termina la transaccion
    Entonces deberia ver el siguiente mensaje: No cuenta con fondos suficientes para realizar esta transacción

  Escenario: Recarga Panapass guardada
    Dado que el Actor quiere ingresar con el usuario: Autorecarga12345_ y la clave: Prueba123##
    Cuando el intenta realizar una recarga de Panapass guardada con un monto: 11.00
    Y el termina la transaccion
    Entonces la recarga deberia ser exitosa

