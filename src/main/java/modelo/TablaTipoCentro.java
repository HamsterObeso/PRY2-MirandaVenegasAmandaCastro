package modelo;

/**
 *
 * @author Muro
 */
public class TablaTipoCentro {
  private int id = -1;
  private String nombre;

  public TablaTipoCentro(int id, String nombre) {
    this.id = id;
    this.nombre = nombre;
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
  
}
