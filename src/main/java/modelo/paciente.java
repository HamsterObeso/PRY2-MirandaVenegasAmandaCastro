package modelo;

/**
 *
 * @author Masiel Castro Mora
 */

public class Paciente {
  public String IDpaciente;
  public String nombrePaciente;
  public String fechaNacimiento;
  public String tipoSangre;
  public String nacionalidad;
  public String provincia;
  public String correo;
  public String canton;
  public String telefono;

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

  public String getIDpaciente() {
    return IDpaciente;
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

  public String getTelefono() {
    return telefono;
  }

  public void setIDpaciente(String IDpaciente) {
    this.IDpaciente = IDpaciente;
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


  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  public Paciente(String IDpaciente, String nombrePaciente, String fechaNacimiento, String
    tipoSangre, String nacionalidad, String provincia, String canton, String telefono) {
    this.IDpaciente = IDpaciente;
    this.nombrePaciente = nombrePaciente;
    this.fechaNacimiento = fechaNacimiento;
    this.tipoSangre = tipoSangre;
    this.nacionalidad = nacionalidad;
    this.provincia = provincia;
    this.canton = canton;
    this.telefono = telefono;
  }

  @Override public String toString() {
    return "pacientes{" + "IDpaciente=" + IDpaciente + ", nombrePaciente=" + nombrePaciente + 
    ", fechaNacimiento=" + fechaNacimiento + ", tipoSangre=" + tipoSangre + ", nacionalidad=" +
      nacionalidad + ", provincia=" + provincia + ", canton=" + canton + ", telefono=" +
      telefono + '}';
  }
}
