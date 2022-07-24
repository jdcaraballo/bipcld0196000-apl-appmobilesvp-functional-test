#language:es

@RecargasMetrobus
Característica: Recargas Metro y Metrobus
  Yo como un usuario de la SVP
  Quiero realizar recargas de mis servicios

  @RutaCriticaLote2
  Escenario: Recarga Metrobus exitosa
    Dado que Marcelo quiere ingresar con el usuario: Autorecarga12345_ y la clave: Prueba123##
    Cuando el intenta realizar una recarga con a Metro y Metrobus
      | Numero de Tarjeta | Monto |
      | 18146266          | 11.00  |
    Y el termina la transaccion
    Entonces la recarga deberia ser exitosa

  Escenario: Recarga Metrobus con valor superior al saldo disponible
    Dado que Marcelo quiere ingresar con el usuario: Autorecarga12345_ y la clave: Prueba123##
    Cuando el intenta realizar una recarga con a Metro y Metrobus
      | Numero de Tarjeta | Monto    |
      | 18146266          | 99999999 |
    Y el termina la transaccion
    Entonces deberia ver el siguiente mensaje: No cuenta con fondos suficientes para realizar esta transacción

  Escenario: Recarga Metrobus con valor inferior al permitido
    Dado que Marcelo quiere ingresar con el usuario: Autorecarga12345_ y la clave: Prueba123##
    Cuando el intenta realizar una recarga con a Metro y Metrobus
      | Numero de Tarjeta | Monto |
      | 18146266          | 0.01  |
    Y el termina la transaccion
    Entonces deberia ver el siguiente mensaje: El mínimo para la recarga es de

  Escenario: Recarga Metro y Metrobus guardada
    Dado que el Actor quiere ingresar con el usuario: Antonio123_ y la clave: Prueba123##
    Cuando el intenta realizar una recarga de Metro y Metrobus guardada con un monto: 11.00
    Y el termina la transaccion
    Entonces la recarga deberia ser exitosa


