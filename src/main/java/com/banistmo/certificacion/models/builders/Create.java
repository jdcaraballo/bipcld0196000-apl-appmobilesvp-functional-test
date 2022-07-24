package com.banistmo.certificacion.models.builders;

public class Create {

  private final String tipoid;
  private final String nroid;
  private final String correo;

  public Create(RegisterBuilder builder) {
    this.tipoid = builder.getTipoid();
    this.nroid = builder.getNroid();
    this.correo = builder.getCorreo();

  }

  public String getTipoid() {return tipoid;}
  public String getNroid() {return nroid;}
  public String getCorreo() {return correo;}
}
