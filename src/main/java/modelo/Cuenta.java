package modelo;

import conexion.ConexionSQL;
import contexto.ContextoUsuario;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Miranda Venegas
 */
public class Cuenta {
  
  private String usuario;
  private String password;
  
  public void setUsuario(String usuario) {
    this.usuario = usuario;
  }
  
  public void setPassword(String password) {
    this.password = password;
  }
  
  public String getUsuario() {
    return usuario;
  }
  
  public String getPassword() {
    return password;
  }
  
  public boolean iniciarSesion() {
    try(CallableStatement cstmt = ConexionSQL.getConnection()
          .prepareCall("{call iniciarSesion(?, ?)}");) {
      cstmt.setString(1, usuario);
      cstmt.setString(2, password);       
      try(ResultSet result = cstmt.executeQuery()) {
        String tipoUsuario = null;
        int idUsuario = -1;
        while(result.next()) {         
          tipoUsuario = result.getString("TipoUsuario");
          idUsuario = result.getInt("IdUsuario");
        }
        result.close();
        ContextoUsuario.setCuenta(usuario, tipoUsuario, idUsuario);
        return true;
      }    
    } catch(SQLException e) {
      e.printStackTrace();       
    }
    return false;
  }
  
  
}
