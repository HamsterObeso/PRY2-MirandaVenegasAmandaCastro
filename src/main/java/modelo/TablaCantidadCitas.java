package modelo;

/**
 *
 * @author Miranda, Amanda
 */
public class TablaCantidadCitas {
  private int cantidadCitas;
  private String fechaInicial;
  private String fechaFinal;
  private String especialidad;
  private String estado;

  public TablaCantidadCitas(int cantidadCitas, String fechaInicial, String fechaFinal, String especialidad, String estado) {
    this.cantidadCitas = cantidadCitas;
    this.fechaInicial = fechaInicial;
    this.fechaFinal = fechaFinal;
    this.especialidad = especialidad;
    this.estado = estado;
  }

  public int getCantidadCitas() {
    return cantidadCitas;
  }

  public void setCantidadCitas(int cantidadCitas) {
    this.cantidadCitas = cantidadCitas;
  }

  public String getFechaInicial() {
    return fechaInicial;
  }

  public void setFechaInicial(String fechaInicial) {
    this.fechaInicial = fechaInicial;
  }

  public String getFechaFinal() {
    return fechaFinal;
  }

  public void setFechaFinal(String fechaFinal) {
    this.fechaFinal = fechaFinal;
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
