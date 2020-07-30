package controlador;

import formulario.DocEnfCantidadDiagnosticos;
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
@RequestMapping(value = "/cantidadDiagnosticos")
public class DocEnfCantDiagnosticos {

  @RequestMapping(method = RequestMethod.GET)
  public String viewFiltroCantidadDiagnosticos(Map<String, Object> model) {
    DocEnfCantidadDiagnosticos form = new DocEnfCantidadDiagnosticos();
    model.put("cantidadDiagnosticosForm", form);
    return "cantidadDiagnosticos";
  }
    
  @RequestMapping(method = RequestMethod.POST)  
  public String filtroCantidadDiagnosticos(@ModelAttribute("cantidadDiagnosticosForm") DocEnfCantidadDiagnosticos form,
      Map<String, Object> model) {
    //filtroCantDiagnosticos(form.getNivel(), form.getEspecialidad(), form.getIdentificacion())
    System.out.println(form.getNivel());
    System.out.println(form.getEspecialidad());
    System.out.println(form.getIdentificacion());
    return "cantidadDiagnosticos";
  }
}