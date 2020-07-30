package controlador;

import formulario.DocEnfTratamientosAsociadosPaciente;
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
@RequestMapping(value = "/tratamientosDocEnf")
public class DocEnfTratamientos {
  @RequestMapping(method = RequestMethod.GET)
  public String viewFiltroCantidadCitas(Map<String, Object> model) {
    DocEnfTratamientosAsociadosPaciente form = new DocEnfTratamientosAsociadosPaciente();
    model.put("tratamientosDocEnfForm", form);
    return "tratamientosDocEnf";
  }
    
  @RequestMapping(method = RequestMethod.POST)  
  public String filtroTratamientosDE(@ModelAttribute("tratamientosDocEnfForm") DocEnfTratamientosAsociadosPaciente form,
      Map<String, Object> model) {
    //filtroTratamientosDocEnf(form.getFecha1(), form.getFecha2(), form.getTipoTratamiento(), form.getNombreTratamiento())
    System.out.println(form.getFecha1());
    System.out.println(form.getFecha2());
    System.out.println(form.getTipoTratamiento());
    System.out.println(form.getNombreTratamiento());
    return "tratamientosDocEnf";
  }
}
