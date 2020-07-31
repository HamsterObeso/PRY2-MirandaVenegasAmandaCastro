package modelo;

/**
 *
 * @author Muro
 */
public class CatalogoTratamiento {
  
  private String nombre;
  private String diagnostico;
  private int id = -1;

  public CatalogoTratamiento(String nombre, String diagnostico, int id) {
    this.nombre = nombre;
    this.diagnostico = diagnostico;
    this.id = id;
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

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }
  
}
