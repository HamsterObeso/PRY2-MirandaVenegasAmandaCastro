package dao;

import conexion.ConexionSQL;
import java.sql.CallableStatement;
import java.sql.SQLException;

/**
 *
 * @author Miranda, Amanda 
 */
public class FuncionarioDAO {
    /**
     * Añadir funcioanrio 
     * @param identificacion
     * @param nombre
     * @param tipoFuncionario
     * @param area
     * @param usuario
     * @param contraseña
     * @throws SQLException 
     */
  public static void anadirFuncionario(String identificacion, String nombre,
    String tipoFuncionario, String area, String usuario, String contraseña) throws SQLException{
    CallableStatement entrada = ConexionSQL.getConnection().prepareCall("{call "
      + "anadirFuncionario(?, ?, ?, ?, ?, ?)}");
    entrada.setString(1, identificacion);
    entrada.setString(2, nombre);
    entrada.setString(3, tipoFuncionario);
    entrada.setString(4, area);
    entrada.setString(5, usuario);
    entrada.setString(6, contraseña);
    entrada.execute();
  }
}
