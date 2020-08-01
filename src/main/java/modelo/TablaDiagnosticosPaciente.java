package modelo;

/**
 *
 * @author Muro
 */
public class TablaDiagnosticosPaciente {
  private int id = -1;
  private int idCita;
  private String diagnostico;
  private String nivel;
  private String observaciones;
  private String fechaCita;

  public TablaDiagnosticosPaciente(int id, int idCita, String diagnostico, String nivel, String observaciones, String fechaCita) {
    this.id = id;
    this.idCita = idCita;
    this.diagnostico = diagnostico;
    this.nivel = nivel;
    this.observaciones = observaciones;
    this.fechaCita = fechaCita;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getIdCita() {
    return idCita;
  }

  public void setIdCita(int idCita) {
    this.idCita = idCita;
  }

  public String getDiagnostico() {
    return diagnostico;
  }

  public void setDiagnostico(String diagnostico) {
    this.diagnostico = diagnostico;
  }

  public String getNivel() {
    return nivel;
  }

  public void setNivel(String nivel) {
    this.nivel = nivel;
  }

  public String getObservaciones() {
    return observaciones;
  }

  public void setObservaciones(String observaciones) {
    this.observaciones = observaciones;
  }

  public String getFechaCita() {
    return fechaCita;
  }

  public void setFechaCita(String fechaCita) {
    this.fechaCita = fechaCita;
  }
  
}
