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
 * @author Mranda Venegas, Amanda Castro 
 * Clase que permite conocer los diagnosticos en sistemas 
 */

@Controller
@RequestMapping(value = "/diagnosticosDocEnf")
public class DocEnfDiagnosticos {
  
  @RequestMapping(method = RequestMethod.GET)
  public String viewFiltroDiagnosticosDE(Map<String, Object> model) {
    DocEnfDiagnosticosAsociadosPaciente form = new DocEnfDiagnosticosAsociadosPaciente();
    model.put("diagnosticosDocEnfForm", form);
    loadTable("", "", "", "", "", model);
    return "diagnosticosDocEnf";
  }
   
  /**
   * Carga los datos de DocEnfDiagnosticosAsociadosPaciente
   * @param form un objeto de tipo DocEnfDiagnosticosAsociadosPaciente
   * @param model objeto de tipo Tabla 
   * @return los diagnosticos 
   */
  @RequestMapping(method = RequestMethod.POST)  
  public String filtroDiagnosticosDE(@ModelAttribute("diagnosticosDocEnfForm") DocEnfDiagnosticosAsociadosPaciente form,
      Map<String, Object> model) {
    loadTable(form.getIdentificacion(), form.getFecha1(), form.getFecha2(), form.getNivel(), form.getNombre(), model);
    return "diagnosticosDocEnf";
  }
  
  /**
   * Permite crear los filtros de acuerdo a lo solicitado 
   * @param identificacion identificacion del paciente
   * @param f1 fecha inicial 
   * @param f2 fecha final 
   * @param pNivel novel del diagnostico 
   * @param pNombreDiag nombre del diagnostico 
   * @param model 
   */
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
