package dao;

import conexion.ConexionSQL;
import java.sql.CallableStatement;
import java.sql.SQLException;

/**
 *
 * @author Muro
 */
public class FuncionarioDAO {
  public static void anadirFuncionario(String identificacion, String nombre,
    String tipoFuncionario, String area) throws SQLException{
    CallableStatement entrada = ConexionSQL.getConnection().prepareCall("{call "
      + "anadirFuncionario(?, ?, ?, ?)}");
    entrada.setString(1, identificacion);
    entrada.setString(2, nombre);
    entrada.setString(3, tipoFuncionario);
    entrada.setString(4, area);
    entrada.execute();
  }
}
