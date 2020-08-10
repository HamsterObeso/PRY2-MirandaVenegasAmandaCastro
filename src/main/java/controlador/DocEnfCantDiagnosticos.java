package controlador;

import dao.DiagnosticoDAO;

import formulario.DocEnfCantidadDiagnosticos;
import generico.Tabla;

import java.sql.SQLException;
import java.util.Map;

import modelo.TablaCantidadDiagnosticos;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Miranda Venegas, Amanda Castro 
 * Clase que permite conocer la cantidad de diagnosticos 
 */

@Controller
@RequestMapping(value = "/cantidadDiagnosticos")
public class DocEnfCantDiagnosticos {

  @RequestMapping(method = RequestMethod.GET)
  public String viewFiltroCantidadDiagnosticos(Map<String, Object> model) {
    DocEnfCantidadDiagnosticos form = new DocEnfCantidadDiagnosticos();
    model.put("cantidadDiagnosticosForm", form);
    loadTable("", "", "", model);
    return "cantidadDiagnosticos";
  }
    
  /**
   * 
   * @param form objeto de tipo DocEnfCantidadDiagnosticos
   * @param model objeto de tipo Tabla
   * @return cantidad de diagnosticos 
   */
  @RequestMapping(method = RequestMethod.POST)  
  public String filtroCantidadDiagnosticos(@ModelAttribute("cantidadDiagnosticosForm") DocEnfCantidadDiagnosticos form,
      Map<String, Object> model) {
    loadTable(form.getNivel(), form.getEspecialidad(), form.getIdentificacion(), model);
    return "cantidadDiagnosticos";
  }
  
  /**
   * Carga los filtros de cantidad de diagnosticos 
   * @param pNivel nivel diagnostico
   * @param pEspecialidad especialidad
   * @param pNombrePaciente nombre del paciente 
   * @param model objeto de tipo Tabla 
   */
  private void loadTable(String pNivel, String pEspecialidad, String pNombrePaciente,
    Map<String, Object> model) {
    try {
      Tabla<TablaCantidadDiagnosticos> resultado = DiagnosticoDAO.cantidadDiagnosticos(pNivel, pEspecialidad, pNombrePaciente);
      model.put("resultados", resultado);
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  }
}
