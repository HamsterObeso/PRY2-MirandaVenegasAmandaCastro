package formulario;

/**
 *
 * @author Muro
 */
public class DocEnfTratamientosAsociadosPaciente {
  private String fecha1 = "";
  private String fecha2 = "";
  private String tipoTratamiento = "";
  private String nombreTratamiento = "";
  private String identificacion = "";

  public String getFecha1() {
    return fecha1;
  }

  public void setFecha1(String fecha1) {
    this.fecha1 = fecha1;
  }

  public String getFecha2() {
    return fecha2;
  }

  public void setFecha2(String fecha2) {
    this.fecha2 = fecha2;
  }

  public String getTipoTratamiento() {
    return tipoTratamiento;
  }

  public void setTipoTratamiento(String tipoTratamiento) {
    this.tipoTratamiento = tipoTratamiento;
  }

  public String getNombreTratamiento() {
    return nombreTratamiento;
  }

  public void setNombreTratamiento(String nombreTratamiento) {
    this.nombreTratamiento = nombreTratamiento;
  }

  public String getIdentificacion() {
    return identificacion;
  }

  public void setIdentificacion(String identificacion) {
    this.identificacion = identificacion;
  }

  @Override public String toString() {
    return "DocEnfTratamientosAsociadosPaciente{" + "fecha1=" + fecha1 + ", fecha2=" + fecha2 +
      ", tipoTratamiento=" + tipoTratamiento + ", nombreTratamiento=" + nombreTratamiento + '}';
  }
  
  
}
