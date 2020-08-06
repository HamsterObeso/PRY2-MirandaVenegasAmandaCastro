package modelo;

/**
 *
 * @author Muro
 */
public class TablaHospitalizaciones {
  private int id = -1;
  private String centroAtencion;
  private String identificacion;
  private String nombrePaciente;
  private String diagnostico;
  private String fechaInicio;
  private String fechaFinal;
  private String especialidad;
  private String funcionario;

  public TablaHospitalizaciones(int id, String centroAtencion, String identificacion,
    String nombrePaciente, String diagnostico, String fechaInicio, String fechaFinal,
    String especialidad, String funcionario) {
    this.id = id;
    this.centroAtencion = centroAtencion;
    this.identificacion = identificacion;
    this.nombrePaciente = nombrePaciente;
    this.diagnostico = diagnostico;
    this.fechaInicio = fechaInicio;
    this.fechaFinal = fechaFinal;
    this.especialidad = especialidad;
    this.funcionario = funcionario;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getCentroAtencion() {
    return centroAtencion;
  }

  public void setCentroAtencion(String centroAtencion) {
    this.centroAtencion = centroAtencion;
  }

  public String getIdentificacion() {
    return identificacion;
  }

  public void setIdentificacion(String identificacion) {
    this.identificacion = identificacion;
  }

  public String getNombrePaciente() {
    return nombrePaciente;
  }

  public void setNombrePaciente(String nombrePaciente) {
    this.nombrePaciente = nombrePaciente;
  }

  public String getDiagnostico() {
    return diagnostico;
  }

  public void setDiagnostico(String diagnostico) {
    this.diagnostico = diagnostico;
  }

  public String getFechaInicio() {
    return fechaInicio;
  }

  public void setFechaInicio(String fechaInicio) {
    this.fechaInicio = fechaInicio;
  }

  public String getFechaFinal() {
    return fechaFinal;
  }

  public void setFechaFinal(String fechaFinal) {
    this.fechaFinal = fechaFinal;
  }

  public String getEspecialidad() {
    return especialidad;
  }

  public void setEspecialidad(String especialidad) {
    this.especialidad = especialidad;
  }

  public String getFuncionario() {
    return funcionario;
  }

  public void setFuncionario(String funcionario) {
    this.funcionario = funcionario;
  }
  
}
