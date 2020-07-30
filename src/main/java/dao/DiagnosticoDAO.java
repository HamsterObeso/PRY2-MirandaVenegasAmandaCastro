package dao;

import conexion.ConexionSQL;
import java.sql.CallableStatement;
import java.sql.SQLException;

/**
 *
 * @author Muro
 */
public class DiagnosticoDAO {
  public static void diagnosticosAsociadosP(String f1, String f2, String pNivel, String pNombre, int idUsuario) throws SQLException{
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
    entrada.execute();
  }
  
  public static void cantidadDiagnosticos(String pNivel, String pEspecialidad, String pPaciente) throws SQLException{
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
    entrada.execute();
  }
  
  public static void diagnosticosAsociadosDE(String f1, String f2, String pNivel, String pNombre, String pIdentificacion) throws SQLException{
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
    entrada.execute();
  }
}
