package modelo;

/**
 *
 * @author Muro
 */
public class TablaCentrosAtencion {
  private int id = -1;
  private String nombre;
  private int capacidad;
  private String tipoCentro;
  private String lugar; 

  public TablaCentrosAtencion(int id, String nombre, String lugar, int capacidad, String tipoCentro) {
    this.id = id;
    this.nombre = nombre;
    this.lugar = lugar;
    this.capacidad = capacidad;
    this.tipoCentro = tipoCentro;
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

  public int getCapacidad() {
    return capacidad;
  }

  public void setCapacidad(int capacidad) {
    this.capacidad = capacidad;
  }

  public String getTipoCentro() {
    return tipoCentro;
  }

  public void setTipoCentro(String tipoCentro) {
    this.tipoCentro = tipoCentro;
  }

  public String getLugar() {
    return lugar;
  }

  public void setLugar(String lugar) {
    this.lugar = lugar;
  }
  
}
