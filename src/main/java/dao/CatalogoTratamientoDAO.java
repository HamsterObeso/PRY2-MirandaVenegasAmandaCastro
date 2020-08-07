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
 * @author Muro
 */
public class CatalogoTratamientoDAO {
  
  public static Tabla<CatalogoTratamiento> obtenerTratamientosID(int idDiagnostico) throws SQLException {
    try(CallableStatement cstmt = ConexionSQL.getConnection()
          .prepareCall("{call mostrarTratamientos(?)}");) {
      cstmt.setInt(1, idDiagnostico);
      try(ResultSet result = cstmt.executeQuery()) {
        Tabla<CatalogoTratamiento> resultados = new Tabla<>();
        while(result.next()) {
          String nombre = result.getString("Nombre");
          String diagnostico = result.getString("Diagnostico");
          int id = result.getInt("idNombreTratamiento");
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