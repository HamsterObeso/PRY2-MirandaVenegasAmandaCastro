package modelo;

/**
 *
 * @author Muro
 */
public class TablaCitasDE {
  private int id = -1;
  private String especialidad;
  private String fecha;
  private String hora;
  private String observacion;
  private String estado;
  private String nombrePaciente;

  public TablaCitasDE(int id, String especialidad, String fecha, String hora, String observacion, String estado, String nombrePaciente) {
    this.id = id;
    this.especialidad = especialidad;
    this.fecha = fecha;
    this.hora = hora;
    this.observacion = observacion;
    this.estado = estado;
    this.nombrePaciente = nombrePaciente;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
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

  public String getNombrePaciente() {
    return nombrePaciente;
  }

  public void setNombrePaciente(String nombrePaciente) {
    this.nombrePaciente = nombrePaciente;
  }
  
}
