package modelo;

/**
 *
 * @author De quien sea, ya vale verga
 */
public class CatalogoDiagnostico {
  
  private String nombre;
  private int id = -1;

  public CatalogoDiagnostico(String nombre, int id) {
    this.nombre = nombre;
    this.id = id;
  }
  
  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }
  
}
