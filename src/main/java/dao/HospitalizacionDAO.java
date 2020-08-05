package dao;

import conexion.ConexionSQL;

import generico.Tabla;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.TablaHospitalizacionesPaciente;
import modelo.TablaDetalleHospitalizacion;

/**
 *
 * @author Muro
 */
public class HospitalizacionDAO {
  
  public static Tabla<TablaHospitalizacionesPaciente> obtenerHospitalizacionesPaciente(int idUsuario) throws SQLException {
    try (CallableStatement cstmt = ConexionSQL.getConnection()
          .prepareCall("{call hospitalizacionesPaciente(?)}");) {
      cstmt.setInt(1, idUsuario);
      try (ResultSet result = cstmt.executeQuery()) {
        Tabla<TablaHospitalizacionesPaciente> resultados = new Tabla<>();
        while (result.next()) {
          int id = result.getInt("idHospitalizacion");
          String centro = result.getString("Centro");
          String identificacion = result.getString("identificacionCliente");
          String nombrePaciente = result.getString("NombrePaciente");
          String diagnostico = result.getString("NombreDiagnostico");
          String fechaInicio = result.getString("inicioFecha");
          String fechaFinal = result.getString("finalFecha");
          String especialidad = result.getString("Especialidad");
          TablaHospitalizacionesPaciente resultado = new TablaHospitalizacionesPaciente(id, centro, identificacion, nombrePaciente, diagnostico, fechaInicio, fechaFinal, especialidad);
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
  
  public static Tabla<TablaDetalleHospitalizacion> detalleHospitalizacion(String nombrePaciente) throws SQLException{
    CallableStatement cstmt = ConexionSQL.getConnection().prepareCall("{call detalleHospitalizacion(?)}");
    if(nombrePaciente.isEmpty() == true) {
      cstmt.setNull(1, java.sql.Types.VARCHAR);
    } else {
      cstmt.setString(1,nombrePaciente);
    }
    try (ResultSet result = cstmt.executeQuery()) {
      Tabla<TablaDetalleHospitalizacion> resultados = new Tabla<>();
      while (result.next()) {
        int id = result.getInt("idHospitalizacion");
        String centro = result.getString("Centro");
        String identificacion = result.getString("identificacionCliente");
        String paciente = result.getString("NombrePaciente");
        String diagnostico = result.getString("NombreDiagnostico");
        String fechaInicio = result.getString("inicioFecha");
        String fechaFinal = result.getString("finalFecha");
        String especialidad = result.getString("Especialidad");
        String funcionario = result.getString("Funcionario");
        TablaDetalleHospitalizacion resultado = new TablaDetalleHospitalizacion(id, centro, identificacion, paciente, diagnostico, fechaInicio, fechaFinal, especialidad, funcionario);
        resultados.agregar(resultado);
        }
      result.close();
      return resultados;
      } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
  }
  
  public static void hospitalizacionesRegistradas(String fechaIni1, String fechaIni2, String fechaFin1, String fechaFin2, String estado, String especialidad, String nombrePaciente) throws SQLException{
    CallableStatement entrada = ConexionSQL.getConnection().prepareCall("{call hospitalizacionesRegistradas(?,?,?,?,?,?,?)}");
    if(fechaIni1.isEmpty() == true) {
      entrada.setNull(1, java.sql.Types.VARCHAR);
    } else {
      entrada.setString(1,fechaIni1);
    }
    if(fechaIni2.isEmpty() == true) {
      entrada.setNull(2, java.sql.Types.VARCHAR);
    } else {
      entrada.setString(2,fechaIni2);
    }
    if(fechaFin1.isEmpty() == true) {
      entrada.setNull(3, java.sql.Types.VARCHAR);
    } else {
      entrada.setString(3,fechaFin1);
    }
    if(fechaFin2.isEmpty() == true) {
      entrada.setNull(4, java.sql.Types.VARCHAR);
    } else {
      entrada.setString(4,fechaFin2);
    }
    if(estado.isEmpty() == true) {
      entrada.setNull(5, java.sql.Types.VARCHAR);
    } else {
      entrada.setString(5,estado);
    }
    if(especialidad.isEmpty() == true) {
      entrada.setNull(6, java.sql.Types.VARCHAR);
    } else {
      entrada.setString(6,especialidad);
    }
    if(nombrePaciente.isEmpty() == true) {
      entrada.setNull(7, java.sql.Types.VARCHAR);
    } else {
      entrada.setString(7,nombrePaciente);
    }
    
  }
}
