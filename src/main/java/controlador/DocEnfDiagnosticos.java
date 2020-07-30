package controlador;

import formulario.DocEnfDiagnosticosAsociadosPaciente;
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
@RequestMapping(value = "/diagnosticosDocEnf")
public class DocEnfDiagnosticos {
  @RequestMapping(method = RequestMethod.GET)
  public String viewFiltroDiagnosticosDE(Map<String, Object> model) {
    DocEnfDiagnosticosAsociadosPaciente form = new DocEnfDiagnosticosAsociadosPaciente();
    model.put("diagnosticosDocEnfForm", form);
    return "diagnosticosDocEnf";
  }
    
  @RequestMapping(method = RequestMethod.POST)  
  public String filtroDiagnosticosDE(@ModelAttribute("diagnosticosDocEnfForm") DocEnfDiagnosticosAsociadosPaciente form,
      Map<String, Object> model) {
    //filtroDiagnosticosDocEnf(form.getFecha1(), form.getFecha2(), form.getEspecialidad(), form.getEstado(), form.getNombrePaciente())
    System.out.println(form.getFecha1());
    System.out.println(form.getFecha2());
    System.out.println(form.getEspecialidad());
    System.out.println(form.getEstado());
    System.out.println(form.getNombrePaciente());
    return "diagnosticosDocEnf";
  }
}
