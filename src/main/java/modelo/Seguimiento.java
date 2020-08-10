package modelo;

/**
 *
 * @author Miranda, Amanda 
 */
public class Seguimiento {
  private int idHospitalizacion;
  private String observacion;
  private String tratamientoAsociado;

  public int getIdHospitalizacion() {
    return idHospitalizacion;
  }

  public void setIdHospitalizacion(int idHospitalizacion) {
    this.idHospitalizacion = idHospitalizacion;
  }

  public String getObservacion() {
    return observacion;
  }

  public void setObservacion(String observacion) {
    this.observacion = observacion;
  }

  public String getTratamientoAsociado() {
    return tratamientoAsociado;
  }

  public void setTratamientoAsociado(String tratamientoAsociado) {
    this.tratamientoAsociado = tratamientoAsociado;
  }

  @Override public String toString() {
    return "Seguimientos{" + "idHospitalizacion=" + idHospitalizacion + ", observacion=" + 
      observacion + ", tratamientoAsociado=" + tratamientoAsociado + '}';
  }
}
