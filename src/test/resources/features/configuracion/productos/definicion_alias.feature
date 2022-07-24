#language:es

@DefinicionAlias @21039
Característica: Definicion de Alias de Productos
  Yo como usuario de la aplicacion movil de Banistmo
  Quiero asignar un alias a los productos que tengo asociado a mi usuario
  Para identificar mis productos con mayor facilidad

  @21039-1
  Escenario: Definicion de alias exitoso a un producto desde el menu de configuracion
    Dado que Felipe quiere ingresar con el usuario: EXTRAFIN11_ y la clave: Prueba123##
    Cuando el cambie el alias del producto por: Prueba Cambio Alias
    Entonces el observara el nuevo Alias

  @21039-2
  Escenario: Definición de Alias repetido
    Dado que Felipe quiere ingresar con el usuario: EXTRAFIN11_ y la clave: Prueba123##
    Cuando el cambie el alias del producto Cuenta Ahorros por: Cuenta Corriente
    Entonces deberia ver el siguiente mensaje: Este nombre ya se encuentra asignado, por favor intenta un nombre diferente
    