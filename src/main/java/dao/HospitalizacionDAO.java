package dao;

import conexion.ConexionSQL;
import java.sql.CallableStatement;
import java.sql.SQLException;

/**
 *
 * @author Muro
 */
public class HospitalizacionDAO {
  public static void detalleHospitalizacion(String nombrePaciente) throws SQLException{
    CallableStatement entrada = ConexionSQL.getConnection().prepareCall("{call detalleHospitalizacion(?)}");
    if(nombrePaciente.isEmpty() == true) {
      entrada.setNull(1, java.sql.Types.VARCHAR);
    } else {
      entrada.setString(1,nombrePaciente);
    }
    entrada.execute();
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
