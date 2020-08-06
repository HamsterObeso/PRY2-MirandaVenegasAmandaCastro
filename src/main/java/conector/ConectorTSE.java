package conector;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Miranda Venegas
 */
public class ConectorTSE {
  
  private static final String PATH = System.getProperty("user.dir") + "/conectorTSE.jar";
  private static final String RESULTADO = System.getProperty("user.dir") + "/resultado.txt";
  
  public static String[] obtenerInformacion(String cedula) {
    String[] resultado = null;
    ProcessBuilder pb = new ProcessBuilder("java", "-jar", PATH, cedula);
    try {
      Process p = pb.start();
      p.waitFor();
      File myObj = new File(RESULTADO);
      try (Scanner myReader = new Scanner(myObj)) {
        while (myReader.hasNextLine()) {
          resultado = myReader.nextLine().split(",");
        }
      }
      if(myObj.exists()) {
        myObj.delete();
      }
    } catch (IOException | InterruptedException ex) {
      ex.printStackTrace();
    }
    return resultado;
  }
  
}
