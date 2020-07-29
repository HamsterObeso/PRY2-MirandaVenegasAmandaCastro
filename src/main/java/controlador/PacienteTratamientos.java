package controlador;

import formulario.PacienteTratamientosAsociados;
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
@RequestMapping(value = "/tratamientosPaciente")
public class PacienteTratamientos {
  
  @RequestMapping(method = RequestMethod.GET)
  public String viewFiltroTratamientosPaciente(Map<String, Object> model) {
    PacienteTratamientosAsociados form = new PacienteTratamientosAsociados();
    model.put("tratamientosAsociadosPacForm", form);
    return "tratamientosAsociadosPaciente";
  }
    
  @RequestMapping(method = RequestMethod.POST)  
  public String filtroTratamientosPaciente(@ModelAttribute("tratamientosAsociadosPacForm") PacienteTratamientosAsociados form,
      Map<String, Object> model) {
    //filtroTratamientos(form.getFecha1(), form.getFecha2(), form.getTipoTratamiento(), form.getNombre(), ContextoUsuario.getIdUsuario())
    System.out.println(form.getFecha1());
    System.out.println(form.getFecha2());
    System.out.println(form.getTipoTratamiento());
    System.out.println(form.getNombre());
    return "menu";
  }
}
