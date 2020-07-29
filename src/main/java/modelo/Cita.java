package modelo;

import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Masiel Castro Mora
 */
public class Cita {

    private String especialidad;
    private String observacion;
    private String estado;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate fechahora;

    public String getEspecialidad() {
        return especialidad;
    }

    public LocalDate getFechahora() {
        return fechahora;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public void setFechahora(LocalDate fechaHora) {
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
