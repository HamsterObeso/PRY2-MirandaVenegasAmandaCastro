package controlador;

import formulario.DocEnfCantidadCitas;

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
@RequestMapping(value = "/cantidadCitas")
public class DocEnfCantCitas {
  
  @RequestMapping(method = RequestMethod.GET)
  public String viewFiltroCantidadCitas(Map<String, Object> model) {
    DocEnfCantidadCitas form = new DocEnfCantidadCitas();
    model.put("cantidadCitasForm", form);
    return "cantidadCitas";
  }
    
  @RequestMapping(method = RequestMethod.POST)  
  public String filtroCantidadCitas(@ModelAttribute("cantidadCitasForm") DocEnfCantidadCitas form,
      Map<String, Object> model) {
    //filtroCantCitas(form.getFecha1(), form.getFecha2(), form.getEspecialidad(), form.getEstado())
    System.out.println(form.getFecha1());
    System.out.println(form.getFecha2());
    System.out.println(form.getEspecialidad());
    System.out.println(form.getEstado());
    return "cantidadCitas";
  }
}
