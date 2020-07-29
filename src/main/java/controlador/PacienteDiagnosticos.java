package controlador;

import formulario.PacienteDiagnosticosAsociados;
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
@RequestMapping(value = "/diagnosticosPaciente")
public class PacienteDiagnosticos {
  
  @RequestMapping(method = RequestMethod.GET)
  public String viewFiltroDiagnosticosPaciente(Map<String, Object> model) {
    PacienteDiagnosticosAsociados form = new PacienteDiagnosticosAsociados();
    model.put("diagnosticosAsociadasPacForm", form);
    return "diagnosticosAsociadasPacForm";
  }
    
  @RequestMapping(method = RequestMethod.POST)  
  public String filtroDiagnosticosPaciente(@ModelAttribute("diagnosticosAsociadasPacForm") PacienteDiagnosticosAsociados form,
      Map<String, Object> model) {
    //filtroDiagnosticos(form.getFecha1(), form.getFecha2(), form.getNivel(), form.getNombre(), ContextoUsuario.getIdUsuario())
    System.out.println(form.getFecha1());
    System.out.println(form.getFecha2());
    System.out.println(form.getNivel());
    System.out.println(form.getNombre());
    return "menu";
  }
}
