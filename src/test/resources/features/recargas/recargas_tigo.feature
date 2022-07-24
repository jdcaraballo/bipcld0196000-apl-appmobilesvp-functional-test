#language:es

@RecargaATigo
Característica: Recargas a Tigo
  Yo como un usuario de la SVP
  Quiero realizar recargas de mis servicios

  @RutaCriticaLote1
  Escenario: Recarga a tigo exitosa
    Dado que el Actor quiere ingresar con el usuario: Autorecarga12345_ y la clave: Prueba123##
    Cuando el intenta realizar una recarga con a Tigo
      | Numero de celular | Monto |
      | 62013622          | 11.00  |
    Y el termina la transaccion
    Entonces la recarga deberia ser exitosa

  @RutaCriticaLote2
  Escenario: Recarga a tigo con valor superior al saldo disponible
    Dado que el Actor quiere ingresar con el usuario: Autorecarga12345_ y la clave: Prueba123##
    Cuando el intenta realizar una recarga con a Tigo
      | Numero de celular | Monto    |
      | 62013622          | 99999999 |
    Y el termina la transaccion
    Entonces deberia ver el siguiente mensaje: No cuenta con fondos suficientes para realizar esta transacción, recuerde que a este valor se le sumará el I.T.B.M.S del 7%

  Escenario: Recarga a Tigo con valor inferior
    Dado que el Actor quiere ingresar con el usuario: Autorecarga12345_ y la clave: Prueba123##
    Cuando el intenta realizar una recarga con a Tigo
      | Numero de celular | Monto |
      | 62013622          | 0.01  |
    Y el termina la transaccion
    Entonces deberia ver el siguiente mensaje: El mínimo para la recarga es de

  Escenario: Recarga Tigo guardada
    Dado que el Actor quiere ingresar con el usuario: Autorecarga12345_ y la clave: Prueba123##
    Cuando el intenta realizar una recarga de Tigo guardada con un monto: 11.00
    Y el termina la transaccion
    Entonces la recarga deberia ser exitosa
