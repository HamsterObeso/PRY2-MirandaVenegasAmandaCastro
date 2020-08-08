package modelo;

/**
 *
 * @author Muro
 */
public class TablaBitácora {
  private int id = -1;
  private String fecha;
  private String usuario;
  private int idCita;
  private String accion;

  public TablaBitácora(int id, String fecha, String usuario, int idCita, String accion) {
    this.id = id;
    this.fecha = fecha;
    this.usuario = usuario;
    this.idCita = idCita;
    this.accion = accion;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getFecha() {
    return fecha;
  }

  public void setFecha(String fecha) {
    this.fecha = fecha;
  }

  public String getUsuario() {
    return usuario;
  }

  public void setUsuario(String usuario) {
    this.usuario = usuario;
  }

  public int getIdCita() {
    return idCita;
  }

  public void setIdCita(int idCita) {
    this.idCita = idCita;
  }

  public String getAccion() {
    return accion;
  }

  public void setAccion(String accion) {
    this.accion = accion;
  }
  
}
