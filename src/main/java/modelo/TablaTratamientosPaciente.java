package modelo;

/**
 *
 * @author Miranda, Amanda 
 */
public class TablaTratamientosPaciente {
  private int id = -1;
  private String nombre;
  private String dosis;
  private String tipoMedicamento;
  private String fechaCita;
  private String diagnostico;

  public TablaTratamientosPaciente(int id, String nombre, String dosis, String tipoMedicamento, String fechaCita, String diagnostico) {
    this.id = id;
    this.nombre = nombre;
    this.dosis = dosis;
    this.tipoMedicamento = tipoMedicamento;
    this.fechaCita = fechaCita;
    this.diagnostico = diagnostico;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getDosis() {
    return dosis;
  }

  public void setDosis(String dosis) {
    this.dosis = dosis;
  }

  public String getTipoMedicamento() {
    return tipoMedicamento;
  }

  public void setTipoMedicamento(String tipoMedicamento) {
    this.tipoMedicamento = tipoMedicamento;
  }

  public String getFechaCita() {
    return fechaCita;
  }

  public void setFechaCita(String fechaCita) {
    this.fechaCita = fechaCita;
  }

  public String getDiagnostico() {
    return diagnostico;
  }

  public void setDiagnostico(String diagnostico) {
    this.diagnostico = diagnostico;
  }
  
}
