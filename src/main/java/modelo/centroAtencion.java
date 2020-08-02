package modelo;

/**
 *
 * @author Amanda Castro, Miranda Venegas
 */
public class CentroAtencion {
    
    
    public String id;
    public String nombre;
    public String lugar;
    public int capacidad;
    public String tipo;

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getLugar() {
        return lugar;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override public String toString() {
        return "centroAtencion{" + "codigoCentro=" + id + ", nombre=" + nombre + ", lugar=" +
          lugar + ", capacidadMax=" + capacidad + ", tipo=" + tipo + '}';
    }
     
}
