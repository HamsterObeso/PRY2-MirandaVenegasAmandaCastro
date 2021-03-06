package dao;

import conexion.ConexionSQL;
import generico.Tabla;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.CatalogoDiagnostico;

/**
 *
 * @author Miranda Venegas, Amanda Castro 
 */
public class CatalogoDiagnosticoDAO {
  /**
   * Obtener diagnosticos 
   * @return diagnosticos 
   * @throws SQLException 
   */
  public static Tabla<CatalogoDiagnostico> obtenerDiagnosticos() throws SQLException {
    try(CallableStatement cstmt = ConexionSQL.getConnection()
          .prepareCall("{call obtenerCatalogoDiagnosticos()}");) {
      try(ResultSet result = cstmt.executeQuery()) {
        Tabla<CatalogoDiagnostico> tabla = new Tabla<>();
        while(result.next()) {
          String nombre = result.getString("Nombre");
          int id = result.getInt("idNombreDiag");
          CatalogoDiagnostico resultado = new CatalogoDiagnostico(nombre, id);
          tabla.agregar(resultado);
        }
        result.close();
        return tabla;
      }    
    } catch(SQLException e) {
      e.printStackTrace();       
    }
    return null;
  }

  /**
   * Crear diagnosticos 
   * @param nombre nombre del diagnostico 
   * @return verdadero si se cumple 
   */
  public static boolean crearDiagnostico(String nombre) {
    try(CallableStatement cstmt = ConexionSQL.getConnection()
          .prepareCall("{call crearCatalogoDiagnostico(?)}");) {
      cstmt.setString(1, nombre);
      cstmt.execute();
      return true;
    } catch(SQLException e) {
      e.printStackTrace();       
    }
    return false; 
  }
  
  /**
   * Actualizar diagnosticos 
   * @param id identificación del diagnostico 
   * @param nombre nombre del diagnostico 
   * @return verdadero si se cumple 
   */
  public static boolean actualizarDiagnostico(int id, String nombre) {
    try(CallableStatement cstmt = ConexionSQL.getConnection()
          .prepareCall("{call actualizarCatalogoDiagnostico(?, ?)}");) {
      cstmt.setInt(1, id);
      cstmt.setString(2, nombre);
      cstmt.execute();
      return true;  
    } catch(SQLException e) {
      e.printStackTrace();       
    }
    return false; 
  }
  
  /**
   * Eliminar diagnostico 
   * @param id identificación del diagnostico
   * @return verdadero si se cumple. 
   */
  public static boolean eliminarDiagnostico(int id) {
    try(CallableStatement cstmt = ConexionSQL.getConnection()
          .prepareCall("{call eliminarCatalogoDiagnostico(?)}");) {
      cstmt.setInt(1, id);
      cstmt.execute();
      return true;  
    } catch(SQLException e) {
      e.printStackTrace();       
    }
    return false; 
  }
  
}
