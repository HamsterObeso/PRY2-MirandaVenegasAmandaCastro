package dao;

import java.sql.CallableStatement;
import java.sql.SQLException;

import conexion.ConexionSQL;

/**
 *
 * @author Muro
 */

public class CitaDAO {
  
  public static void anadirCita(String especialidad, String fecha, String hora, String observacion,
    int idUsuario)throws SQLException{
    CallableStatement entrada = ConexionSQL.getConnection().prepareCall
  ("{call anadirCitas(?, ?, ?, ?, ?)}");
    entrada.setString(1, especialidad);
    entrada.setString(2, fecha);
    entrada.setString(3, hora);
    entrada.setString(4, observacion);
    entrada.setInt(5, idUsuario);
    entrada.execute();
  }
  
  public static void cancelarCitaPaciente(int idCita, int idUsuario) throws SQLException{
    CallableStatement entrada = ConexionSQL.getConnection().prepareCall
  ("{call cancelarCitaPaciente(?, ?)}");
    entrada.setInt(1, idCita);
    entrada.setInt(2, idUsuario);
    entrada.execute();
  }
  
  public static void cancelarCitaFuncionario(int idCita, int idUsuario) throws SQLException{
    CallableStatement entrada = ConexionSQL.getConnection().prepareCall
  ("{call cancelarCitaCentro(?, ?)}");
    entrada.setInt(1, idCita);
    entrada.setInt(2, idUsuario);
    entrada.execute();
  }
  
  public static void citasAsociadasPaciente(String f1, String f2, String pEstado, String 
    pEspecialidad, int idUsuario) throws SQLException{
    CallableStatement entrada = ConexionSQL.getConnection().prepareCall
  ("{call citasAsociadasAlPaciente(?, ?, ?, ?, ?)}");
    if(f1.isEmpty() == true) {
      entrada.setNull(1, java.sql.Types.VARCHAR);
    } else {
      entrada.setString(1,f1);
    } if(f2.isEmpty() == true) {
      entrada.setNull(2, java.sql.Types.VARCHAR);
    } else {
      entrada.setString(2, f2);
    } if(pEstado.isEmpty() == true) {
      entrada.setNull(3, java.sql.Types.VARCHAR);
    } else {
      entrada.setString(3, pEstado);
    } if(pEspecialidad.isEmpty() == true) {
      entrada.setNull(4, java.sql.Types.VARCHAR);
    } else {
      entrada.setString(4, pEspecialidad);
    }
    entrada.setInt(5, idUsuario);
    entrada.execute();
  }
  
  public static void cantidadCitas(String f1, String f2, String pEspecialidad, String pEstado) 
    throws SQLException{
    CallableStatement entrada = ConexionSQL.getConnection().prepareCall
  ("{call cantidadCitas(?, ?, ?, ?)}");
    if(f1.isEmpty() == true) {
      entrada.setNull(1, java.sql.Types.VARCHAR);
    } else {
      entrada.setString(1,f1);
    } if(f2.isEmpty() == true) {
      entrada.setNull(2, java.sql.Types.VARCHAR);
    } else {
      entrada.setString(2, f2);
    } if(pEspecialidad.isEmpty() == true) {
      entrada.setNull(3, java.sql.Types.VARCHAR);
    } else {
      entrada.setString(3, pEspecialidad);
    } if(pEstado.isEmpty() == true) {
      entrada.setNull(4, java.sql.Types.VARCHAR);
    } else {
      entrada.setString(4, pEstado);
    entrada.execute();
    }
  }
    
  // Funciona para ambos doctor|enfermero y secretario. Mismos parámetros.
  public static void citasSistema(String f1, String f2, String pEstado, String pEspecialidad,
    String pNombrePaciente) throws SQLException{
    CallableStatement entrada = ConexionSQL.getConnection().prepareCall
  ("{call citasSistema(?, ?, ?, ?, ?)}");
    if(f1.isEmpty() == true) {
      entrada.setNull(1, java.sql.Types.VARCHAR);
    } else {
      entrada.setString(1,f1);
    } if(f2.isEmpty() == true) {
      entrada.setNull(2, java.sql.Types.VARCHAR);
    } else {
      entrada.setString(2, f2);
    } if(pEstado.isEmpty() == true) {
      entrada.setNull(3, java.sql.Types.VARCHAR);
    } else {
      entrada.setString(3, pEstado);
    } if(pEspecialidad.isEmpty() == true) {
      entrada.setNull(4, java.sql.Types.VARCHAR);
    } else {
      entrada.setString(4, pEspecialidad);
    } if(pNombrePaciente.isEmpty() == true) {
      entrada.setNull(5, java.sql.Types.VARCHAR);
    } else {
      entrada.setString(5, pNombrePaciente);
    }
    entrada.execute();
  }
  
  public static void asignarCita(int idCita, int idUsuario) throws SQLException{
    CallableStatement entrada = ConexionSQL.getConnection().prepareCall("{call asignarCita(?, ?)}");
    entrada.setInt(1, idCita);
    entrada.setInt(2, idUsuario);
    entrada.execute();
  }
  
}
