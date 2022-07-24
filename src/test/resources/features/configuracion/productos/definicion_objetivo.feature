#language:es

@DefinirObjetivo @21042
Característica: Definicion de objetivo
  Yo como cliente del APP de Personas
  Quiero definir un objetivo monetario de mis productos
  Para las Cuenta de Ahorro, Corriente e Inversiones

  @21042-1
  Escenario: Definir un objetivo de ahorro
    Dado que Felipe quiere ingresar con el usuario: elizabeth1234 y la clave: Prueba123##
    Cuando el defina un objetivo exitoso de ahorro en una cuenta
    Entonces la cuenta tiene el objetivo de ahorro correctamente

  @21042-2
  Escenario: Definir un objetivo de ahorro fallido
    Dado que Felipe quiere ingresar con el usuario: elizabeth1234 y la clave: Prueba123##
    Cuando el defina un objetivo fallido de ahorro en una cuenta
    Entonces deberia ver el siguiente mensaje: El monto objetivo debe ser mayor a el saldo actual de esta cuenta. Verifica la información.