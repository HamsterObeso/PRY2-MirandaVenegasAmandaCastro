package formulario;

/**
 *
 * @author Miranda Amanda 
 */
public class SecretarioHospitalizacionesRegistradas {
    private String fechaIni1 = "";
    private String fechaFin1 = "";
    private String fechaIni2 = "";
    private String fechaFin2 = "";
    private String estado = "";
    private String especialidad = "";
    private String nombrePaciente = "";

    public void setFechaIni1(String fechaIni1) {
        this.fechaIni1 = fechaIni1;
    }

    public void setFechaFin1(String fechaFin1) {
        this.fechaFin1 = fechaFin1;
    }

    public void setFechaIni2(String fechaIni2) {
        this.fechaIni2 = fechaIni2;
    }

    public void setFechaFin2(String fechaFin2) {
        this.fechaFin2 = fechaFin2;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public String getFechaIni1() {
        return fechaIni1;
    }

    public String getFechaFin1() {
        return fechaFin1;
    }

    public String getFechaIni2() {
        return fechaIni2;
    }

    public String getFechaFin2() {
        return fechaFin2;
    }

    public String getEstado() {
        return estado;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }
    
    @Override public String toString() {
        return "SecretarioHospitalizacionesRegistradas{" + "fechaIni1=" + 
        fechaIni1 + ", fechaFin1=" + fechaFin1 + ", fechaIni2=" + fechaIni2 + 
        ", fechaFin2=" + fechaFin2 + ", estado=" + estado + ", especialidad=" +
        especialidad + ", nombrePaciente=" + nombrePaciente + '}';
    }
  
}
