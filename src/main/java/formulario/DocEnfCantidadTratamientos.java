package formulario;

/**
 *
 * @author Muro
 */
public class DocEnfCantidadTratamientos {
  private String tratamiento;
  private String especialidad;
  private String identificacion;

  public String getTratamiento() {
    return tratamiento;
  }

  public void setTratamiento(String tratamiento) {
    this.tratamiento = tratamiento;
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
    return "DocEnfCantidadTratamientos{" + "tratamiento=" + tratamiento + ", especialidad=" +
      especialidad + ", identificacion=" + identificacion + '}';
  }
  
  
}
