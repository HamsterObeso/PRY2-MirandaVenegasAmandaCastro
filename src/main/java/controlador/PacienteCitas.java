package controlador;

import contexto.ContextoUsuario;
import dao.CitaDAO;

import java.util.Map;

import formulario.PacienteCitasAsociadas;

import generico.Tabla;

import java.sql.SQLException;

import modelo.TablaCita;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Muro
 */

@Controller
@RequestMapping(value = "/citasPaciente")
public class PacienteCitas {
  
  @RequestMapping(method = RequestMethod.GET)
  public String viewFiltroCitasPaciente(Map<String, Object> model) {
    PacienteCitasAsociadas form = new PacienteCitasAsociadas();
    model.put("citasAsociadasPacForm", form);
    loadTable("", "", "", "", ContextoUsuario.getIdUsuario(), model);
    return "citasAsociadasPaciente";
  }

  @RequestMapping(method = RequestMethod.POST)  
  public String filtroCitasPaciente(@ModelAttribute("citasAsociadasPacForm") 
    PacienteCitasAsociadas form, Map<String, Object> model) {
    loadTable(form.getFecha1(), form.getFecha2(), form.getEstado(), form.getEspecialidad(), ContextoUsuario.getIdUsuario(), model);
    return "citasAsociadasPaciente";
  }
  
  private void loadTable(String f1, String f2, String pEstado, 
      String pEspecialidad, int pIdUsuario, Map<String, Object> model) {
    try {
      Tabla<TablaCita> resultado = CitaDAO.citasAsociadasPaciente(f1, f2, pEstado, pEspecialidad, pIdUsuario);
      model.put("resultados", resultado);
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  }
  
}
