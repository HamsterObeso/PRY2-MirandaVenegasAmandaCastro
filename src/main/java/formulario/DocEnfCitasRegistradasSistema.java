package formulario;

/**
 *
 * @author Muro
 */
public class DocEnfCitasRegistradasSistema {
  private String fecha1;
  private String fecha2;
  private String estado;
  private String especialidad;
  private String nombrePaciente;

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

  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  public String getEspecialidad() {
    return especialidad;
  }

  public void setEspecialidad(String especialidad) {
    this.especialidad = especialidad;
  }

  public String getNombrePaciente() {
    return nombrePaciente;
  }

  public void setNombrePaciente(String nombrePaciente) {
    this.nombrePaciente = nombrePaciente;
  }

  @Override
  public String toString() {
    return "DocEnfCitasRegistradasSistema{" + "fecha1=" + fecha1 + ", fecha2=" + fecha2 +
      ", estado=" + estado + ", especialidad=" + especialidad + ", nombrePaciente=" +
      nombrePaciente + '}';
  }
  
  
}
