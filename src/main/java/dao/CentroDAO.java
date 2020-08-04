package dao;

import conexion.ConexionSQL;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.TablaCentrosAtencion;

/**
 *
 * @author Muro
 */
public class CentroDAO {
  public static boolean crearCentro(String nombre, String lugar, int capacidad, String tipoCentro) {
    try(CallableStatement cstmt = ConexionSQL.getConnection()
          .prepareCall("{call crearCentros(?, ?, ?, ?)}");) {
      cstmt.setString(1, nombre);
      cstmt.setString(2, lugar);
      cstmt.setInt(3, capacidad);
      cstmt.setString(4, tipoCentro);
      cstmt.execute();
      return true;
    } catch(SQLException e) {
      e.printStackTrace();       
    }
    return false; 
  }
  
  public static ArrayList<TablaCentrosAtencion> obtenerCentros() throws SQLException {
    try(CallableStatement cstmt = ConexionSQL.getConnection()
          .prepareCall("{call cargarCentros()}");) {
      try(ResultSet result = cstmt.executeQuery()) {
        ArrayList<TablaCentrosAtencion> resultados = new ArrayList<>();
        while(result.next()) {
          int codigo = result.getInt("id");
          String nombre = result.getString("Nombre");
          String lugar = result.getString("Lugar");
          int capacidadMaxima = result.getInt("Capacidad");
          String tipoCentro = result.getString("TipoCentro");
          TablaCentrosAtencion resultado = new TablaCentrosAtencion(codigo, nombre, lugar, capacidadMaxima, tipoCentro);
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
