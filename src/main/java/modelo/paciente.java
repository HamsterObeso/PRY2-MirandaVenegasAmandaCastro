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
public class paciente {
     public String IDpaciente;
    public String nombrePaciente;
    public String fechaNacimiento;
    public String tipoSangre;
    public String nacionalidad;
    public String lugarResidencia;
    public String telefono;
    
    public String getIDpaciente() {
        return IDpaciente;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public String getLugarResidencia() {
        return lugarResidencia;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setIDpaciente(String IDpaciente) {
        this.IDpaciente = IDpaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public void setLugarResidencia(String lugarResidencia) {
        this.lugarResidencia = lugarResidencia;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public paciente(String IDpaciente, String nombrePaciente, String fechaNacimiento, String tipoSangre, String nacionalidad, String lugarResidencia, String telefono) {
        this.IDpaciente = IDpaciente;
        this.nombrePaciente = nombrePaciente;
        this.fechaNacimiento = fechaNacimiento;
        this.tipoSangre = tipoSangre;
        this.nacionalidad = nacionalidad;
        this.lugarResidencia = lugarResidencia;
        this.telefono = telefono;
    }
    
    @Override
    public String toString() {
        return "pacientes{" + "IDpaciente=" + IDpaciente + ", nombrePaciente=" + nombrePaciente + ", fechaNacimiento=" + fechaNacimiento + ", tipoSangre=" + tipoSangre + ", nacionalidad=" + nacionalidad + ", lugarResidencia=" + lugarResidencia + ", telefono=" + telefono + '}';
    }

    
}
