package DAO;

import conexion.ConexionSQL;
import java.sql.CallableStatement;
import java.sql.SQLException;
import modelo.Cita;
import modelo.Paciente;

/**
 *
 * @author Masiel Castro Mora
 */
public class EnfermeroDAO {
    public static Paciente paciente;
    public static Cita cita;
    
    public void cancelarCita( int pIDCita, int pIDFuncionario)throws SQLException{
       CallableStatement entrada = ConexionSQL.getConnection().prepareCall("{call cancelarCitaCentro(?,?)}"); 
       entrada.setInt(1, pIDCita);
       entrada.setInt(2, pIDFuncionario);
       entrada.execute();
    }
     public void registrarDiagnosticos(int cita, String nivel, String observaciones, String nombreDiagnostico) throws SQLException{
         CallableStatement entrada = ConexionSQL.getConnection().prepareCall("{call registrarDiagnosticos(?,?,?,?)}");
         entrada.setInt(1, cita);
         entrada.setString(2, nivel);
         entrada.setString(3, observaciones);
         entrada.setString(4, nombreDiagnostico);
         entrada.execute();
    }
    
    public void registrarTratamientos(String nombreTrata, String dosis, String tipo, int idDiagnostico) throws SQLException{
        CallableStatement entrada = ConexionSQL.getConnection().prepareCall("{call registrarTratamientos(?,?,?,?)}");
        entrada.setString(1, nombreTrata);
        entrada.setString(2, dosis);
        entrada.setString(3, tipo);
        entrada.setInt(4, idDiagnostico);
        entrada.execute();
    }
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
   
   public void detallesHospitalizacion(String nombre) throws SQLException{
        CallableStatement entrada = ConexionSQL.getConnection().prepareCall("{call detalleHospitalizacion(?)}");
        entrada.setString(1, nombre);
        entrada.execute();
   }
}


