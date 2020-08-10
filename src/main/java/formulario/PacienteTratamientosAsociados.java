package formulario;

/**
 *
 * @author Miranda Amanda 
 */
public class PacienteTratamientosAsociados {
  private String fecha1 = "";
  private String fecha2 = "";
  private String tipoTratamiento = "";
  private String nombre = "";

  public String getFecha1() {
    return fecha1;
  }

  public void setFecha1(String fecha1) {
    this.fecha1 = fecha1;
  }

  public String getFecha2() {
    return fecha2;
  }

  public void setFecha2(String fecha2) {
    this.fecha2 = fecha2;
  }

  public String getTipoTratamiento() {
    return tipoTratamiento;
  }

  public void setTipoTratamiento(String tipoTratamiento) {
    this.tipoTratamiento = tipoTratamiento;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  @Override
  public String toString() {
    return "PacienteTratamientosAsociados{" + "fecha1=" + fecha1 + ", fecha2=" + fecha2 + 
      ", tipoTratamiento=" + tipoTratamiento + ", nombre=" + nombre + '}';
  }
  
  
}
