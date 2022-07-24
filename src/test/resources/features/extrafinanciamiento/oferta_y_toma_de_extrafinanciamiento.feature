#language: es

@Extrafinanciamiento
Característica: Oferta y Toma de Extrafinanciamiento
  Yo como un usuario de la app SVP Banistmo
  Quiero ver que se presenta la oferta de extrafinanciamiento
  Para poder aceptarla y tomar el Extrafinanciamiento o posponer la visualización

  @48464-1
  Escenario: Desaparece la oferta al seleccionar Ver despues hasta el proximo login
    Dado que Santiago quiere ingresar con el usuario: ribana1234_ y la clave: Prueba123##
    Cuando el selecciona la opcion verDespues en el mensaje de extrafinanciamiento aprobado
    Entonces el no deberia ver el mensaje de extrafinanciamiento

  @48464-2
  Escenario: Reaparece la oferta al seleccionar en el escenario anterior Ver despues
    Dado que Santiago quiere ingresar con el usuario: ribana1234_ y la clave: Prueba123##
    Cuando el selecciona la opcion verDespues en el mensaje de extrafinanciamiento aprobado
    Y el cierra sesion en la aplicacion por la pantalla de inicio
    Y Santiago ingresa con el usuario: ribana1234_ y la clave: Prueba123##
    Entonces el deberia ver el mensaje de extrafinanciamiento

  @48464-3
  Escenario: Cancelar la Toma del extrafinanciamiento
    Dado que Santiago quiere ingresar con el usuario: ribana1234_ y la clave: Prueba123##
    Cuando el solicita el extrafinanciamiento por 600 dolares a 12 cuotas con descripcion Pruebas automatizadas
    Y el cancela la transaccion en la pantalla de Verificación
    Entonces el usuario verifica que el saldo de su cuenta no se modifico

  @48464-4
  Escenario: Tomar el extrafinanciamiento
    Dado que Santiago quiere ingresar con el usuario: ribana1234_ y la clave: Prueba123##
    Cuando el solicita el extrafinanciamiento por 1000 dolares a 18 cuotas con descripcion Pruebas automatizadas
    Y el termina la transaccion de extrafinanciamiento
    Entonces el verifica que los datos del extrafinanciamiento
    Y el verifica que el saldo de la cuenta aumentó en el monto aprobado