package controlador;

import java.util.Map;
import modelo.Cita;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Muro
 */

@Controller
@RequestMapping(value = "/cancelarCitaPaciente")
public class CancelarCitaPaciente {
  
  @RequestMapping(method = RequestMethod.GET)
    public String viewCancelarCitaP(Map<String, Object> model) {
      Cita cita = new Cita();
      model.put("cancelarCitaPacForm", cita);
      return "cancelarCitaPaciente";
    }
    
    @RequestMapping(method = RequestMethod.POST)  
    public String cancelarCitaP(@ModelAttribute("cancelarCitaPacForm") Cita cita,
        Map<String, Object> model) {
      //cancelarCita(cita.getIdCita(), ContextoUsuario.getIdUsuario())
      System.out.println(cita.getIdCita());
      return "menu";
    }
}
