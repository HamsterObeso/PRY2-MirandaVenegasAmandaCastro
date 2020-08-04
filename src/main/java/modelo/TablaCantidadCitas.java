package modelo;

/**
 *
 * @author Muro
 */
public class TablaCantidadCitas {
  private int cantidadCitas;
  private String fecha;
  private String especialidad;
  private String estado;

  public TablaCantidadCitas(int cantidadCitas, String fecha, String especialidad, String estado) {
    this.cantidadCitas = cantidadCitas;
    this.fecha = fecha;
    this.especialidad = especialidad;
    this.estado = estado;
  }

  public int getCantidadCitas() {
    return cantidadCitas;
  }

  public void setCantidadCitas(int cantidadCitas) {
    this.cantidadCitas = cantidadCitas;
  }

  public String getFecha() {
    return fecha;
  }

  public void setFecha(String fecha) {
    this.fecha = fecha;
  }

  public String getEspecialidad() {
    return especialidad;
  }

  public void setEspecialidad(String especialidad) {
    this.especialidad = especialidad;
  }

  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }
  
}
