package dao;

import java.sql.CallableStatement;
import java.sql.SQLException;

import modelo.Cita;

import conexion.ConexionSQL;

/**
 *
 * @author Muro
 */

public class CitaDAO {
  
  public static void anadirCita(String especialidad, String fechaHora, String observacion, int idPaciente)throws SQLException{
    CallableStatement entrada = ConexionSQL.getConnection().prepareCall("{call anadirCitas(?, ?, ?, ?)}");
    entrada.setString(1, especialidad);
    entrada.setString(2, fechaHora);
    entrada.setString(3, observacion);
    entrada.setInt(4, idPaciente);
    entrada.execute();
  }
}
