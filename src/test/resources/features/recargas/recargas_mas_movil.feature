#language:es

@RecargaAMasMovil
Característica: Recargas a Mas Movil
  Yo como un usuario de la SVP
  Quiero realizar recargas de mis servicios

  @RutaCriticaLote1
  Escenario: Recarga a Mas Movil exitosa
    Dado que el Actor quiere ingresar con el usuario: Autorecarga12345_ y la clave: Prueba123##
    Cuando el intenta realizar una recarga con a Más Móvil
      | Numero de celular | Monto |
      | 61529178          | 11.00  |
    Y el termina la transaccion
    Entonces la recarga deberia ser exitosa

  @RutaCriticaLote2
  Escenario: Recarga a Mas Movil con valor superior al saldo disponible
    Dado que el Actor quiere ingresar con el usuario: Autorecarga12345_ y la clave: Prueba123##
    Cuando el intenta realizar una recarga con a Más Móvil
      | Numero de celular | Monto    |
      | 61529178          | 99999999 |
    Y el termina la transaccion
    Entonces deberia ver el siguiente mensaje: No cuenta con fondos suficientes para realizar esta transacción

  Escenario: Recarga a Mas Movil con valor inferior
    Dado que el Actor quiere ingresar con el usuario: Autorecarga12345_ y la clave: Prueba123##
    Cuando el intenta realizar una recarga con a Más Móvil
      | Numero de celular | Monto |
      | 61529178          | 0.01  |
    Y el termina la transaccion
    Entonces deberia ver el siguiente mensaje: El mínimo para la recarga es de

  Escenario: Recarga Mas Movil guardada
    Dado que el Actor quiere ingresar con el usuario: Autorecarga12345_ y la clave: Prueba123##
    Cuando el intenta realizar una recarga de Mas Movil guardada con un monto: 11.00
    Y el termina la transaccion
    Entonces la recarga deberia ser exitosa
