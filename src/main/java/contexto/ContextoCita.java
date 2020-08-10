package contexto;

/**
 *
 * @author Amanda Castro, Miranda Venegas
 * 
 * Método que permite guardar información de las citas 
 */
public class ContextoCita {
  
  private static int idCita;

  public static void setCita(int idCita){
    ContextoCita.idCita = idCita;
  }

  public static int getIdCita() {
    return idCita;
  }

  public static void setIdCita(int idCita) {
    ContextoCita.idCita = idCita;
  }
  
  public static void guardarCita(int idCita){
    ContextoCita.setCita(idCita);
  }
  
}
