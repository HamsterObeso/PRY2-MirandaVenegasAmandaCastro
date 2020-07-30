package dao;

import java.sql.CallableStatement;
import java.sql.SQLException;

import conexion.ConexionSQL;

/**
 *
 * @author Muro
 */

public class CitaDAO {
  
  public static void anadirCita(String especialidad, String fecha, String hora, String observacion, int idUsuario)throws SQLException{
    CallableStatement entrada = ConexionSQL.getConnection().prepareCall("{call anadirCitas(?, ?, ?, ?, ?)}");
    entrada.setString(1, especialidad);
    entrada.setString(2, fecha);
    entrada.setString(3, hora);
    entrada.setString(4, observacion);
    entrada.setInt(5, idUsuario);
    entrada.execute();
  }
  
  public static void cancelarCitaPaciente(int idCita, int idUsuario) throws SQLException{
    CallableStatement entrada = ConexionSQL.getConnection().prepareCall("{call cancelarCitaPaciente(?, ?)}");
    entrada.setInt(1, idCita);
    entrada.setInt(2, idUsuario);
    entrada.execute();
  }
  
  public static void cancelarCitaFuncionario(int idCita, int idUsuario) throws SQLException{
    CallableStatement entrada = ConexionSQL.getConnection().prepareCall("{call cancelarCitaCentro(?, ?)}");
    entrada.setInt(1, idCita);
    entrada.setInt(2, idUsuario);
    entrada.execute();
  }
  
  public static void citasAsociadasPaciente(int idUsuario, String f1, String f2, String pEspecialidad) throws SQLException{
    CallableStatement entrada = ConexionSQL.getConnection().prepareCall("{call citasAsociadasAlPaciente(?, ?, ?, ?)}");
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
    }
    entrada.setInt(4, idUsuario);
    entrada.execute();
  }
}
