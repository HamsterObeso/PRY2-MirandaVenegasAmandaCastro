package dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.Paciente;

import conexion.ConexionSQL;

/**
 *
 * @author Muro
 */
public class PacienteDAO {
    public static Paciente paciente;
    public static ResultSet result;
    
    public void ingresarPaciente(Paciente paciente) throws SQLException{
        CallableStatement entrada = ConexionSQL.getConnection().prepareCall("{call anadirPaciente(?,?,?,?,?,?,?,?,?)}");
        /*entrada.setString(1,paciente.getID());
        entrada.setString(2,paciente.getUsuario());
        entrada.setString(3,paciente.getContraseña());
        entrada.setString(4,paciente.getNombre());
        entrada.setString(5,paciente.getNombreEmpresa());
        entrada.setString(6,paciente.getSitioWeb());
        entrada.setString(7,paciente.getCorreo());
        entrada.setString(8,paciente.getHorarioAtencion());
        entrada.setString(9,paciente.getPerfilSocialPrincipal());*/
        entrada.executeUpdate();
    }
}
