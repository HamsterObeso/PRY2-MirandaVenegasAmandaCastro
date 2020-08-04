package dao;

import conexion.ConexionSQL;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

import modelo.TablaTipoCentro;

/**
 *
 * @author Muro
 */
public class TipoCentroDAO {
  
  public static boolean crearTipoCentro(String nombre) {
    try(CallableStatement cstmt = ConexionSQL.getConnection()
          .prepareCall("{call crearTipoCentro(?)}");) {
      cstmt.setString(1, nombre);
      cstmt.execute();
      return true;
    } catch(SQLException e) {
      e.printStackTrace();       
    }
    return false; 
  }
  
  public static ArrayList<TablaTipoCentro> obtenerTipoCentros() throws SQLException {
    try(CallableStatement cstmt = ConexionSQL.getConnection()
          .prepareCall("{call cargarTipoCentro()}");) {
      try(ResultSet result = cstmt.executeQuery()) {
        ArrayList<TablaTipoCentro> resultados = new ArrayList<>();
        while(result.next()) {
          int codigo = result.getInt("id");
          String nombre = result.getString("TipoCentro");
          TablaTipoCentro resultado = new TablaTipoCentro(codigo, nombre);
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
