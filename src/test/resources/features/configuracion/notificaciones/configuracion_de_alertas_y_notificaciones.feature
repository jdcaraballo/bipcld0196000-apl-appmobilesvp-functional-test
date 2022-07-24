#language: es
@ConfiguracionDeAlertasYNotificaciones @35402
Característica: Configuración de Alertas y Notificaciones APP
  Yo como un usuario del APP de Personas
  Quiero gestionar mis alertas y notificaciones
  Para activar o desactivar y escoger el medio por el cual enviar las alertas y notificaciones

  @35402-1 @35402-2
  Esquema del escenario: Modificar opciones de notificaciones
    Dado que Felipe quiere ingresar con el usuario: reina123_ y la clave: Prueba123##
    Cuando el modifica los datos de la configuracion de notificaciones
      | menu   | opcion   | notificar   | medio   | monto   |
      | <menu> | <opcion> | <notificar> | <medio> | <monto> |
    Y el guarda los cambios realizados en notificaciones
    Entonces el puede observar los cambios en la configuración de notificaciones

    Ejemplos:
      | menu           | opcion                         | notificar | medio    | monto |
      | Pagos          | Pago de servicios con terceros | si        | email    | 1.77  |
      | Pagos          | Pago de Préstamo               | no        |          |       |
      | Transferencias | A Cuentas propias              | si        | email    | 1.95  |
      | Transferencias | Internacionales                | no        |          |       |
      | Recargas       | Todos los servicios            | si        | email    | 2.15  |
      | Compras        | Débito                         | si        | sms,push | 1.03  |
