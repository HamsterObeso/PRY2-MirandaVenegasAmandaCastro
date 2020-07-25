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
public class funcionario {
    public String identificacion;
    public String nombre;
    public String tipo;
    public String fechaIngreso;
    public String areaTrabajo;

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public void setAreaTrabajo(String areaTrabajo) {
        this.areaTrabajo = areaTrabajo;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public String getAreaTrabajo() {
        return areaTrabajo;
    }
    
    @Override
    public String toString() {
        return "funcionario{" + "identificacion=" + identificacion + ", nombre=" + nombre + ", tipo=" + tipo + ", fechaIngreso=" + fechaIngreso + ", areaTrabajo=" + areaTrabajo + '}';
    }

    public funcionario(String identificacion, String nombre, String tipo, String fechaIngreso, String areaTrabajo) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.tipo = tipo;
        this.fechaIngreso = fechaIngreso;
        this.areaTrabajo = areaTrabajo;
    }
    
}
