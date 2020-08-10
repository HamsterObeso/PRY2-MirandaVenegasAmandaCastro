package dao;

import conexion.ConexionSQL;
import generico.Tabla;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.CatalogoTratamiento;

/**
 *
 * @author Miranda Venegas, Amanda Castro 
 */
public class CatalogoTratamientoDAO {
  
    /**
     * Obtener  los tratamientos en sistema
     * @param idDiagnostico identificación del diagnostico 
     * @return las datos solicitados 
     * @throws SQLException 
     */
  public static Tabla<CatalogoTratamiento> obtenerTratamientosID(int idDiagnostico) throws SQLException {
    try(CallableStatement cstmt = ConexionSQL.getConnection()
          .prepareCall("{call mostrarTratamientos(?)}");) {
      cstmt.setInt(1, idDiagnostico);
      try(ResultSet result = cstmt.executeQuery()) {
        Tabla<CatalogoTratamiento> resultados = new Tabla<>();
        while(result.next()) {
          String nombre = result.getString("Tratamiento");
          String diagnostico = result.getString("Diagnostico");
          int id = result.getInt("idCatalogoTratamiento");
          CatalogoTratamiento resultado = new CatalogoTratamiento(nombre, diagnostico, id);
          resultados.agregar(resultado);
        }
        result.close();
        return resultados;
      }    
    } catch(SQLException e) {
      e.printStackTrace();       
    }
    return null; 
  } 
  
  /**
   * Obtener tratamientos 
   * @return datos de los tratamientos 
   * @throws SQLException 
   */
  public static ArrayList<CatalogoTratamiento> obtenerTratamientos() throws SQLException {
    try(CallableStatement cstmt = ConexionSQL.getConnection()
          .prepareCall("{call obtenerCatalogoTratamientos()}");) {
      try(ResultSet result = cstmt.executeQuery()) {
        ArrayList<CatalogoTratamiento> resultados = new ArrayList<>();
        while(result.next()) {
          String nombre = result.getString("Nombre");
          String diagnostico = result.getString("Diagnostico");
          int id = result.getInt("idNombreTratamiento");
          CatalogoTratamiento resultado = new CatalogoTratamiento(nombre, diagnostico, id);
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
  
  /**
   * Crear tratamiento 
   * @param nombre nombre del tratamiento 
   * @param diagnostico nombre diagnostico 
   * @return verdadero si se cumple 
   */
  public static boolean crearTratamiento(String nombre, String diagnostico) {
    try(CallableStatement cstmt = ConexionSQL.getConnection()
          .prepareCall("{call crearCatalogoTratamiento(?, ?)}");) {
      cstmt.setString(1, nombre);
      cstmt.setString(2, diagnostico);
      cstmt.execute();
      return true;
    } catch(SQLException e) {
      e.printStackTrace();       
    }
    return false; 
  }
  
  /**
   * Actualizar tratamientos 
   * @param id identificación del tratamiento 
   * @param nombre nombre del tratamiento 
   * @param diagnostico nombre del diagnostico 
   * @return 
   */
  public static boolean actualizarTratamiento(int id, String nombre, String diagnostico) {
    try(CallableStatement cstmt = ConexionSQL.getConnection()
          .prepareCall("{call actualizarCatalogoTratamiento(?, ?, ?)}");) {
      cstmt.setInt(1, id);
      cstmt.setString(2, nombre);
      cstmt.setString(3, diagnostico);
      cstmt.execute();
      return true;  
    } catch(SQLException e) {
      e.printStackTrace();       
    }
    return false; 
  }
  
  /**
   * Eliminar tratamiento 
   * @param id identificación del tratamiento 
   * @return 
   */
  public static boolean eliminarTratamiento(int id) {
    try(CallableStatement cstmt = ConexionSQL.getConnection()
          .prepareCall("{call eliminarCatalogoTratamiento(?)}");) {
      cstmt.setInt(1, id);
      cstmt.execute();
      return true;  
    } catch(SQLException e) {
      e.printStackTrace();       
    }
    return false; 
  }
  
}