package dao;

import java.sql.CallableStatement;
import java.sql.SQLException;

import conexion.ConexionSQL;
import generico.Tabla;
import java.sql.ResultSet;
import modelo.TablaPacientesAtendidos;

/**
 *
 * @author Miranda, Amanda 
 */
public class PacienteDAO {
  public static String correoPaciente;
  public static String numeroPaciente;
  
  /**
   * Obtener los pacientes obtenidos
   * @return pacientes atentidos 
   * @throws SQLException 
   */
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
  
  /**
   * Agregar paciente 
   * @param cedula
   * @param nombre
   * @param fechaNacimiento
   * @param tipoSangre
   * @param nacionalidad
   * @param provincia
   * @param canton
   * @param correo
   * @param usuario
   * @param contraseña
   * @return paciente agregado 
   */
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
  
  /**
   * Agregar telefono 
   * @param identificacion
   * @param telefono
   * @return telefonos agregados 
   */
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
  
  /**
   * Telefono paciente 
   * @param idUsuario
   * @return telefono paciente 
   * @throws SQLException 
   */
  public static String telefonoPaciente(int idUsuario) throws SQLException {
    try (CallableStatement entrada = ConexionSQL.getConnection().prepareCall("{? = call obtenerTelefono(?)}")) {
      entrada.registerOutParameter(1, java.sql.Types.VARCHAR);
      entrada.setInt(2, idUsuario);
      try (ResultSet result = entrada.executeQuery()) {
        while (result.next()) {
          String num = result.getString("TelefonoPaciente");
          numeroPaciente = num;
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }
      return numeroPaciente;
    }
  }
  /**
   * Obtener correo paciente 
   * @param idUsuario
   * @return correo del paciente 
   * @throws SQLException 
   */
  public static String obtenerCorreo(int idUsuario) throws SQLException{
    CallableStatement entrada = ConexionSQL.getConnection().prepareCall("{? = call obtenerCorreo(?)}");
    entrada.registerOutParameter(1, java.sql.Types.VARCHAR);
    entrada.setInt(2, idUsuario);
    try (ResultSet result = entrada.executeQuery()) {
      while (result.next()) {
        String correo = result.getString("CorreoPaciente");
        correoPaciente = correo;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return correoPaciente;
  }
  
}
