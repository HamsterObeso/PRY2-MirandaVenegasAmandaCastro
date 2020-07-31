package controlador;

import dao.CitaDAO;

import formulario.DocEnfCitasRegistradasSistema;

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
@RequestMapping(value = "/citasSistemaDocEnf")
public class DocEnfCitas{
  @RequestMapping(method = RequestMethod.GET)
  public String viewFiltroCitasDE(Map<String, Object> model) {
    DocEnfCitasRegistradasSistema form = new DocEnfCitasRegistradasSistema();
    model.put("citasSistemaDocEnfForm", form);
    return "citasSistemaDocEnf";
  }

  @RequestMapping(method = RequestMethod.POST)  
  public String filtroCitasDE(@ModelAttribute("citasAsociadasPacForm") DocEnfCitasRegistradasSistema form,
      Map<String, Object> model) {
    try {
      CitaDAO.citasSistema(form.getFecha1(), form.getFecha2(), form.getEstado(), form.getEspecialidad(), form.getNombrePaciente());
      model.put("form", "form");
    } catch(SQLException e){
      model.put("error", "error");
      e.printStackTrace();
    }
    return "citasSistemaDocEnf";
  }
}
