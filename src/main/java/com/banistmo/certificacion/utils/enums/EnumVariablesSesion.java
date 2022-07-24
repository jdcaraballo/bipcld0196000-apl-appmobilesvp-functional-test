package com.banistmo.certificacion.utils.enums;

public enum EnumVariablesSesion {
  VERIFICAR_TRANSACCION("Verificar Transaccion"),
  NUMERO_CUENTA("Numero Cuenta"),
  VALOR_AHORRO("Valor Ahorro"),
  NOMBRE_NUEVO("Nombre nuevo"),
  NOMBRE_ANTERIOR("Nombre anterior"),
  CONTRASENA("Contrasena"),
  CONTRASENA_NUEVA("Contrasena nueva"),
  DESCRIPCION_PAGO_FECHA_FUTURA("Prueba fecha futura"),
  USUARIO_LOGIN("USUARIO LOGIN"),
  CLAVE_LOGIN("CLAVE LOGIN"),
  OTRO_USUARIO_LOGIN("USUARIO LOGIN"),
  OTRA_CLAVE_LOGIN("CLAVE LOGIN"),
  DESCRIPCION_TOKEN("descripcion token"),
  SALDO_INICIAL_CUENTA("Saldo inicial"),
  VERIFICAR_FRASE_ACTUAL("Verificar frase actual"),
  VERIFICAR_FRASE_NUEVA("Verificar frase nueva"),
  VERIFICAR_IMAGEN_ACTUAL("Imagen actual"),
  VERIFICAR_IMAGEN_NUEVA("Imagen nueva"),
  VERIFICAR_CONFIGURACION_INICIAL("Verificar configuracion inicial"),
  VERIFICAR_CONFIGURACION_ACTUAL("Verificar configuracion actual"),
  NRO_BOLETA_DGI("nroBoletaDGI"),
  VERIFICAR_CONFIGURACION_NUEVA("Verificar configuracion nueva");


  private final String variableSesion;

  EnumVariablesSesion(String variableSesion) {
    this.variableSesion = variableSesion;
  }

  public String getVariableSesion() {
    return variableSesion;
  }
}
