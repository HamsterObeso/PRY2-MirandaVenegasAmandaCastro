package controlador;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller public class InicioControlador {
    
     @Autowired
     ServletContext context;

    
    @RequestMapping(value="/home", method = RequestMethod.GET)
    public String viewHome(){
        String path = System.getProperty("user.dir");
        System.out.println(path);
        System.out.println(context.getRealPath("/"));
        ProcessBuilder pb = new ProcessBuilder("java", "-jar", System.getProperty("user.dir") + "/Reportify 1.3.0.jar");
        try {
            Process p = pb.start();
        } catch (IOException ex) {
            ex.printStackTrace();
            Logger.getLogger(InicioControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "home";
    }
    
}
