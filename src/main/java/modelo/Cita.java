package modelo;

/**
 *
 * @author Masiel Castro Mora
 */
public class Cita {

  private String especialidad;
  private String observacion;
  private String estado;
  private int idCita;
  private String fecha;
  private String hora;

  public String getHora() {
    return hora;
  }

  public void setHora(String hora) {
    this.hora = hora;
  }
    
  public int getIdCita() {
    return idCita;
  }

  public void setIdCita(int idCita) {
    this.idCita = idCita;
  }  

  public String getEspecialidad() {
      return especialidad;
  }

  public String getFecha() {
      return fecha;
  }

  public String getObservacion() {
      return observacion;
  }

  public void setEspecialidad(String especialidad) {
      this.especialidad = especialidad;
  }

  public void setFecha(String fecha) {
      this.fecha = fecha;
  }

  public void setObservacion(String observacion) {
      this.observacion = observacion;
  }

  public void setEstado(String estado) {
      this.estado = estado;
  }

  public String getEstado() {
      return estado;
  }

  @Override
  public String toString() {
      return "citas{" + "especialidad=" + especialidad + ", fecha=" + fecha + ", hora=" + hora 
        + "observacion=" + observacion + ", estado=" + estado + '}';
  }
  
}
