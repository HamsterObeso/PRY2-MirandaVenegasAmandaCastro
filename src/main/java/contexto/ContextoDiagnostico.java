package contexto;

/**
 *
 * @author Amanda Castro, Miranda Venegas
 * Método que permite guardar la información de los diagnosticos 
 */
public class ContextoDiagnostico {
  
  private static int idDiagnostico;

  public static void setDiagnostico(int idDiagnostico){
    ContextoDiagnostico.idDiagnostico = idDiagnostico;
  }

  public static int getIdDiagnostico() {
    return idDiagnostico;
  }

  public static void setIdDiagnostico(int idDiagnostico) {
    ContextoDiagnostico.idDiagnostico = idDiagnostico;
  }
  
}
