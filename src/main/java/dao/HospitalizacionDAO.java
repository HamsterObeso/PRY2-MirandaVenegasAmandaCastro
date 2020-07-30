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
}
