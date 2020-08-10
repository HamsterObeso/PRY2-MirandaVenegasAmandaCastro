package modelo;

/**
 *
 * @author Miranda, Amanda 
 */
public class TablaCita {
  private int idCita = -1;
  private String especialidad;
  private String fecha;
  private String hora;
  private String observacion;
  private String estado;

  public TablaCita(int idCita, String especialidad, String fecha, String hora, String observacion, String estado) {
    this.idCita = idCita;
    this.especialidad = especialidad;
    this.fecha = fecha;
    this.hora = hora;
    this.observacion = observacion;
    this.estado = estado;
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

  public void setEspecialidad(String especialidad) {
    this.especialidad = especialidad;
  }

  public String getFecha() {
    return fecha;
  }

  public void setFecha(String fecha) {
    this.fecha = fecha;
  }

  public String getHora() {
    return hora;
  }

  public void setHora(String hora) {
    this.hora = hora;
  }

  public String getObservacion() {
    return observacion;
  }

  public void setObservacion(String observacion) {
    this.observacion = observacion;
  }

  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }
  
}
