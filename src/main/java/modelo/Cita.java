/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Masiel Castro Mora
 */
public class Cita {
 
  
    public String especialidad;
    public String fechaHora;
    public String observacion;
    public String IDcita;
    public String estado;

    public String getEspecialidad() {
        return especialidad;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public String getObservacion() {
        return observacion;
    }

    public String getIDcita() {
        return IDcita;
    }

    public String getEstado() {
        return estado;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public void setIDcita(String IDcita) {
        this.IDcita = IDcita;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Cita(String especialidad, String fechaHora, String observacion, String IDcita, String estado) {
        this.especialidad = especialidad;
        this.fechaHora = fechaHora;
        this.observacion = observacion;
        this.IDcita = IDcita;
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "citas{" + "especialidad=" + especialidad + ", fechaHora=" + fechaHora + ", observacion=" + observacion + ", IDcita=" + IDcita + ", estado=" + estado + '}';
    }
    

}

