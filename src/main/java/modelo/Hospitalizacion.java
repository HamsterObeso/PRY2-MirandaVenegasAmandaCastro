package modelo;

/**
 *
 * @author Amanda, Miranda 
 */
public class Hospitalizacion {
  private String nombre;
  private String identificacion;
  private String centro;
  private String especialidad;
  private String diagnostico;
  private String fecha;

  public String getFecha() {
    return fecha;
  }

  public void setFecha(String fecha) {
    this.fecha = fecha;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getIdentificacion() {
    return identificacion;
  }

  public void setIdentificacion(String identificacion) {
    this.identificacion = identificacion;
  }

  public String getCentro() {
    return centro;
  }

  public void setCentro(String centro) {
    this.centro = centro;
  }

  public String getEspecialidad() {
    return especialidad;
  }

  public void setEspecialidad(String especialidad) {
    this.especialidad = especialidad;
  }

  public String getDiagnostico() {
    return diagnostico;
  }

  public void setDiagnostico(String diagnostico) {
    this.diagnostico = diagnostico;
  }
  
  
}
