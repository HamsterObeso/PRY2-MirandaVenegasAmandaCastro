package DAO;

import conexion.ConexionSQL;
import java.sql.CallableStatement;
import java.sql.SQLException;
import modelo.Cita;
import modelo.Paciente;

/**
 *
 * @author Masiel Castro Mora, Amanda Castro 
 */
public class EnfermeroDAO {
    public static Paciente paciente;
    public static Cita cita;
    
    /**
     * Cancelar cita 
     * @param pIDCita identificacion de la cita 
     * @param pIDFuncionario identificacion de funcionario 
     * @throws SQLException 
     */
    public void cancelarCita( int pIDCita, int pIDFuncionario)throws SQLException{
       CallableStatement entrada = ConexionSQL.getConnection().prepareCall("{call cancelarCitaCentro(?,?)}"); 
       entrada.setInt(1, pIDCita);
       entrada.setInt(2, pIDFuncionario);
       entrada.execute();
    }
    /**
     * Registrar diagnostico 
     * @param cita identificacion de la cita 
     * @param nivel nivel
     * @param observaciones observaciones 
     * @param nombreDiagnostico nombre del diagnostico 
     * @throws SQLException 
     */
     public void registrarDiagnosticos(int cita, String nivel, String observaciones, String nombreDiagnostico) throws SQLException{
         CallableStatement entrada = ConexionSQL.getConnection().prepareCall("{call registrarDiagnosticos(?,?,?,?)}");
         entrada.setInt(1, cita);
         entrada.setString(2, nivel);
         entrada.setString(3, observaciones);
         entrada.setString(4, nombreDiagnostico);
         entrada.execute();
    }
    /**
     * Registrar tratamientos 
     * @param nombreTrata nombre del tratamiento
     * @param dosis dosis 
     * @param tipo tipo de tratamiento 
     * @param idDiagnostico identificacion del diagnostico 
     * @throws SQLException 
     */
    public void registrarTratamientos(String nombreTrata, String dosis, String tipo, int idDiagnostico) throws SQLException{
        CallableStatement entrada = ConexionSQL.getConnection().prepareCall("{call registrarTratamientos(?,?,?,?)}");
        entrada.setString(1, nombreTrata);
        entrada.setString(2, dosis);
        entrada.setString(3, tipo);
        entrada.setInt(4, idDiagnostico);
        entrada.execute();
    }
    /**
     * Citas en sistema 
     * @param fecha1 fecha inicial 
     * @param fecha2 fecha final
     * @param estado estado 
     * @param especialidad especialidad
     * @param nombrePaciente nombre paciente 
     * @return las citas en sistemas 
     * @throws SQLException 
     */
    public CallableStatement citasSistemas(String fecha1,String fecha2, String estado, String especialidad, String nombrePaciente) throws SQLException{
        CallableStatement entrada = ConexionSQL.getConnection().prepareCall("{call citasSistemas(?,?,?,?,?)}");
        if (fecha1.isEmpty() == true){
            entrada.setNull(1, java.sql.Types.VARCHAR);
        }else{
            entrada.setString(1,fecha1);
        }
        if (fecha2.isEmpty() == true){
            entrada.setNull(2, java.sql.Types.VARCHAR);
        }else{
            entrada.setString(2,fecha2);
        }
        if (estado.isEmpty() == true){
            entrada.setNull(3, java.sql.Types.VARCHAR);
        }else{
            entrada.setString(3,estado);
        }
        if (especialidad.isEmpty() == true){
            entrada.setNull(4, java.sql.Types.VARCHAR);
        }else{
            entrada.setString(4,especialidad);
        }
        if (nombrePaciente.isEmpty() == true){
            entrada.setNull(5, java.sql.Types.VARCHAR);
        }else{
            entrada.setString(5,nombrePaciente);
        }
        return entrada;
    }
    /**
     * Diagnostico de pacientes
     * @param fecha1 fecha incial 
     * @param fecha2 fecha final 
     * @param nivel nivel
     * @param nombre nombre diagnostico 
     * @param identificacion del paciente 
     * @return diagnsoticos del paciente 
     * @throws SQLException 
     */
    public CallableStatement diagnosticosPaciente(String fecha1, String fecha2, String nivel, String nombre, String identificacion) throws SQLException{
        CallableStatement entrada = ConexionSQL.getConnection().prepareCall("{call diagnosticosPaciente(?,?,?,?,?)}");
        if (fecha1.isEmpty() == true){
            entrada.setNull(1, java.sql.Types.VARCHAR);
        }else{
            entrada.setString(1,fecha1);
        }
        if (fecha2.isEmpty() == true){
            entrada.setNull(2, java.sql.Types.VARCHAR);
        }else{
            entrada.setString(2,fecha2);
        }
        if (nivel.isEmpty() == true){
            entrada.setNull(3, java.sql.Types.VARCHAR);
        }else{
            entrada.setString(3,nivel);
        }
        if (nombre.isEmpty() == true){
            entrada.setNull(4, java.sql.Types.VARCHAR);
        }else{
            entrada.setString(4,nombre);
        }
        if (identificacion.isEmpty() == true){
            entrada.setNull(5, java.sql.Types.VARCHAR);
        }else{
            entrada.setString(5,identificacion);
        }
        return entrada;
    }
    /**
     * Tratamientos del paciente 
     * @param fecha1 fecha inicial
     * @param fecha2 fecha final
     * @param tipo
     * @param nombre
     * @param identificacion
     * @return Tratamientos del paciente 
     * @throws SQLException 
     */
    public CallableStatement tratamientosPaciente(String fecha1, String fecha2, String tipo, String nombre, String identificacion) throws SQLException{
        CallableStatement entrada = ConexionSQL.getConnection().prepareCall("{call tratamientosPaciente(?,?,?,?,?)}");
        if (fecha1.isEmpty() == true){
            entrada.setNull(1, java.sql.Types.VARCHAR);
        }else{
            entrada.setString(1,fecha1);
        }
        if (fecha2.isEmpty() == true){
            entrada.setNull(2, java.sql.Types.VARCHAR);
        }else{
            entrada.setString(2,fecha2);
        }
        if (tipo.isEmpty() == true){
            entrada.setNull(3, java.sql.Types.VARCHAR);
        }else{
            entrada.setString(3,tipo);
        }
        if (nombre.isEmpty() == true){
            entrada.setNull(4, java.sql.Types.VARCHAR);
        }else{
            entrada.setString(4,nombre);
        }
        if (identificacion.isEmpty() == true){
            entrada.setNull(5, java.sql.Types.VARCHAR);
        }else{
            entrada.setString(5,identificacion);
        }
     return entrada;
    }
    /**
     * Cantidad de citas 
     * @param fecha1 fecha inicial
     * @param fecha2 fecha final 
     * @param especialidad 
     * @param estadoCita
     * @return cantidad de citas 
     * @throws SQLException 
     */
    public CallableStatement cantidadCitas(String fecha1, String fecha2, String especialidad, String estadoCita) throws SQLException{
        CallableStatement entrada = ConexionSQL.getConnection().prepareCall("{call cantidadCitas(?,?,?,?)}");
        if (fecha1.isEmpty() == true){
            entrada.setNull(1, java.sql.Types.VARCHAR);
        }else{
            entrada.setString(1,fecha1);
        }
        if (fecha2.isEmpty() == true){
            entrada.setNull(2, java.sql.Types.VARCHAR);
        }else{
            entrada.setString(2,fecha2);
        }
        if (especialidad.isEmpty() == true){
            entrada.setNull(3, java.sql.Types.VARCHAR);
        }else{
            entrada.setString(3,especialidad);
        }
        if (estadoCita.isEmpty() == true){
            entrada.setNull(4, java.sql.Types.VARCHAR);
        }else{
            entrada.setString(4,estadoCita);
        }
        return entrada;
    }
    /**
     * Cantidad de diagnosticos 
     * @param nivel
     * @param especialidad
     * @param identificacion
     * @return cantidad diagnosticos 
     * @throws SQLException 
     */
    public CallableStatement cantidadDiagnosticos(String nivel, String especialidad,String identificacion) throws SQLException{
        CallableStatement entrada = ConexionSQL.getConnection().prepareCall("{call cantidadDiagnosticos(?,?,?)}");
         if (nivel.isEmpty() == true){
            entrada.setNull(1, java.sql.Types.VARCHAR);
        }else{
            entrada.setString(1,nivel);
        }
         if (especialidad.isEmpty() == true){
            entrada.setNull(2, java.sql.Types.VARCHAR);
        }else{
            entrada.setString(2,especialidad);
        }
         if (identificacion.isEmpty() == true){
            entrada.setNull(3, java.sql.Types.VARCHAR);
        }else{
            entrada.setString(3,identificacion);
        }
      return entrada;
    }
    /**
     * Cantidad de tratamientos  
     * @param tipo
     * @param especialidad
     * @param identificacion
     * @return cantidad tratamientos 
     * @throws SQLException 
     */
   public CallableStatement cantidadTratamientos(String tipo, String especialidad, String identificacion) throws SQLException{
        CallableStatement entrada = ConexionSQL.getConnection().prepareCall("{call cantidadTratamientos(?,?,?)}");
         if (tipo.isEmpty() == true){
            entrada.setNull(1, java.sql.Types.VARCHAR);
        }else{
            entrada.setString(1,tipo);
        }
         if (especialidad.isEmpty() == true){
            entrada.setNull(2, java.sql.Types.VARCHAR);
        }else{
            entrada.setString(2,especialidad);
        }
         if (identificacion.isEmpty() == true){
            entrada.setNull(3, java.sql.Types.VARCHAR);
        }else{
            entrada.setString(3,identificacion);
        }
       return entrada;
   }
   
   /**
    * Detalles de hospitalizacion 
    * @param nombre
    * @throws SQLException 
    */
   public void detallesHospitalizacion(String nombre) throws SQLException{
        CallableStatement entrada = ConexionSQL.getConnection().prepareCall("{call detalleHospitalizacion(?)}");
        entrada.setString(1, nombre);
        entrada.execute();
   }
}


