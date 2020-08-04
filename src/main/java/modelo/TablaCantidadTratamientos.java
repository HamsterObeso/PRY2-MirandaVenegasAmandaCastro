package modelo;

/**
 *
 * @author Muro
 */
public class TablaCantidadTratamientos {
  private int cantidadTratamientos;
  private String tipoTratamiento; 
  private String especialidad;
  private String paciente;

  public TablaCantidadTratamientos(int cantidadTratamientos, String tipoTratamiento, String especialidad, String paciente) {
    this.cantidadTratamientos = cantidadTratamientos;
    this.tipoTratamiento = tipoTratamiento;
    this.especialidad = especialidad;
    this.paciente = paciente;
  }

  public int getCantidadTratamientos() {
    return cantidadTratamientos;
  }

  public void setCantidadTratamientos(int cantidadTratamientos) {
    this.cantidadTratamientos = cantidadTratamientos;
  }

  public String getTipoTratamiento() {
    return tipoTratamiento;
  }

  public void setTipoTratamiento(String tipoTratamiento) {
    this.tipoTratamiento = tipoTratamiento;
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
