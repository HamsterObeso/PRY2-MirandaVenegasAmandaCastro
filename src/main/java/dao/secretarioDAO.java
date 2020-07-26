package dao;

import conexion.conexionSQL;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.citas;

/**
 *
 * @author Masiel Castro Mora
 */
public class secretarioDAO {
    
    public citas citas;
    public ResultSet result;
    
    public void cancelarCita( int idCita, int idFuncionario) throws SQLException{
        CallableStatement entrada = conexionSQL.getConnection().prepareCall("{call cancelarCitaCentro(?,?)}");
        entrada.setInt(1, idCita);
        entrada.setInt(2,idFuncionario);
        entrada.execute();

    }
   
    public void asignarCitaPaciente (int idCita, int idFuncionario) throws SQLException{
        CallableStatement entrada = conexionSQL.getConnection().prepareCall("{call asignarCita(?,?)}");
        entrada.setInt(1, idCita);
        entrada.setInt(2, idFuncionario);
        entrada.execute();
    }
    
    public void citasRegistradas(String fecha1, String fecha2, String estado, String especialidad, String nombrePaciente) throws SQLException{
        CallableStatement entrada = conexionSQL.getConnection().prepareCall("{call citasEnSistema(?,?,?,?,?)}");
        if (fecha1.isEmpty() == true){
            entrada.setNull(1, java.sql.Types.VARCHAR);
        }else{
            entrada.setString(1,fecha1);
        }
        if (fecha2.isEmpty() == true){
            entrada.setNull(2, java.sql.Types.VARCHAR);
        }else{
            entrada.setString(2,fecha2);
        }
        if (estado.isEmpty() == true){
            entrada.setNull(3, java.sql.Types.VARCHAR);
        }else{
            entrada.setString(3,estado);
        }
        if (especialidad.isEmpty() == true){
            entrada.setNull(4, java.sql.Types.VARCHAR);
        }else{
            entrada.setString(4,especialidad);
        }
        if (nombrePaciente.isEmpty() == true){
            entrada.setNull(5, java.sql.Types.VARCHAR);
        }else{
            entrada.setString(5,nombrePaciente);
        }
       
    }
    
    public void hospitalizacionesRegistradas (String fechaIni1, String fechaIni2, String fechaFinal1, String fechaFinal2, String estado, String especialidad, String nombrePaciente) throws SQLException{
        CallableStatement entrada = conexionSQL.getConnection().prepareCall("{call hospitalizacionesRegistradas(?,?,?,?,?,?,?)}");
        if (fechaIni1.isEmpty() == true){
            entrada.setNull(1, java.sql.Types.VARCHAR);
        }else{
            entrada.setString(1,fechaIni1);
        }
        if (fechaIni2.isEmpty() == true){
            entrada.setNull(2, java.sql.Types.VARCHAR);
        }else{
            entrada.setString(2,fechaIni2);
        }
        if (fechaFinal1.isEmpty() == true){
            entrada.setNull(3, java.sql.Types.VARCHAR);
        }else{
            entrada.setString(3,fechaFinal1);
        }
        if (fechaFinal2.isEmpty() == true){
            entrada.setNull(4, java.sql.Types.VARCHAR);
        }else{
            entrada.setString(4,fechaFinal2);
        }
        if (estado.isEmpty() == true){
            entrada.setNull(5, java.sql.Types.VARCHAR);
        }else{
            entrada.setString(5,estado);
        }
        if (especialidad.isEmpty() == true){
            entrada.setNull(6, java.sql.Types.VARCHAR);
        }else{
            entrada.setString(6,especialidad);
        }
        if (nombrePaciente.isEmpty() == true){
            entrada.setNull(7, java.sql.Types.VARCHAR);
        }else{
            entrada.setString(7,nombrePaciente);
        }
        
    }
    
}
