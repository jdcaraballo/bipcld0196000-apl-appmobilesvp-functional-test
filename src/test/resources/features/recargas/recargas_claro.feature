#language:es

@RecargaAClaro
Característica: Recargas a Claro
  Yo como un usuario de la SVP
  Quiero realizar recargas de mis servicios

  @RutaCriticaLote1
  Escenario: Recarga a Claro exitosa
    Dado que el Actor quiere ingresar con el usuario: Autorecarga12345_ y la clave: Prueba123##
    Cuando el intenta realizar una recarga con a Claro
      | Numero de celular | Monto |
      | 62013622          | 11.00  |
    Y el termina la transaccion
    Entonces la recarga deberia ser exitosa

  @RutaCriticaLote2
  Escenario: Recarga a claro con valor superior al saldo disponible
    Dado que el Actor quiere ingresar con el usuario: Autorecarga12345_ y la clave: Prueba123##
    Cuando el intenta realizar una recarga con a Claro
      | Numero de celular | Monto    |
      | 62013622          | 99999999 |
    Y el termina la transaccion
    Entonces deberia ver el siguiente mensaje: No cuenta con fondos suficientes para realizar esta transacción

  Escenario: Recarga a Claro con valor inferior
    Dado que el Actor quiere ingresar con el usuario: Autorecarga12345_ y la clave: Prueba123##
    Cuando el intenta realizar una recarga con a Claro
      | Numero de celular | Monto |
      | 62013622          | 0.01  |
    Y el termina la transaccion
    Entonces deberia ver el siguiente mensaje: El mínimo para la recarga es de

  Escenario: Recarga Claro guardada
    Dado que el Actor quiere ingresar con el usuario: Autorecarga12345_ y la clave: Prueba123##
    Cuando el intenta realizar una recarga de claro guardada con un monto: 11.00
    Y el termina la transaccion
    Entonces la recarga deberia ser exitosa
