package modelo;

/**
 *
 * @author Masiel Castro Mora
 */
public class Cita {

    private String especialidad;
    private String observacion;
    private String estado;
    private int idCita;
    private String fechahora;
    
    public int getIdCita() {
      return idCita;
    }
   
    public void setIdCita(int idCita) {
      this.idCita = idCita;
    }  

    public String getEspecialidad() {
        return especialidad;
    }

    public String getFechahora() {
        return fechahora;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public void setFechahora(String fechaHora) {
        this.fechahora = fechaHora;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }
    
    @Override
    public String toString() {
        return "citas{" + "especialidad=" + especialidad + ", fechaHora=" + fechahora + ", observacion=" + observacion + ", estado=" + estado + '}';
    }

}
