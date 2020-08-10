package formulario;

/**
 *
 * @author Miranda Amanda 
 */
public class FormDiagnostico {
  private String nombreDiagnostico;
  private String nivel;
  private String observaciones;
  private int idDiagnostico;
  private String opcion;

  public String getOpcion() {
    return opcion;
  }

  public void setOpcion(String opcion) {
    this.opcion = opcion;
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

  public int getIdDiagnostico() {
    return idDiagnostico;
  }

  public void setIdDiagnostico(int idDiagnostico) {
    this.idDiagnostico = idDiagnostico;
  }
  
}
