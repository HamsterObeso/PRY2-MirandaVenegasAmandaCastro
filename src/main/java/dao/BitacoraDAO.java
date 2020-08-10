package dao;

import conexion.ConexionSQL;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.TablaBitácora;

/**
 *
 * @author Miranda, Amanda 
 * 
 */
public class BitacoraDAO {
    /**
     * Obtener bitacora 
     * @return bitacora 
     * @throws SQLException 
     */
  public static ArrayList<TablaBitácora> obtenerBitacora() throws SQLException {
    try(CallableStatement cstmt = ConexionSQL.getConnection()
          .prepareCall("{call cargarBitacora()}");) {
      try(ResultSet result = cstmt.executeQuery()) {
        ArrayList<TablaBitácora> resultados = new ArrayList<>();
        while(result.next()) {
          int bitacora = result.getInt("Bitacora");
          String fecha = result.getString("Fecha");
          String usuario = result.getString("Usuario");
          int cita = result.getInt("Cita");
          String accion = result.getString("Accion");
          TablaBitácora resultado = new TablaBitácora(bitacora, fecha, usuario, cita, accion);
          resultados.add(resultado);
        }
        result.close();
        return resultados;
      }    
    } catch(SQLException e) {
      e.printStackTrace();       
    }
    return null; 
  } 
}
