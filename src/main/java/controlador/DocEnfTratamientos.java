package controlador;

import dao.CitaDAO;
import dao.TratamientoDAO;
import formulario.DocEnfTratamientosAsociadosPaciente;
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
@RequestMapping(value = "/tratamientosDocEnf")
public class DocEnfTratamientos {
  @RequestMapping(method = RequestMethod.GET)
  public String viewFiltroCantidadCitas(Map<String, Object> model) {
    DocEnfTratamientosAsociadosPaciente form = new DocEnfTratamientosAsociadosPaciente();
    model.put("tratamientosDocEnfForm", form);
    return "tratamientosDocEnf";
  }
    
  @RequestMapping(method = RequestMethod.POST)  
  public String filtroTratamientosDE(@ModelAttribute("tratamientosDocEnfForm") DocEnfTratamientosAsociadosPaciente form,
      Map<String, Object> model) {
    try {
      TratamientoDAO.tratamientosAsociadosDE(form.getFecha1(), form.getFecha2(), form.getTipoTratamiento(), form.getNombreTratamiento(), form.getIdentificacion());
      model.put("form", "form");
    } catch(SQLException e){
      model.put("error", "error");
      e.printStackTrace();
    }
    return "tratamientosDocEnf";
  }
}
