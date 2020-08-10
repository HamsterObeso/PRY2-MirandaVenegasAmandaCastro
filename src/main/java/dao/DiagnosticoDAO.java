package dao;

import conexion.ConexionSQL;

import generico.Tabla;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.TablaCantidadCitas;

import modelo.TablaDiagnosticosPaciente;
import modelo.TablaCantidadDiagnosticos;
import modelo.TablaDiagnostico;
import modelo.TablaDiagnosticosDE;

/**
 *
 * @author Miranda Venegas, Amanda Castro 
 */
public class DiagnosticoDAO {
  
    /**
     * Añadir diagnostico 
     * @param nombreDiagnostico nombre diagnostico
     * @param nivel nivel del diagnostico 
     * @param observaciones observaciones del diagnostico 
     * @param idCita cita del diagnosticos 
     * @throws SQLException 
     */
  public static void anadirDiagnostico(String nombreDiagnostico, String nivel, String observaciones,
    int idCita) throws SQLException {
    CallableStatement entrada = ConexionSQL.getConnection().prepareCall("{call registrarDiagnosticos(?, ?, ?, ?)}");
    entrada.setInt(1, idCita);
    entrada.setString(2, nivel);
    entrada.setString(3, observaciones);
    entrada.setString(4, nombreDiagnostico);
    entrada.execute();
  }
  
  /**
   * Obtener diagnostico 
   * @param idCita identificacion cita 
   * @return diagnostico 
   * @throws SQLException 
   */
  public static Tabla<TablaDiagnostico> obtenerDiagnosticos(int idCita) throws SQLException {
    try (CallableStatement cstmt = ConexionSQL.getConnection()
          .prepareCall("{call cargarDiagnosticos(?)}");) {
      cstmt.setInt(1, idCita);
      try (ResultSet result = cstmt.executeQuery()) {
        Tabla<TablaDiagnostico> resultados = new Tabla<>();
        while (result.next()) {
            int id = result.getInt("idDiagnostico");
            String diagnostico = result.getString("Diagnostico");
            String nivel = result.getString("Nivel");
            String observaciones = result.getString("Observaciones");
            int cita = result.getInt("idCita");
            TablaDiagnostico resultado = new TablaDiagnostico(id, cita, diagnostico, nivel, observaciones);
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
   * Diagnosticos de los pacienes 
   * @param f1 fecha inicial 
   * @param f2 fecha final 
   * @param pNivel nivel de los diagnostico 
   * @param pNombre nombre de los diagnosticos 
   * @param idUsuario identificacion de usuario 
   * @return diagnosticos pacientes 
   * @throws SQLException 
   */
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
  
  /**
   * Cantidad diagnosticos 
   * @param pNivel nivel diagnostico 
   * @param pEspecialidad especialidad diagnosticos 
   * @param pPaciente nombre paciente 
   * @return cantidad diagnosticos 
   * @throws SQLException 
   */
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
      int total = 0;
      while(result.next()) {
        total ++;
      }
      TablaCantidadDiagnosticos resultado = new TablaCantidadDiagnosticos(total, clamp(pNivel), clamp(pEspecialidad), clamp(pPaciente));
      tabla.agregar(resultado);
      result.close();
      return tabla;
    } catch(SQLException e) {
      e.printStackTrace();
    }
    return null;
  }
  
  public static String clamp(String valor){
    if(valor.isEmpty()){
      return "Sin indicar";
    } else {
      return valor;
    }
  }
  
  /**
   * Diagnosticos del paciente 
   * @param f1 fecha inicial 
   * @param f2 fecha final 
   * @param pNivel nivel del diagnostico 
   * @param pNombre nombre del diagnostico 
   * @param pIdentificacion identificación del daignostico 
   * @return diagnosticos asociados 
   * @throws SQLException 
   */
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
    } if(pNombre.isEmpty() == true) {
      entrada.setNull(4, java.sql.Types.VARCHAR);
    } else {
      entrada.setString(4, pNombre);
    }
    entrada.setString(5, pIdentificacion);
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