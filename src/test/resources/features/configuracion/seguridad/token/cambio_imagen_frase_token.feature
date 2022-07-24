#language:es

@CambioDeImagenFraseToken
Característica: Cambio imagen y frase con token
  Como usuario de app Banistmo SVP
  Quiero ingresar a Cambio imagen y frase de seguiridad
  Para modificar dichos datos

  @CambioDeImagenFraseExitosoToken
  Escenario: Cambio de imagen y frase exitoso con token
    Dado que Ivan quiere inscribir token con usuario elizabeth1234 y clave Prueba123##
    Y el registra el token en el dispositivo con descripcion: CAMBIOIMAGENFRASE
    Y el inicia sesion en la app
    Cuando el realiza el cambio de imagen y nueva frase de seguridad automatizacion
    Y el guarda los cambios realizados de imagen y frase con validacion token
    Entonces el confirma que los datos de seguridad fueron modificados exitosamente