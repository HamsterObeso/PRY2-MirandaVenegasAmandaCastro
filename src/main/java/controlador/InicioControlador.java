package controlador;

import conector.ConectorTSE;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller 
public class InicioControlador {
  
  @RequestMapping(method = RequestMethod.GET)
  public String viewHome() {
    String[] resultado = ConectorTSE.obtenerInformacion("208000135");
    System.out.println(resultado[1]);
    return "inicio";    
  }

}
