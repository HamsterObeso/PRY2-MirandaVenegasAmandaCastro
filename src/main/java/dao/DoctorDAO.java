package dao;

import conexion.ConexionSQL;

import java.sql.CallableStatement;
import java.sql.SQLException;

import modelo.Cita;
import modelo.Paciente;

/**
 *
 * @author Miranda Venegas, Amanda Castro 
 */
public class DoctorDAO {


public class doctorDAO {
   
    public  Paciente paciente;
    public  Cita cita;
    
    /**
     * cancelar cita 
     * @param pIDCita identificacion cita
     * @param pIDFuncionario identificación funcionario 
     * @throws SQLException 
     */
    public void cancelarCita( int pIDCita, int pIDFuncionario)throws SQLException{
       CallableStatement entrada = ConexionSQL.getConnection().prepareCall("{call cancelarCitaCentro(?,?)}"); 
       entrada.setInt(1, pIDCita);
       entrada.setInt(2, pIDFuncionario);
       entrada.execute();
    }
    
//    public void asignarCitaPaciente(int idCita, int pIDPaciente) throws SQLException{
//        CallableStatement entrada = ConexionSQL.getConnection().prepareCall("{call anadirCitas(?,?,?,?)}"); 
//        entrada.setString(1,cita.getIDcita());
//        entrada.setString(2,cita.getEstado());//Falta
//        entrada.execute();
//    }
    /**
     * Registrar diagnosticos 
     * @param cita identificacion cita 
     * @param nivel nombre nivel 
     * @param observaciones nombre observaciones 
     * @param nombreDiagnostico nombre diagnosticos 
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
     * @param tipo tipo 
     * @param idDiagnostico identificación del diagnostico 
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
    }
}
