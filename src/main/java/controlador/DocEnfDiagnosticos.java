package controlador;

import contexto.ContextoUsuario;
import dao.CitaDAO;
import dao.DiagnosticoDAO;
import formulario.DocEnfDiagnosticosAsociadosPaciente;
import java.sql.SQLException;
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
    try {
      DiagnosticoDAO.diagnosticosAsociadosDE(form.getFecha1(), form.getFecha2(), form.getNivel(), form.getNombre(), form.getIdentificacion());
      model.put("form", "form");
    } catch(SQLException e){
      model.put("error", "error");
      e.printStackTrace();
    }
    return "diagnosticosDocEnf";
  }
}
