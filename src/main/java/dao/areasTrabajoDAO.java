package dao;

/**
 *
 * @author Masiel Castro Mora
 */

import conexion.ConexionSQL;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

import modelo.TablaEspecialidad;
import modelo.AreasTrabajo;

/**
 *
 * @author Amanda Castro, Miranda Venegas 
 */
public class AreasTrabajoDAO {
  public static AreasTrabajo areas;
  public static ResultSet result;

  //Gestión de areas
  
  public static ArrayList<TablaEspecialidad> obtenerAreas() throws SQLException {
    try(CallableStatement cstmt = ConexionSQL.getConnection()
          .prepareCall("{call cargarBitacora()}");) {
      try(ResultSet result = cstmt.executeQuery()) {
        ArrayList<TablaEspecialidad> resultados = new ArrayList<>();
        while(result.next()) {
          int area = result.getInt("id");
          String nombre = result.getString("Especialidad");
          TablaEspecialidad resultado = new TablaEspecialidad(area, nombre);
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
  
   public static boolean crearArea(String nombre) {
    try(CallableStatement cstmt = ConexionSQL.getConnection()
          .prepareCall("{call anadirAreas(?)}");) {
      cstmt.setString(1, nombre);
      cstmt.execute();
      return true;
    } catch(SQLException e) {
      e.printStackTrace();       
    }
    return false; 
  }
  
  public static boolean actualizarArea(int id, String nombre) {
    try(CallableStatement cstmt = ConexionSQL.getConnection()
          .prepareCall("{call actualizarArea(?, ?)}");) {
      cstmt.setInt(1, id);
      cstmt.setString(2, nombre);
      cstmt.execute();
      return true;  
    } catch(SQLException e) {
      e.printStackTrace();       
    }
    return false; 
  }
  
  public static boolean eliminarArea(int id) {
    try(CallableStatement cstmt = ConexionSQL.getConnection()
          .prepareCall("{call borrarArea(?)}");) {
      cstmt.setInt(1, id);
      cstmt.execute();
      return true;  
    } catch(SQLException e) {
      e.printStackTrace();       
    }
    return false; 
  }
    
}
