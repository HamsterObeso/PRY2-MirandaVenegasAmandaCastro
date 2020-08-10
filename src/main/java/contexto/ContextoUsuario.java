package contexto;

import conexion.ConexionSQL;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * @author Amanda Castro, Miranda Venegas
 * Se definen los tipos de usuario
 */
public class ContextoUsuario {
  
  private static String usuario;
  private static String tipo;
  private static int idUsuario;
  
  /**
   * Se le asignan los datos a la cuenta 
   * @param usuario nombre usuario
   * @param tipo tipo de usuario
   * @param idUsuario identificador del usuario 
   */
  public static void setCuenta(String usuario, String tipo, int idUsuario) {
    ContextoUsuario.usuario = usuario;
    ContextoUsuario.tipo = tipo;
    ContextoUsuario.idUsuario = idUsuario;
  }
  
  public static int getIdUsuario() {
    return idUsuario;
  }
  
  public static String getUsuario() {
    return usuario;
  }
  
  public static String getTipo() {
    return tipo;
  }
  
  
  /**
   * Método para iniciar sesión 
   * @param usuario nombre del usuario 
   * @param password contraseña del usuario 
   * @return 
   */   
  public static boolean iniciarSesion(String usuario, String password) {
    try(CallableStatement cstmt = ConexionSQL.getConnection()
          .prepareCall("{call iniciarSesion(?, ?)}");) {
      cstmt.setString(1, usuario);
      cstmt.setString(2, password);       
      try(ResultSet result = cstmt.executeQuery()) {
        String tipoUsuario = null;
        int id = -1;
        while(result.next()) {         
          tipoUsuario = result.getString("TipoUsuario");
          id = result.getInt("IdUsuario");
        }
        result.close();
        if(tipoUsuario == null) {
          return false;
        }
        ContextoUsuario.setCuenta(usuario, tipoUsuario, id);
        return true;
      }    
    } catch(SQLException e) {
      e.printStackTrace();       
    }
    return false;
  }
  
}
