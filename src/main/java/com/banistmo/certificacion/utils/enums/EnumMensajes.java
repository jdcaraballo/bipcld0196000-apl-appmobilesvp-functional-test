package com.banistmo.certificacion.utils.enums;

public enum EnumMensajes {
  CREDENCIALES_BLOQUEADAS("El usuario ha sido bloqueado por seguridad."),
  ERROR_CREDENCIALES("La información no es válida. Por favor verifica los datos de ingreso."),
  TRANSFERENCIA_EXITOSA("La transferencia se ha ejecutado exitosamente"),
  TRANSACCION_EXITOSA("La transacción se ha ejecutado exitosamente"),
  PAGO_EXITOSO("El pago se ha realizado de manera exitosa"),
  PAGO_EJECUTADO_EXITOSO("El pago se ha ejecutado exitosamente"),
  MENSAJE_INSCRIPCION_TOKEN("Ingresa tu número de Soft Token."),
  PAGO_EXITOSO_SEGUNDO_MENSAJE("El pago se ha realizado de manera exitosa"),
  RECARGA_EXITOSA("La recarga se ha relizado de manera exitosa."),
  MENSAJE_EXITOSO_PAGO_PROGRAMADA("El pago se ha programado exitosamente"),
  MENSAJE_EXITOSO_PAGO_SERVICIO_PROGRAMADA("Tu pago se ha programado exitosamente"),
  TRANSFERENCIA_PROGRAMADA_EXITOSA("La programación se ha editado de manera exitosa "),
  MENSAJE_EXITOSO_PAGO_ACTUALIZADO(
      "Los datos de la programación han sido actualizados correctamente. "),
  MENSAJE_EXITOSO_PAGO_PROGRAMADO_ELIMINADO("Tu pago programado se ha eliminado correctamente."),
  INSCRIPCION_TOKEN_EXITOSA("¡Inscripción exitosa!"),
  TOKEN_ELIMINADO_EXITOSO(" Has eliminado el token exitosamente "),
  TRANSFERENCIA_PROGRAMADA_EDITADA_EXITOSAMENTE("La programación se ha editado de manera exitosa "),
  MENSAJE_EXITOSO_TRANSFERENCIA_PROGRAMADA_ELIMINADA(
      "La transacción ha sido eliminada exitosamente "),
  MENSAJE_EXITOSO_TRANSFERENCIA_PROGRAMADA(
          "La transacción se ha programado exitosamente "),
  CAMBIO_DE_IMAGEN_FRASE_EXITOSO("La imagen y frase de seguridad se ha actualizado correctamente"),
  ENCRYPT_ERROR("An error occurred while encrypting"),
  DECRYPT_ERROR("An error occurred while decrypting"),
  GUARDADO_CORRECTAMENTE("Se ha guardado correctamente");

  private final String mensaje;

  EnumMensajes(String mensaje) {
    this.mensaje = mensaje;
  }

  public String getMensaje() {
    return mensaje;
  }
}
