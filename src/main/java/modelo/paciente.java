package modelo;

/**
 *
 * @author Masiel Castro Mora
 */

public class Paciente {
  private int idPaciente;
  private String identificacion;
  private String nombrePaciente;
  private String fechaNacimiento;
  private String tipoSangre;
  private String nacionalidad;
  private String provincia;
  private String correo;
  private String canton;
  private String opcion;
  private String usuario;
  private String contraseña;

  public String getUsuario() {
    return usuario;
  }

  public void setUsuario(String usuario) {
    this.usuario = usuario;
  }

  public String getContraseña() {
    return contraseña;
  }

  public void setContraseña(String contraseña) {
    this.contraseña = contraseña;
  }

  public String getIdentificacion() {
    return identificacion;
  }

  public void setIdentificacion(String identificacion) {
    this.identificacion = identificacion;
  }

  public String getOpcion() {
    return opcion;
  }

  public void setOpcion(String opcion) {
    this.opcion = opcion;
  }

  public String getCorreo() {
    return correo;
  }

  public void setCorreo(String correo) {
    this.correo = correo;
  }

  public String getProvincia() {
    return provincia;
  }

  public void setProvincia(String provincia) {
    this.provincia = provincia;
  }

  public String getCanton() {
    return canton;
  }

  public void setCanton(String canton) {
    this.canton = canton;
  }

  public int getIdPaciente() {
    return idPaciente;
  }

  public String getNombrePaciente() {
    return nombrePaciente;
  }

  public String getFechaNacimiento() {
    return fechaNacimiento;
  }

  public String getTipoSangre() {
    return tipoSangre;
  }

  public String getNacionalidad() {
    return nacionalidad;
  }

  public void setIdPaciente(int idPaciente) {
    this.idPaciente = idPaciente;
  }

  public void setNombrePaciente(String nombrePaciente) {
    this.nombrePaciente = nombrePaciente;
  }

  public void setFechaNacimiento(String fechaNacimiento) {
    this.fechaNacimiento = fechaNacimiento;
  }

  public void setTipoSangre(String tipoSangre) {
    this.tipoSangre = tipoSangre;
  }

  public void setNacionalidad(String nacionalidad) {
    this.nacionalidad = nacionalidad;
  }
  @Override public String toString() {
    return "pacientes{" + "IDpaciente=" + idPaciente + ", nombrePaciente=" + nombrePaciente + 
    ", fechaNacimiento=" + fechaNacimiento + ", tipoSangre=" + tipoSangre + ", nacionalidad=" +
      nacionalidad + ", provincia=" + provincia + ", canton=" + canton + '}';
  }
}
