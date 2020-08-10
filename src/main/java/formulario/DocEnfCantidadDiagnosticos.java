package formulario;

/**
 *
 * @author amanda castro, miranda venegas
 */
public class DocEnfCantidadDiagnosticos {
  private String nivel = "";
  private String especialidad = "";
  private String identificacion = "";
  
  public String getNivel() {
    return nivel;
  }

  public void setNivel(String nivel) {
    this.nivel = nivel;
  }

  public String getEspecialidad() {
    return especialidad;
  }

  public void setEspecialidad(String especialidad) {
    this.especialidad = especialidad;
  }

  public String getIdentificacion() {
    return identificacion;
  }

  public void setIdentificacion(String identificacion) {
    this.identificacion = identificacion;
  }

  @Override public String toString() {
    return "DocEnfCantidadDiagnosticos{" + "nivel=" + nivel + ", especialidad=" + especialidad +
      ", identificacion=" + identificacion + '}';
  }
  
  
}
