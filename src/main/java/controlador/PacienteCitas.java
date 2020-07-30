package controlador;

import contexto.ContextoUsuario;
import dao.CitaDAO;
import java.util.Map;
import formulario.PacienteCitasAsociadas;
import java.sql.SQLException;
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
    return "citasAsociadasPaciente";
  }

  @RequestMapping(method = RequestMethod.POST)  
  public String filtroCitasPaciente(@ModelAttribute("citasAsociadasPacForm") PacienteCitasAsociadas form,
      Map<String, Object> model) {
    try {
      CitaDAO.citasAsociadasPaciente(form.getFecha1(), form.getFecha2(), form.getEstado(), form.getEspecialidad(), ContextoUsuario.getIdUsuario());
      model.put("form", "form");
    } catch(SQLException e){
      model.put("error", "error");
      e.printStackTrace();
    }
    return "citasAsociadasPaciente";
  }
}
