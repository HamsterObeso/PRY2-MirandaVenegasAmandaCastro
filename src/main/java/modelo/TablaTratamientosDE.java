package modelo;

/**
 *
 * @author Muro
 */
public class TablaTratamientosDE {
  private String nombrePaciente;
  private int id = -1;
  private String fecha;
  private String nombreTratamiento;
  private String dosis;
  private String tipo;
  private int idDiagnostico;

  public TablaTratamientosDE(int id, String nombrePaciente, String fecha, String nombreTratamiento, String dosis, String tipo, int idDiagnostico) {
    this.id = id;
    this.nombrePaciente = nombrePaciente;
    this.fecha = fecha;
    this.nombreTratamiento = nombreTratamiento;
    this.dosis = dosis;
    this.tipo = tipo;
    this.idDiagnostico = idDiagnostico;
  }

  public String getNombrePaciente() {
    return nombrePaciente;
  }

  public void setNombrePaciente(String nombrePaciente) {
    this.nombrePaciente = nombrePaciente;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getFecha() {
    return fecha;
  }

  public void setFecha(String fecha) {
    this.fecha = fecha;
  }

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
  
}
