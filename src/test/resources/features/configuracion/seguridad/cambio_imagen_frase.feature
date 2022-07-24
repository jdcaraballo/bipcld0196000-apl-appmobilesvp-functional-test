#language:es
@CambioDeImagenFrase
Característica: Cambio imagen y frase
  Como usuario de app Banistmo SVP
  Quiero ingresar a Cambio imagen y frase de seguiridad
  Para modificar dichos datos

  @CambioDeImagenFraseExitoso
  Escenario: Cambio de imagen y frase exitoso
    Dado que Ivan quiere ingresar con el usuario: Antonio123_ y la clave: Prueba123##
    Cuando el realiza el cambio de imagen y nueva frase de seguridad automatizacion
    Y el guarda los cambios realizados de imagen y frase
    Entonces el confirma que los datos de seguridad fueron modificados exitosamente

  @CancelarCambioDeImagenFrase
  Escenario: Cambio de imagen y frase cancelado
    Dado que Ivan quiere ingresar con el usuario: AutoTDC123_ y la clave: Prueba123##
    Cuando el realiza el cambio de imagen y nueva frase de seguridad automatizacion
    Y el cancela los cambios realizados de imagen y frase
    Entonces el puede ver que los datos de seguridad no fueron modificados

