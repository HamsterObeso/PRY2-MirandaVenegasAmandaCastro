package contexto;

public class ContextoUsuario {
  
  private static String usuario;
  private static String tipo;
  private static int idUsuario;
  
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
   
}
