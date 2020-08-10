package controlador;

import dao.CitaDAO;

import formulario.DocEnfCitasRegistradasSistema;
import generico.Tabla;

import java.sql.SQLException;
import java.util.Map;
import modelo.TablaCitasDE;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Miranda Venegas, Amanda Castro 
 * Clase que permite conocer las citas en sistema 
 */
@Controller
@RequestMapping(value = "/citasSistemaDocEnf")
public class DocEnfCitas{
  @RequestMapping(method = RequestMethod.GET)
  public String viewFiltroCitasDE(Map<String, Object> model) {
    DocEnfCitasRegistradasSistema form = new DocEnfCitasRegistradasSistema();
    model.put("citasSistemaDocEnfForm", form);
    loadTable("", "", "", "", "", model);
    return "citasSistemaDocEnf";
  }

  /**
   * Método que permite conocer las citas en sistema 
   * @param form objeto de tipo DocEnfCitasRegistradasSistema 
   * @param model objeto de tipo Tabla 
   * @return 
   */
  @RequestMapping(method = RequestMethod.POST)  
  public String filtroCitasDE(@ModelAttribute("citasAsociadasPacForm") DocEnfCitasRegistradasSistema form,
      Map<String, Object> model) {
    loadTable(form.getFecha1(), form.getFecha2(), form.getEstado(), form.getEspecialidad(), form.getNombrePaciente(), model);
    return "citasSistemaDocEnf";
  }
  
  /**
   * Método que permite cargar los datos de losfiltros correspondientes 
   * @param f1 fecha inicial 
   * @param f2 fech final
   * @param pEstado estado de la cita
   * @param pEspecialidad especialidad de la cita 
   * @param pNombrePaciente nombre del paciente de la cita 
   * @param model objeto de tipo Tabla 
   */
  private void loadTable(String f1, String f2, String pEstado, 
      String pEspecialidad, String pNombrePaciente, Map<String, Object> model) {
    try {
      Tabla<TablaCitasDE> resultado = CitaDAO.citasSistema(f1, f2, pEstado, pEspecialidad, pNombrePaciente);
      model.put("resultados", resultado);
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  }
  
}
