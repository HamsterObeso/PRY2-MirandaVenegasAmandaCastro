package dao;

import conexion.ConexionSQL;
import java.sql.CallableStatement;
import java.sql.SQLException;

/**
 *
 * @author Muro
 */
public class TratamientoDAO {
  public static void tratamientosAsociadosP(String f1, String f2, String pTipo, String pNombre, int idUsuario) throws SQLException{
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
    entrada.execute();
  }
  
  public static void cantidadTratamientos(String pTipo, String pEspecialidad, String pPaciente) throws SQLException{
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
    entrada.execute();
  }
  
  public static void tratamientosAsociadosDE(String f1, String f2, String pTipo, String pNombre, String pIdentificacion) throws SQLException{
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
    entrada.execute();
  }
}
