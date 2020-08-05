package controlador;

import dao.DiagnosticoDAO;

import formulario.DocEnfDiagnosticosAsociadosPaciente;

import generico.Tabla;

import java.sql.SQLException;

import java.util.Map;

import modelo.TablaDiagnosticosDE;

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
    loadTable(form.getIdentificacion(), "", "", "", "", model);
    return "diagnosticosDocEnf";
  }
    
  @RequestMapping(method = RequestMethod.POST)  
  public String filtroDiagnosticosDE(@ModelAttribute("diagnosticosDocEnfForm") DocEnfDiagnosticosAsociadosPaciente form,
      Map<String, Object> model) {
    loadTable(form.getFecha1(), form.getFecha2(), form.getNivel(), form.getNombre(), form.getIdentificacion(), model);
    return "diagnosticosDocEnf";
  }
  
  private void loadTable(String identificacion, String f1, String f2, String pNivel, 
      String pNombreDiag, Map<String, Object> model) {
    try {
      Tabla<TablaDiagnosticosDE> resultado = DiagnosticoDAO.diagnosticosAsociadosDE(f1, f2, pNivel, pNombreDiag, identificacion);
      model.put("resultados", resultado);
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  }
  
}
