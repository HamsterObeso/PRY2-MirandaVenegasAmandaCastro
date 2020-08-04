package modelo;

/**
 *
 * @author Muro
 */
public class TablaDetalleHospitalizacion {
  private int id = -1;
  private String centro;
  private String identificacion;
  private String nombrePaciente;
  private String nombreDiag;
  private String fechaIni;
  private String fechaFin;
  private String especialidad;
  private String nombreFuncionario;

  public TablaDetalleHospitalizacion(int id, String centro, String identificacion,
    String nombrePaciente, String nombreDiag, String fechaIni, String fechaFin, String especialidad,
    String nombreFuncionario) {
    this.id = id;
    this.centro = centro;
    this.identificacion = identificacion;
    this.nombrePaciente = nombrePaciente;
    this.nombreDiag = nombreDiag;
    this.fechaIni = fechaIni;
    this.fechaFin = fechaFin;
    this.especialidad = especialidad;
    this.nombreFuncionario = nombreFuncionario;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getCentro() {
    return centro;
  }

  public void setCentro(String centro) {
    this.centro = centro;
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

  public String getNombreDiag() {
    return nombreDiag;
  }

  public void setNombreDiag(String nombreDiag) {
    this.nombreDiag = nombreDiag;
  }

  public String getFechaIni() {
    return fechaIni;
  }

  public void setFechaIni(String fechaIni) {
    this.fechaIni = fechaIni;
  }

  public String getFechaFin() {
    return fechaFin;
  }

  public void setFechaFin(String fechaFin) {
    this.fechaFin = fechaFin;
  }

  public String getEspecialidad() {
    return especialidad;
  }

  public void setEspecialidad(String especialidad) {
    this.especialidad = especialidad;
  }

  public String getNombreFuncionario() {
    return nombreFuncionario;
  }

  public void setNombreFuncionario(String nombreFuncionario) {
    this.nombreFuncionario = nombreFuncionario;
  }
  
}
