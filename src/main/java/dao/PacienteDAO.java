package dao;

import java.sql.CallableStatement;
import java.sql.SQLException;

import conexion.ConexionSQL;
import generico.Tabla;
import java.sql.ResultSet;
import modelo.TablaPacientesAtendidos;

/**
 *
 * @author Muro
 */
public class PacienteDAO {
  
  public static Tabla<TablaPacientesAtendidos> obtenerPacientesAtentidos() throws SQLException {
    try (CallableStatement cstmt = ConexionSQL.getConnection()
          .prepareCall("{call mostrarPacientesAtendidos()}");) {
      try (ResultSet result = cstmt.executeQuery()) {
        Tabla<TablaPacientesAtendidos> resultados = new Tabla<>();
        while (result.next()) {
          String nombrePaciente = result.getString("NombrePaciente");
          String identificacion = result.getString("Identificacion");
          String diagnosticos = result.getString("Diagnostico");
          int idCita = result.getInt("idCita");
          String estado = result.getString("Estado");
          TablaPacientesAtendidos resultado = new TablaPacientesAtendidos(nombrePaciente, identificacion, diagnosticos, idCita, estado);
          resultados.agregar(resultado);
          }
        result.close();
        return resultados;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }
  
  public static boolean AgregarPaciente(String cedula, String nombre, String fechaNacimiento, String tipoSangre,
    String nacionalidad, String provincia, String canton, String correo, String usuario, String contraseña) {
    try(CallableStatement cstmt = ConexionSQL.getConnection()
          .prepareCall("{call anadirPaciente(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");) {
      cstmt.setString(1, cedula);
      cstmt.setString(2, nombre);
      cstmt.setString(3, fechaNacimiento);
      cstmt.setString(4, tipoSangre);
      cstmt.setString(5, nacionalidad);
      cstmt.setString(6, provincia);
      cstmt.setString(7, canton);
      cstmt.setString(8, correo);
      cstmt.setString(9, usuario);
      cstmt.setString(10, contraseña);
      cstmt.execute();
      return true;
    } catch(SQLException e) {
      e.printStackTrace();       
    }
    return false; 
  }
  
  public static boolean AgregarTelefono(String identificacion, String telefono) {
    try(CallableStatement cstmt = ConexionSQL.getConnection()
          .prepareCall("{call anadirTelefonosPaciente(?, ?)}");) {
      cstmt.setString(1, identificacion);
      cstmt.setString(2, telefono);
      cstmt.execute();
      return true;
    } catch(SQLException e) {
      e.printStackTrace();       
    }
    return false; 
  }
}
