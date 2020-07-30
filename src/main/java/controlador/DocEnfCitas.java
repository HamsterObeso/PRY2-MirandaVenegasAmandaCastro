package controlador;

import formulario.DocEnfCitasRegistradasSistema;
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
@RequestMapping(value = "/citasSistemaDocEnf")
public class DocEnfCitas{
  @RequestMapping(method = RequestMethod.GET)
    public String viewFiltroCitasDE(Map<String, Object> model) {
      DocEnfCitasRegistradasSistema form = new DocEnfCitasRegistradasSistema();
      model.put("citasSistemaDocEnfForm", form);
      return "citasSistemaDocEnf";
    }
    
    @RequestMapping(method = RequestMethod.POST)  
    public String filtroCitasDE(@ModelAttribute("citasAsociadasPacForm") DocEnfCitasRegistradasSistema form,
        Map<String, Object> model) {
      //filtroCitasDE(form.getFecha1(), form.getFecha2(), form.getEstado(), form.getEspecialidad(), form.getNombrePaciente())
      System.out.println(form.getFecha1());
      System.out.println(form.getFecha2());
      System.out.println(form.getEstado());
      System.out.println(form.getEspecialidad());
      System.out.println(form.getNombrePaciente());
      return "citasSistemaDocEnf";
    }
}
