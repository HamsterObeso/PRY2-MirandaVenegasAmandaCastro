package modelo;

/**
 *
 * @author Amanda Castro, Miranda Venegas 
 */
public class AreasTrabajo {

    public String id;
    public String nombre;
    
    public String getIDarea() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setIDarea(String IDarea) {
        this.id = IDarea;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public AreasTrabajo(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    @Override public String toString() {
        return "areasTrabajo{" + "IDarea=" + id + ", nombre=" + nombre + '}';
    }
    
}
