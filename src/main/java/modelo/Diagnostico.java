package modelo;

/**
 *
 * @author Miranda Venegas, Amanda Castro 
 */
public class Diagnostico {
  private String nombreDiagnostico;
  private String nivel;
  private String observaciones;

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

  public Diagnostico(String nombreDiagnostico, String nivel, String observaciones) {
    this.nombreDiagnostico = nombreDiagnostico;
    this.nivel = nivel;
    this.observaciones = observaciones;
  }
  
}
