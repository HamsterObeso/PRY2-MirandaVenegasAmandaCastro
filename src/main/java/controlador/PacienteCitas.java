package controlador;

import java.util.Map;
import formulario.PacienteCitasAsociadas;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Muro
 */

@Controller
@RequestMapping(value = "/citasPaciente")
public class PacienteCitas {
  
  @RequestMapping(method = RequestMethod.GET)
    public String viewFiltroCitasPaciente(Map<String, Object> model) {
      PacienteCitasAsociadas form = new PacienteCitasAsociadas();
      model.put("citasAsociadasPacForm", form);
      return "citasAsociadasPaciente";
    }
    
    @RequestMapping(method = RequestMethod.POST)  
    public String filtroCitasPaciente(@ModelAttribute("citasAsociadasPacForm") PacienteCitasAsociadas form,
        Map<String, Object> model) {
      //filtroCitas(form.getFecha1(), form.getFecha2(), form.getEstado(), form.getEspecialidad(), ContextoUsuario.getIdUsuario())
      System.out.println(form.getFecha1());
      System.out.println(form.getFecha2());
      System.out.println(form.getEstado());
      System.out.println(form.getEspecialidad());
      return "menu";
    }
}
