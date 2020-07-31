package modelo;

/**
 *
 * @author Muro
 */
public class Funcionario {
  private String identificacion;
  private String nombre;
  private String tipoFuncionario;
  private String area;
  private String usuario;
  private String contrasena;

  public String getIdentificacion() {
    return identificacion;
  }

  public void setIdentificacion(String identificacion) {
    this.identificacion = identificacion;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getTipoFuncionario() {
    return tipoFuncionario;
  }

  public void setTipoFuncionario(String tipoFuncionario) {
    this.tipoFuncionario = tipoFuncionario;
  }

  public String getArea() {
    return area;
  }

  public void setArea(String area) {
    this.area = area;
  }

  public String getUsuario() {
    return usuario;
  }

  public void setUsuario(String usuario) {
    this.usuario = usuario;
  }

  public String getContrasena() {
    return contrasena;
  }

  public void setContrasena(String contrasena) {
    this.contrasena = contrasena;
  }

  @Override public String toString() {
    return "Funcionario{" + "identificacion=" + identificacion + ", nombre=" + nombre +
      ", tipoFuncionario=" + tipoFuncionario + ", area=" + area + ", usuario=" + usuario +
      ", contrasena=" + contrasena + '}';
  }
  
  
}
