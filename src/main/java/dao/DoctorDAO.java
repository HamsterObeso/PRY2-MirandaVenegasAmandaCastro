package dao;

import Conexiones.conexionSQL;

import java.sql.CallableStatement;
import java.sql.SQLException;

import modelo.citas;
import modelo.pacientes;

/**
 *
 * @author Muro
 */
public class DoctorDAO {


public class doctorDAO {
    public static pacientes paciente;
    public static  citas cita;
    
    public void cancelarCita( int pIDCita, int pIDFuncionario)throws SQLException{
       CallableStatement entrada = conexionSQL.getConnection().prepareCall("{call cancelarCitaCentro(?,?)}"); 
       entrada.setInt(1, pIDCita);
       entrada.setInt(2, pIDFuncionario);
       entrada.execute();
    }
    
    public void asignarCitaPaciente(int idCita, int pIDPaciente) throws SQLException{
        CallableStatement entrada = conexionSQL.getConnection().prepareCall("{call anadirCitas(?,?,?,?)}"); 
        entrada.setString(1,citas.getIDcita());
        entrada.setString(2,citas.getIDPaciente());
        entrada.execute();
    }
    
    public void registrarDiagnosticos(int cita, String nivel, String observaciones, String nombreDiagnostico) throws SQLException{
         CallableStatement entrada = conexionSQL.getConnection().prepareCall("{call registrarDiagnosticos(?,?,?,?)}");
         entrada.setInt(1, cita);
         entrada.setString(2, nivel);
         entrada.setString(3, observaciones);
         entrada.setString(4, nombreDiagnostico);
         entrada.execute();
    }
    
    public void registrarTratamientos(String nombreTrata, String dosis, String tipo, int idDiagnostico) throws SQLException{
        CallableStatement entrada = conexionSQL.getConnection().prepareCall("{call registrarTratamientos(?,?,?,?)}");
        entrada.setString(1, nombreTrata);
        entrada.setString(2, dosis);
        entrada.setString(3, tipo);
        entrada.setInt(4, idDiagnostico);
        entrada.execute();
    }
    }
}
