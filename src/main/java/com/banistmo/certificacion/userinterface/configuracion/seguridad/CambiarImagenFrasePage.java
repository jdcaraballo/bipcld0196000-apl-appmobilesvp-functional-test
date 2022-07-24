package com.banistmo.certificacion.userinterface.configuracion.seguridad;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CambiarImagenFrasePage {
  public static final Target BTN_EDITAR_FRASE =
      Target.the("Opción editar frase de seguridad").located(By.name("banistmo-edit"));
  public static final Target INPUT_FRASE_DE_SEGURIDAD =
      Target.the("ingreso frase de seguridad").located(By.cssSelector("#inpUser>input"));
  public static final Target BTN_EDITAR_IMAGEN =
      Target.the("Boton editar imagen de seguridad").located(By.name("banistmo-settings"));
  public static final Target LBL_IMAGEN_FRASE =
          Target.the("Titulo de imagenes y frase").located(By.xpath("//h2[.='Cambiar imagen y frase de seguridad']"));
  public static final Target LBL_OPCIONES_IMAGENES =
      Target.the("Opciones para cambio de imagen de seguridad")
          .located(By.xpath("//*[@class='col']"));
  public static final Target BTN_GUARDAR =
      Target.the("Aplicar Cambio de imagen y frase").located(By.cssSelector("#btnSave>button"));
  public static final Target MENSAJE_DATOS_ACTUALIZADOS =
      Target.the("Mensaje cambio exitoso datos").located(By.xpath("success_Msg"));
  public static final Target MENSAJE_IMAGEN_ACTUALIZADA =
          Target.the("Mensaje cambio exitoso datos")
                  .located(By.xpath("//*[@id='success_Msg_Change_Image']"));
  public static final Target MENSAJE_IMAGEN_FRASE_ACTUALIZADOS =
          Target.the("Mensaje cambio exitoso datos").located(By.id("success_Msg_Change_Image"));
  public static final Target LBL_FRASE_MODIFICADA =
      Target.the("Campo frase modificada").located(By.xpath("//*[@class='security-phrase row']/p"));
  public static final Target LBL_FRASE =
      Target.the("Campo frase").located(By.xpath("//p[@class='security-phrase']"));
  public static final Target SUB_OPT_CAMBIO_IMAGEN_FRASE =
      Target.the("Opcion Cambio de imagen y frase")
          .located(By.xpath("//*[text()='Cambiar imagen y frase de seguridad']/ancestor::button"));
  public static final Target LBL_NUEVA_IMAGEN =
      Target.the("Nueva imagen seleccionada").located(By.className("security-img"));
  public static final Target BTN_REGRESAR =
      Target.the("Boton regresar")
          .located(By.xpath("(//button[contains(@class,'back-button')])[last()]"));

  private CambiarImagenFrasePage() {}
}
