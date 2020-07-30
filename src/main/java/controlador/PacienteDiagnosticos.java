package controlador;

import contexto.ContextoUsuario;
import dao.DiagnosticoDAO;
import formulario.PacienteDiagnosticosAsociados;
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
@RequestMapping(value = "/diagnosticosPaciente")
public class PacienteDiagnosticos {
  
  @RequestMapping(method = RequestMethod.GET)
  public String viewFiltroDiagnosticosPaciente(Map<String, Object> model) {
    PacienteDiagnosticosAsociados form = new PacienteDiagnosticosAsociados();
    model.put("diagnosticosAsociadasPacForm", form);
    return "diagnosticosAsociadosPaciente";
  }
    
  @RequestMapping(method = RequestMethod.POST)  
  public String filtroDiagnosticosPaciente(@ModelAttribute("diagnosticosAsociadasPacForm") PacienteDiagnosticosAsociados form,
      Map<String, Object> model) {
    try {
      DiagnosticoDAO.diagnosticosAsociadosP(form.getFecha1(), form.getFecha2(), form.getNivel(), form.getNombre(), ContextoUsuario.getIdUsuario());
      model.put("form", "form");
    } catch(SQLException e){
      model.put("error", "error");
      e.printStackTrace();
    }
    return "diagnosticosAsociadosPaciente";
  }
}
