package dao;

import conexion.ConexionSQL;

import generico.Tabla;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.TablaCantidadDiagnosticos;

import modelo.TablaTratamientosPaciente;
import modelo.TablaTratamientosDE;
import modelo.TablaCantidadTratamientos;

/**
 *
 * @author Muro
 */
public class TratamientoDAO {
  
  public static void anadirTratamiento(String nombre, String dosis, String tipo, int idDiagnostico)
    throws SQLException {
    CallableStatement entrada = ConexionSQL.getConnection().prepareCall("{call registrarTratamientos(?, ?, ?, ?)}");
    entrada.setString(1, nombre);
    entrada.setString(2, dosis);
    entrada.setString(3, tipo);
    entrada.setInt(4, idDiagnostico);
    entrada.execute();
  }
  
  public static Tabla<TablaTratamientosPaciente> tratamientosAsociadosP(String f1, String f2, String pTipo, String pNombre, int idUsuario) throws SQLException{
    CallableStatement entrada = ConexionSQL.getConnection().prepareCall("{call tratamientosP(?, ?, ?, ?, ?)}");
    if(f1.isEmpty() == true) {
      entrada.setNull(1, java.sql.Types.VARCHAR);
    } else {
      entrada.setString(1,f1);
    } if(f2.isEmpty() == true) {
      entrada.setNull(2, java.sql.Types.VARCHAR);
    } else {
      entrada.setString(2, f2);
    } if(pTipo.isEmpty() == true) {
      entrada.setNull(3, java.sql.Types.VARCHAR);
    } else {
      entrada.setString(3, pTipo);
    } if(pNombre.isEmpty() == true) {
      entrada.setNull(4, java.sql.Types.VARCHAR);
    } else {
      entrada.setString(4, pNombre);
    }
    entrada.setInt(5, idUsuario);
    try(ResultSet result = entrada.executeQuery()) {
        Tabla<TablaTratamientosPaciente> tabla = new Tabla<>();
      while(result.next()) {
        int idTratamiento = result.getInt("idTratamiento");
        String tratamiento = result.getString("Tratamiento");
        String dosisRecomendada = result.getString("dosisRecomendada");
        String tipoTratamiento = result.getString("tipoTratamiento");
        String fecha = result.getString("Fecha");
        String diagnostico = result.getString("Diagnostico");
        TablaTratamientosPaciente resultado = new TablaTratamientosPaciente(idTratamiento, tratamiento, dosisRecomendada, tipoTratamiento, fecha, diagnostico);
        tabla.agregar(resultado);
      }
      result.close();
      return tabla;
      } catch(SQLException e) {
      e.printStackTrace();       
    }
    return null;
    }
  
  public static Tabla<TablaCantidadTratamientos> cantidadTratamientos(String pTipo, String pEspecialidad, String pPaciente) throws SQLException{
    CallableStatement entrada = ConexionSQL.getConnection().prepareCall("{call cantidadTratamientos(?, ?, ?)}");
    if(pTipo.isEmpty() == true) {
      entrada.setNull(1, java.sql.Types.VARCHAR);
    } else {
      entrada.setString(1,pTipo);
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
      Tabla<TablaCantidadTratamientos> tabla = new Tabla<>();
      int total = 0;
      while(result.next()) {
        total ++;
      }
      TablaCantidadTratamientos resultado = new TablaCantidadTratamientos(total, clamp(pTipo), clamp(pEspecialidad), clamp(pPaciente));
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
  
  public static Tabla<TablaTratamientosDE> tratamientosAsociadosDE(String f1, String f2, String pTipo, String pNombre, String pIdentificacion) throws SQLException{
    CallableStatement entrada = ConexionSQL.getConnection().prepareCall("{call tratamientosDE(?, ?, ?, ?, ?)}");
    if(f1.isEmpty() == true) {
      entrada.setNull(1, java.sql.Types.VARCHAR);
    } else {
      entrada.setString(1,f1);
    } if(f2.isEmpty() == true) {
      entrada.setNull(2, java.sql.Types.VARCHAR);
    } else {
      entrada.setString(2, f2);
    } if(pTipo.isEmpty() == true) {
      entrada.setNull(3, java.sql.Types.VARCHAR);
    } else {
      entrada.setString(3, pTipo);
    } if(pNombre.isEmpty() == true) {
      entrada.setNull(4, java.sql.Types.VARCHAR);
    } else {
      entrada.setString(4, pNombre);
    } 
    entrada.setString(5, pIdentificacion);
    try(ResultSet result = entrada.executeQuery()) {
        Tabla<TablaTratamientosDE> tabla = new Tabla<>();
      while(result.next()) {
        String nombrePaciente = result.getString("NombrePaciente");
        int idTratamiento = result.getInt("idTratamiento");
        String fecha = result.getString("fecha");
        String nombreTratamiento = result.getString("Especialidad");
        String dosis = result.getString("Paciente");
        String tipo = result.getString("Paciente");
        int idDiagnostico = result.getInt("idTratamiento");
        TablaTratamientosDE resultado = new TablaTratamientosDE(idTratamiento, nombrePaciente,
          fecha, nombreTratamiento, dosis, tipo, idDiagnostico);
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