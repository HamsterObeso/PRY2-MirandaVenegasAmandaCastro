package formulario;

/**
 *
 * @author Miranda, Amanda 
 */
public class DocEnfDiagnosticosAsociadosPaciente {
  private String fecha1 = "";
  private String fecha2 = "";
  private String nivel = "";
  private String nombre = "";
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

  public String getNivel() {
    return nivel;
  }

  public void setNivel(String nivel) {
    this.nivel = nivel;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getIdentificacion() {
    return identificacion;
  }

  public void setIdentificacion(String identificacion) {
    this.identificacion = identificacion;
  }

  @Override public String toString() {
    return "DocEnfDiagnosticosAsociadosPaciente{" + "fecha1=" + fecha1 + ", fecha2=" + fecha2 +
      ", nivel=" + nivel + ", nombre=" + nombre + ", identificacion=" + identificacion + '}';
  }

  
}
