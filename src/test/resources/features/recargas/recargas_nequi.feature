#language:es

@RecargasNequi
Característica: Recargas a Nequi
  Yo como un usuario de la SVP
  Quiero realizar recargas de mis servicios

  @RutaCriticaLote2
  Escenario: Recarga Nequi exitosa
    Dado que Camilo quiere ingresar con el usuario: Autorecarga12345_ y la clave: Prueba123##
    Cuando el intenta realizar una recarga con Nequi
      | Numero de celular | Monto |
      | 67777742          | 10.00 |
    Y el termina la transaccion
    Entonces la recarga deberia ser exitosa

  @RutaCriticaLote2
  Escenario: Recarga a Nequi con valor superior al saldo disponible
    Dado que el Actor quiere ingresar con el usuario: Autorecarga12345_ y la clave: Prueba123##
    Cuando el intenta realizar una recarga con Nequi
      | Numero de celular | Monto    |
      | 12345678          | 99999999 |
    Y el termina la transaccion
    Entonces deberia ver el siguiente mensaje: No cuenta con fondos suficientes para realizar esta transacción.

  Escenario: Recarga a Nequi con valor inferior
    Dado que el Actor quiere ingresar con el usuario: Autorecarga12345_ y la clave: Prueba123##
    Cuando el intenta realizar una recarga con Nequi
      | Numero de celular | Monto |
      | 67777742          | 0.00  |
    Y el termina la transaccion
    Entonces deberia ver el siguiente mensaje: Ingresa un monto mayor

  Escenario: Recarga Nequi guardada
    Dado que el Actor quiere ingresar con el usuario: Autorecarga12345_ y la clave: Prueba123##
    Cuando el intenta realizar una recarga de Nequi guardada con un monto: 11.00
    Y el termina la transaccion
    Entonces la recarga deberia ser exitosa
