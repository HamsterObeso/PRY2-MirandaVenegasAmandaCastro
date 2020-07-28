package modelo;

import java.time.LocalDateTime;

/**
 *
 * @author Masiel Castro Mora
 */
public class Cita {
  
    private String especialidad;
    private LocalDateTime fechaHora;
    private String observacion;
    private String estado;
    
    public String getEspecialidad() {
        return especialidad;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public String getObservacion() {
        return observacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "citas{" + "especialidad=" + especialidad + ", fechaHora=" + fechaHora + ", observacion=" + observacion + ", estado=" + estado + '}';
    }
    
}

