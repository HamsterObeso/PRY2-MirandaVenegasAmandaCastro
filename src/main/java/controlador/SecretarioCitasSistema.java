package controlador;

import formulario.SecretarioCitasRegistradas;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Muro
 */

@Controller
@RequestMapping(value = "/citasSistema")
public class SecretarioCitasSistema {
  
  @RequestMapping(method = RequestMethod.GET)
  public String viewFiltroCitasSistema(Map<String, Object> model) {
    SecretarioCitasRegistradas form = new SecretarioCitasRegistradas();
    model.put("citasRegistradasSecreForm", form);
    return "citasRegistradas";
  }
    
  @RequestMapping(method = RequestMethod.POST)  
  public String filtroCitasSistema(@ModelAttribute("citasRegistradasSecreForm") SecretarioCitasRegistradas form,
      Map<String, Object> model) {
    //filtroCitasSistema(form.getFecha1(), form.getFecha2(), form.getEspecialidad(), form.getEstado(), form.getNombrePaciente())
    System.out.println(form.getFecha1());
    System.out.println(form.getFecha2());
    System.out.println(form.getEspecialidad());
    System.out.println(form.getEstado());
    System.out.println(form.getNombrePaciente());
    
    return "citasRegistradas";
  }
}
