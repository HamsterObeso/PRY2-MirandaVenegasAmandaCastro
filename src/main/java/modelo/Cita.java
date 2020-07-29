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

  public int getIdCita() {
    return idCita;
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

    @Override
    public String toString() {
        return "citas{" + "especialidad=" + especialidad + ", fechaHora=" + fechahora + ", observacion=" + observacion + ", estado=" + estado + '}';
    }

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

  @Override public String toString() {
      return "citas{" + "especialidad=" + especialidad + ", fechaHora=" + fechaHora +
        ", observacion=" + observacion + ", estado=" + estado + '}';
  }
}
