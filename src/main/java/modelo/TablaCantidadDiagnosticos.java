package modelo;

/**
 *
 * @author Muro
 */
public class TablaCantidadDiagnosticos {
  private int cantidadDiagnosticos;
  private String nivel;
  private String especialidad;
  private String paciente;

  public TablaCantidadDiagnosticos(int cantidadDiagnosticos, String nivel, String especialidad, String paciente) {
    this.cantidadDiagnosticos = cantidadDiagnosticos;
    this.nivel = nivel;
    this.especialidad = especialidad;
    this.paciente = paciente;
  }

  public int getCantidadDiagnosticos() {
    return cantidadDiagnosticos;
  }

  public void setCantidadDiagnosticos(int cantidadDiagnosticos) {
    this.cantidadDiagnosticos = cantidadDiagnosticos;
  }

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

  public String getPaciente() {
    return paciente;
  }

  public void setPaciente(String paciente) {
    this.paciente = paciente;
  }
  
}
