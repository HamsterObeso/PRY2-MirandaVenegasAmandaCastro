package formulario;

/**
 *
 * @author Muro
 */
public class DocEnfDetalleHospitalizacion {
  private String nombrePaciente = "";

  public String getNombrePaciente() {
    return nombrePaciente;
  }

  public void setNombrePaciente(String nombrePaciente) {
    this.nombrePaciente = nombrePaciente;
  }

  @Override public String toString() {
    return "DocEnfDetalleHospitalizacion{" + "nombrePaciente=" + nombrePaciente + '}';
  }
}
