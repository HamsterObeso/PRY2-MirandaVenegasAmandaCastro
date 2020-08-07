package modelo;

/**
 *
 * @author Muro
 */
public class TablaDiagnostico {
  private int id = -1;
  private int idCita;
  private String nombreDiagnostico;
  private String nivel;
  private String observaciones;

  public TablaDiagnostico(int id, int idCita, String nombreDiagnostico, String nivel, String observaciones) {
    this.idCita = idCita;
    this.nombreDiagnostico = nombreDiagnostico;
    this.nivel = nivel;
    this.observaciones = observaciones;
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

  public String getNombreDiagnostico() {
    return nombreDiagnostico;
  }

  public void setNombreDiagnostico(String nombreDiagnostico) {
    this.nombreDiagnostico = nombreDiagnostico;
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
  
}
