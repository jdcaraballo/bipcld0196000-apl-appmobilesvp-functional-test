package com.banistmo.certificacion.models.builders;

import java.util.List;
import java.util.Map;

public class RegisterBuilder {

  private String tipoid;
  private String nroid;
  private String correo;

  public String getTipoid() {
    return tipoid;
  }
  public String getNroid() {return nroid;}
  public String getCorreo() {return correo;}

  public static RegisterBuilder con() {
    return new RegisterBuilder();
  }

  public RegisterBuilder tipoid(List<Map<String, String>> datos) {
    this.tipoid = datos.get(0).get("tipo id");
    return this;
  }

  public RegisterBuilder nroid(List<Map<String, String>> datos) {
    this.nroid = datos.get(0).get("nro id");
    return this;
  }

  public RegisterBuilder correo(List<Map<String, String>> datos) {
    this.correo = datos.get(0).get("correo");
    return this;
  }

  public Create build() {
    return new Create(this);
  }


}
