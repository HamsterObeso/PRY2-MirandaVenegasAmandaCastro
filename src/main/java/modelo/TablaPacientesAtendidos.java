package modelo;

/**
 *
 * @author Muro
 */
public class TablaPacientesAtendidos {
  private String nombrePaciente;
  private String identificacion;
  private String diagnostico;
  private int idCita;
  private String estado;

  public String getNombrePaciente() {
    return nombrePaciente;
  }

  public void setNombrePaciente(String nombrePaciente) {
    this.nombrePaciente = nombrePaciente;
  }

  public String getIdentificacion() {
    return identificacion;
  }

  public void setIdentificacion(String identificacion) {
    this.identificacion = identificacion;
  }

  public String getDiagnostico() {
    return diagnostico;
  }

  public void setDiagnostico(String diagnostico) {
    this.diagnostico = diagnostico;
  }

  public int getIdCita() {
    return idCita;
  }

  public void setIdCita(int idCita) {
    this.idCita = idCita;
  }

  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  public TablaPacientesAtendidos(String nombrePaciente, String identificacion, String diagnostico, int idCita, String estado) {
    this.nombrePaciente = nombrePaciente;
    this.identificacion = identificacion;
    this.diagnostico = diagnostico;
    this.idCita = idCita;
    this.estado = estado;
  }
  
}
