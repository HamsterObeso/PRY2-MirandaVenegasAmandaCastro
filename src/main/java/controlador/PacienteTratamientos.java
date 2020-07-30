package controlador;

import contexto.ContextoUsuario;
import dao.DiagnosticoDAO;
import formulario.PacienteTratamientosAsociados;
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
@RequestMapping(value = "/tratamientosPaciente")
public class PacienteTratamientos {
  
  @RequestMapping(method = RequestMethod.GET)
  public String viewFiltroTratamientosPaciente(Map<String, Object> model) {
    PacienteTratamientosAsociados form = new PacienteTratamientosAsociados();
    model.put("tratamientosAsociadosPacForm", form);
    return "tratamientosAsociadosPaciente";
  }
    
  @RequestMapping(method = RequestMethod.POST)  
  public String filtroTratamientosPaciente(@ModelAttribute("tratamientosAsociadosPacForm") PacienteTratamientosAsociados form,
      Map<String, Object> model) {
    try {
      DiagnosticoDAO.diagnosticosAsociadosP(form.getFecha1(), form.getFecha2(), form.getTipoTratamiento(), form.getNombre(), ContextoUsuario.getIdUsuario());
      model.put("form", "form");
    } catch(SQLException e){
      model.put("error", "error");
      e.printStackTrace();
    }
    return "tratamientosAsociadosPaciente";
  }
  
}
