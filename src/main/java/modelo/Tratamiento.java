package modelo;

/**
 *
 * @author Miranda Amanda 
 */
public class Tratamiento {
  private String nombreTratamiento;
  private String dosis;
  private String tipo;
  private int idDiagnostico;

  public String getNombreTratamiento() {
    return nombreTratamiento;
  }

  public void setNombreTratamiento(String nombreTratamiento) {
    this.nombreTratamiento = nombreTratamiento;
  }

  public String getDosis() {
    return dosis;
  }

  public void setDosis(String dosis) {
    this.dosis = dosis;
  }

  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public int getIdDiagnostico() {
    return idDiagnostico;
  }

  public void setIdDiagnostico(int idDiagnostico) {
    this.idDiagnostico = idDiagnostico;
  }

  @Override
  public String toString() {
    return "Tratamiento{" + "nombreTratamiento=" + nombreTratamiento + ", dosis=" + dosis +
      ", tipo=" + tipo + ", idDiagnostico=" + idDiagnostico + '}';
  }
  
}
