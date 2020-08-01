package modelo;

/**
 *
 * @author Muro
 */
public class TablaHospitalizacionesPaciente {
  private int id = -1;
  private String centro;
  private String identificacion;
  private String nombre;
  private String diagnostico;
  private String fechaIni;
  private String fechaFin;
  private String especialidad;

  public TablaHospitalizacionesPaciente(int id, String centro, String identificacion, String nombre,
    String diagnostico, String fechaIni, String fechaFin, String especialidad) {
    this.id = id;
    this.centro = centro;
    this.identificacion = identificacion;
    this.nombre = nombre;
    this.diagnostico = diagnostico;
    this.fechaIni = fechaIni;
    this.fechaFin = fechaFin;
    this.especialidad = especialidad;
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

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getDiagnostico() {
    return diagnostico;
  }

  public void setDiagnostico(String diagnostico) {
    this.diagnostico = diagnostico;
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
  
}
