package contexto;

public class ContextoUsuario {
  
  private static String usuario;
  private static String tipo;
  
  public static void setCuenta(String usuario, String tipo) {
    ContextoUsuario.usuario = usuario;
    ContextoUsuario.tipo = tipo;
  }
  
  public static String getUsuario() {
    return usuario;
  }
  
  public static String getTipo() {
    return tipo;
  }
   
}
