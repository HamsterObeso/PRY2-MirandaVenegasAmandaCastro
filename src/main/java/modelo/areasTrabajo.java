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
public class areasTrabajo {

    public String IDarea;
    public String nombre;
    
    public String getIDarea() {
        return IDarea;
    }

    public String getNombre() {
        return nombre;
    }

    public void setIDarea(String IDarea) {
        this.IDarea = IDarea;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public areasTrabajo(String IDarea, String nombre) {
        this.IDarea = IDarea;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "areasTrabajo{" + "IDarea=" + IDarea + ", nombre=" + nombre + '}';
    }
    

    
    
    
}
