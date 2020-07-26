/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Amanda Castro, Miranda Venegas
 */
public class CentroAtencion {
    
    
    public String codigoCentro;
    public String nombre;
    public String lugar;
    public int capacidadMax;
    public String tipo;

    public String getCodigoCentro() {
        return codigoCentro;
    }

    public String getNombre() {
        return nombre;
    }

    public String getLugar() {
        return lugar;
    }

    public int getCapacidadMax() {
        return capacidadMax;
    }

    public String getTipo() {
        return tipo;
    }

    public void setCodigoCentro(String codigoCentro) {
        this.codigoCentro = codigoCentro;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public void setCapacidadMax(int capacidadMax) {
        this.capacidadMax = capacidadMax;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public CentroAtencion(String codigoCentro, String nombre, String lugar, int capacidadMax, String tipo) {
        this.codigoCentro = codigoCentro;
        this.nombre = nombre;
        this.lugar = lugar;
        this.capacidadMax = capacidadMax;
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "centroAtencion{" + "codigoCentro=" + codigoCentro + ", nombre=" + nombre + ", lugar=" + lugar + ", capacidadMax=" + capacidadMax + ", tipo=" + tipo + '}';
    }
    
    
    
}
