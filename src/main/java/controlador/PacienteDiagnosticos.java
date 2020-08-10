package controlador;

import contexto.ContextoUsuario;

import dao.DiagnosticoDAO;

import formulario.PacienteDiagnosticosAsociados;
import generico.Tabla;

import java.sql.SQLException;

import java.util.Map;
import modelo.TablaDiagnosticosPaciente;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Miranda Venegas, Amanda Castro 
 */

@Controller
@RequestMapping(value = "/diagnosticosPaciente")
public class PacienteDiagnosticos {
  
  @RequestMapping(method = RequestMethod.GET)
  public String viewFiltroDiagnosticosPaciente(Map<String, Object> model) {
    PacienteDiagnosticosAsociados form = new PacienteDiagnosticosAsociados();
    model.put("diagnosticosAsociadasPacForm", form);
    loadTable("", "", "", "", ContextoUsuario.getIdUsuario(), model);
    return "diagnosticosAsociadosPaciente";
  }
   
  /**
   * Cargar el filtro de diagnostico de paciente 
   * @param form objeto de tipo PacienteDiagnosticosAsociados
   * @param model objeto de tipo Map 
   * @return 
   */
  @RequestMapping(method = RequestMethod.POST)  
  public String filtroDiagnosticosPaciente(@ModelAttribute("diagnosticosAsociadasPacForm") PacienteDiagnosticosAsociados form,
      Map<String, Object> model) {
    loadTable(form.getFecha1(), form.getFecha2(), form.getNivel(), form.getNombre(), ContextoUsuario.getIdUsuario(), model);
    return "diagnosticosAsociadosPaciente";
  }
  /**
   * Cargar los datos de los diagnosticos de los pacientes 
   * @param f1 fecha incial 
   * @param f2 fecha final 
   * @param pNivel nivel de los diagnosticos
   * @param pNombre nombre de los diagnosticos 
   * @param pUsuario nombre del paciente 
   * @param model objeto de tipo Map 
   */
  private void loadTable(String f1, String f2, String pNivel, 
      String pNombre, int pUsuario, Map<String, Object> model) {
    try {
      Tabla<TablaDiagnosticosPaciente> resultado = DiagnosticoDAO.diagnosticosAsociadosP(f1, f2, pNivel, pNombre, pUsuario);
      model.put("resultados", resultado);
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  }
}
