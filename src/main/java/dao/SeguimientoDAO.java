package dao;

import conexion.ConexionSQL;
import java.sql.CallableStatement;
import java.sql.SQLException;

/**
 *
 * @author Muro
 */
public class SeguimientoDAO {
  
  public static void anadirSeguimiento(int pHospitalizacion, int pUsuario, String observacion, String tratamientoAsociado)throws SQLException{
    CallableStatement entrada = ConexionSQL.getConnection().prepareCall("{call realizarSeguimiento(?, ?, ?, ?)}");
    entrada.setInt(1, pHospitalizacion);
    entrada.setInt(2, pUsuario);
    entrada.setString(3, observacion);
    entrada.setString(4, tratamientoAsociado);
    entrada.execute();
  }
}
