package dao;

import conexion.ConexionSQL;

import generico.Tabla;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.TablaDiagnosticosPaciente;
import modelo.TablaCantidadDiagnosticos;
import modelo.TablaDiagnosticosDE;

/**
 *
 * @author Muro
 */
public class DiagnosticoDAO {
  
  public static Tabla<TablaDiagnosticosPaciente> diagnosticosAsociadosP(String f1, String f2, String pNivel, String pNombre, int idUsuario) throws SQLException{
    CallableStatement entrada = ConexionSQL.getConnection().prepareCall("{call diagnosticosP(?, ?, ?, ?, ?)}");
    if(f1.isEmpty() == true) {
      entrada.setNull(1, java.sql.Types.VARCHAR);
    } else {
      entrada.setString(1,f1);
    } if(f2.isEmpty() == true) {
      entrada.setNull(2, java.sql.Types.VARCHAR);
    } else {
      entrada.setString(2, f2);
    } if(pNivel.isEmpty() == true) {
      entrada.setNull(3, java.sql.Types.VARCHAR);
    } else {
      entrada.setString(3, pNivel);
    } if(pNombre.isEmpty() == true) {
      entrada.setNull(4, java.sql.Types.VARCHAR);
    } else {
      entrada.setString(4, pNombre);
    }
    entrada.setInt(5, idUsuario);
    try(ResultSet result = entrada.executeQuery()) {
      Tabla<TablaDiagnosticosPaciente> tabla = new Tabla<>();
      while(result.next()) {
        int idDiagnostico = result.getInt("idDiagnostico");
        int idCita = result.getInt("idCita");
        String diagnostico = result.getString("Diagnostico");
        String nivel = result.getString("Nivel");
        String observacion = result.getString("Observaciones");
        String fecha = result.getString("Fecha");
        TablaDiagnosticosPaciente resultado = new TablaDiagnosticosPaciente(idDiagnostico, idCita, diagnostico, nivel, observacion, fecha);
        tabla.agregar(resultado);
      }
      result.close();
      return tabla;
    } catch(SQLException e) {
      e.printStackTrace();       
    }
    return null;
  }
  
  public static Tabla<TablaCantidadDiagnosticos> cantidadDiagnosticos(String pNivel, String pEspecialidad, String pPaciente) throws SQLException{
    CallableStatement entrada = ConexionSQL.getConnection().prepareCall("{call cantidadDiagnosticos(?, ?, ?)}");
    if(pNivel.isEmpty() == true) {
      entrada.setNull(1, java.sql.Types.VARCHAR);
    } else {
      entrada.setString(1,pNivel);
    } if(pEspecialidad.isEmpty() == true) {
      entrada.setNull(2, java.sql.Types.VARCHAR);
    } else {
      entrada.setString(2, pEspecialidad);
    } if(pPaciente.isEmpty() == true) {
      entrada.setNull(3, java.sql.Types.VARCHAR);
    } else {
      entrada.setString(3, pPaciente);
    }
    try(ResultSet result = entrada.executeQuery()) {
      Tabla<TablaCantidadDiagnosticos> tabla = new Tabla<>();
      while(result.next()) {
        int cantidad = result.getInt("CantidadDiagnosticos");
        String nivel = result.getString("nivel");
        String especialidad = result.getString("Especialidad");
        String paciente = result.getString("Paciente");
        TablaCantidadDiagnosticos resultado = new TablaCantidadDiagnosticos(cantidad, nivel, especialidad, paciente);
        tabla.agregar(resultado);
      }
      result.close();
      return tabla;
    } catch(SQLException e) {
      e.printStackTrace();       
    }
    return null;
  }
  
  public static Tabla<TablaDiagnosticosDE> diagnosticosAsociadosDE(String f1, String f2, String pNivel, String pNombre, String pIdentificacion) throws SQLException{
    CallableStatement entrada = ConexionSQL.getConnection().prepareCall("{call diagnosticosDE(?, ?, ?, ?, ?)}");
    if(f1.isEmpty() == true) {
      entrada.setNull(1, java.sql.Types.VARCHAR);
    } else {
      entrada.setString(1,f1);
    } if(f2.isEmpty() == true) {
      entrada.setNull(2, java.sql.Types.VARCHAR);
    } else {
      entrada.setString(2, f2);
    } if(pNivel.isEmpty() == true) {
      entrada.setNull(3, java.sql.Types.VARCHAR);
    } else {
      entrada.setString(3, pNivel);
    }
    entrada.setString(4, pIdentificacion);
    try(ResultSet result = entrada.executeQuery()) {
      Tabla<TablaDiagnosticosDE> tabla = new Tabla<>();
      while(result.next()) {
        String paciente = result.getString("Paciente");
        int id  = result.getInt("idDiagnostico");
        int idCita = result.getInt("idCita");
        String diagnostico = result.getString("Diagnostico");
        String nivel = result.getString("nivel");
        String observacion = result.getString("observaciones");
        
        TablaDiagnosticosDE resultado = new TablaDiagnosticosDE(id, paciente, idCita, diagnostico, nivel, observacion);
        tabla.agregar(resultado);
      }
      result.close();
      return tabla;
    } catch(SQLException e) {
      e.printStackTrace();       
    }
    return null;
  }
}