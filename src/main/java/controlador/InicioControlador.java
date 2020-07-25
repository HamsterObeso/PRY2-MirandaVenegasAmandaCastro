package controlador;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller public class InicioControlador {

  @RequestMapping(value="/home", method = RequestMethod.GET)
  public String viewHome(){
    ProcessBuilder pb = new ProcessBuilder("java", "-jar", System.getProperty("user.dir") + "/parametros.jar", "117170450");
    try {
      Process p = pb.start();
      p.waitFor();
      InputStream in = p.getInputStream();
      byte b[]=new byte[in.available()];
      in.read(b,0,b.length);
      String data = new String(b);
      System.out.println(data);
    } catch (IOException | InterruptedException ex) {
      Logger.getLogger(InicioControlador.class.getName()).log(Level.SEVERE, null, ex);
    }
    return "home";    
  }

}
